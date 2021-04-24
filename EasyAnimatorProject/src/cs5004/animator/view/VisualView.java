package cs5004.animator.view;

import cs5004.animator.model.ReadOnlyModel;
import cs5004.animator.shape.Shape;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class VisualView extends JFrame implements EditorView {

  private ReadOnlyModel model;
  private Timer timer;
  private float speed;
  private boolean isPlaying;
  private boolean loopEnable;

  private JPanel mainPanel;
  private JPanel sideBar;
  private JPanel buttonPanel;
  private JPanel filePanel;
  private MyPanel panel;
  private JLabel speedDisplay;

  private JButton play;
  private JButton loop;
  private JButton restart;
  private JButton increaseSpeed;
  private JButton decreaseSpeed;
  private JButton openFile;
  private JButton saveFile;

  /**
   * Constructs visual view given the read-only model.
   *
   * @param model the ReadOnlyModel passed into the view
   * @throws IllegalArgumentException if the model is null
   */
  public VisualView(ReadOnlyModel model)
      throws IllegalArgumentException {
    super();
    if (model == null) {
      throw new IllegalArgumentException("The model can't be null.");
    }
    this.model = model;
    this.speed = 1;

    this.isPlaying = false;
    this.loopEnable = false;

    // set size
    this.setSize(1000, 600);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // set side bar
    this.sideBar = new JPanel();
    this.sideBar.setPreferredSize(new Dimension(200, 600));
    this.sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
    this.add(this.sideBar);

    // add file panel
    this.filePanel = new JPanel();
    this.filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));
    this.filePanel.setBorder(BorderFactory.createTitledBorder("File Management"));

    this.openFile = new JButton("Open A File");
    this.openFile.setPreferredSize(new Dimension(150, 30));
    this.openFile.setActionCommand("OpenFile");
    this.filePanel.add(openFile);

    this.filePanel.add(new JLabel("    "));

    this.saveFile = new JButton("Save as");
    this.saveFile.setPreferredSize(new Dimension(150, 30));
    this.saveFile.setActionCommand("SaveFile");
    this.filePanel.add(saveFile);

    this.sideBar.add(this.filePanel);

    this.sideBar.add(new JLabel("   "));

    // add shape management panel

    // set main panel
    this.mainPanel = new JPanel();
    this.mainPanel.setPreferredSize(new Dimension(800, 600));
    this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

