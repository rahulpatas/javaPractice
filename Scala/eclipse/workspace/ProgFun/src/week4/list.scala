package week4

trait list[T] {
  def isEmpty: Boolean
  def head: T
  def tail: list[T]
}

class Cons[T](val head: T, val tail: list[T]) extends list[T] {
  def isEmpty = false
}

class Nil[T] extends list[T]{
  def isEmpty: Boolean =true
  def head : Nothing = throw new NoSuchElementException("Nil.head")
  def tail : Nothing = throw new NoSuchElementException("Nil.tail")
}

 object list{
 
   def apply [T]( x1 : T, x2 : T): list[T] = new Cons(x1, new Cons(x2, new Nil))
   def apply [T] () = new Nil
 }