package cs5004.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of TicTacToe game that supports all operations of the game.
 */
public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private final Player[][] board;
  private int round;

  /**
   * Constructor for TicTacToeModel. Initializes the board.
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    round = 1;
  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    } else if (outOfBound(r, c) || board[r][c] != null) {
      throw new IllegalArgumentException("Invalid position.");
    }

    board[r][c] = round % 2 == 0 ? Player.O : Player.X;
    round++;
  }

  /**
   * outOfBound checks if a given row and col are out of bound.
   *
   * @param r int row number
   * @param c int col number
   * @return boolean whether it is out of bound
   */
  private boolean outOfBound(int r, int c) {
    return r < 0 || r > 2 || c < 0 || c > 2;
  }

  @Override
  public Player getTurn() {
    return round % 2 == 0 ? Player.O : Player.X;
  }

  @Override
  public boolean isGameOver() {
    if (round < 6) {
      return false;
    } else if (round == 10) {
      return true;
    }

    return getWinner() != null;
  }

  @Override
  public Player getWinner() {
    // check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != null
              && board[i][0] == board[i][1]
              && board[i][1] == board[i][2]) {
        return board[i][0];
      }
    }

    // check cols
    for (int j = 0; j < 3; j++) {
      if (board[0][j] != null
              && board[0][j] == board[1][j]
              && board[1][j] == board[2][j]) {
        return board[0][j];
      }
    }

    // check diagonals
    if (board[1][1] != null
            && ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
            || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
      return board[1][1];
    }

    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] copy = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        copy[i][j] = board[i][j];
      }
    }

    return copy;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (outOfBound(r, c)) {
      throw new IllegalArgumentException("Invalid positions.");
    }

    return board[r][c];
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    /*
    return Arrays.stream(getBoard()).map(
            row -> " " + Arrays.stream(row).map(
                    p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
     */
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
    List<String> rows = new ArrayList<>();
    for (Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for (Player p : row) {
        if (p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
  }
}
