import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * MarbleSolitaireModelImplTest tests all functionalities of MarbleSolitaireModelImpl with JUnit
 * tests.
 */
public class MarbleSolitaireModelImplTest {
  @Test
  public void testFirstConstructor() {
    MarbleSolitaireModelImpl m = new MarbleSolitaireModelImpl();
    String board =
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";
    assertEquals(m.getGameState(), board);
  }

  @Test
  public void testValidSecondConstructor() {
    MarbleSolitaireModelImpl m = new MarbleSolitaireModelImpl(0, 2);
    String board =
                    "    _ O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";
    assertEquals(m.getGameState(), board);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor1() {
    // test empty row out of bound
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(-1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor4() {
    // test empty row out of bound
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(7, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor2() {
    // test empty col out of bound
    MarbleSolitaireModelImpl m3 = new MarbleSolitaireModelImpl(0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor5() {
    // test empty col out of bound
    MarbleSolitaireModelImpl m4 = new MarbleSolitaireModelImpl(0, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor3() {
    // test empty row and col being invalid
    MarbleSolitaireModelImpl m5 = new MarbleSolitaireModelImpl(0, 0);
    MarbleSolitaireModelImpl m6 = new MarbleSolitaireModelImpl(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor6() {
    // test empty row and col being invalid
    MarbleSolitaireModelImpl m7 = new MarbleSolitaireModelImpl(0, 6);
    MarbleSolitaireModelImpl m8 = new MarbleSolitaireModelImpl(6, 6);
  }

  @Test
  public void testValidThirdConstructor() {
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(3);
    String board1 =
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";
    assertEquals(m1.getGameState(), board1);

    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(5);
    String board2 =
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O";
    assertEquals(m2.getGameState(), board2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor1() {
    // test negative arm thickness
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor3() {
    // test negative arm thickness
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor2() {
    // test zero arm thickness
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor4() {
    // test even number arm thickness
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(2);
  }

  @Test
  public void testValidFourthConstructor() {
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(3, 0, 2);
    String board1 =
                    "    _ O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";
    assertEquals(m1.getGameState(), board1);

    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(5, 10, 8);
    String board2 =
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O _\n" +
                    "        O O O O O\n" +
                    "        O O O O O";
    assertEquals(m2.getGameState(), board2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor1() {
    // test even, negative or zero arm thickness
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(2, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor2() {
    // test even, negative or zero arm thickness
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(-1, 0, 2);
    MarbleSolitaireModelImpl m3 = new MarbleSolitaireModelImpl(-2, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor3() {
    // test even, negative or zero arm thickness
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(2, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor4() {
    // test invalid empty positions
    // row out of bound
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl(3, -1, 2);
    MarbleSolitaireModelImpl m2 = new MarbleSolitaireModelImpl(3, 7, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor5() {
    // test invalid empty positions
    // col out of bound
    MarbleSolitaireModelImpl m3 = new MarbleSolitaireModelImpl(3, 0, -1);
    MarbleSolitaireModelImpl m4 = new MarbleSolitaireModelImpl(3, 0, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor6() {
    // test invalid empty positions
    // empty cell is invalid
    MarbleSolitaireModelImpl m5 = new MarbleSolitaireModelImpl(5, 0, 0);
  }

  @Test
  public void testValidMove1() {
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, 3, 3);
    String board =
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O";
    assertEquals(m1.getGameState(), board);

    m1.move(2, 1, 2, 3);
    board = "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O";
    assertEquals(m1.getGameState(), board);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    // from row and col out of bound
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(-1, -1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    // to row and col out of bound
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    // from position invalid
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(0, 0, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    // to position invalid
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    // from position is empty
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(3, 3, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove6() {
    // to position is occupied
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(4, 3, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove7() {
    // from and to position is not two spaces away
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, 3, 3);
    m1.move(4, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove8() {
    // no marble between positions
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, 3, 3);
    m1.move(3, 3, 1, 3);
  }

  @Test
  public void testisGameOver1() {
    // test game is not over
    // new game
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    assertFalse(m1.isGameOver());
    // after one move
    m1.move(1, 3, 3, 3);
    assertFalse(m1.isGameOver());
    // after several moves then game is over
    m1.move(4, 3, 2, 3);
    m1.move(3, 1, 3, 3);
    m1.move(3, 4, 3, 2);
    m1.move(3, 6, 3, 4);
    m1.move(6, 3, 4, 3);
    String board =
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ O _ _\n" +
                    "O O O O O O O\n" +
                    "    O _ O\n" +
                    "    O _ O";
    assertEquals(m1.getGameState(), board);
    assertTrue(m1.isGameOver());
  }

  @Test
  public void testisGameOver2() {
    // test game is over while there's only one marble left
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    assertFalse(m1.isGameOver());
    m1.move(5, 3, 3, 3);
    m1.move(4, 5, 4, 3);
    m1.move(6, 4, 4, 4);
    m1.move(6, 2, 6, 4);
    m1.move(3, 4, 5, 4);
    assertFalse(m1.isGameOver());
    m1.move(6, 4, 4, 4);
    m1.move(1, 4, 3, 4);
    m1.move(2, 6, 2, 4);
    m1.move(4, 6, 2, 6);
    m1.move(2, 3, 2, 5);
    assertFalse(m1.isGameOver());
    m1.move(2, 6, 2, 4);
    m1.move(2, 1, 2, 3);
    m1.move(0, 2, 2, 2);
    m1.move(0, 4, 0, 2);
    m1.move(3, 2, 1, 2);
    assertFalse(m1.isGameOver());
    m1.move(0, 2, 2, 2);
    m1.move(5, 2, 3, 2);
    m1.move(4, 0, 4, 2);
    m1.move(2, 0, 4, 0);
    m1.move(4, 3, 4, 1);
    assertFalse(m1.isGameOver());
    m1.move(4, 0, 4, 2);
    m1.move(2, 3, 2, 1);
    m1.move(2, 1, 4, 1);
    m1.move(4, 1, 4, 3);
    m1.move(4, 3, 4, 5);
    assertFalse(m1.isGameOver());
    m1.move(4, 5, 2, 5);
    m1.move(2, 5, 2, 3);
    m1.move(3, 3, 3, 5);
    m1.move(1, 3, 3, 3);
    m1.move(3, 2, 3, 4);
    assertFalse(m1.isGameOver());
    m1.move(3, 5, 3, 3);
    String board =
                    "    _ _ _\n" +
                    "    _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "    _ _ _\n" +
                    "    _ _ _";
    assertEquals(m1.getGameState(), board);
    assertTrue(m1.isGameOver());
  }

  @Test
  public void testScore1() {
    // new game
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    assertEquals(32, m1.getScore());
  }

  @Test
  public void testScore2() {
    // after 1 move
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(1, 3, 3, 3);
    assertEquals(31, m1.getScore());
  }

  @Test
  public void testScore3() {
    MarbleSolitaireModelImpl m1 = new MarbleSolitaireModelImpl();
    m1.move(5, 3, 3, 3);
    m1.move(4, 5, 4, 3);
    m1.move(6, 4, 4, 4);
    m1.move(6, 2, 6, 4);
    m1.move(3, 4, 5, 4);
    m1.move(6, 4, 4, 4);
    m1.move(1, 4, 3, 4);
    m1.move(2, 6, 2, 4);
    m1.move(4, 6, 2, 6);
    m1.move(2, 3, 2, 5);
    m1.move(2, 6, 2, 4);
    m1.move(2, 1, 2, 3);
    m1.move(0, 2, 2, 2);
    m1.move(0, 4, 0, 2);
    m1.move(3, 2, 1, 2);
    m1.move(0, 2, 2, 2);
    m1.move(5, 2, 3, 2);
    m1.move(4, 0, 4, 2);
    m1.move(2, 0, 4, 0);
    m1.move(4, 3, 4, 1);
    m1.move(4, 0, 4, 2);
    m1.move(2, 3, 2, 1);
    m1.move(2, 1, 4, 1);
    m1.move(4, 1, 4, 3);
    m1.move(4, 3, 4, 5);
    m1.move(4, 5, 2, 5);
    m1.move(2, 5, 2, 3);
    m1.move(3, 3, 3, 5);
    m1.move(1, 3, 3, 3);
    m1.move(3, 2, 3, 4);
    m1.move(3, 5, 3, 3);
    assertEquals(1, m1.getScore());
  }
}
