package cs5004.tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * Implementation of TicTacToeController interface.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private Appendable out;
  private Readable in;

  /**
   * Constructor for TicTacToeConsoleController. Initializes in and out.
   *
   * @param in  Readable input handler
   * @param out Appendable output handler
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("In and Out cannot be null");
    }

    this.in = in;
    this.out = out;
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    Scanner s = new Scanner(in);

    // print empty board
    try {
      out.append(m.toString() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Board state illegal");
    }

    // start game
    while (!m.isGameOver()) {
      // enter a move
      try {
        out.append("Enter a move for " + m.getTurn().toString() + ":\n");
      } catch (IOException e) {
        throw new IllegalStateException("Board state illegal");
      }

      String input1 = new String();
      String input2 = new String();
      try {
        input1 = s.next();
        input2 = s.next();
      } catch (Exception e) {
        e.printStackTrace();
      }

      // check game quits
      if (input1.equalsIgnoreCase("q") || input2.equalsIgnoreCase("q")) {
        try {
          out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
        } catch (IOException e) {
          throw new IllegalStateException("Board state illegal");
        }
        break;
      }

      // move

      try {
        int row = Integer.parseInt(input1);
        int col = Integer.parseInt(input2);
        row -= 1;
        col -= 1;
        m.move(row, col);
        out.append(m.toString() + "\n");
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (IOException e) {
        throw new IllegalStateException("Board state illegal");
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid position.");
      }
    }

    // check if game over
    if (m.isGameOver()) {
      try {
        if (m.getWinner() == Player.X) {
          out.append("Game is over! X wins.");
        } else if (m.getWinner() == Player.O) {
          out.append("Game is over! O wins.");
        } else {
          out.append("Game is over! Tie game.");
        }
      } catch (IOException e) {
        throw new IllegalStateException("Board state illegal");
      }
    }
  }
}