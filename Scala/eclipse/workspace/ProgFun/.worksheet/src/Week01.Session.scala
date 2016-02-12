package Week01
import math.abs
object Session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  println("Welcome to the Scala worksheet");$skip(4); val res$0 = 
1+3;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(39); 
def abs(x: Double) = if(x>0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(8); val res$1 = 
abs(-2);System.out.println("""res1: Double = """ + $show(res$1));$skip(323); 

  def sqrt(x: Double) = {
  
    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
      }


def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$2 = 

sqrt(2);System.out.println("""res2: Double = """ + $show(res$2));$skip(8); val res$3 = 
sqrt(3);System.out.println("""res3: Double = """ + $show(res$3));$skip(11); val res$4 = 
sqrt(1E-6);System.out.println("""res4: Double = """ + $show(res$4));$skip(11); val res$5 = 
sqrt(1e60);System.out.println("""res5: Double = """ + $show(res$5))}
}
