import scala.util.Try

object Main {
  private val Forward: Int = 1
  private val Backward: Int = -1

  def main(args: Array[String]): Unit = {
    val input = args(0)
    Try(input.toInt).fold(_ => printSnailShell(0), printSnailShell)
  }

  private def printSnailShell(n: Int): Unit = {
    println(s"N = $n")
    printResult(n)
  }

  private def printResult(n: Int): Unit = {
    createSnailShell(n) foreach { row => println(row.mkString("\t")) }
  }

  def createSnailShell(n: Int): Array[Array[Int]] = {
    if (n < 1) {
      Array()
    } else {
      var startX = 0
      val lastIndex = n - 1
      var endX = lastIndex
      var startY = 0
      var endY = lastIndex

      var currentNumber: Int = 1
      val matrix = Array.ofDim[Int](n, n)

      def fillAndIncrease(x: Int, y: Int): Unit = {
        matrix(x)(y) = currentNumber
        currentNumber += 1
      }

      while (startX <= endX && startY <= endY) {
        var step = Forward
        // Move right
        startX to endX by step foreach { x => fillAndIncrease(startY, x) }
        startY += 1

        // Move down
        startY to endY by step foreach { y => fillAndIncrease(y, endX) }
        endX -= 1

        step = Backward
        // Move left
        endX to startX by step foreach { x => fillAndIncrease(endY, x) }
        endY -= 1

        // Move up
        endY to startY by step foreach { y => fillAndIncrease(y, startX) }
        startX += 1
      }

      matrix
    }
  }

}