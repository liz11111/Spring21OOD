import org.junit.Before;
import org.junit.Test;

import bank.SavingsAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * CheckingAccountTest class tests the functionalities of bank.CheckingAccount with JUnit tests.
 */
public class SavingsAccountTest {
  private SavingsAccount s1;

  @Before
  public void setUp() {
    s1 = new SavingsAccount(10.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    SavingsAccount s2 = new SavingsAccount(0.0);
  }

  @Test
  public void testGetBalance() {
    assertEquals(10.0, s1.getBalance(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalDeposit() {
    s1.deposit(-5);
  }

  @Test
  public void testDeposit() {
    s1.deposit(100.0);
    assertEquals(110.0, s1.getBalance(), 0.001);
  }

  @Test
  public void testWithdraw() {
    assertFalse(s1.withdraw(500.0));
    assertFalse(s1.withdraw(-5.0));
    assertTrue(s1.withdraw(1.0));
  }

  @Test
  public void testNoPenaltyMaintenance() {
    s1.withdraw(1.0);
    s1.withdraw(1.0);
    s1.performMonthlyMaintenance();
    assertEquals(8.0, s1.getBalance(), 0.001);
  }

  @Test
  public void testPenaltyMaintenance() {
    s1.deposit(14.0);
    for (int i = 0; i < 7; i++) {
      s1.withdraw(1.0);
    }
    s1.performMonthlyMaintenance();
    assertEquals(3.0, s1.getBalance(), 0.001);
  }
}
