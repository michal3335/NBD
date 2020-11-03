class Konto_bankowe(private var stanKonta: Double) {
  def this() {
    this(0)
  }
  def zwroc = stanKonta

  def wplata(ilosc: Double)={
    this.stanKonta = ilosc
  }

  def wyplata(ilosc: Double): Unit = {
    this.stanKonta -= ilosc
  }

}
  object Main {

    def main(args: Array[String]) {
      //zad2
      var konto = new Konto_bankowe()
      konto.wplata(500)
      println(konto.zwroc)
      konto.wyplata(500)
      println(konto.zwroc)
      var konto2 = new Konto_bankowe(500)
      println(konto2.zwroc)
    }
  }





