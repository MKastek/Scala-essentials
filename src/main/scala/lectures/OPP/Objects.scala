package lectures.OPP

object Objects extends App{


  // Scala does not have class-level functionality ("static")
  // Object do not receive parameters
  // Companions pattern
  object Person{ // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }
  class Person(val name: String){
    // instance-level functionality
  }


    println(Person.N_EYES)
    println(Person.canFly)
    // Scala object = SINGLETON INSTANCE
    // Point to the same instance
    val mary = Person
    val john = Person
   

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit

}
