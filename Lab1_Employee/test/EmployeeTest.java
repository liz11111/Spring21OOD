import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * EmployeeTest class tests all functionalities of Employee class with JUnit.
 */

public class EmployeeTest {
  private Employee e1;

  @Before
  public void setUp() {
    e1 = new Employee("Wenyuan", "Huang", 7.1);
  }

  @Test
  public void testEmployeeFirstName() {
    assertEquals("Wenyuan", e1.getFirstName());
  }

  @Test
  public void testEmployeeLastName() {
    assertEquals("Huang", e1.getLastName());
  }

  @Test
  public void testEmployeePayRate() {
    assertEquals(7.1, e1.getPayRate(), 0.001);
  }

  @Test
  public void testInitialHoursWorked() {
    assertEquals(0.0, e1.getHours(), 0.001);
  }

  @Test
  public void testAddHoursWorked() {
    e1.addHoursWorked(5.0);
    assertEquals(5.0, e1.getHours(), 0.001);
  }

  @Test
  public void testResetHoursWorked() {
    e1.resetHoursWorked();
    assertEquals(0.0, e1.getHours(), 0.001);
  }

  @Test
  public void testToString() {
    assertEquals("Wenyuan Huang", e1.toString());
  }
}
