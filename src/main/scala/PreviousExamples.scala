import calculator.Calculator

/**
  * Created by Shock on 2/27/2016.
  */
object PreviousExamples {
  type VoidVoid = () => Unit

  def run(): Unit = {

    val calculator = new Calculator
    calculator.main()

    testPassingAFunction({ () => println("tessfdafsdsdf") })
    testPassingAFunctionWithType({ () => println("With VoidVoid Type") })

    exampleUseJavaLibraries()
    exampleWithDTOs()
    functionAsParameter()
  }

  def testPassingAFunction(function: () => Unit): Unit = {
    function()
  }

  def testPassingAFunctionWithType(function: VoidVoid): Unit = {
    function()
  }

  def exampleUseJavaLibraries(): Unit = {
    val frenchDateObject = new FrenchDate
    frenchDateObject.printDate()
  }

  def exampleWithDTOs(): Unit = {
    val complex = new Complex(2.3, 6.7)
    println("Real : " + complex.re() + " | Imaginary : " + complex.im())

    val complexAlt = new ComplexWithoutParenthesis(4.65, 23.3)
    println("Real : " + complexAlt.re + " | Imaginary : " + complexAlt.im) // re and im are still method calls
    println(complexAlt.toString)
    println(complex.toString)
    // Try to change stuff

    val complexCase = ComplexCase(23, 3)
    println(complexCase)

    val complex2 = new Complex(2.3, 6.7)
    assert(complex2 != complex)
    val complexCase2 = ComplexCase(23, 3)
    assert(complexCase2 == complexCase)
    println(complexCase.real)
  }

  def functionAsParameter(): Unit = {
    val timer = new Timer
    timer.oncePerSecond(timer.timeFlies)

    val timerAnonymous = new TimerAnonymous(3)
    timerAnonymous.run()
  }
}
