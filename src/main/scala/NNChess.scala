import Array._

object NNChess {

  private val xMove = Array(2, 1, -1, -2, -2, -1, 1, 2)
  private val yMove = Array(1, 2, 2, 1, -1, -2, -2, -1)

  def getNNChess(N: Int, x: Int, y: Int): Unit = {
    val chess = ofDim[Int](N, N)
    chess(x)(y) = 1
    val curIndex = 2

    findPath(chess, N, x, y, curIndex)

    def findPath(chess: Array[Array[Int]], N: Int, x: Int, y: Int, curIndex: Int): Boolean = {

      if (curIndex == N * N + 1)
        return true

      for (i <- 0 to xMove.length) {

        val xNext = x + xMove(i)
        val yNext = y + yMove(i)

        if (xNext < N && xNext >= 0 && yNext >= 0 && yNext < N && chess(xNext)(yNext) == 0) {
          chess(xNext)(yNext) = curIndex

          if (findPath(chess, N, xNext, yNext, curIndex + 1)) {
            return true
          }
          else {
            chess(xNext)(yNext) = 0
          }
        }
      }

      false
    }
  }

  def printChess(chess: Array[Array[Int]]): Unit = {
    for (x <- 0 to chess.length) {
      for (y <- 0 to chess.length) {
        println((if (chess(x)(y) > 9) chess(x)(y) else "0" + chess(x)(y)) + " ")
      }
    }
  }

  def facTail(n: Int, offset: Int): Int = {
    if (n <= 1) offset else facTail(n-1, offset * n)
  }

  println(facTail(5, 1))
}
