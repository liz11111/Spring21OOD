import Model.AnimationModel;
import Model.AnimationModelImpl;
import Shape.Circle;
import Shape.Color;
import Shape.Oval;
import Shape.Position;
import Shape.Rectangle;

public class test {
  public static void main(String[] args) {
    AnimationModel m = new AnimationModelImpl();
    Rectangle R = new Rectangle("R", new Position(200, 200), new Color(1, 0, 0), 1, 100, 50, 100);
    m.addShape(R);
    Oval C = new Oval("C", new Position(500, 100), new Color(0, 0, 1), 6, 100, 60, 30);
    m.addShape(C);
    m.scale(R, 1, 25, 51, 70);
    m.move(R, new Position(300, 300), 10, 50);
    m.move(C, new Position(500, 400), 20, 70);
    m.changeColor(C, new Color(0, 1, 0), 50, 80);
    m.move(R, new Position(200, 200), 70, 100);
    m.scale(C, 1, 40, 50, 80);
    System.out.println(m.toString());
  }
}
