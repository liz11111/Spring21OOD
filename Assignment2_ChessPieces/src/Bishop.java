/**
 * Bishop is a chess piece. It can only move diagonally, and kill any opponent chess if it moves to
 * its position.
 */

public class Bishop extends AbstractPiece {
  /**
   * Constructor for a bishop piece.
   *
   * @param row   int initial row
   * @param col   int initial col
   * @param color color of the piece
   */
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  /**
   * canMove determines whether a bishop can move to target position.
   * A bishop can only move diagonally.
   *
   * @param row int target row
   * @param col int target column
   * @return boolean if it can move to position
   */
  @Override
  public boolean canMove(int row, int col) {
    return canMoveDiag(row, col);
  }

  /**
   * canKill determines whether a bishop can kill an opponent piece.
   *
   * @param piece ChessPiece target to kill
   * @return boolean if it can kill the target piece
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
