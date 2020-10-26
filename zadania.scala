object zadania extends App{

  val dni = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

  // 1
  var wynik: String = " ";
  for(a <- dni){
    wynik = wynik+a+","
  }
  println(wynik)
  wynik= " "

  for(a <- dni){
    if(a.startsWith("P")) {
      wynik = wynik + a + ","
    }
  }
  println(wynik)
  wynik= " "
  var i = 0;
  while(i < dni.size){
    wynik = wynik + dni(i) + ","
    i = i + 1
  }

  println(wynik)
  wynik= " "

  // 2
  def rek(l: List[String]): String ={
    if (l.size > 0) l(0) + "," + rek(l.tail)
    else ""
  }
  println(rek(dni))

  def rek2(l: List[String]): String ={
    if (l.size > 0) rek2(l.tail)+ ","  + l(0)
    else ""
  }
  println(rek2(dni))

  // 3
  def rek3(l:List[String],wynik : String = "") :String = {
    if (l.size > 0) rek3(l.tail, wynik + "," + l(0))
    else wynik
  }
  println(rek3(dni,""))

  // 4
  wynik = dni.foldLeft("")(_+_+",")
  println(wynik)
  wynik = dni.foldRight("")(_+","+_)
  println(wynik)
  wynik = dni.filter(_.startsWith("P")).foldLeft("")(_+_+",")
  println(wynik)

  // 5
  var produkty = Map(
    "Telefon" -> 2200.00,
    "Klawiatura" -> 200.00,
    "Monitor" -> 1100.00,
    "Zasilacz" -> 250.00)

 produkty = produkty.map { case (k, v) => k -> 0.9 * v }
  println(produkty("Monitor"))

  // 6
  def printit(krotka: (String,Int,Double)) {
    print(krotka._1)
    print(krotka._2 + " ")
    println(krotka._3)
  }
  printit(("test ", 30 , 14.00))

  // 7
  def handle(key: Option[Double]) = key match{
    case None    => "Brak takiego produktu"
    case Some(s) => "Koszt produktu: " + s
  }
  println(handle(produkty.get("Telefon")))
  println(handle(produkty.get("Lampa")))

  // 8
  var liczby = List(6,4,0,7,15,9,0)
  def zeroext(list: List[Int], result: List[Int]): List[Int] = {
    if (list.size == 0) result
    else {
      if (list(0) == 0)
        zeroext(list.tail, result)
        else
        zeroext(list.tail, result ::: List(list(0)))
    }
  }
  println(zeroext(liczby, List()))

  // 9
  def add(l: List[Int]): List[Int] = {
    l.map(l => l + 1)
  }
  println(add(liczby))

  // 10
  val rzeczywiste = List(2,-5,0.5,18,4,20,-10)
  def przedzial(l : List[Double]) : List[Any] = {
    l.filter(_ <= 12).
      filter(_ >= -5).
      map(_.abs)
  }
  println(przedzial(rzeczywiste))
}
