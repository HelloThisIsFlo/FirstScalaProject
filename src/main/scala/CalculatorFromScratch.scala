import java.util

abstract class Tree

/**
  * Second version of the calculator, made from scratch to check if I understood the principles used in the first
  * version
  */
class CalculatorFromScratch {
  type Mapping = String => Double
  private var equation: Tree = _

  def main(): Unit = {

    // Create the equation : 5x - 3y | == 44 When x == 10 and y == 2
    val five = Const(5)
    val three = Const(3)
    val x = Var("x")
    val y = Var("y")
    equation = Difference(Product(five, x), Product(three, y))

    val map = new util.HashMap[String, Double]()

    doItTheJavaWay()
    doItTheScalaWay()
  }

  private def doItTheJavaWay(): Unit = {
    val map = new util.HashMap[String, Double]()
    map.put("x", 10)
    map.put("y", 2)

    println("Java way : " + evaluateJavaWay(equation, map))
  }

  private def evaluateJavaWay(equation: Tree, variables: util.Map[String, Double]): Double = {
    equation match {
      case Difference(l, r) =>
        return evaluateJavaWay(l, variables) - evaluateJavaWay(r, variables)
      case Product(l, r) =>
        return evaluateJavaWay(l, variables) * evaluateJavaWay(r, variables)
      case Var(v) =>
        return variables.get(v)
      case Const(c) =>
        return c
    }
  }

  private def doItTheScalaWay(): Unit = {
    println("Scala way : " + evaluateScalaWayWithTypes(equation, { case "x" => 10.0 case "y" => 2.0 }))
  }

  private def evaluateScalaWay(equation: Tree, mappingFunction: String => Double): Double = {
    equation match {
      case Difference(l, r) => evaluateScalaWay(l, mappingFunction) - evaluateScalaWay(r, mappingFunction)
      case Product(l, r) => evaluateScalaWay(l, mappingFunction) * evaluateScalaWay(r, mappingFunction)
      case Var(v) => mappingFunction(v)
      case Const(c) => c
    }
  }

  private def evaluateScalaWayWithTypes(equation: Tree, mappingFunction: Mapping): Double = equation match {
    case Difference(l, r) => evaluateScalaWayWithTypes(l, mappingFunction) - evaluateScalaWay(r, mappingFunction)
    case Product(l, r) => evaluateScalaWayWithTypes(l, mappingFunction) * evaluateScalaWay(r, mappingFunction)
    case Var(v) => mappingFunction(v)
    case Const(c) => c
  }
}

case class Difference(l: Tree, r: Tree) extends Tree

case class Product(l: Tree, r: Tree) extends Tree

case class Var(v: String) extends Tree

// used to represent a variable with a string
case class Const(c: Double) extends Tree
