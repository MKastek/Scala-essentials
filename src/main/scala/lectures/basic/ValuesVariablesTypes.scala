package lectures.basic

object ValuesVariablesTypes extends App{
  val x: Int = 42
  println(x)
  // val can not be reassigned, val are immutable
  val y = 42
  println(y)
  // types of vals are optional, compiler can infer type

  val aString: String = "hello"; val anotherString = "goodbye"

  // boolean type
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 4613 // 4 bytes
  val aLong: Long = 1231243434L // 8 bytes
  val aFloat: Float = 2.0f // float number
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5

}
