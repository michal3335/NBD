class Osoba (_imie: String,_nazwisko: String){

  def nazwisko = _nazwisko
}


object Main2 {

  def main(args: Array[String]) {

    //zad3
    val osoba1 = new Osoba("Michal","Majewski")
    val osoba2 = new Osoba("Robert","Brown")
    val osoba3 = new Osoba("Marian","Kowalski")
    val osoba4 = new Osoba("Damian","Glowacki")
    println(komunikat(osoba1))
    println(komunikat(osoba2))
    println(komunikat(osoba3))
    println(komunikat(osoba4))

    //zad4
    println(fun2(4,fun))
  }
  //zad3
  def komunikat(osoba: Osoba): String ={
    osoba.nazwisko match{
      case "Majewski" | "Kowalski" => "Dzien dobry"
      case "Brown" => "Hello"
      case _ => "Witaj gosciu"
    }
  }

  //zad4
  def fun(i : Int):Int={
    i+6
  }
  def fun2(i : Int,f : (Int) => Int):Int={
    f(f(f(i)))
  }

}

