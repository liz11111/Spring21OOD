import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PolynomialImplTest class tests all functionalities of Polynomial ADT with JUnit tests.
 */
public class PolynomialImplTest {
  private Polynomial p1;
  private Polynomial p2;
  private Polynomial p3;

  @Before
  public void setUp() {
    p1 = new PolynomialImpl();
    p2 = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    p3 = new PolynomialImpl("5");
  }

  @Test
  public void testEmptyConstructorAndToString() {
    assertEquals("0", p1.toString());
  }

  @Test
  public void testStringConstructorAndToString() {
    assertEquals("-2x^5 -3x^4 +11x^1 -5", p2.toString());
    assertEquals("5", p3.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    Polynomial p4 = new PolynomialImpl("x^-5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAddTerm() {
    p1.addTerm(4, -4);
  }

  @Test
  public void testAddTerm1() {
    // test adding term then deletes trailing 0
    // test with adding positive/negative/zero coefficients
    p1.addTerm(5, 3);
    assertEquals("5x^3", p1.toString());
  }

  @Test
  public void testAddTerm2() {
    // test adding term then add trailing 0
    p1.addTerm(5, 3);
    assertEquals("5x^3", p1.toString());
    p1.addTerm(-5, 3);
    assertEquals("0", p1.toString());
  }

  @Test
  public void testAddTerm3() {
    // test general adding terms
    p1.addTerm(5, 3);
    assertEquals("5x^3", p1.toString());
    p1.addTerm(-4, 2);
    assertEquals("5x^3 -4x^2", p1.toString());
    p1.addTerm(0, 1);
    assertEquals("5x^3 -4x^2", p1.toString());
    p1.addTerm(8, 0);
    assertEquals("5x^3 -4x^2 +8", p1.toString());
    p1.addTerm(5, 3);
    assertEquals("10x^3 -4x^2 +8", p1.toString());
    p1.addTerm(-11, 3);
    assertEquals("-1x^3 -4x^2 +8", p1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRemoveTerm() {
    p1.removeTerm(-1);
  }

  @Test
  public void testRemoveTerm1() {
    // test removing the last term then add trailing 0
    p1.addTerm(5, 3);
    p1.removeTerm(3);
    assertEquals("0", p1.toString());
    p3.removeTerm(0);
    assertEquals("0", p3.toString());
  }

  @Test
  public void testRemoveTerm2() {
    // test removing a term
    p2.removeTerm(4);
    assertEquals("-2x^5 +11x^1 -5", p2.toString());
    p2.removeTerm(0);
    assertEquals("-2x^5 +11x^1", p2.toString());
  }

  @Test
  public void testRemoveTerm3() {
    // test removing a non-existing term
    p1.removeTerm(1);
    assertEquals("0", p1.toString());
  }

  @Test
  public void testGetDegree() {
    assertEquals(0, p1.getDegree());
    assertEquals(5, p2.getDegree());
    assertEquals(0, p3.getDegree());
  }

  @Test
  public void testGetCoefficient1() {
    // test get coefficient from a non-existing term
    assertEquals(0, p2.getCoefficient(3));
    assertEquals(0, p1.getCoefficient(1));
    assertEquals(0, p3.getCoefficient(1));
  }

  @Test
  public void testGetCoefficient2() {
    // test get coefficient from an existing term
    assertEquals(0, p1.getCoefficient(0));
    assertEquals(-3, p2.getCoefficient(4));
    assertEquals(11, p2.getCoefficient(1));
    assertEquals(5, p3.getCoefficient(0));
  }

  @Test
  public void testEvaluate() {
    // test positive input
    assertEquals(0, p1.evaluate(1.2), 0.001);
    assertEquals(-2.99744, p2.evaluate(1.2), 0.001);
    assertEquals(5, p3.evaluate(1.2), 0.001);

    // test zero input
    assertEquals(0, p1.evaluate(0), 0.001);
    assertEquals(-5, p2.evaluate(0), 0.001);
    assertEquals(5, p3.evaluate(0), 0.001);

    // test negative input
    assertEquals(0, p1.evaluate(-1.2), 0.001);
    assertEquals(-19.44416, p2.evaluate(-1.2), 0.001);
    assertEquals(5, p3.evaluate(-1.2), 0.001);
  }

  @Test
  public void testAdd() {
    // test add with empty polynomial
    Polynomial p12 = p1.add(p2);
    assertEquals("-2x^5 -3x^4 +11x^1 -5", p12.toString());

    // test add with polynomial only contains constant
    Polynomial p23 = p2.add(p3);
    assertEquals("-2x^5 -3x^4 +11x^1", p23.toString());

    // test add with other polynomial with same and different power terms
    Polynomial p4 = new PolynomialImpl("6 +3x^5 -3x^3 -12x^1 +0x^500");
    Polynomial p24 = p2.add(p4);
    assertEquals("1x^5 -3x^4 -3x^3 -1x^1 +1", p24.toString());
  }
}
