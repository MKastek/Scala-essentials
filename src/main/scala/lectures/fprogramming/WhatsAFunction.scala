package lectures.fprogramming

object WhatsAFunction extends App{

  // use functions as first class elements
  // problem: opp

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToIntConverter = new Function[String , Int]{
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3")+4)

  // Function types Function2[A, B, R] == (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS
  /*
  1. function which take 2 string and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an int and returns another function which takes an int and returns an int
     - what's the type of this function
     - how to do it
  */

  val stringConcatenate: (String, String)=>String = new Function2[String, String, String]{
    override def apply(string_1: String, string_2: String): String = string_1+string_2
  }
  println(stringConcatenate("Marcin","Kastek"))

  // Function1[Int, Function1[Int, Int]]
  val specialFunction = (x: Int) => (y: Int) => x+y

  val adder3 = specialFunction(3)
  println(adder3(4))
  println(specialFunction(3))// curried function

}

trait MyFunction[A,B]{
  def apply(element: A): B = ???
}
