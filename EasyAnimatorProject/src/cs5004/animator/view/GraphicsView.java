package cs5004.animator.view;

import cs5004.animator.model.ReadOnlyModel;
import cs5004.animator.shape.Shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * GraphicView implements View interface and supports showing view as graphics.
 */
public class GraphicsView extends JFrame implements View, ActionListener {
  private ReadOnlyModel model;
  private int tick;
  private MyPanel panel;

  /**
   * Constructor for GraphicsView.
   * @param model ReadOnlyModel model
   * @throws IllegalArgumentException if model is null
   */
  public GraphicsView(ReadOnlyModel model) throws IllegalArgumentException {
    super();

    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    this.model = model;

    this.setSize(this.model.getCanvasWidth() + 100, this.model.getCanvasHeight() + 100);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // set layout
    this.setLayout(new BorderLayout());

    // initialize the panel
    panel = new MyPanel(this.model.getLeftBound(), this.model.getTopBound());
    panel.setBackground(Color.WHITE);
    panel.setPreferredSize(new Dimension(this.model.getCanvasWidth(),
            this.model.getCanvasHeight()));
    this.add(panel);

    // add scroll pane
    JScrollPane scrollPane = new JScrollPane(this.panel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollPane);

    this.setVisible(true);

    this.pack();
  }

  @Override
  public void play(int startTime, int speed) {
    Timer timer = new Timer(1000 / speed, this);
    tick = startTime;
    List<Shape> shapeList = model.getShapeAtTick(tick);
    panel.paintShapes(shapeList);
    timer.start();
  }

  @Override
  public void showErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage, "Error",
            JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    tick += 1;
    List<Shape> shapeList = model.getShapeAtTick(tick);
    panel.paintShapes(shapeList);
    this.refresh();
  }

  /**
   * refresh refreshes the canvas.
   */
  public void refresh() {
    this.repaint();
  }
}
