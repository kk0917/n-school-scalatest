import org.scalatest._
import org.scalatest.concurrent.TimeLimits._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.time.SpanSugar._
import org.mockito.Mockito._

class CalcSpec extends FlatSpec with DiagrammedAssertions with MockitoSugar {
  val calc = new Calc

  "Calc.sum function" should "fetch integers array, and can return sum them all." in {
    assert(calc.sum(Seq(1,2,3)) === 6) // true
    assert(calc.sum(Seq(0)) === 0)     // true
    assert(calc.sum(Seq(-1,1)) === 0)  // true
//  assert(calc.sum(Seq()) === 9999)   // false
  }

  it should "Overflow occure when sum them all is over Integer.MAX_VALUE." in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  "Calc.div function" should "Receive two Integer value, and return float value divided the numerator by the denominator." in {
    assert(calc.div(6, 3) === 2.0)
    assert(calc.div(1, 3) === 0.3333333333333333)
  }
  it should "Exception is thrown when dividing by 0." in {
    intercept[ArithmeticException] {
      calc.div(1, 0)
    }
  }

  "Calc.isPrime function" should "Return boolean value whether or not it is prime number." in {
    assert(calc.isPrime(0) === false)
    assert(calc.isPrime(-1) === false)
    assert(calc.isPrime(2))
    assert(calc.isPrime(17))
  }

  it should "Be able to process judging prime number under 1000 thousand value within 1 seconds." in {
    failAfter(1000 millis) {
        assert(calc.isPrime(9999991))
    }
  }

  "Calc Mock's object" should "Be able to camouflage behaviours" in {
    val mockCalc = mock[Calc]
    when(mockCalc.sum(Seq(3,4,5))).thenReturn(12)
    assert(mockCalc.sum(Seq(3,4,5)) === 12)
  }

  // TODO: How to output asserts value?
}
