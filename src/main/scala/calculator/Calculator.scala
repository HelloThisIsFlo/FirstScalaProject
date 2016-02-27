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
  }

  type Environment = String => Int

  def eval(t: Tree, env: Environment): Int = {
    t match {
      case Sum(l, r) => eval(l, env) + eval(r, env)
      case Var(n) => env(n)
      case Const(v) => v
    }
  }
}
