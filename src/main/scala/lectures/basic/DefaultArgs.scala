package lectures.basic

object DefaultArgs extends App{

  def trFactorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFactorial(n-1, n*acc)

  val fact10 = trFactorial(10)
  println(fact10)
}
