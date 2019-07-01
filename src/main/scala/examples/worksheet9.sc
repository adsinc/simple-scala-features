import java.util.Date

//имплиситы
val name = "Grav"

implicit class StringOpts(s: String) {
  def wrapped: String = s"($s)"
}

name.wrapped

// неявные пераметры
def toCSV[T](data: List[T])(implicit encoder: T => String): String =
  data.foldLeft("")((acc, t) => acc + s"${encoder(t)}\n")

case class Player(id: Int, name: String, createDate: Date)

implicit def playerEncoder(player: Player)(implicit e: Date => String): String =
  s"${player.id},${player.name}, ${e(player.createDate)}"

implicit def dateEncoder(date: Date): String =
  date.toInstant.toEpochMilli.toString

def players = List(
  Player(1, "John Snow", new Date()),
  Player(2, "Dragon", new Date())
)

val csv = toCSV(players)

// являются основой для тайп левел программирования
// являются основой для функционального программирования