
package shipsinspace;

import java.awt.Color;

public class EmptySpace extends Thing {
   
    public EmptySpace(){
        
       Color color = Color.BLACK;
        if (ShipsInSpace.size < 30) {
            super.icon = "   ";
        } else {
            super.icon = " ";
        }
    }
}
