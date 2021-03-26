package cs5004.marblesolitaire.model;

/**
 * MarbleSolitaireModeImpl implements all functionalities of MarbleSolitaireModel interface.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private State[][] board;
  private int score;
  private static final int[][] oneStep = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static final int[][] twoSteps = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};

  /**
   * Empty constructor takes no parameters. Initializes the game board with arm thickness 3 and
   * empty slot in the center.
   */
  public MarbleSolitaireModelImpl() {
    int armThickness = 3;
    int sRow = 3;
    int sCol = 3;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  /**
   * Constructor that takes in the row and col number of empty cell. Initializes the game board with
   * arm thickness 3 and specific position of empty cell.
   *
   * @param sRow int row number of empty cell
   * @param sCol int col number of empty cell
   * @throws IllegalArgumentException if sRow and sCol are invalid
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    int armThickness = 3;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  /**
   * Constructor that takes in arm thickness. Initializes the game board with specific arm thickness
   * and empty cell in the center.
   *
   * @param armThickness int arm thickness
   * @throws IllegalArgumentException if arm thickness is not a positive odd number
   */
  public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    int length = armThickness + (armThickness - 1) * 2;
    int sRow = length / 2;
    int sCol = length / 2;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  /**
   * Constructor that takes in arm thickness, row and col number of empty cell. Initializes the game
   * board with specific arm thickness and position of empty cell.
   *
   * @param armThickness int arm thickness, must be a positive odd number
   * @param sRow         int row number of empty cell
   * @param sCol         int col number of empty cell
   * @throws IllegalArgumentException if arm thickness, row and col are invalid
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  /**
   * Helper function that calculates total possible marbles.
   *
   * @param armThickness int arm thickness
   * @return int total possible number of marbles
   */
  private int getTotalMarble(int armThickness) {
    return armThickness * armThickness * 5 // 5 squares
            - 4 // 4 corners overlaps
            - (armThickness * 2 + (armThickness - 2) * 2) // inner square circumference overlap
            - 1; // empty slot
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (isOutOfBound(fromRow, fromCol) || isOutOfBound(toRow, toCol)) {
      throw new IllegalArgumentException("Invalid positions - out of bound");
    } else if (board[fromRow][fromCol] == State.Invalid || board[toRow][toCol] == State.Invalid) {
      throw new IllegalArgumentException("Invalid positions - illegal positions");
    } else if (board[fromRow][fromCol] == State.Empty || board[toRow][toCol] == State.Marble) {
      throw new IllegalArgumentException("Invalid positions - from position unoccupied "
              + "or to position occupied");
    } else if (!hasValidMoves(fromRow, fromCol)) {
      throw new IllegalArgumentException("Cannot make a move from from position");
    } else if (!isTwoPositionsAway(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("From and to positions are not two spaces away");
    } else if (board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == State.Empty) {
      throw new IllegalArgumentException("There is no marble between from and to positions");
    }

    board[fromRow][fromCol] = State.Empty;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = State.Empty;
    board[toRow][toCol] = State.Marble;
    score--;
  }

  /**
   * Helper function that checks if from and to positions are two spaces away.
   *
   * @param fromRow int from row
   * @param fromCol int from col
   * @param toRow   int to row
   * @param toCol   int to col
   * @return boolean whether from and to positions are two spaces away
   */
  private boolean isTwoPositionsAway(int fromRow, int fromCol, int toRow, int toCol) {
    for (int[] offset : twoSteps) {
      if (toRow == fromRow + offset[0] && toCol == fromCol + offset[1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Helper function that checks if a marble has possible moves.
   *
   * @param row int row of marble
   * @param col int col of marble
   * @return if it is possible to make a move from specific position
   */
  private boolean hasValidMoves(int row, int col) {
    if (isOutOfBound(row, col)
            || board[row][col] == State.Invalid
            || board[row][col] == State.Empty) {
      return false;
    }

    for (int i = 0; i < 4; i++) {
      int oneRow = row + oneStep[i][0];
      int oneCol = col + oneStep[i][1];
      int twoRow = row + twoSteps[i][0];
      int twoCol = col + twoSteps[i][1];

      if (!isOutOfBound(oneRow, oneCol) && !isOutOfBound(twoRow, twoCol)) {
        if (board[oneRow][oneCol] == State.Marble && board[twoRow][twoCol] == State.Empty) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Helper function that checks if a specific position of out of bound.
   *
   * @param row int row
   * @param col int col
   * @return boolean is out of bound
   */
  private boolean isOutOfBound(int row, int col) {
    return row < 0 || row >= board.length || col < 0 || col >= board.length;
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (hasValidMoves(i, j)) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      boolean flag = false;
      for (int j = 0; j < board.length; j++) {
        if (flag && board[i][j] == State.Invalid) {
          break;
        } else if (board[i][j] != State.Invalid) {
          flag = true;
        }
        sb.append(board[i][j].toString()).append(" ");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append("\n");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  @Override
  public int getScore() {
    return this.score;
  }
}
