import java.text.DateFormat._
import java.util.{Date, Locale}

/**
  * Simple class to demonstrate the possibility to use Java libraries with scala
  */
class FrenchDate {
  def printDate(): Unit = {
    val now = new Date
    val frenchDate = getDateInstance(LONG, Locale.FRANCE)
    println(frenchDate format now)
  }
}
