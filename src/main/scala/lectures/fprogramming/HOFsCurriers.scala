package lectures.fprogramming

object HOFsCurriers extends App {

  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // higher order function (HOF)

  // map, flat, filter
  // function as a parameter

  // function that applies a function n times over a value x
  // nTimes(f, n, x)

  def nTimes(f: Int=> Int, n: Int, x: Int): Int = {
    if (n <= 0 ) x
    else nTimes(f, n-1, f(x))
  }
  
  val plusOne = (x: Int) => x+1
  println(nTimes(plusOne,10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n<= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried functions
  val supperAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x+y
  val add3 = supperAdder(3)
  println(add3(10))
  println(supperAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormetter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormetter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormetter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
  1. Expand MyList
     - foreach method A => Unit
      [1,2,3].foreach( x => println(x))
     - sort function ((A,A) => Int) => MyList
     - zipWith (list, (A,A) => B) => MyList[B]
     - fold

  */
}
