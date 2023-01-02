package lectures.OPP

object Generics extends App{

  // generic type
  class MyList[+A]{
    def add[B >: A](element: B): MyList[B] = ???
    // use the type A
  }
  // two generic types
  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. no = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types
  // parameter A is subtype of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)
  // parameter A is supertype of Animal
  class Cage2[A >: Animal](animal: A)
  val cage2 = new Cage(new Dog)

}
