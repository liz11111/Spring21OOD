/**
 * Rook is a chess piece. It can move horizontally and vertically.
 * It kills if it can move to the opponent's position.
 */

public class Rook extends AbstractPiece {
  /**
   * Constructor for a Rook piece.
   *
   * @param row   int initial row
   * @param col   int initial col
   * @param color color of the piece
   */
  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  /**
   * canMove determines whether a rook can move to target position.
   * A rook can move horizontally and vertically.
   *
   * @param row int target row
   * @param col int target column
   * @return boolean if it can move to position
   */
  @Override
  public boolean canMove(int row, int col) {
    return canMoveStraight(row, col);
  }

  /**
   * canKill determines whether a rook can kill an opponent piece.
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
