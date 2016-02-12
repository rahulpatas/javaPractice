package Week2

object SumProduct {

  def sumProduct(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), sumProduct(f, combine, zero)(a + 1, b))
                                                  //> sumProduct: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
  def product(f: Int => Int)(a: Int, b: Int): Int = sumProduct(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x )(1, 3)                      //> res0: Int = 36
}