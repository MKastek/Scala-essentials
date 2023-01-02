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
}
