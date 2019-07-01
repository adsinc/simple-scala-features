// call by value
def anyMoreThenTenByValue(p1: Int, p2: Int): Boolean =
  p1 > 10 || p2 > 10

anyMoreThenTenByValue(11, 12)

def getAndPrint(x: Int) = {
  println(x)
  x
}

anyMoreThenTenByValue(getAndPrint(11), getAndPrint(1))

// call by name
def anyMoreThenTenByName(p1: => Int, p2: => Int): Boolean =
  p1 > 10 || p2 > 10

anyMoreThenTenByName(getAndPrint(11), getAndPrint(1))

// собственные языковые конструкции
def repeatN(n: Int)(block: => Unit): Unit =
  (1 to n).foreach(_ => block)

repeatN(10) {
  print("hello")
  print("world")
}
