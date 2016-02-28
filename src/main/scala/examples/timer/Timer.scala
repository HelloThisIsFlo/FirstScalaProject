package examples.timer

/**
  * Simple class to demonstrate that functions can be used as arguments :D
  */
class Timer {
  /**
    * This is a javadoc test (scaladoc ??)
    *
    * With different types of markdown style formatting.
    *
    * =Title=
    *
    * Like for instance `monospace` or ''italic text'' and '''bold text'''
    *
    * There is also __underline__ and ^superscript, no idea what it is^
    *
    * {{{
    *   This is multiline code block
    * }}}
    *
    * @param callback Function that will be called once every second
    */
  def oncePerSecond(callback: (String) => Unit): Unit = {
    var i = 0
    while (i < 10) {
      i += 1
      callback(i.toString)
      Thread sleep 300
    }
  }

  def timeFlies(number: String): Unit = {
    println(s"$number : Time flies . . . like an arrow . . .")
  }
}