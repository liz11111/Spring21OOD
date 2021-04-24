import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.shape.Circle;
import cs5004.animator.shape.Color;
import cs5004.animator.shape.Oval;
import cs5004.animator.shape.Parallelogram;
import cs5004.animator.shape.Position;
import cs5004.animator.shape.Rectangle;
import cs5004.animator.shape.Shape;
import cs5004.animator.shape.Square;

/**
 * Junit test for the animation model.
 */
public class AnimationModelTest {

  private AnimationModel model1;
  private AnimationModel model2;
  private Circle circle;
  private Parallelogram para;

  @Before
  public void setUp() {
    model1 = new AnimationModelImpl();
    model2 = new AnimationModelImpl();

    para = new Parallelogram("para1", new Position(199, 10),
        new Color(2, 1, 0), 80, 181, 179, 10, 189.9);
    model2.addShape(para);
    circle = new Circle("circle1", new Position(0, 28), new Color(0, 0, 0),
        100, 191, 88);
    model2.addShape(circle);
  }

  @Test
  public void testConstructor() {
    // test creating an empty model
    AnimationModel emptyModel = new AnimationModelImpl();
    assertEquals("Shapes: ", emptyModel.toString());
  }

  @Test
  public void testAddShape() {
    assertEquals("Shapes: ", model1.toString());
    // adding an oval
    Shape oval = new Oval("oval1", new Position(1, 2), new Color(255, 245, 120),
        10, 60, 109, 90.57);
    model1.addShape(oval);
    assertEquals("Shapes: \n"
        + "Name: oval1\n"
        + "Type: oval\n"
        + "Center: (1.0,2.0), Horizontal Radius: 109.0, Vertical Radius: 90.6, Color: (255,245,120)"
        + "\n"
        + "Appears at t=10\n"
        + "Disappears at t=60\n", model1.toString());
    // adding an circle
    Shape circle = new Circle("circle1", new Position(1.9, 70.999),
        new Color(240, 76, 22), 9, 20, 26);
    model1.addShape(circle);
    assertEquals("Shapes: \n"
        + "Name: circle1\n"
        + "Type: circle\n"
        + "Center: (1.9,71.0), Radius: 26.0, Color: (240,76,22)\n"
        + "Appears at t=9\n"
        + "Disappears at t=20\n\n"
        + "Name: oval1\n"
        + "Type: oval\n"
        + "Center: (1.0,2.0), Horizontal Radius: 109.0, Vertical Radius: 90.6, Color: (255,245,120)"
        + "\n"
        + "Appears at t=10\n"
        + "Disappears at t=60\n", model1.toString());
    // adding a rectangle
    Shape rectangle = new Rectangle("rectangle1", new Position(10, 2.3),
        new Color(25, 45, 20), 1, 9, 109, 90.57);
    model1.addShape(rectangle);
    assertEquals("Shapes: \n"
        + "Name: rectangle1\n"
        + "Type: rectangle\n"
        + "corner: (10.0,2.3), Width: 109.0, Height: 90.6, Color: (25,45,20)\n"
        + "Appears at t=1\n"
        + "Disappears at t=9\n\n"
        + "Name: circle1\n"
        + "Type: circle\n"
        + "Center: (1.9,71.0), Radius: 26.0, Color: (240,76,22)\n"
        + "Appears at t=9\n"
        + "Disappears at t=20\n\n"
        + "Name: oval1\n"
        + "Type: oval\n"
        + "Center: (1.0,2.0), Horizontal Radius: 109.0, Vertical Radius: 90.6, Color: (255,245,120)"
        + "\n"
        + "Appears at t=10\n"
        + "Disappears at t=60\n", model1.toString());
    // invalid adding
    try {
      // try to add a shape which already exists
      model1.addShape(circle);
      // try to add a shape having the same name with the one already exists
      model1.addShape(new Circle("circle1", new Position(0, 999),
          new Color(40, 6, 22), 21, 2, 6));
      fail();
    } catch (IllegalStateException e) {
      assertEquals("Shape already exists.", e.getMessage());
    }

  }

