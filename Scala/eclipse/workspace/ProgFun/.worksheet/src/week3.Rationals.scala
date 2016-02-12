package week3

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 

  val x = new Rational(1, 2);System.out.println("""x  : week3.Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(146); 

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom);System.out.println("""addRational: (r: week3.Rational, s: week3.Rational)week3.Rational""");$skip(62); 

  def makeString(r: Rational) =
    r.numer + "/" + r.denom;System.out.println("""makeString: (r: week3.Rational)String""");$skip(68); val res$2 = 

  makeString(addRational(new Rational(1, 2), new Rational(2, 3)));System.out.println("""res2: String = """ + $show(res$2));$skip(31); 

  val y = new Rational(2, 3);System.out.println("""y  : week3.Rational = """ + $show(y ));$skip(19); 
  val a = x.add(y);System.out.println("""a  : week3.Rational = """ + $show(a ));$skip(16); val res$3 = 
  makeString(a);System.out.println("""res3: String = """ + $show(res$3));$skip(32); 

  val x1 = new Rational(1, 3);System.out.println("""x1  : week3.Rational = """ + $show(x1 ));$skip(30); 
  val y1 = new Rational(5, 7);System.out.println("""y1  : week3.Rational = """ + $show(y1 ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week3.Rational = """ + $show(z ));$skip(28); 
  val b = x1.sub(y1).sub(z);System.out.println("""b  : week3.Rational = """ + $show(b ));$skip(16); val res$4 = 
  makeString(b);System.out.println("""res4: String = """ + $show(res$4));$skip(16); val res$5 = 

  x1.less(y1);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(26); val res$6 = 

  makeString(x1 max y1);System.out.println("""res6: String = """ + $show(res$6))}
  
  //val st= new Rational(1,0)
  //makeString(st.add(st))
  
}

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be non Zero")
  
  def this(x : Int) = this(x,1)
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def less(that: Rational) = numer * that.denom < that.numer * denom
  def max(that: Rational) = if (this.less(that)) that else this
  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom, denom * that.denom)

  def neg: Rational =
    new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
  //new Rational(
  //numer * that.denom - that.numer * denom, denom * that.denom)
}
