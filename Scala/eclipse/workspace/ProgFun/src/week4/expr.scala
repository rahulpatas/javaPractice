package week4

trait expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: expr
  def rightOp: expr
}

class number(n: Int) extends expr {
  def isNumber = true
  def isSum = false
  def numValue = n
  def leftOp: expr = throw new Error("Number.leftOp")
  def rightOp: expr = throw new Error("Number.rightOp")
}