  @Test
  public void testRemoveShape() {
    Shape square = new Square("square1", new Position(9.55, 2.94),
        new Color(2, 1, 88), 10, 98, 16);
    // remove shape not exists
    model2.removeShape(square);
    String[] description = model2.toString().split("\n");
    assertEquals(12, description.length);
    String lastTwoShapes = String.join("\n",
        Arrays.copyOfRange(description, 0, 12));
    assertEquals("Shapes: \n"
            + "Name: para1\n"
            + "Type: parallelogram\n"
            + "corner: (199.0,10.0), Width: 10.0, Height: 189.9, Angle: 179.0, Color: (2,1,0)\n"
            + "Appears at t=80\n"
            + "Disappears at t=181\n\n"
            + "Name: circle1\n"
            + "Type: circle\n"
            + "Center: (0.0,28.0), Radius: 88.0, Color: (0,0,0)\n"
            + "Appears at t=100\n"
            + "Disappears at t=191"
        , lastTwoShapes);

    // remove shape in the model
    model2.addShape(square);
    model2.removeShape(square);
    assertEquals("Shapes: \n"
            + "Name: para1\n"
            + "Type: parallelogram\n"
            + "corner: (199.0,10.0), Width: 10.0, Height: 189.9, Angle: 179.0, Color: (2,1,0)\n"
            + "Appears at t=80\n"
            + "Disappears at t=181\n\n"
            + "Name: circle1\n"
            + "Type: circle\n"
            + "Center: (0.0,28.0), Radius: 88.0, Color: (0,0,0)\n"
            + "Appears at t=100\n"
            + "Disappears at t=191\n"
        , model2.toString());
  }

  @Test
  public void testMove() {
    // valid move
    // move right after it appears
    model2.move(para, new Position(200, 90), 81, 86);
    String[] description = model2.toString().split("\n");
    assertEquals("Shape para1 moves from (199.0,10.0) to (200.0,90.0) from t=81 to t=86",
        Array.get(description, description.length - 1));
    // move just before it disappear
    model2.move(para, new Position(40, 121), 90, 181);
    description = model2.toString().split("\n");
    assertEquals("Shape para1 moves from (200.0,90.0) to (40.0,121.0) from t=90 to t=181",
        Array.get(description, description.length - 1));
    // make a move between interval of 2 moves
    model2.move(para, new Position(33, 1), 88, 89);
    description = model2.toString().split("\n");

    assertEquals("Shape para1 moves from (199.0,10.0) to (200.0,90.0) from t=81 to t=86",
        Array.get(description, 13));
    assertEquals("Shape para1 moves from (200.0,90.0) to (33.0,1.0) from t=88 to t=89",
        Array.get(description, 14));

    // having time conflict
    try {
      model2.move(para, new Position(33, 33), 89, 170);
      model2.move(para, new Position(0, 0), 84, 87);
      model2.move(para, new Position(0, 0), 99, 101);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Has conflict with existing animations.", e.getMessage());
    }
    // illegal move: before start time or after end time
    try {
      model2.move(para, new Position(0, 0), 0, 20);
      model2.move(para, new Position(0, 0), 0, 90);
      model2.move(para, new Position(0, 0), 200, 244);
      model2.move(para, new Position(0, 0), 80, 500);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Operation span is outside of shape's lifetime.", e.getMessage());
    }

    // move shape not existing
    Circle circle2 = new Circle("c", new Position(0, 28), new Color(0, 0, 0),
        100, 191, 88);

    try {
      model2.move(circle2, new Position(0, 0), 101, 190);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("No such shape", e.getMessage());
    }

    // start time later than end time
    try {
      model2.move(para, new Position(0, 0), 190, 90);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid times.", e.getMessage());
    }

  }

