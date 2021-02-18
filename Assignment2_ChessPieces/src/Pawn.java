/**
 * Pawn is a chess piece. It can move one place ahead in its column.
 * It kills if it can move one place forward diagonally.
 */

public class Pawn extends AbstractPiece {
  /**
   * Constructor for a Pawn piece.
   *
   * @param row   int initial row
   * @param col   int initial col
   * @param color color of the piece
   */
  public Pawn(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  /**
   * canMove determines whether a pawn can move to target position.
   * A pawn can only move one place forward in its column.
   *
   * @param row int target row
   * @param col int target column
   * @return boolean if it can move to position
   */
  @Override
  public boolean canMove(int row, int col) {
    if (!validPosition(row, col)) {
      return false;
    }

    if (this.color == Color.BLACK) {
      return (this.col == col) && (this.row == row + 1);
    } else {
      return (this.col == col) && (this.row == row - 1);
    }
  }

  /**
   * canKill determines whether a pawn can kill an opponent piece.
   * A pawn can only move one place forward diagonally.
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

    if (this.color == Color.BLACK) {
      if (this.row == targetRow + 1) {
        if (this.col == targetCol - 1 || this.col == targetCol + 1) {
          return true;
        }
      }
      return false;
    } else {
      if (this.row == targetRow - 1) {
        if (this.col == targetCol - 1 || this.col == targetCol + 1) {
          return true;
        }
      }
      return false;
    }

  }
}
