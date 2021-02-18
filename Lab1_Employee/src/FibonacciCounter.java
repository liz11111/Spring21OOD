/**
 * FibonacciCounter class computes the nth fibonacci number FibonacciCounter class has attributes
 * count and fibonacci number associated with the current count.
 */

public class FibonacciCounter {
  private int currCount;
  private int currFiboNum;

  /**
   * Constructor helps instantiate a FibonacciCounter object with count set to currCount.
   *
   * @param currCount int count which must be greater than or equal to 0
   * @throws IllegalArgumentException if count is less than 0
   */
  public FibonacciCounter(int currCount) throws IllegalArgumentException {
    if (currCount < 0) {
      throw new IllegalArgumentException("Count cannot be less than 0");
    }

    this.currCount = currCount;
    this.currFiboNum = calculateFibo(currCount);
  }

  /**
   * calculateFibo calculates fibonacci number associated with current count.
   *
   * @param n int current count
   * @return int current fibonacci number
   */
  public int calculateFibo(int n) {
    double part1 = (1 / Math.sqrt(5));
    double part2 = ((Math.pow((1 + Math.sqrt(5)) / 2, n)) - (Math.pow((1 - Math.sqrt(5)) / 2, n)));
    return (int) (part1 * part2);
  }

  /**
   * incrementByOne returns a FibonacciCounter object with its count incremented by 1.
   *
   * @return FibonacciCounter object with its count incremented by 1
   */
  public FibonacciCounter incrementByOne() {
    return new FibonacciCounter(this.currCount + 1);
  }

  /**
   * decrementByOne returns a FibonacciCounter object with its count decremented by 1, if it cannot
   * be decremented, return the same count.
   *
   * @return FibonacciCounter object with its count decremented by 1
   */
  public FibonacciCounter decrementByOne() {
    return new FibonacciCounter(Math.max(0, this.currCount - 1));
  }

  /**
   * getCurrCount is a getter method for private field currCount.
   *
   * @return currCount int representing current count
   */
  public int getCurrCount() {
    return currCount;
  }

  /**
   * getCurrFiboNum is a getter method for private field currFiboNum.
   *
   * @return currFiboNum int representing the fibonacci number associated with current count
   */
  public int getCurrFiboNum() {
    return currFiboNum;
  }
}
