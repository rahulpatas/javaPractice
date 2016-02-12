package week3

object RationWithSymboles {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 
 
 def makeString(r: Rational1) =
    r.numer + "/" + r.denom;System.out.println("""makeString: (r: week3.Rational1)String""");$skip(33); 


  val x1 = new Rational1(1, 3);System.out.println("""x1  : week3.Rational1 = """ + $show(x1 ));$skip(30); 
  val y = new Rational1(5, 7);System.out.println("""y  : week3.Rational1 = """ + $show(y ));$skip(30); 
  val z = new Rational1(3, 2);System.out.println("""z  : week3.Rational1 = """ + $show(z ));$skip(20); 
  val b = x1 - y -z;System.out.println("""b  : week3.Rational1 = """ + $show(b ));$skip(16); val res$0 = 
  makeString(b);System.out.println("""res0: String = """ + $show(res$0));$skip(10); val res$1 = 

  x1 < y;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(24); val res$2 = 

  makeString(x1 max y);System.out.println("""res2: String = """ + $show(res$2))}
  
  //val st= new Rational(1,0)
  //makeString(st.add(st))
  
}

class Rational1(x: Int, y: Int) {
  require(y != 0, "Denominator must be non Zero")
  
  def this(x : Int) = this(x,1)
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def <(that: Rational1) = numer * that.denom < that.numer * denom
  def max(that: Rational1) = if (this < that) that else this
  
  def + (that: Rational1) =
    new Rational1(
      numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- : Rational1 =
    new Rational1(-numer, denom)

  def - (that: Rational1) = this + -that
  //new Rational(
  //numer * that.denom - that.numer * denom, denom * that.denom)
}
