/**
  * Created by Shock on 2/27/2016.
  */
class TimerAnonymous(limit: Int) {

  def oncePerSecond(callback: () => Unit): Unit = {
    var i = 0
    while (i < limit) {
      i += 1
      callback()
      Thread sleep 1000
    }
  }

  def run(): Unit = {
    oncePerSecond(
      () => println("Time flies like an Arrow . . .")
    )
  }
}
