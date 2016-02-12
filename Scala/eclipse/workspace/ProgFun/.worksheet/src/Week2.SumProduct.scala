package Week2

object SumProduct {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(214); 

  def sumProduct(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), sumProduct(f, combine, zero)(a + 1, b));System.out.println("""sumProduct: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(92); 
  def product(f: Int => Int)(a: Int, b: Int): Int = sumProduct(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(29); val res$0 = 
  product(x => x * x )(1, 3);System.out.println("""res0: Int = """ + $show(res$0))}
}
