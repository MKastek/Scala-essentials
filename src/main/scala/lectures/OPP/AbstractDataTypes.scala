package lectures.OPP

object AbstractDataTypes extends App{

  // abstract classes
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits ultimate abstract
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore{
    override val creatureType: String = "croc"
    override def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm croc and I'm earing ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // trais vs abstract classes
  // Abstract classes and traits can have abstract and non-abstract members
  // 1 - multiple traits may be inherited by the same class
  // 2 - traits = behavior, abstract class = "type of thing"



}
