package cs5004.animator;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.SVGView;
import java.io.FileReader;
import java.io.IOException;

public class EasyAnimator {

  public static void main(String[] args) throws IOException {
    //String fileName = "big-bang-big-crunch.txt";
    //String fileName = "buildings.txt";
    //String fileName = "smalldemo.txt";
    //String fileName = "toh-3.txt";
    String fileName = "toh-8.txt";
    String filePath = "..." + fileName;
    Readable inFile = new FileReader(filePath);
    AnimationModel model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());

    SVGView svg = new SVGView(model);
    svg.play(60, 10);
    System.out.println(svg.getStringOutput());
    svg.saveSVG("testSVG.svg");

    GraphicsView myView = new GraphicsView(model);
    myView.play(1, 10);

  }
}
