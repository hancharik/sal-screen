/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Mark
 */
public class EmptySolarSystemObject extends SolarSystemObject{
    
    //public SolarSystemObject[][] solarSystemMap;
    
    public EmptySolarSystemObject(){
        super.name = "Empty Space ";
        super.icon = " ";
        super.color = Color.BLACK;
        //createSolarSystemMap();
    }
    
    
    /*public void createSolarSystemMap(){
       SolarSystemObject[][] ssMap = new SolarSystemObject[ShipsInSpace.size][ShipsInSpace.size]; 
        
       for(int i = 0; i < ShipsInSpace.size; i++){
           for(int j = 0; j < ShipsInSpace.size; j++){
               ssMap[i][j] = new EmptySolarSystemObject();
           }
       }
       
       
        solarSystemMap = ssMap;
    }
   */ 

}