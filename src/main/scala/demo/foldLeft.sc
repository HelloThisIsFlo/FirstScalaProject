case class Person (firstName: String, lastName: String, age: Int)
val persons = List(
  Person("Ted", "Neward", 38),
  Person("Scott", "Davis", 40),
  Person("Kito", "Mann", 35),
  Person("David", "Geary", 102),
  Person("Florian", "Kempenich", 26)
)
object Counter {
  var i = 0
  def incrementAndReturn: String = {
    i += 1
    i.toString
  }
}
def foldFunction(accum: String, it: Person) = accum +
  Counter.incrementAndReturn +
  "<person>\n" +
  "<firstName>" + it.firstName + "</firstName>\n" +
  "</person>\n\n"
val xml = persons.foldLeft("\n<peolple>\n\n") (foldFunction) + "</people>"
type FoldFunction= (String, Person) => String
def implementation(peoples: List[Person], foldFunction: FoldFunction): String = peoples match {
  case List() => "END"
  case it :: lst => foldFunction(implementation(lst, foldFunction), it)
}
implementation(persons, foldFunction)