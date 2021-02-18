import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * PawnTest class tests the functionalities of pawn with JUnit tests.
 */
public class PawnTest {
  private ChessPiece p1;
  private ChessPiece p2;

  @Before
  public void setUp() {
    p1 = new Pawn(1, 2, Color.WHITE);
    p2 = new Pawn(6, 2, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    ChessPiece p3 = new Pawn(-1, 0, Color.BLACK);
    ChessPiece p4 = new Pawn(0, 8, Color.WHITE);
  }

  @Test
  public void testGetRow() {
    assertEquals(1, p1.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(2, p1.getColumn());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, p1.getColor());
  }

  @Test
  public void testIllegalMove1() {
    assertFalse(p1.canMove(-1, 0));
    assertFalse(p1.canMove(0, 8));
    assertFalse(p1.canMove(3, 3));
  }

  @Test
  public void testIllegalMove2() {
    //Test horizontal movement
    assertFalse(p1.canMove(1, 0));
    assertFalse(p1.canMove(1, 4));
    //Test backward vertical movement
    assertFalse(p1.canMove(0, 2));
    assertFalse(p2.canMove(7, 2));
    //Test vertical movement for more than one place
    assertFalse(p1.canMove(4, 2));
    assertFalse(p2.canMove(4, 2));
    //Test random movement
    assertFalse(p1.canMove(2, 6));
  }

  @Test
  public void testMove() {
    assertTrue(p1.canMove(2, 2));
    assertTrue(p2.canMove(5, 2));
  }

  @Test
  public void testIllegalKill1() {
    ChessPiece b1 = new Bishop(2, 1, Color.WHITE);
    assertFalse(p1.canKill(b1));
    ChessPiece b2 = new Bishop(5, 1, Color.BLACK);
    assertFalse(p2.canKill(b2));
  }

  @Test
  public void testIllegalKill2() {
    ChessPiece q1 = new Queen(2, 2, Color.BLACK);
    assertFalse(p1.canKill(q1));
    ChessPiece q2 = new Queen(3, 6, Color.WHITE);
    assertFalse(p2.canKill(q2));
    ChessPiece q3 = new Queen(1, 2, Color.BLACK);
    assertFalse(p1.canKill(q3));
  }

  @Test
  public void testKill() {
    ChessPiece k1 = new Knight(2, 1, Color.BLACK);
    assertTrue(p1.canKill(k1));
    ChessPiece k2 = new Knight(5, 1, Color.WHITE);
    assertTrue(p2.canKill(k2));
  }
}
