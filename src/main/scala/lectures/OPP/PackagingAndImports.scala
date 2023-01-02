package lectures.OPP

//aliasing
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App{

  // package members are accesible by their simple name
  val writer = new Writer("Daniel", "RocktTheJVM",2018)

  // package object
  sayHello

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
