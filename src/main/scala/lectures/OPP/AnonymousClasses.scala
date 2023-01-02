package lectures.OPP

object AnonymousClasses extends App {
  abstract class Animal{
    def eat: Unit
  }

  // anonymous class - no the spot implementation
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }
  println(funnyAnimal.getClass)
}