//    // set file panel
//    this.filePanel = new JPanel();
//    this.filePanel.setLayout(new FlowLayout());
//
//    this.openFile = new JButton("Open A File");
//    this.openFile.setPreferredSize(new Dimension(150, 30));
//    this.openFile.setActionCommand("OpenFile");
//    this.filePanel.add(openFile);
//
//    this.saveFile = new JButton("Save as");
//    this.saveFile.setPreferredSize(new Dimension(150, 30));
//    this.saveFile.setActionCommand("SaveFile");
//    this.filePanel.add(saveFile);
//
//    this.mainPanel.add(this.filePanel);

    // set panel
    this.panel = new MyPanel(this.model.getLeftBound(), this.model.getTopBound());
    this.panel.setBackground(Color.WHITE);
    this.panel.setPreferredSize(new Dimension(this.model.getCanvasWidth(),
        this.model.getCanvasHeight()));
    this.mainPanel.add(this.panel);
    this.mainPanel.add(new JScrollPane(this.panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

    // set button panel
    this.buttonPanel = new JPanel();
    this.buttonPanel.setBackground(Color.LIGHT_GRAY);
//    this.buttonPanel.setBorder(BorderFactory.createTitledBorder("Playback Control"));
    this.buttonPanel.setPreferredSize(new Dimension(500, 40));
    this.buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

    // play control
    JPanel playControl = new JPanel();
    playControl.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    playControl.setLayout(new BoxLayout(playControl, BoxLayout.LINE_AXIS));

    playControl.add(new JLabel("     "));

    this.play = new JButton("Play");
    this.play.setPreferredSize(new Dimension(150, 30));
    //this.play.setSize(new Dimension(100, 30));
    this.play.setActionCommand("PlayPause");
    playControl.add(play);

    playControl.add(new JLabel("     "));

    this.restart = new JButton("Restart");
    this.restart.setPreferredSize(new Dimension(100, 30));
    this.restart.setActionCommand("Restart");
    playControl.add(restart);

    playControl.add(new JLabel("     "));

    this.buttonPanel.add(playControl);

    //this.buttonPanel.add(new JLabel("        "));

    // playback detail
    JPanel detailControl = new JPanel();
    detailControl.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    detailControl.setLayout(new BoxLayout(detailControl, BoxLayout.LINE_AXIS));

    detailControl.add(new JLabel("      "));

    this.loop = new JButton("Enable Looping");
    this.loop.setPreferredSize(new Dimension(200, 30));
    this.loop.setActionCommand("LoopControl");
    detailControl.add(loop);

    detailControl.add(new JLabel("      "));

    this.buttonPanel.add(detailControl);
    //this.buttonPanel.add(new JLabel("      "));

    // speed setting
    JPanel speedControl = new JPanel();
    speedControl.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    speedControl.setLayout(new BoxLayout(speedControl, BoxLayout.LINE_AXIS));

    speedControl.add(new JLabel("      "));

    this.increaseSpeed = new JButton("Increase Speed");
    this.increaseSpeed.setPreferredSize(new Dimension(200, 30));
    this.increaseSpeed.setActionCommand("SpeedUp");
    speedControl.add(increaseSpeed);

    speedControl.add(new JLabel("   "));

    this.speedDisplay = new JLabel("Playback Speed: 1");
    this.speedDisplay.setPreferredSize(new Dimension(200, 30));
    speedControl.add(this.speedDisplay);

    speedControl.add(new JLabel("   "));

    this.decreaseSpeed = new JButton("Decrease Speed");
    this.decreaseSpeed.setPreferredSize(new Dimension(200, 30));
    this.decreaseSpeed.setActionCommand("SlowDown");
    speedControl.add(decreaseSpeed);

    speedControl.add(new JLabel("      "));

    this.buttonPanel.add(speedControl);

    this.mainPanel.add(this.buttonPanel);

    this.add(this.sideBar, BorderLayout.WEST);

    this.add(mainPanel, BorderLayout.CENTER);

    this.pack();

    this.setFocusable(true);

  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public void play() {
    this.timer.start();
    this.isPlaying = true;
    this.play.setText("Pause");
  }

  @Override
  public void pause() {
    this.timer.stop();
    this.isPlaying = false;
    this.play.setText("Play");
  }

  @Override
  public void enableLooping() {
    this.loopEnable = true;
    this.loop.setText("Disable Looping");
  }

  @Override
  public void disableLooping() {
    this.loopEnable = false;
    this.loop.setText("Enable Looping");
  }

  @Override
  public void speedUp() {
    if (this.speed == 50) {
      this.showingErrorMessage("The playback speed can't be faster than 50.");
      return;
    }
    this.speed += 0.5;
    this.timer.setDelay((int) (1000 / this.speed));
    this.speedDisplay.setText(String.format("Playback Speed: %.2f", this.speed));
  }

  @Override
  public void slowDown() {
    if (this.speed == 0.5) {
      this.showingErrorMessage("The playback speed can't be lower than 0.5.");
      return;
    }
    this.speed -= 0.5;
    this.timer.setDelay((int) (1000 / this.speed));
    this.speedDisplay.setText(String.format("Playback Speed: %.2f", this.speed));
  }

  @Override
  public void setListener(ActionListener actionListener, KeyListener keyListener) {
    this.addKeyListener(keyListener);
    // set the timer
    this.timer = new Timer((int) (1000 / this.speed), actionListener);
    this.timer.setInitialDelay(0);
    this.timer.setActionCommand("TimerAction");

    this.play.addActionListener(actionListener);
    this.restart.addActionListener(actionListener);
    this.loop.addActionListener(actionListener);
    this.increaseSpeed.addActionListener(actionListener);
    this.decreaseSpeed.addActionListener(actionListener);

    this.openFile.addActionListener(actionListener);
    this.saveFile.addActionListener(actionListener);
  }

  @Override
  public void getFrameAtTick(int tick) {
    List<Shape> shapeList = this.model.getShapeAtTick(tick);
    this.panel.paintShapes(shapeList);
    this.refresh();

  }

  @Override
  public boolean isPlaying() {
    return this.isPlaying;
  }

  @Override
  public boolean isLooping() {
    return this.loopEnable;
  }

  @Override
  public void showingErrorMessage(String msg) {
    JOptionPane.showMessageDialog(this, msg, "Error",
        JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void setModel(ReadOnlyModel model) {
    this.model = model;
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

}
