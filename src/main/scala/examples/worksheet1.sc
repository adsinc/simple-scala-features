import scala.util.Random
// var
var str = "new"
str = "year"
// val
val deerCount = 3
// def
def genPrintRandom = {
  val n = Random.nextInt()
  println(s"generated: $n")
  n
}

def genRandom = genPrintRandom
def genRandom2 = genPrintRandom


val randomNumber = genPrintRandom
randomNumber
randomNumber

lazy val randomNumber2 = genPrintRandom
randomNumber2
randomNumber2

// все является выражением
val q = 1
val result = if(q >= 0) "Positive" else "Negative"