package calculator

/**
  * Set of case class representing an arithmetic operation
  */
abstract class Tree

case class Sum(l: Tree, r:Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

//{ case "x" => 5}
//type Environment = String => Int