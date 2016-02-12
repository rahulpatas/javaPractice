package week4

trait ExprDe {
def eval : Int
}

class Number (n: Int) extends ExprDe {
  def eval: Int =n
}

class Sum (E1 : ExprDe, E2 : ExprDe) extends ExprDe {
  def eval : Int = E1.eval + E2.eval
}