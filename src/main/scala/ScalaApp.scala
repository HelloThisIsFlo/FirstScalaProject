/**
  * Created by Shock on 2/27/2016.
  */
object ScalaApp {
  def main(args: Array[String]) {
    println("Hello, world!")

    val frenchDateObject = new FrenchDate
    frenchDateObject.printDate()

    val complex = new Complex(2.3,6.7)
    println("Real : " + complex.re() + " | Imaginary : " + complex.im())
    
    val complexAlt = new ComplexWithoutParenthesis(4.65, 23.3)
    println("Real : " + complexAlt.re + " | Imaginary : " + complexAlt.im) // re and im are still method calls
    println(complexAlt.toString)
    println(complex.toString)
    // Try to change stuff



    stuffWithTheTimers()
  }



  def stuffWithTheTimers(): Unit = {
    val timer = new Timer
    timer.oncePerSecond(timer.timeFlies)

    val timerAnonymous = new TimerAnonymous(3)
    timerAnonymous.run()
  }
}