/**
 * Knight is a chess piece. It can only move in L shape and kill opponent piece if it can move to
 * its place.
 */

public class Knight extends AbstractPiece {
  /**
   * Constructor for a knight piece.
   *
   * @param row   int initial row
   * @param col   int initial col
   * @param color color of the piece
   */
  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  /**
   * canMove determines if the piece can move to the specific position.
   * A knight can only move in L shape.
   *
   * @param row int target row
   * @param col int target column
   * @return
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!validPosition(row, col)) {
      return false;
    }

    int rowDiff = Math.abs(this.row - row);
    int colDiff = Math.abs(this.col - col);

    return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
  }

  /**
   * canKill determines whether a knight can kill an opponent piece.
   *
   * @param piece ChessPiece target to kill
   * @return boolean if it can kill
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.color == piece.getColor()) {
      return false;
    }

    int targetRow = piece.getRow();
    int targetCol = piece.getColumn();

    return canMove(targetRow, targetCol);
  }
}
