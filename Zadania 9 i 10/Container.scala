object Container {

  def main(args: Array[String])= {

    println("zad.1")
    val container = new Container2("50")
    println(container.getContent)
    val test = container.applyFunction(toInt)
    println(test+30)

    println("zad.2")
    val no = new No[String]
    val yes = new Yes[String]("100")
    println(no.isInstanceOf[Maybe[String]])
    println(yes.isInstanceOf[Maybe[String]])

    println("zad.3, zad.4")
    println(no.applyFunction(toInt).getOrElse("param"))
    println(yes.applyFunction(toInt).getOrElse("param"))
  }


  class Container2[A](private var _value: A) {

    def getContent: A = _value

    def applyFunction[R](x: A => R): R = {
      x(_value)
    }
  }

    trait Maybe[A] {
      def applyFunction[R](f: A => R): Maybe[R]

      def getOrElse[R >: A](default: R): R
    }

    class No[Nothing] extends Maybe[Nothing] {
      override def applyFunction[R](f: Nothing => R): Maybe[R] = {
        new No[R]
      }

      override def getOrElse[R >: Nothing](x: R): R = {x}
    }

    class Yes[A](private var _content: A) extends Maybe[A] {

      override def applyFunction[R](f: A => R): Maybe[R] = {
        new Yes[R](f(_content))
      }

      override def getOrElse[R >: A](x: R): R = {
        _content
      }
    }

  def toInt(s: String): Int = {
    try { s.toInt
    } catch {
      case e: Exception => 0
    }
  }

}