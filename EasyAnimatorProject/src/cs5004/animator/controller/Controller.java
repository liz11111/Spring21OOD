package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller implements ActionListener, KeyListener {

  private int tick;
  private AnimationModel model;
  private EditorView view;

  public Controller(AnimationModel m, EditorView v) throws IllegalArgumentException {
    if (m == null || v == null) {
      throw new IllegalArgumentException("The model and view can't be null.");
    }

    this.model = m;
    this.view = v;
    tick = 0;
    this.view.setListener(this, this);
    this.view.display();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "TimerAction":
        this.view.getFrameAtTick(this.tick);
        if (this.tick > this.model.getAnimationEndTick()) {
          if (this.view.isLooping()) {
            this.tick = 1;
          } else {
            this.view.pause();
          }
        } else {
          this.tick += 1;
        }
        break;

      case "LoopControl":
        if (this.view.isLooping()) {
          this.view.disableLooping();
        } else {
          this.view.enableLooping();
        }
        break;

      case "PlayPause":
        if (this.view.isPlaying()) {
          this.view.pause();
        } else {
          this.view.play();
        }
        break;

      case "Restart":
        this.tick = 1;
        this.view.getFrameAtTick(this.tick);
        break;

      case "SpeedUp":
        this.view.speedUp();
        break;

      case "SlowDown":
        this.view.slowDown();
        break;

      case "OpenFile":
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "TXT file", "txt");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog((Component) this.view);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          String filePath = f.getAbsolutePath();
          try {
            Readable inFile = new FileReader(filePath);
            this.model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());
            this.view.setModel(this.model);
            if (this.view.isPlaying()) {
              this.view.pause();
            }
            this.tick = 0;
            this.view.getFrameAtTick(this.tick);
            this.view.refresh();
            this.view.resetFocus();
          } catch (FileNotFoundException fileNotFoundException) {
            this.view.showingErrorMessage("No such file");
          } catch (IllegalStateException illegalStateException) {
            this.view.showingErrorMessage("Fail to open this file!");
          }
        }
        break;

      case "SaveFile":
        final JFileChooser chooser = new JFileChooser(".");
        int ret = chooser.showSaveDialog((Component) this.view);
        if (ret == JFileChooser.APPROVE_OPTION) {
          File f = chooser.getSelectedFile();
          String filePath = f.getAbsolutePath();
          if (!(filePath.endsWith(".txt") || filePath.endsWith(".svg"))) {
            this.view.showingErrorMessage("Can only save as txt or svg file!");
          } else if (filePath.endsWith(".txt")) {
            TextualView textualView = new TextualView(this.model, System.out);
            textualView.play(0, 1);
            try {
              textualView.saveTxt(filePath);
            } catch (IOException ioException) {
              this.view.showingErrorMessage("Can't save this as txt file!");
            }
          } else if (filePath.endsWith("svg")) {
            SVGView svgView = new SVGView(this.model);
            svgView.play(0, 1);
            try {
              svgView.saveSVG(filePath);
            } catch (IOException ioException) {
              this.view.showingErrorMessage("Can't save this as svg file");
            }
          }
        }
        break;

    }
    this.view.resetFocus();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_SPACE:
        if (this.view.isPlaying()) {
          this.view.pause();
        } else {
          this.view.play();
        }
        break;
      case KeyEvent.VK_UP:
        this.view.speedUp();
        break;
      case KeyEvent.VK_DOWN:
        this.view.slowDown();
        break;
      case KeyEvent.VK_R:
        this.tick = 1;
        this.view.getFrameAtTick(this.tick);
        break;
      case KeyEvent.VK_L:
        if (this.view.isLooping()) {
          this.view.disableLooping();
        } else {
          this.view.enableLooping();
        }
        break;

    }
    this.view.resetFocus();

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

}
