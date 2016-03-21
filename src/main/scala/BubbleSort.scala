
object BubbleSort {

  def bubbleSort(array: Array[Double]): Unit = {

    for (i <- 0 until array.length - 1) {

      for (j <- 0 until(array.length - 1 - i)) {

        if (array(j) > array(j + 1)){
          val tmp = array(j)
          array(j) = array(j+1)
          array(j + 1) = tmp;
        }
      }

    }

  }

  def main(args: Array[String]) {

    val nums = Array.fill(20)(math.random)
    println(nums.mkString(","))
    bubbleSort(nums)
    println(nums.mkString(","))
  }
}
