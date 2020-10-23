class Calc {

  /** fetch Integer's array, and return the Integer sum them all.
   *
   * Overflow occure when sum them all is over Integer.MAX_VALUE.
   *
   * @param seq Integer's array
   * @return an Integer value sum all Integers into the array.
   */
  def sum(seq: Seq[Int]): Int = seq.sum

  /** 整数を2つ受け取り、分子を分母で割った浮動小数点の値を返す
   *
   * 0でわろうとした際には実行時例外が投げられる
   */
  def div(numerator: Int, denominator: Int): Double = {
    if (denominator == 0) throw new ArithmeticException("/ by zero")
    numerator.toDouble / denominator.toDouble
  }

  /** 整数値を1つ受け取り、その値が素数であるかどうかの真偽値を返す */
  def isPrime(n: Int): Boolean = {
    if (n < 2) false else !((2 to Math.sqrt(n).toInt) exists(n % _ == 0))
  }
}
