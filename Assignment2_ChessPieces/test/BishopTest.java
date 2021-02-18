import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * BishopTest class tests the functionalities of Bishop with JUnit tests.
 */
public class BishopTest {
  private ChessPiece b1;
  private ChessPiece b2;

  @Before
  public void setUp() {
    b1 = new Bishop(3, 3, Color.WHITE);
    b2 = new Bishop(7, 2, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    ChessPiece b3 = new Bishop(-1, 0, Color.WHITE);
    ChessPiece b4 = new Bishop(0, 8, Color.BLACK);
  }

  @Test
  public void testGetRow() {
    assertEquals(3, b1.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(3, b1.getColumn());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, b1.getColor());
  }

  @Test
  public void testIllegalMove1() {
    assertFalse(b1.canMove(-1, 0));
    assertFalse(b1.canMove(0, 8));
    assertFalse(b1.canMove(3, 3));
  }

  @Test
  public void testIllegalMove2() {
    //Test vertical movement
    assertFalse(b1.canMove(2, 3));
    //Test horizontal movement
    assertFalse(b1.canMove(3, 2));
    //Test diagonal but out of board movement
    assertFalse(b1.canMove(-1, -1));
    assertFalse(b1.canMove(8, 8));
    //Test random movement
    assertFalse(b1.canMove(2, 5));
  }

  @Test
  public void testMove() {
    assertTrue(b1.canMove(2, 2));
    assertTrue(b1.canMove(2, 4));
    assertTrue(b1.canMove(4, 2));
    assertTrue(b1.canMove(4, 4));
    assertTrue(b1.canMove(7, 7));
  }

  @Test
  public void testIllegalKill1() {
    //Cannot kill pieces of same color
    ChessPiece k1 = new Knight(2, 2, Color.WHITE);
    assertFalse(b1.canKill(k1));
    ChessPiece q1 = new Queen(6, 1, Color.BLACK);
    assertFalse(b2.canKill(q1));
  }

  @Test
  public void testIllegalKill2() {
    ChessPiece r1 = new Rook(2, 3, Color.BLACK);
    assertFalse(b1.canKill(r1));
    ChessPiece r2 = new Rook(3, 3, Color.BLACK);
    assertFalse(b1.canKill(r2));
  }

  @Test
  public void testKill() {
    ChessPiece p1 = new Pawn(2, 2, Color.BLACK);
    assertTrue(b1.canKill(p1));
  }
}
