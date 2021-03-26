package cs5004.marblesolitaire.model;

/**
 * BoardGenerator is a helper class that generates board.
 */
public class BoardGenerator {
  /**
   * Helps generate a game board according to specifications.
   *
   * @param armThickness int arm thickness
   * @param emptyRow     int empty cell row number
   * @param emptyCol     int empty cell col number
   * @return State[][] game board
   * @throws IllegalArgumentException if inputs are invalid
   */
  public State[][] generate(int armThickness, int emptyRow, int emptyCol) throws
          IllegalArgumentException {
    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd number.");
    }

    int length = armThickness + 2 * (armThickness - 1);
    if (emptyRow < 0 || emptyRow >= length || emptyCol < 0 || emptyCol >= length) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }

    State[][] board = new State[length][length];

    // set invalid positions
    for (int i = 0; i < armThickness - 1; i++) {
      for (int j = 0; j < armThickness - 1; j++) {
        board[i][j] = State.Invalid;
        board[i][length - 1 - j] = State.Invalid;
        board[length - 1 - i][j] = State.Invalid;
        board[length - 1 - i][length - 1 - j] = State.Invalid;
      }
    }

    // set empty position
    if (board[emptyRow][emptyCol] == State.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }
    board[emptyRow][emptyCol] = State.Empty;

    // set marble positions
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (board[i][j] == null) {
          board[i][j] = State.Marble;
        }
      }
    }

    return board;
  }
}
