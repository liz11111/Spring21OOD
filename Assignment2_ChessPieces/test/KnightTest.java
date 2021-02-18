import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * KnightTest class tests the functionalities of Knight with JUnit tests.
 */
public class KnightTest {
  private ChessPiece k1;
  private ChessPiece k2;

  @Before
  public void setUp() {
    k1 = new Knight(3, 3, Color.WHITE);
    k2 = new Knight(7, 1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    ChessPiece k3 = new Knight(-1, 0, Color.BLACK);
    ChessPiece k4 = new Knight(0, 8, Color.WHITE);
  }

  @Test
  public void testGetRow() {
    assertEquals(3, k1.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(3, k1.getColumn());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, k1.getColor());
  }

  @Test
  public void testIllegalMove1() {
    assertFalse(k1.canMove(-1, 0));
    assertFalse(k1.canMove(0, 8));
    assertFalse(k1.canMove(3, 3));
  }

  @Test
  public void testIllegalMove2() {
    //Test vertical movement
    assertFalse(k1.canMove(2, 3));
    //Test horizontal movement
    assertFalse(k1.canMove(3, 2));
    //Test out of board movement
    assertFalse(k1.canMove(-1, -1));
    //Test random movement
    assertFalse(k1.canMove(2, 6));
  }

  @Test
  public void testMove() {
    assertTrue(k1.canMove(1, 2));
    assertTrue(k1.canMove(2, 1));
    assertTrue(k1.canMove(4, 1));
    assertTrue(k1.canMove(5, 2));
    assertTrue(k1.canMove(5, 4));
    assertTrue(k1.canMove(4, 5));
    assertTrue(k1.canMove(2, 5));
    assertTrue(k1.canMove(1, 4));
  }

  @Test
  public void testIllegalKill1() {
    //Cannot kill pieces of same color
    ChessPiece p1 = new Pawn(1, 2, Color.WHITE);
    assertFalse(k1.canKill(p1));
    ChessPiece q1 = new Queen(5, 0, Color.BLACK);
    assertFalse(k2.canKill(q1));
  }

  @Test
  public void testIllegalKill2() {
    ChessPiece b1 = new Bishop(2, 2, Color.BLACK);
    assertFalse(k1.canKill(b1));
    ChessPiece r2 = new Rook(3, 3, Color.BLACK);
    assertFalse(k1.canKill(r2));
  }

  @Test
  public void testKill() {
    ChessPiece r1 = new Rook(1, 2, Color.BLACK);
    assertTrue(k1.canKill(r1));
  }
}
