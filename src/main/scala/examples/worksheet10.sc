import javainterop._

import scala.jdk.CollectionConverters._

val scalaList = CallScalaCode.getStrings.asScala

scalaList.maxBy(_.length)

List(1, 2, 3).asJava
List(1, 2, 3).asJavaCollection
