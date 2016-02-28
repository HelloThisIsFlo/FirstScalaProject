package calculator

class Calculator {

  def main() {
    println("calculator started")

    val variable = Var("x")
    val constant = Const(3)
    val sum = Sum(variable, constant)

    val result = eval(sum, {case "x" => 5})
    println("Equation : " + sum.toString)
    println("Result = " + result)

    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = {
      case "x" => 5
      case "y" => 7
    }
    println()
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))

    val derived = derive(exp, "x")
    println("Simplified derivative relative to x : " + simplify(derived))
    println("Simplified derivative relative to y : " + simplify(derive(exp, "y")))
  }

  type Environment = String => Int

  def eval(t: Tree, env: Environment): Int = {
    t match {
      case Sum(l, r) => eval(l, env) + eval(r, env)
      case Var(n) => env(n)
      case Const(v) => v
    }
  }

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if v == n => Const(1) // Not a regular 'if'! Here it's a condition to match the case!
    case _ => Const(0)
  }

  def simplify(t: Tree): Tree = t match {
    case Sum(l, r) => simplifySum(Sum(l, r))
    case Const(a) => Const(a)
    case Var(v) => Var(v)
  }

  def simplifySum(s: Sum): Const = {
    var right: Const = Const(0)
    var left: Const = Const(0)

    s.r match {
      case Sum(a, b) => right = simplifySum(Sum(a, b))
      case Const(a) => right = Const(a)
    }
    s.l match {
      case Sum(a, b) => left = simplifySum(Sum(a, b))
      case Const(a) => left = Const(a)
    }

    return Const(right.v + left.v)
  }
}
