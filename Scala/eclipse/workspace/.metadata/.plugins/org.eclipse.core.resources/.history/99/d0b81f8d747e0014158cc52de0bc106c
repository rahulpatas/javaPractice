package week3

object Rationals {

  val x = new Rational(1, 2)                      //> x  : week3.Rational = week3.Rational@2133c8f8
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom)                          //> addRational: (r: week3.Rational, s: week3.Rational)week3.Rational

  def makeString(r: Rational) =
    r.numer + "/" + r.denom                       //> makeString: (r: week3.Rational)String

  makeString(addRational(new Rational(1, 2), new Rational(2, 3)))
                                                  //> res2: String = 7/6

  val y = new Rational(2, 3)                      //> y  : week3.Rational = week3.Rational@19dfb72a
  val a = x.add(y)                                //> a  : week3.Rational = week3.Rational@17c68925
  makeString(a)                                   //> res3: String = 7/6

  val x1 = new Rational(1, 3)                     //> x1  : week3.Rational = week3.Rational@7e0ea639
  val y1 = new Rational(5, 7)                     //> y1  : week3.Rational = week3.Rational@3d24753a
  val z = new Rational(3, 2)                      //> z  : week3.Rational = week3.Rational@59a6e353
  val b = x1.sub(y1).sub(z)                       //> b  : week3.Rational = week3.Rational@7a0ac6e3
  makeString(b)                                   //> res4: String = -79/42

  x1.less(y1)                                     //> res5: Boolean = true

  makeString(x1 max y1)                           //> res6: String = 5/7
  
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