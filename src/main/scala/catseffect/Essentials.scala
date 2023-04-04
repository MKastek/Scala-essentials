package catseffect

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{ Success, Failure}

object Essentials {

  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))

  val aFuture: Future[Int] = Future {
    8
  }

  aFuture.onComplete {
    case Success(value) => println(s"value = ${value}")
    case Failure(exception) => println(exception)
  }

  val cartesianProduct = List(1,2,3).flatMap(n => List('a','b','b').map(c=>(n,c)))

  val cartesianProductComprehension = for {
    n <- List(1,2,3)
    c <- List('a','b','c')
  } yield(n,c)


  def main(args: Array[String]): Unit = {
    println(cartesianProduct)
    println(cartesianProductComprehension)
  }
}
