/* Rectangular.java
 * Jonathan Mainhart
 * CMIS 242
 * Extends Shape. Defines a Rectangular shape and provides a method to draw the shape. 
 */
package mainhart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jonmainhart
 */
public class Rectangular extends Shape {

    private static final long serialVersionUID = 1L;
    
    public Rectangular(Rectangle r, Color color, boolean isSolid) {
        super(r, color, isSolid);
    } // end constructor

    @Override
    public void draw(Graphics g) {
        // calls appropriate method for solid or empty rectangles
        if (this.getSolid()) {
            g.fillRect(this.x, this.y, this.width, this.height);
        } else {
            g.drawRect(this.x, this.y, this.width, this.height);
        }
    }

}
