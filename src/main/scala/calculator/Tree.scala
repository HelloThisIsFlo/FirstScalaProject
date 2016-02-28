package calculator

/**
  * Set of case class representing an arithmetic operation
  */
abstract class Tree

case class Difference(l: Tree, r:Tree) extends Tree
case class Sum(l: Tree, r:Tree) extends Tree {
  override def toString: String = l.toString + " + " + r.toString
}
case class Var(n: String) extends Tree {
  override def toString: String = n
}
case class Const(v: Int) extends Tree {
  override def toString: String = v.toString
}

//{ case "x" => 5}
//type Environment = String => Int