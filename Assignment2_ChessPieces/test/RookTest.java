import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * RookTest class tests the functionalities of Rook with JUnit tests.
 */
public class RookTest {
  private ChessPiece r1;
  private ChessPiece r2;

  @Before
  public void setUp() {
    r1 = new Rook(3, 3, Color.WHITE);
    r2 = new Rook(7, 0, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    ChessPiece r3 = new Rook(-1, 0, Color.BLACK);
    ChessPiece r4 = new Rook(0, 8, Color.WHITE);
  }

  @Test
  public void testGetRow() {
    assertEquals(3, r1.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(3, r1.getColumn());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, r1.getColor());
  }

  @Test
  public void testIllegalMove1() {
    assertFalse(r1.canMove(-1, 0));
    assertFalse(r1.canMove(0, 8));
    assertFalse(r1.canMove(3, 3));
  }

  @Test
  public void testIllegalMove2() {
    //Test diagonal move
    assertFalse(r1.canMove(2, 2));
    //Test random move
    assertFalse(r1.canMove(2, 6));
  }

  @Test
  public void testMove() {
    assertTrue(r1.canMove(2, 3));
    assertTrue(r1.canMove(3, 2));
  }

  @Test
  public void testIllegalKill1() {
    ChessPiece b1 = new Bishop(2, 3, Color.WHITE);
    assertFalse(r1.canKill(b1));
    ChessPiece b2 = new Bishop(7, 1, Color.BLACK);
    assertFalse(r2.canKill(b2));
  }

  @Test
  public void testIllegalKill2() {
    ChessPiece k1 = new Knight(2, 2, Color.BLACK);
    assertFalse(r1.canKill(k1));
    ChessPiece k2 = new Knight(3, 3, Color.BLACK);
    assertFalse(r1.canKill(k2));
  }

  @Test
  public void testKill() {
    ChessPiece p1 = new Pawn(2, 3, Color.BLACK);
    assertTrue(r1.canKill(p1));
  }
}
