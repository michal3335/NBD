class Osoba2 (private var _imie: String, private var _nazwisko: String, private var _podatek: Double){

  def imie = _imie
  def nazwisko = _nazwisko
  def podatek = _podatek
}

trait Student extends Osoba2 {
  override def podatek: Double = 0
}

trait Nauczyciel extends Pracownik {
  override def podatek = _pensja*0.1
}

trait Pracownik extends Osoba2{

  var _pensja: Double = 0

  def pensja = _pensja
  def pensja_ (p : Double) : Unit =  _pensja = p

  override def podatek: Double = _pensja*0.2
}

object Main3 {
  //zad5
  def main(args: Array[String]): Unit = {
    var student = new Osoba2("Michał","Majewski",1100) with Student
    var pracownik = new Osoba2("Marcin","Kowalski",1100) with Pracownik
    var nauczyciel = new Osoba2("Marek","Grzyb",1100) with Nauczyciel
    pracownik.pensja_(4000)
    nauczyciel.pensja_(4000)
    println(student.podatek)
    println(pracownik.podatek)
    println(nauczyciel.podatek)

    var studentPracownik = new Osoba2("Damian","Kucharek",1100) with Student with Pracownik
    var pracownikStudent = new Osoba2("Rafał","Jelen",1100) with Pracownik with Student

    studentPracownik.pensja_(4000)
    pracownikStudent.pensja_(4000)
    println(studentPracownik.podatek)
    println(pracownikStudent.podatek)

  }

}
