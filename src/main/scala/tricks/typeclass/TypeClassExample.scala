package tricks.typeclass
import JsonWriterInstances._

final case class Person(name: String, email: String)

object TypeClassExample  extends App {
  val personToJson = Json.toJson(Person("Dave", "dave@example.com"))(personWriter)
}

