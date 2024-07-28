import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class launch {
	
  JRadioButton blackBtn, blueBtn, greenBtn, redBtn, magentaBtn, yellowBtn, grayBtn, eraseBtn;
  JButton clearBtn;
  ButtonGroup bg = new ButtonGroup();
  DrawArea drawArea;

  ActionListener actionListener = new ActionListener() {

    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == clearBtn) {
        drawArea.clear();
		
		// after screen clear, it should know what color is selected, so it can draw without selecting color again
        if (blackBtn.isSelected() == true) {
          drawArea.black();
        } else if (blueBtn.isSelected() == true) {
          drawArea.blue();
        } else if (greenBtn.isSelected() == true) {
          drawArea.green();
        } else if (redBtn.isSelected() == true) {
          drawArea.red();
        } else if (magentaBtn.isSelected() == true) {
          drawArea.magenta();
        }else if (yellowBtn.isSelected() == true) {
          drawArea.yellow();
        }else if (grayBtn.isSelected() == true) {
          drawArea.gray();
        } else if (eraseBtn.isSelected() == true) {
          drawArea.erase();
        }

      } else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }else if (yellowBtn.isSelected() == true) {
        drawArea.yellow();
      }else if (grayBtn.isSelected() == true) {
        drawArea.gray();
      } else if (e.getSource() == eraseBtn) {
        drawArea.erase();
      }
    }
  };

  public void show() {

    // create main frame
    JFrame frame = new JFrame("Paint using Swing");
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    Container content = frame.getContentPane();

    // set layout on content pane
    content.setLayout(new BorderLayout());

    // create draw area
    drawArea = new DrawArea();

    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);

    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();

    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(actionListener);

    blackBtn = new JRadioButton("Black");
    blackBtn.addActionListener(actionListener);

    blueBtn = new JRadioButton("Blue");
    blueBtn.addActionListener(actionListener);

    greenBtn = new JRadioButton("Green");
    greenBtn.addActionListener(actionListener);

    redBtn = new JRadioButton("Red");
    redBtn.addActionListener(actionListener);

    magentaBtn = new JRadioButton("Magenta");
    magentaBtn.addActionListener(actionListener);

    yellowBtn = new JRadioButton("Yellow");
    yellowBtn.addActionListener(actionListener);

    grayBtn = new JRadioButton("Gray");
    grayBtn.addActionListener(actionListener);

    eraseBtn = new JRadioButton("Eraser");
    eraseBtn.addActionListener(actionListener);

    // add Radiobuttons in group
    bg.add(blackBtn);
    bg.add(blueBtn);
    bg.add(greenBtn);
    bg.add(redBtn);
    bg.add(magentaBtn);
    bg.add(yellowBtn);
    bg.add(grayBtn);
    bg.add(eraseBtn);

    // add to the panel
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(yellowBtn);
    controls.add(grayBtn);
    controls.add(eraseBtn);
    controls.add(clearBtn);

    // add to the content pane
    content.add(controls, BorderLayout.NORTH);

  }
	
  // main method
  public static void main(String[] args) {
    new launch().show();
  }
}
