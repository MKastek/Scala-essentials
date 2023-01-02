package lectures.OPP

object CaseClasses extends App{
  // Case classes
  // 1. class parameters are fields
  // 2. sensible toString
  // 3. equals and hashCode are implemented
  // 4. handy compy method
  // 5. companion object
  // 6. serializable (Akka)
  // 7. extractor patterns
  
  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)
  println(jim.name)
  println(jim.toString)
  println(jim)

  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 53)
  
  val thePerson = Person
  val mary = Person("Mary", 23)
  
  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }
  
  
}
