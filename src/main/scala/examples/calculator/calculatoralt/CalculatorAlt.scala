package examples.calculator.calculatoralt

/**
  * Created by Shock on 2/27/2016.
  */
class CalculatorAlt {
  type Mapping= String => Double
  private var equation: Tree = _

  def main(): Unit = {

    // Create the equation : 5x - 3y | == 44 When x == 10 and y == 2
    val five = Const(5)
    val three = Const(3)
    val x = Var("x")
    val y = Var("y")
    equation = Difference(Product(five, x), Product(three, y))

    /* For explanation see ScalaReference Section 8.5
    http://www.scala-lang.org/files/archive/nightly/pdfs/ScalaReference.pdf
     */
    val result = evaluate(equation, { case "x" => 10 case "y" => 2})
    println("Calculator Alt : result = " + result)

  }

  private def evaluate(equation: Tree, mappingFunction: Mapping): Double = {
    equation.evaluate(mappingFunction)
  }
}

abstract class Tree {
  type Mapping= String => Double

  def evaluate(mapping: Mapping): Double
}

case class Difference(l: Tree, r: Tree) extends Tree {
  override def evaluate(mapping: Mapping): Double = l.evaluate(mapping) - r.evaluate(mapping)
}
case class Product(l: Tree, r: Tree) extends Tree {
  override def evaluate(mapping: Mapping): Double = l.evaluate(mapping) * r.evaluate(mapping)
}
case class Var(v: String) extends Tree {// used to represent a variable with a string
  override def evaluate(mapping: Mapping): Double = mapping(v)
}
case class Const(c: Double) extends Tree {
  override def evaluate(mapping: Mapping): Double = c
}







