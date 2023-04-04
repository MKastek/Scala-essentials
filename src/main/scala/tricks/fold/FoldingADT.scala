package tricks.fold

object FoldingADT extends App {


  private val optionInt: Option[Int] = Some(42)
  private val optionNone: Option[Int] = None
  /*
  Option [A] = None | Some[A](a: A)
  */
  println(optionInt.fold("option - None")(_.toString()))
  println(optionNone.fold("option - None")(_.toString()))

  private val listInt: List[Int] = List(1,2,3)
  /*
  List[A] = Nil | A :: List[A]
  :: - Cons operator

  Lis(1,2,3)  = 1 :: 2 :: 3 :: Nil

  Nil replaced with zero
  _ + _ :: replaced with +
  */

  def sumFold(list: List[Int]) = list.foldRight(0)(_ + _)

  private val eitherIntRight: Either[String, Int] = Right(42)
  private val eitherIntLeft: Either[String, Int] = Left("42")

  /*
  Either[A, B] = Left[A](a: A) | Right[B](b: B)
  */

  println(eitherIntRight)
  println(eitherIntLeft)

  eitherIntRight.fold( _ => println("error"), _ => println(24) )


  // Folding custom types

}
