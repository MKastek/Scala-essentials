package lectures.OPP

object Exceptions extends App{
  val x: String = null
  //println(x.length)

  // 1. throwing exceptions
  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int")
    else 42
  }

  val potentialFail = try{
    // Code that might throw (fail)
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  /*
  1. Crash your program with an OutOfMemoryError
  2. Crash with SOError
  3. PocketCalculator
     - add(x,y)
     - subtract(x,y)
     - multiply(x,y)
     - divide(x,y)
  Throw
   - OverflowException if add(x,y) exceeds Int.MAX_VALUE
   - UnderflowException if substract(x,) exceeds Int.MIN_VALUE
   - MathCalculationException for division by 0
  */

  // 1.
  // OOM
  // val array = Array.ofDim[Int](Int.MaxValue)

  // SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  
  object PocketCalculator{
    def add(x: Int,y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
  }
  print(PocketCalculator.add(10,10))
}
