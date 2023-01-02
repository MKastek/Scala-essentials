package lectures.fprogramming

object AnonymousFunction extends App {

  val doublerr = new Function[Int, Int]{
    override def apply(x: Int) = x * 2
  }

  // anonymous function, lambda
  val doubler: Int => Int = x => x*2

  // multiple params in lambda
  val adder: (Int,Int)=>Int = (a:Int,b:Int) => a+b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /*
  1. MyList: replace all FunctionX call with lambdas
  2. Rewrite "special" adder as anonymous
  */
}
