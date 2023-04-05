package tricks.EncodingDecoding
import io.circe.*
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.syntax.*
import io.circe.Encoder.encodeString
import io.circe.jawn.decode

object EncodingDecoding  extends App {

  /*
  Encoding and decoding circe uses Encoder and Decoder type classes for encoding and decoding.
  An Encoder[A] instance provides a function that will convert any A to a Json,
  and a Decoder[A] takes a Json value to either an exception or an A.
  circe provides implicit instances of these type classes for many types from
  the Scala standard library, including Int, String, and others.
  It also provides instances for List[A], Option[A], and other generic types,
  but only if A has an Encoder instance.
  */

  final case class Message(sender: String, recipient: String, body: String)

  implicit val messageDecoder: Decoder[Message] = deriveDecoder[Message]
  implicit val messageEncoder: Encoder[Message] = deriveEncoder[Message]

  println("Example:")
  val messageJson = Message("a", "b", "test").asJson
  println(messageJson)
  val messageFromJson = messageJson.as[Message]
  messageFromJson.fold(err => println(err), message=> println(message.body))

  println("\nExample Wrong:")
  val messageJsonWrong = Message("a", "b", "test").asJson.toString + "\nERROR\n"
  println(messageJsonWrong)
  val messageFromWrong = messageJson.as[Message]
  messageFromWrong.fold(err => println(err), message=> println(message.body))

  println("Message example:")
  val message = Message("a", "b", "test")
  println(message.asJson)


  // Encoding
  println(( Message("a", "b", "test"): Message).asJson.noSpaces)
  println()

  // Decoding
  println(decode[Message]("""{"sender":"a","recipient":"b","body":"test"}"""))
}
