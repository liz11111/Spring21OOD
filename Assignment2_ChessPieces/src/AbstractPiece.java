/**
 * AbstractPiece is an abstract class. It contains common fields and implementations for a chess
 * piece.
 */
public abstract class AbstractPiece implements ChessPiece {
  protected int row;
  protected int col;
  protected Color color;

  /**
   * Constructor for a chess piece.
   *
   * @param row   int initial row
   * @param col   int initial col
   * @param color color of the piece
   */
  public AbstractPiece(int row, int col, Color color) throws IllegalArgumentException {
    if (!validPosition(row, col)) {
      throw new IllegalArgumentException("Cannot initialize a piece outside of board");
    }

    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public Color getColor() {
    return color;
  }

  /**
   * validPosition checks if a target position is on the chess board.
   *
   * @param row int target row
   * @param col int target col
   * @return boolean whether it is a valid position
   */
  protected boolean validPosition(int row, int col) {
    return !(row < 0 || row > 7 || col < 0 || col > 7);
  }

  /**
   * canMoveDiag determines if a piece can move diagonally to target position.
   *
   * @param row int target row
   * @param col int target col
   * @return boolean whether it can move
   */
  protected boolean canMoveDiag(int row, int col) {
    if (!validPosition(row, col)) {
      return false;
    } else if (this.row == row && this.col == col) {
      return false;
    }

    return Math.abs(this.row - row) == Math.abs(this.col - col);
  }

  /**
   * canMoveStraight determines if a piece can move horizontally or vertically to target position.
   *
   * @param row int target row
   * @param col int target col
   * @return boolean whether it can move
   */
  protected boolean canMoveStraight(int row, int col) {
    if (!validPosition(row, col)) {
      return false;
    } else if (this.row == row && this.col == col) {
      return false;
    }

    return (this.row == row) || (this.col == col);
  }
}
