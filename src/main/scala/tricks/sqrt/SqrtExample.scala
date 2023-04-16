package tricks.sqrt

object SqrtExample extends App{

  /*
  Newton method of calculating sqrt:
  Calculating sqrt(x)
  Estimation: y
  Quotient: x / y
  Mean: (y + x / y)/2

  */
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIter(y: Double, x: Double): Double =
    if (isGoodEnough(y, x)) y
    else sqrtIter(improve(y, x), x)

  def isGoodEnough(y: Double, x: Double): Boolean = abs(y*y - x) < 0.001

  def improve(y: Double, x: Double) = (y + x / y) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)

  print(s"""Square root of: ${sqrt(2)}""")

}
