import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.ReadOnlyModel;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;

/**
 * AnimationViewTest tests all functionalities of animation view classes with JUnit test.
 */
public class AnimationViewTest {
  private String filePath = "resources\\";
  private ReadOnlyModel model;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @Before
  public void setUp() throws FileNotFoundException {
    String fileName = "toh-3.txt";
    Readable inFile = new FileReader(filePath + fileName);
    model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void testTextualView0() {
    View myView = new TextualView(model, System.out);
    myView.play(1, 1);
    Assert.assertEquals("Create:\n" +
                    "Name: disk3\n" +
                    "Type: rectangle\n" +
                    "corner: (145.0,240.0), Width: 110.0, Height: 30.0, Color: (11,45,175)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Create:\n" +
                    "Name: disk1\n" +
                    "Type: rectangle\n" +
                    "corner: (190.0,180.0), Width: 20.0, Height: 30.0, Color: (0,49,90)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Create:\n" +
                    "Name: disk2\n" +
                    "Type: rectangle\n" +
                    "corner: (167.0,210.0), Width: 65.0, Height: 30.0, Color: (6,247,41)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Shape disk1 moves from (190.0,180.0) to (190.0,50.0) from t=25 to t=35\n" +
                    "Shape disk1 moves from (190.0,50.0) to (490.0,240.0) from t=47 to t=57\n" +
                    "Shape disk2 moves from (167.0,210.0) to (167.0,50.0) from t=57 to t=67\n" +
                    "Shape disk2 moves from (167.0,50.0) to (317.0,240.0) from t=79 to t=89\n" +
                    "Shape disk1 moves from (490.0,240.0) to (490.0,50.0) from t=89 to t=99\n" +
                    "Shape disk1 moves from (490.0,50.0) to (340.0,210.0) from t=111 to t=121\n" +
                    "Shape disk3 moves from (145.0,240.0) to (145.0,50.0) from t=121 to t=131\n" +
                    "Shape disk3 moves from (145.0,50.0) to (445.0,240.0) from t=143 to t=153\n" +
                    "Shape disk1 moves from (340.0,210.0) to (340.0,50.0) from t=153 to t=163\n" +
                    "Shape disk3 changes color from (11,45,175) to (0,255,0) from " +
                    "t=153 to t=161\n" +
                    "Shape disk1 moves from (340.0,50.0) to (190.0,240.0) from t=175 to t=185\n" +
                    "Shape disk2 moves from (317.0,240.0) to (317.0,50.0) from t=185 to t=195\n" +
                    "Shape disk2 moves from (317.0,50.0) to (467.0,210.0) from t=207 to t=217\n" +
                    "Shape disk2 changes color from (6,247,41) to (0,255,0) from " +
                    "t=217 to t=225\n" +
                    "Shape disk1 moves from (190.0,240.0) to (190.0,50.0) from t=217 to t=227\n" +
                    "Shape disk1 moves from (190.0,50.0) to (490.0,180.0) from t=239 to t=249\n" +
                    "Shape disk1 changes color from (0,49,90) to (0,255,0) from t=249 to t=257",
            outputStreamCaptor.toString().trim());
  }

  @Test
  public void testTextualView1() {
    // test play start at random time
    View myView = new TextualView(model, System.out);
    myView.play(50, 1);
    Assert.assertEquals("Create:\n" +
                    "Name: disk3\n" +
                    "Type: rectangle\n" +
                    "corner: (145.0,240.0), Width: 110.0, Height: 30.0, Color: (11,45,175)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Create:\n" +
                    "Name: disk1\n" +
                    "Type: rectangle\n" +
                    "corner: (190.0,180.0), Width: 20.0, Height: 30.0, Color: (0,49,90)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Create:\n" +
                    "Name: disk2\n" +
                    "Type: rectangle\n" +
                    "corner: (167.0,210.0), Width: 65.0, Height: 30.0, Color: (6,247,41)\n" +
                    "Appears at t=1\n" +
                    "\n" +
                    "Shape disk2 moves from (167.0,210.0) to (167.0,50.0) from t=57 to t=67\n" +
                    "Shape disk2 moves from (167.0,50.0) to (317.0,240.0) from t=79 to t=89\n" +
                    "Shape disk1 moves from (490.0,240.0) to (490.0,50.0) from t=89 to t=99\n" +
                    "Shape disk1 moves from (490.0,50.0) to (340.0,210.0) from t=111 to t=121\n" +
                    "Shape disk3 moves from (145.0,240.0) to (145.0,50.0) from t=121 to t=131\n" +
                    "Shape disk3 moves from (145.0,50.0) to (445.0,240.0) from t=143 to t=153\n" +
                    "Shape disk1 moves from (340.0,210.0) to (340.0,50.0) from t=153 to t=163\n" +
                    "Shape disk3 changes color from (11,45,175) to (0,255,0) " +
                    "from t=153 to t=161\n" +
                    "Shape disk1 moves from (340.0,50.0) to (190.0,240.0) from t=175 to t=185\n" +
                    "Shape disk2 moves from (317.0,240.0) to (317.0,50.0) from t=185 to t=195\n" +
                    "Shape disk2 moves from (317.0,50.0) to (467.0,210.0) from t=207 to t=217\n" +
                    "Shape disk2 changes color from (6,247,41) to (0,255,0) " +
                    "from t=217 to t=225\n" +
                    "Shape disk1 moves from (190.0,240.0) to (190.0,50.0) from t=217 to t=227\n" +
                    "Shape disk1 moves from (190.0,50.0) to (490.0,180.0) from t=239 to t=249\n" +
                    "Shape disk1 changes color from (0,49,90) to (0,255,0) from t=249 to t=257",
            outputStreamCaptor.toString().trim());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTextualIllegalArgument() {
    View myView = new TextualView(null, null);
  }

  @Test
  public void testSVG() {
    SVGView myView = new SVGView(model);
    myView.play(1, 20);
    Assert.assertEquals(27472, myView.getStringOutput().length());
  }
}
