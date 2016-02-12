package week4
import week4._

object LinkedList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(191); 
 
 def nth[T] (n : Int, t: list[T]) : T =
 if(t.isEmpty ) throw new IndexOutOfBoundsException
 else if (n == 0) t.head
 else nth(n-1, t.tail);System.out.println("""nth: [T](n: Int, t: week4.list[T])T""");$skip(62); 
 
 val list = new Cons(1, new Cons(2, new Cons (3, new Nil)));System.out.println("""list  : week4.Cons[Int] = """ + $show(list ));$skip(17); val res$0 = 
    nth(2, list);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
    nth(1, list);System.out.println("""res1: Int = """ + $show(res$1))}
    
 }
 