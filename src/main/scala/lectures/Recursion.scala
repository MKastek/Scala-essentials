package lectures

import scala.annotation.tailrec

object Recursion extends App{

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else{
      println(s"Computing of $n factorial")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n: $result")
      result
    }
  }


  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1 ) accumulator
      else factHelper(x-1, x *accumulator) // TAIL RECURSION = user recursive call as the LAST expression

    factHelper(n,1)
  }


  // QUESTIONS
  // 1. Concatenate a string n times - tail recursive
  def concatenateString(word: String, n: Int): String = {
    @tailrec
    def concatenateHelper(n: Int, stringAccumulator: String): String =
      if (n>1)
        concatenateHelper(n-1,stringAccumulator + word)
      else
        stringAccumulator

    concatenateHelper(n,word)
  }
  println(concatenateString("ok",3))

  // 2. Fibonacci - tail recursive
  // f(1) = 1
  // f(2) = 1
  // f(n) = f(n - 1) + f(n - 2)
  def fibonacciFunction(n: Int): Int = {
    def fibonacciHelper(i:Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciHelper(i + 1, last+nextToLast, last)

    if (n<=2) 1
    else fibonacciHelper(2, 1, 1)
  }
  println(fibonacciFunction(6))

}

