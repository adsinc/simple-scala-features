// рэнжи
(1 to 5).toList
(1 until 10).toList
val odd = 0.to(10, 2).toList

// продвинутый for для работы с коллекциями

val l = List(1, 2)

val pairs = for {
  i <- 1 to 5
  j <- 1 to 5
  x <- l.indices
  if i != j
  p = (i, j)
} yield p
