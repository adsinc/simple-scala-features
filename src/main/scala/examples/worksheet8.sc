import scala.util.{Failure, Success, Try}

// optional
val name: Option[String] = Some("Alex")
val name2: Option[String] = Some("Grav")

name match {
  case Some(n) => n
  case None => "Error"
}

for {
  n1 <- name
  n2 <- name2
} yield s"$n1 and $n2"

name.iterator.toList

// Either
def parseInt(s: String): Either[String, Int] =
  Try(Integer.parseInt(s)) match {
    case Success(value) => Right(value)
    case Failure(exception) => Left(exception.toString)
  }

parseInt("10")
parseInt("a")