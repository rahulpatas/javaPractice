def square(n:Double): Double = n*n
def cube (n: Double): Double = n*square(n)

square(2.2)
cube(2.2)
1.23
val f = (x:Double) => x*x
val g = (_:Double)*2

def com(f: Double => Double, double: Double ): Double = f(double)
com(f, 2)

type vet3 = (Double, Double, Double)

def fac(n: Int): Int = if (n > 1) n*fac(n-1) else 1
fac(5)
Array(1,2,3)
val a = List(1,2,3,4,5)
a.head
a.take(2)

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
  val nums = Array.fill(20)(math.random)
  println(nums.mkString(","))
  bubbleSort(nums)
  println(nums.mkString(","))


def facTail(n: Int, offset: Int): Int = {

  if (n <= 1) offset else facTail(n-1, offset * n)
}

println(facTail(5, 1))




