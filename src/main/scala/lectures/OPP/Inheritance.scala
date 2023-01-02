package lectures.OPP

object Inheritance extends App{

  class Animal {
    val creatureType = "wild"
    def eat() = println("nomnom")
  }

  class Cat extends Animal {
    def crunch() = {
      eat()
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()
  // constructor
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal{
    //override val creatureType = "domestic"
    override def eat() = {
      super.eat()
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unkownAnimal: Animal = new Dog("K9")
  unkownAnimal.eat()

  // overriding vs overloading

  // super - from parent class

  // preventing overrides
  // 1 - use final
  // 2 - use final to class
  // 3 - seal the class (softer, you can extend classes only in THIS class)
}
