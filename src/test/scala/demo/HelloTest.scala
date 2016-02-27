package demo

import org.scalatest.FunSuite

/**
  * Created by Shock on 2/27/2016.
  */
class HelloTest extends FunSuite {

  test("sayHello method works correctly") {
    val hello = new Hello
    assert(hello.sayHello("Scala") == "Hello, Scala!")
  }
}
