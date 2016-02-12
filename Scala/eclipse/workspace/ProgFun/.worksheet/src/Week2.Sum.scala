package Week2

object Sum {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(177); 
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(30); 

  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(37); 
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(108); 

  {
    def sum(f: Int => Int)(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  }}
  
                                                  
}
