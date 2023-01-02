package lectures.OPP

object OOBasic extends App{

  val person = new Person("Marcin", 26)
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Daniel")


  println("Questions")
  val writer = new Writer("Marcin", "Kastek", 1989)
  val novel = new Novel("Scala", 1998, writer)
  println(writer.fullName())
  println(novel.authorAge())

  val counter = new Counter(10)
  println(counter.currentCount)
  counter.incrementCount(10)
  println(counter.currentCount)
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  // side effect
  println(1 + 3)
  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  //method overloading
  def greet(): Unit = println(s"Hi, I am $name")
  //multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

// class parameters are not FIELDS


// Questions
// 1. Novel and Writer Class
// Writer: firstname, surname, year
// method: fullname

// Novel: name, year of release, author
// -authorAge
// -isWrittenBy(author)
// -copy(new year of release) = new instance of novel

class Writer(val firstname: String,val surname: String,val year: Int){
  def fullName(): String = s"${this.firstname} ${this.surname}"
}

class Novel(name: String, year: Int, author: Writer){
  def authorAge(): Int = (this.year - this.author.year)
  def isWrittenBy(author: Writer) : Boolean = this.author == author

  def copy(year: Int) : Novel = {
    new Novel(name, year, author)
  }

}

// 2. Counter class
// - receives current count
// - method current count
// - method to increment/decrement
// - overload inc/dec to receive an amount

class Counter(val currentCount: Int) {
  def incrementCount(): Counter = new Counter(currentCount + 1)
  def decrementCount(): Counter = new Counter(currentCount - 1)

  def incrementCount(amount: Int): Counter = new Counter(currentCount+ amount)

  def decrementCount(amount: Int): Counter = new Counter(currentCount - amount)




}