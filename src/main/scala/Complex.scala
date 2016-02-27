/**
  * Created by Shock on 2/27/2016.
  */
class Complex(real: Double, imaginary: Double) {
  def re() = real

  def im() = imaginary

}

class ComplexWithoutParenthesis(real: Double, imaginary: Double) {
  /**
    * Method without parenthesis
 *
    * @return value of real
    */
  def re = real

  def im = imaginary

  override def toString: String = "Real : " + re + " | Imaginary : " + im
}

/**
  * Example of a 'case' class.
  *
  * Here are the characteristics of a 'case' class : (It's basically a DTO)
  *
  *  - The new keyword is not mandatory to create instances of these classes
  *     (i.e., one can write Const(5) instead of new Const(5))
  *
  *  - Getter functions are automatically defined for the constructor parameters
  *     (i.e., it is possible to get the value of the v constructor parameter of some
  *     instance c of class Const just by writing c.v)
  *
  *  - Default definitions for methods equals and hashCode are provided, which work on the structure of the
  *     instances and not on their identity
  *
  *  - A default definition for method toString is provided, and prints the value in a “source form”
  *     (e.g., the tree for expression x+1 prints as Sum(Var(x),Const(1)))
  *
  *  - Instances of these classes can be decomposed through pattern matching as we will see below
  *
  */
case class ComplexCase(real: Double, imaginary: Double)
