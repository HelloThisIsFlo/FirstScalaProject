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
