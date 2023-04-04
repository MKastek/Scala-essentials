package catseffect

import scala.concurrent.Future

object Effects {

  // pure functional programming
  // substitution
  def combine(a: Int, b: Int): Int = a +b
  val five= combine(2,3)
  val five_v2 = 2 + 3
  val five_v3 = 5

  // referential transparency

  // impure - print

  // effect
  /*
  - type signature describes VALUE
  - side effect ?
  */

  val anOption: Option[Int] = Option(42)
  /*
  - describes a possilbe absent value
  - computes a value of type A, if it exists
  - no side are not needed
  */
  import scala.concurrent.ExecutionContext.Implicits.global
  val aFuture: Future[Int] = Future(42)
  /*
  - describes an asynchronous computation
  - computes a value of type A
  - side effect i required (allocating/scheduling a thread
  */

  // example
  case class MyIO[A](unsafeRun: () => A){
    def map[B](f: A => B): MyIO[B] = MyIO(() => f(unsafeRun()))

    def flatMap[B](f: A => MyIO[B]): MyIO[B] = MyIO(() => f(unsafeRun()).unsafeRun())
  }

  def main(args: Array[String]): Unit = {

  }
}
