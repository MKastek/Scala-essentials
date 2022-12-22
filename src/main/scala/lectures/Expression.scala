package lectures

object Expression extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)
  println(x == 1)
  println(!(x == 1))

  var aVariable = 2
  aVariable += 3

  // Instructions (TO DO) vs Expressions (VALUE)
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionValue)
  println(1 + 3)

  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  // Everything in Scala is an EXPRESSION !

  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue) // ()

  // side affects: println(), while, reassigning

  // Code blocks (expression)

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // QUESTIONS
  // 1. Difference between "hello world" vs println("hello world")

  // "hello world" is value of type string, println("hello world") is an expression of side effect type of unit

  // 2. Value of
  // val someValue = {
  //   2 < 3
  // }

  // true

  // val someValue = {
  //   if (someValue) 239 else 986
  //    42
  // }

  // 42
}
