/* Oval.java
 * Jonathan Mainhart
 * CMIS 242
 * Extends Shape. Defines an Oval and provides a method to draw the shape. 
 */
package mainhart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jonmainhart
 */
public class Oval extends Shape {

    private static final long serialVersionUID = 1L;

    public Oval(Rectangle r, Color color, boolean isSolid) {
        super(r, color, isSolid);
    } // end constructor

    @Override
    public void draw(Graphics g) {
        // calls appropriate method for solid or empty ovals
        if (this.getSolid()) {
            g.fillOval(this.x, this.y, this.width, this.height);
        } else {
            g.drawOval(this.x, this.y, this.width, this.height);
        }

    }

}
