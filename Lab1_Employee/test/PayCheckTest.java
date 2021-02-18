import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PayCheckTest class tests the functionalities of PayCheck class with JUnit.
 */

public class PayCheckTest {
  private PayCheck p1;
  private PayCheck p2;

  @Before
  public void setUp() {
    p1 = new PayCheck("Wenyuan", "Huang", 7.1, 5.0);
    p2 = new PayCheck("Chloe", "Chen", 7.1, 45.0);
  }

  @Test
  public void testTotalPayP1() {
    assertEquals(35.50, p1.getTotalPay(), 0.001);
  }

  @Test
  public void testTotalPayP2() {
    assertEquals(337.25, p2.getTotalPay(), 0.001);
  }

  @Test
  public void testToStringP1() {
    assertEquals("$35.50", p1.toString());
  }

  @Test
  public void testToStringP2() {
    assertEquals("$337.25", p2.toString());
  }
}
