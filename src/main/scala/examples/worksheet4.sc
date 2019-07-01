// алиасы типов
type IntIntBooleanMap = Map[Int, Map[Int, Boolean]]

//типы-значения
case class FirstName(firstName: String) extends AnyVal
case class SecondName(secondName: String) extends AnyVal

case class Person(firstName: FirstName, secondName: SecondName)
