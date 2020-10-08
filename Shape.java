/* Shape.java
 * Jonathan Mainhart
 * CMIS 242
 * Defines an abstract Class of Shapes. 
 */
package mainhart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jonmainhart
 */
public abstract class Shape extends Rectangle {

    private static final long serialVersionUID = 1L;
    
    private static int numberOfShapes;

    private Color shapeColor;
    private boolean isSolid;

    public Shape(Rectangle r, Color color, boolean isSolid) {
        super(r);
        this.isSolid = isSolid;
        this.shapeColor = color;
        numberOfShapes++;
    }

    public void setColor(Graphics g) { 
        g.setColor(shapeColor);
    }

    public boolean getSolid() {
        return this.isSolid;
    }

    public static int getNoOfShapes() {
        return numberOfShapes;
    }

    public abstract void draw(Graphics g);

}
