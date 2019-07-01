package javainterop

import scala.beans.BeanProperty

class Hello(@BeanProperty val name: String, val secondName: String) {
}
