// удобные коллекции
val l = List(1, 2, 3, 4)
l

val m = Map[Int, String]()
// тут мы восхищаемся кучей методов на все случаи жизни
// take drop reduce fold maxBy и тд


val names = List("Ana", "Pert", "Ivan", "Yohan Greg Shtromptersner")
val ages = List(10, 20, 30, 40)

case class Person(name: String, age: Int)

val q = names.zip(ages).map {
  case (name, age) => Person(name, age)
}
q.take(1)

names.zipWithIndex
// еще есть unzip для обратной операции

// стримы удобнее
// ленивые, но можно бранчеваться

var c = 0
def slowCalculation(): Int = {
  c += 1
  println(s"calculated: $c")
  c
}

//val ints = Stream.fill(5)(slowCalculation()).map(_ + 10)
val ints = LazyList.fill(5)(slowCalculation()).map(_ + 10)
ints.take(2).toList
ints.sum
