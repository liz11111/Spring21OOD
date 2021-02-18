import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * QueenTest class tests the functionalities of Queen with JUnit tests.
 */
public class QueenTest {
  private ChessPiece q1;
  private ChessPiece q2;

  @Before
  public void setUp() {
    q1 = new Queen(3, 3, Color.WHITE);
    q2 = new Queen(7, 3, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    ChessPiece q3 = new Queen(-1, 0, Color.BLACK);
    ChessPiece q4 = new Queen(0, 8, Color.WHITE);
  }

  @Test
  public void testGetRow() {
    assertEquals(3, q1.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(3, q1.getColumn());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, q1.getColor());
  }

  @Test
  public void testIllegalMove1() {
    assertFalse(q1.canMove(-1, 0));
    assertFalse(q1.canMove(0, 8));
    assertFalse(q1.canMove(3, 3));
  }

  @Test
  public void testIllegalMove2() {
    //Test L shape movement
    assertFalse(q1.canMove(1, 2));
    //Test random movement
    assertFalse(q1.canMove(2, 7));
  }

  @Test
  public void testMove() {
    assertTrue(q1.canMove(2, 3));
    assertTrue(q1.canMove(3, 2));
    assertTrue(q1.canMove(2, 2));
  }

  @Test
  public void testIllegalKill1() {
    ChessPiece b1 = new Bishop(2, 2, Color.WHITE);
    assertFalse(q1.canKill(b1));
    ChessPiece b2 = new Bishop(6, 2, Color.BLACK);
    assertFalse(q2.canKill(b2));
  }

  @Test
  public void testIllegalKill2() {
    ChessPiece k1 = new Knight(2, 6, Color.BLACK);
    assertFalse(q1.canKill(k1));
    ChessPiece r2 = new Rook(3, 3, Color.BLACK);
    assertFalse(q1.canKill(r2));
  }

  @Test
  public void testKill() {
    ChessPiece r1 = new Rook(2, 3, Color.BLACK);
    assertTrue(q1.canKill(r1));
  }
}
