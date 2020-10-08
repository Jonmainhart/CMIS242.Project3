/* Drawing.java
 * Jonathan Mainhart
 * CMIS 242
 * Extends JPanel to provide custom methods to draw the user defined shape and
 * check whether the shape will fit inside of the panel.
 */
package mainhart;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author jonmainhart
 */
public class Drawing extends JPanel {

    private static final long serialVersionUID = 1L;
    private Shape currentShape;

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        if (currentShape != null) { // do not try to draw an empty shape
            
            try {
                
                // draws the current shape onto the graphics component passed to the method
                g.drawString(String.valueOf(Shape.getNoOfShapes()), 10, 30);
                currentShape.setColor(g);
                currentShape.draw(g);
                currentShape = null; // resets current shape for next time

            } catch (NullPointerException npe) {
                System.out.println("Attempted to draw something that was not there: " 
                        + npe.getMessage());
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // returns a dimesnion size of 200 x 200 px
        return new Dimension(200, 200);
    }

    private boolean inBounds(Shape currentShape) {

        // define the panel bounds relative to the shape
        // Does not account for border placement
        int panelRight = (int) (this.getX() - this.getBounds().getX() + this.getWidth());
        int panelLeft = (int) (this.getX() - this.getBounds().getX()); // should always be 0.
        int panelTop = (int) (this.getY() - this.getBounds().getY()); // should always be 0.
        int panelBottom = (int) (this.getY() - this.getBounds().getY() + this.getHeight());

        // define shape bounds relative to the panel
        int shapeRight = (int) (currentShape.getX() + currentShape.getWidth());
        int shapeLeft = (int) (currentShape.getX());
        int shapeTop = (int) (currentShape.getY());
        int shapeBottom = (int) (currentShape.getY() + currentShape.getHeight());

        // check if the shape edge crosses the bounds
        // On the boundry is in bounds. Remove '=' to force inside the lines.
        return shapeLeft >= panelLeft && shapeRight <= panelRight
                && shapeTop >= panelTop && shapeBottom <= panelBottom;
    }

    public void drawShape(Shape currentShape) {

        try { // check if out of bounds
            if (inBounds(currentShape)) {
                this.currentShape = currentShape; // save shape to instance variable
                repaint();

            } else {
                throw new OutsideBounds();
            }

        } catch (OutsideBounds ob) {
            // error to the console
            System.out.println("Exception Thrown: " + ob.getMessage()
                    + "\n" + Arrays.toString(ob.getStackTrace()));
            // popup user message
            javax.swing.JFrame frame = new javax.swing.JFrame();
            javax.swing.JOptionPane.showMessageDialog(frame,
                    String.valueOf(ob.getMessage()));
        }

    }

}
