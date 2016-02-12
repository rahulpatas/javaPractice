package Week2

object exp1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(175); 
   
  def sum(f: Int =>Int, a : Int, b: Int)= {
  
  def loop(a: Int, acc:Int): Int=
  if(a>b) acc
  else loop(a+1, f(a)+acc)
  
  loop(a, 0)
   };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(25); val res$0 = 
  sum (x => x * x, 3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(23); val res$1 = 
  sum(x => x*x*x, 3,5);System.out.println("""res1: Int = """ + $show(res$1))}
  }
  