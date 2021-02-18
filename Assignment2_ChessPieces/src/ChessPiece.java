/**
 * ChessPiece interface provides contract to all chess pieces. It specifies what a chess piece can
 * do, including canMove, canKill, etc.
 */

public interface ChessPiece {
  /**
   * getRow is a getter for current row of the piece.
   *
   * @return int current row
   */
  int getRow();

  /**
   * getColumn is a getter for current column of the piece.
   *
   * @return int current column
   */
  int getColumn();

  /**
   * getColor is a getter for color of the piece.
   *
   * @return Color enum black or white
   */
  Color getColor();

  /**
   * canMove determines if the piece can move to the specific position.
   *
   * @param row int target row
   * @param col int target column
   * @return boolean if it can move to target position
   */
  boolean canMove(int row, int col);

  /**
   * canKill determines if the piece can kill another specific piece.
   *
   * @param piece ChessPiece target to kill
   * @return boolean if it can kill the specified piece
   */
  boolean canKill(ChessPiece piece);

}
