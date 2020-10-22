import org.scalatest._

class CalcSpec extends FlatSpec with DiagrammedAssertions {
  val calc = new Calc

  "sum function" should "fetch integers array, and can return sum them all." in {
    assert(calc.sum(Seq(1,2,3)) === 6)
    assert(calc.sum(Seq(0)) === 0)
    assert(calc.sum(Seq(-1,1)) === 0)
    assert(calc.sum(Seq()) === 0)
  }

  it should "Overflow occure when sum them all is over Integer.MAX_VALUE." in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }
}
