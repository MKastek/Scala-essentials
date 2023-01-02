package lectures.basic

import scala.annotation.tailrec

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello",3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // In Scala we use recursion, recursive function need return types

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n,n-1)
  }


  // QUESTIONS
  // 1. Greeting function
  def aGreetingFunction(name: String, age: Int): String =
    s"Hi my name is $name and I am $age years old."

  println(aGreetingFunction("Marcin", 13))

  // 2. Factorial function

  def aFactorialFunction(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else n * aFactorialFunction(n - 1)
  }
  println(aFactorialFunction(4))

  // 3. Fibonacci function
  // f(1) = 1
  // f(2) = 1
  // f(n) = f(n - 1) + f(n - 2)

  def aFibonacciFunction(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }
  println(aFibonacciFunction(6))
  // 4. Test if number is prime

  def aPrimeFunction(n: Int): Boolean = {
    def isPrimeUntil(t : Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }

  println(aPrimeFunction(37))
}
