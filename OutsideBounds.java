/* OutsideBounds.java
 * Jonathan Mainhart
 * CMIS 242
 * Defines Exception OutsideBounds and provides a message to the user. 
 */
package mainhart;

/**
 *
 * @author jonmainhart
 */
public class OutsideBounds extends Exception {

    private static final long serialVersionUID = 1L;

    public OutsideBounds() {
        super("The shape is out of bounds.\nTry adjusting the size or placement.");
    }

}
