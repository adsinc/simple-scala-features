import concurrent.ExecutionContext.Implicits.global
import concurrent._
import concurrent.duration._
import scala.util._

case class Token(value: String) extends AnyVal
case class Login(value: String) extends AnyVal
case class Password(value: String) extends AnyVal

val userDb = Map[Login, Password](Login("user1") -> Password("secret"))

def afterDelay(): Future[Unit] = Future{Thread.sleep(200)}

def authorize(login: Login, password: Password): Future[Token] =
  afterDelay().flatMap(_ =>
    userDb.get(login) match {
      case Some(p) =>
        if (p == password)
          Future.successful(Token(s"${login}_token"))
        else
          Future.failed(new RuntimeException("Incorrect password"))
      case None =>
        Future.failed(new RuntimeException(s"No user $login"))
    }
  )

def loadGreeting(token: Token): Future[String] =
  afterDelay.flatMap(_ => Future.successful(s"Hello, player $token"))

def loadMessages(token: Token): Future[Seq[String]] =
  afterDelay.flatMap(_ => Future.successful(Seq("msg1", "msg2")))

def enterGame(login: Login, password: Password): Future[(String, Seq[String])] =
  for {
    token <- authorize(login, password)
    greeting <- loadGreeting(token)
    messages <- loadMessages(token)
  } yield (greeting, messages)

val r = enterGame(Login("user1"), Password("secret")).transformWith {
  case Success(value) => Future.successful(Right(value))
  case Failure(exception) => Future.successful(Left(exception))
}
Await.result(r, 2.seconds)

val failed = enterGame(Login("user1"), Password("ololo")).transformWith {
  case Success(value) => Future.successful(Right(value))
  case Failure(exception) => Future.successful(Left(exception))
}

Await.result(failed, 2.seconds)

val failed2 = enterGame(Login("andrey"), Password("ololo")).transformWith {
  case Success(value) => Future.successful(Right(value))
  case Failure(exception) => Future.successful(Left(exception))
}

Await.result(failed2, 2.seconds)
