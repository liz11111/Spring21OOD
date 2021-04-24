import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;


import cs5004.animator.controller.Controller;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.VisualView;

/**
 * AnimationControllerTest tests all functionalities of Controller with JUnit tests.
 */
public class AnimationControllerTest {
  private String filePath = "resources\\";
  private AnimationModel model;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private EditorView view;
  private Controller c;

  @Before
  public void setUp() throws FileNotFoundException {
    String fileName = "toh-3.txt";
    Readable inFile = new FileReader(filePath + fileName);
    model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());
    view = new VisualView(model);
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalController() {
    Controller c1 = new Controller(null, null);
  }

  @Test
  public void testListeners0() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "TimerAction"));
    Assert.assertEquals("TimerAction Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners1() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "LoopControl"));
    Assert.assertEquals("LoopControl Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners2() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "PlayPause"));
    Assert.assertEquals("PlayPause Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners3() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "Restart"));
    Assert.assertEquals("Restart Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners4() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "SpeedUp"));
    Assert.assertEquals("SpeedUp Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners5() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "SlowDown"));
    Assert.assertEquals("SlowDown Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners6() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "OpenFile"));
    Assert.assertEquals("OpenFile Triggered.", outputStreamCaptor.toString().trim());
  }

  @Test
  public void testListeners7() {
    c = new Controller(model, view);
    c.actionPerformed(new ActionEvent(view, 1, "SaveFile"));
    Assert.assertEquals("SaveFile Triggered.", outputStreamCaptor.toString().trim());
  }
}