  @Test
  public void testChangeColor() {
    // valid change
    // change color right after it appears
    model2.changeColor(circle, new Color(6, 6, 6), 120, 130);
    String[] description = model2.toString().split("\n");
    assertEquals("Shape circle1 changes color from (0,0,0) to (6,6,6) from t=120 to t=130",
        Array.get(description, 13));
    // change color just before it disappear
    model2.changeColor(circle, new Color(8, 8, 8), 190, 191);
    description = model2.toString().split("\n");
    assertEquals("Shape circle1 changes color from (0,0,0) to (6,6,6) from t=120 to t=130",
        Array.get(description, 13));
    assertEquals("Shape circle1 changes color from (6,6,6) to (8,8,8) from t=190 to t=191",
        Array.get(description, 14));
    // change color after it appears
    model2.changeColor(circle, new Color(1, 1, 1), 100, 110);
    description = model2.toString().split("\n");
    assertEquals("Shape circle1 changes color from (0,0,0) to (1,1,1) from t=100 to t=110",
        Array.get(description, 13));

    // having time conflict
    try {
      model2.changeColor(circle, new Color(1, 1, 1), 105, 115);
      model2.changeColor(circle, new Color(1, 1, 1), 180, 191);
      model2.changeColor(circle, new Color(1, 1, 1), 155, 158);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Has conflict with existing animations.", e.getMessage());
    }
    // illegal move: before start time or after end time
    try {
      model2.changeColor(circle, new Color(1, 1, 1), 105, 200);
      model2.changeColor(circle, new Color(1, 1, 1), 90, 115);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Operation span is outside of shape's lifetime.", e.getMessage());
    }

    // shape not existing
    Circle circle2 = new Circle("c", new Position(0, 28), new Color(0, 0, 0),
        100, 191, 88);

    try {
      model2.changeColor(circle2, new Color(1, 1, 1), 101, 190);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("No such shape", e.getMessage());
    }

    // start time later than end time
    try {
      model2.changeColor(circle, new Color(1, 1, 1), 190, 90);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid times.", e.getMessage());
    }

  }

  @Test
  public void testScale() {
    // valid scaling
    // scale right after it appears
    model2.scale(circle, 1, 130, 120, 130);
    String[] description = model2.toString().split("\n");
    assertEquals("Shape circle1 scales from Radius: 88.0 to Radius: 130.0 from t=120 to "
        + "t=130", Array.get(description, 13));
    // scale just before it disappears
    model2.scale(circle, 1, 191, 190, 191);
    description = model2.toString().split("\n");
    assertEquals("Shape circle1 scales from Radius: 88.0 to Radius: 130.0 from t=120 to "
        + "t=130", Array.get(description, 13));
    assertEquals("Shape circle1 scales from Radius: 130.0 to Radius: 191.0 from t=190 to "
        + "t=191", Array.get(description, 14));
    // scale after it appears
    model2.scale(circle, 1, 110, 100, 110);
    description = model2.toString().split("\n");
    assertEquals("Shape circle1 scales from Radius: 88.0 to Radius: 110.0 from t=100 to "
        + "t=110", Array.get(description, 13));

    // having time conflict
    try {
      model2.scale(circle, 1, 100, 105, 115);
      model2.scale(circle, 1, 100, 180, 191);
      model2.scale(circle, 1, 100, 155, 158);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Has conflict with existing animations.", e.getMessage());
    }
    // illegal move: before start time or after end time
    try {
      model2.scale(circle, 1, 100, 105, 200);
      model2.scale(circle, 1, 100, 90, 115);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Operation span is outside of shape's lifetime.", e.getMessage());
    }

    // shape not existing
    Circle circle2 = new Circle("c", new Position(0, 28), new Color(0, 0, 0),
        100, 191, 88);

    try {
      model2.scale(circle2, 1, 100, 101, 190);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("No such shape", e.getMessage());
    }

    // start time later than end time
    try {
      model2.scale(circle, 1, 100, 190, 90);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid times.", e.getMessage());
    }


  }

  @Test
  public void testDifferentOperationsWithOverlapping() {
    model2.scale(circle, 1, 130, 120, 130);
    model2.changeColor(circle, new Color(5, 5, 5), 120, 130);
    model2.move(circle, new Position(100.09, 89.12), 120, 130);

    String[] description = model2.toString().split("\n");
    assertEquals("Shape circle1 scales from Radius: 88.0 to Radius: 130.0 from t=120 to "
        + "t=130", Array.get(description, 13));
    assertEquals("Shape circle1 moves from (0.0,28.0) to (100.1,89.1) from t=120 to t=130"
        , Array.get(description, 14));
    assertEquals("Shape circle1 changes color from (0,0,0) to (5,5,5) from t=120 to t=130"
        , Array.get(description, 15));
  }

}
