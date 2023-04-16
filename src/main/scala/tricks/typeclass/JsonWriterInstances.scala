package tricks.typeclass

sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
final case object JsNull extends Json

// type class
trait JsonWriter[A]{
  def write(value: A): Json
}

// type class - implicit parameters
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}

// type class instances - implicit values
object JsonWriterInstances {



  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String]{
      def write(value: String): Json=
        JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(value: Person): Json =
        JsObject(Map(
          "name" -> JsString(value.name),
          "email" -> JsString(value.email)
        ))
    }

}


