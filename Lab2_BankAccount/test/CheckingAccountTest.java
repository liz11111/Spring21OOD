import org.junit.Before;
import org.junit.Test;

import bank.CheckingAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * CheckingAccountTest class tests the functionalities of bank.CheckingAccount with JUnit tests.
 */
public class CheckingAccountTest {
  private CheckingAccount c1;

  @Before
  public void setUp() {
    c1 = new CheckingAccount(200.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    CheckingAccount c2 = new CheckingAccount(0.0);
  }

  @Test
  public void testGetBalance() {
    assertEquals(200.0, c1.getBalance(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalDeposit() {
    c1.deposit(-5);
  }

  @Test
  public void testDeposit() {
    c1.deposit(100.0);
    assertEquals(300.0, c1.getBalance(), 0.001);
  }

  @Test
  public void testWithdraw() {
    assertFalse(c1.withdraw(500.0));
    assertFalse(c1.withdraw(-5.0));
    assertTrue(c1.withdraw(1.0));
  }

  @Test
  public void testNoPenaltyMaintenance() {
    c1.performMonthlyMaintenance();
    assertEquals(200.0, c1.getBalance(), 0.001);
    c1.withdraw(50);
    assertEquals(150, c1.getBalance(), 0.001);
  }

  @Test
  public void testPenaltyMaintenance() {
    c1.withdraw(150);
    c1.performMonthlyMaintenance();
    assertEquals(45, c1.getBalance(), 0.001);

    c1.deposit(100);
    c1.performMonthlyMaintenance();
    assertEquals(140, c1.getBalance(), 0.001);

    c1.performMonthlyMaintenance();
    assertEquals(140, c1.getBalance(), 0.001);
  }
}
