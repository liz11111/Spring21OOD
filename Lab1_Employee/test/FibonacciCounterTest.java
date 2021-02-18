import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * FibonacciCounterTest class tests the functionalities of FibonacciCounter class with JUnit.
 */
public class FibonacciCounterTest {
  private FibonacciCounter f1;
  private FibonacciCounter f2;

  @Before
  public void setUp() {
    f1 = new FibonacciCounter(0);
    f2 = new FibonacciCounter(7);
  }

  @Test
  public void testFibonacciCounterf1() {
    assertEquals(0, f1.getCurrCount());
    assertEquals(0, f1.getCurrFiboNum());
  }

  @Test
  public void testFibonacciCounterf2() {
    assertEquals(7, f2.getCurrCount());
    assertEquals(13, f2.getCurrFiboNum());
  }

  @Test
  public void testIncrementF1() {
    FibonacciCounter f3 = f1.incrementByOne();
    assertEquals(1, f3.getCurrCount());
    assertEquals(1, f3.getCurrFiboNum());
  }

  @Test
  public void testIncrementF2() {
    FibonacciCounter f4 = f2.incrementByOne();
    assertEquals(8, f4.getCurrCount());
    assertEquals(21, f4.getCurrFiboNum());
  }

  @Test
  public void testDecrementF1() {
    FibonacciCounter f5 = f1.decrementByOne();
    assertEquals(0, f5.getCurrCount());
    assertEquals(0, f5.getCurrFiboNum());
  }

  @Test
  public void testDecrementF2() {
    FibonacciCounter f6 = f2.decrementByOne();
    assertEquals(6, f6.getCurrCount());
    assertEquals(8, f6.getCurrFiboNum());
  }
}
