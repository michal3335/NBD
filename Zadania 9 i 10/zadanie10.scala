object zadanie10 {

  def main(args: Array[String])= {

    val pom = pairs.buffered
    println(pom.next)
    println(pom.next)
    println(pom.next)
    pairs drop 3 take 17 foreach println
  }

  def pairs = for {
    a <- Iterator.from(1)
    b <- 1 to a
    if a%b == 0
  } yield(a,b)

}