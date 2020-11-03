object Zadanie2_1 extends App {

def dni(dzien : String): String={
dzien match{
  case "Poniedzialek"| "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
  case "Sobota" | "Niedziela" => "Weekend"
  }
}
  println(dni("Poniedzialek"))
  println(dni("Niedziela"))
}
