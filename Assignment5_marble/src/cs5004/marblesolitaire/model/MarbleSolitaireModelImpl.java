package cs5004.marblesolitaire.model;

public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private State[][] board;
  private int score;

  public MarbleSolitaireModelImpl() {
    int armThickness = 3;
    int sRow = 3, sCol = 3;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    int armThickness = 3;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    int length = armThickness + (armThickness - 1) * 2;
    int sRow = length / 2, sCol = length / 2;
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
    throws IllegalArgumentException {
    this.board = new BoardGenerator().generate(armThickness, sRow, sCol);
    this.score = getTotalMarble(armThickness);
  }

  private int getTotalMarble(int armThickness) {
    return armThickness * armThickness * 5 // 5 squares
            - 4 // 4 corners overlaps
            - (armThickness * 2 + (armThickness - 2) * 2) // inner square circumference overlap
            - 1; // empty slot
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
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
    return 0;
  }
}
