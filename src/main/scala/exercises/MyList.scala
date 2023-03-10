package exercises
import math.Fractional.Implicits.infixFractionalOps
import math.Integral.Implicits.infixIntegralOps
import math.Numeric.Implicits.infixNumericOps
import scala.annotation.unused

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(Int) => new list with this element added
    toString  => string representation of the list
  */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "|" + printElements + "|"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A,A) => Int): MyList[A]
}

case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B>: Nothing](list: MyList[B]): MyList[B] = list
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B]= new Cons(element, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else " "+ h + " " + t.printElements
  }
  /*
    [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty))
  */
  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }
  /*
  [1,2].flatMap(m => [n, n+1]) = [1,2] ++ [2].flatMap(n => [n, n+1]) = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])=
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
  */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
  /*
  [1,2,3].filter(n % 2 == 0) =
  [2,3].filter(n % 2 == 0) =
  = new Cons(2, [3].filter(n % 2 == 0))
  = new Cons(2, Empty.filter(n % 2 == 0))
  = new Cons(2, Empty)
  */
  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  // hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A,A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x,sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
}



object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers.toString)

  println(listOfIntegers.map(elem => elem * 2).toString)
  println()
  listOfIntegers.foreach(x => print(x))
  println()
  listOfIntegers.foreach(print)
  println(listOfIntegers.sort((x,y) => y-x))
}
