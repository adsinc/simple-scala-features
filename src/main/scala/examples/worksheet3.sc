// Паттерн матчинг
def sum(list: List[Int]): Int = list match {
  case Nil => 0
  case x :: xs => x + sum(xs)
}

sum(List(1, 2, 3, 4))

sealed trait Tree
case class Branch(left: Tree, right: Tree) extends Tree
case class Leaf(value: Int) extends Tree

// суммируем элементы дерева больше нуля
def sum(tree: Tree): Int = tree match {
  case Branch(l, r) => sum(l) + sum(r)
  case Leaf(v) if v > 0 => v
  case _ => 0
}

// чтобы так сделать нужен метод unapply
val t = Tuple3(1, 2, 3)
val (x, y, z) = t

class Point(val x: Int, val y: Int)
object Point {
  def unapply(p: Point): Option[(Int, Int)] = Some(p.x, p.y)
  // позволяет использовать констрировать объект без new
  def apply(): Point = new Point(0, 0)
}

val point = Point()
val Point(a, b) = point

// кейс класс автоматически создает методы apply и unapply

