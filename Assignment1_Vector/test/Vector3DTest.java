import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Vector3DTest class tests all functionalities of Vector3D class with JUnit.
 */

public class Vector3DTest {
  private Vector3D v1;
  private Vector3D v2;
  private Vector3D v3;
  private Vector3D v4;

  @Before
  public void setUp() {
    v1 = new Vector3D(1, 2, 2);
    v2 = new Vector3D(2.0, 0.0, 0.0);
    v3 = new Vector3D(0.0, -5.0, 0.0);
    v4 = new Vector3D(0, 0, 0.0);
  }

  @Test
  public void testConstructor() {
    assertEquals(1.0, v1.getX(), 0.001);
    assertEquals(2.0, v1.getY(), 0.001);
    assertEquals(2.0, v1.getZ(), 0.001);
  }

  @Test
  public void testToString() {
    assertEquals("(1.00,2.00,2.00)", v1.toString());
    assertEquals("(2.00,0.00,0.00)", v2.toString());
    assertEquals("(0.00,-5.00,0.00)", v3.toString());
    assertEquals("(0.00,0.00,0.00)", v4.toString());
  }

  @Test
  public void testGetMagnitude() {
    assertEquals(3.0, v1.getMagnitude(), 0.001);
    assertEquals(2.0, v2.getMagnitude(), 0.001);
    assertEquals(5.0, v3.getMagnitude(), 0.001);
    assertEquals(0.0, v4.getMagnitude(), 0.001);
  }

  @Test
  public void testNormalize1() {
    Vector3D v5 = v1.normalize();
    assertEquals((double) 1 / 3, v5.getX(), 0.001);
    assertEquals((double) 2 / 3, v5.getY(), 0.001);
    assertEquals((double) 2 / 3, v5.getZ(), 0.001);
  }

  @Test(expected = IllegalStateException.class)
  public void testNormalize2() {
    Vector3D v6 = v4.normalize();
  }

  @Test
  public void testAdd() {
    Vector3D v7 = v1.add(v2);
    assertEquals(3.0, v7.getX(), 0.001);
    assertEquals(2.0, v7.getY(), 0.001);
    assertEquals(2.0, v7.getZ(), 0.001);
    assertEquals(1.0, v1.getX(), 0.001);
    assertEquals(2.0, v1.getY(), 0.001);
    assertEquals(2.0, v1.getZ(), 0.001);
    assertEquals(2.0, v2.getX(), 0.001);
    assertEquals(0.0, v2.getY(), 0.001);
    assertEquals(0.0, v2.getZ(), 0.001);
  }

  @Test
  public void testMultiply() {
    Vector3D v8 = v1.multiply(3);
    assertEquals(3.0, v8.getX(), 0.001);
    assertEquals(6.0, v8.getY(), 0.001);
    assertEquals(6.0, v8.getZ(), 0.001);

    Vector3D v9 = v1.multiply(-3);
    assertEquals(-3.0, v9.getX(), 0.001);
    assertEquals(-6.0, v9.getY(), 0.001);
    assertEquals(-6.0, v9.getZ(), 0.001);
  }

  @Test
  public void testDotProduct() {
    double prod1 = v1.dotProduct(v2);
    assertEquals(2.0, prod1, 0.001);
    double prod2 = v1.dotProduct(v4);
    assertEquals(0.0, prod2, 0.001);
  }

  @Test
  public void testAngleBetween1() {
    double angle = v2.angleBetween(v3);
    assertEquals(90.0, angle, 0.001);
  }

  @Test(expected = IllegalStateException.class)
  public void testAngleBetween2() {
    double angle = v2.angleBetween(v4);
  }
}

