/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import java.awt.Color;
  import java.util.Random;  
  import java.util.ArrayList;
/**
 *
 * @author mark
 */
public class SolarSystem extends Thing{
    
    Color color = Color.WHITE;
    String SolarSystemName;
    ArrayList<SolarSystemObject> solarSystem  = new ArrayList<SolarSystemObject>();
    ArrayList<String> solarSystemNameList  = new ArrayList<String>();
    public SolarSystemObject[][] solarSystemMap;
    
    public SolarSystem(){
        if (ShipsInSpace.size < 30) {
            super.icon = " @ ";
        } else {
            super.icon = "@";
        }
        
        Sun sun = new Sun();
        
        
        Random rand = new Random();
        int objects = 1 + rand.nextInt( 10 );
        
        
        
        switch(objects){
            case 1 : Planet planet9 = new Planet(sun.name,9); solarSystem.add(planet9); solarSystemNameList.add(planet9.name);
            case 2 : Planet planet8 = new Planet(sun.name,8); solarSystem.add(planet8); solarSystemNameList.add(planet8.name);
            case 3 : Planet planet7 = new Planet(sun.name,7); solarSystem.add(planet7); solarSystemNameList.add(planet7.name);
            case 4 : Planet planet6 = new Planet(sun.name,6); solarSystem.add(planet6); solarSystemNameList.add(planet6.name);
            case 5 : Planet planet5 = new Planet(sun.name,5); solarSystem.add(planet5); solarSystemNameList.add(planet5.name);
            case 6 : Planet planet4 = new Planet(sun.name,4); solarSystem.add(planet4); solarSystemNameList.add(planet4.name);
            case 7 : Planet planet3 = new Planet(sun.name,3); solarSystem.add(planet3); solarSystemNameList.add(planet3.name);
            case 8 : Planet planet2 = new Planet(sun.name,2); solarSystem.add(planet2); solarSystemNameList.add(planet2.name);
            case 9 : Planet planet1 = new Planet(sun.name,1); solarSystem.add(planet1); solarSystemNameList.add(planet1.name); 
            
        
        }   
        
        solarSystem.add(sun);
        solarSystemNameList.add(sun.name);
        SolarSystemName = sun.name + " System";
        createSolarSystemMap();
    }
    
    /*public SolarSystemObject[][] createSolarSystemMap(int x, int y){
       SolarSystemObject[][] ssMap = new SolarSystemObject[10][10]; 
        
        return ssMap;
    }
    * */
    public void createSolarSystemMap(){
       SolarSystemObject[][] ssMap = new SolarSystemObject[ShipsInSpace.size][ShipsInSpace.size]; 
        
       for(int i = 0; i < ShipsInSpace.size; i++){
           for(int j = 0; j < ShipsInSpace.size; j++){
               ssMap[i][j] = new EmptySolarSystemObject();
           }
       }
       
       //ssMap[ShipsInSpace.size/2][ShipsInSpace.size/2] = solarSystem.get(solarSystem.size()-1);
       for(int i = 0; i < solarSystem.size() - 1; i++){
           
        Random randX = new Random();
        int xCord = 1 + randX.nextInt( ShipsInSpace.size - 1 );
        Random randY = new Random();
        int yCord = 1 + randY.nextInt( ShipsInSpace.size - 1 );
        if(xCord!=ShipsInSpace.size/2 && yCord!=ShipsInSpace.size/2){
        ssMap[xCord][yCord] = solarSystem.get(i);
        }else{
          //createSolarSystemMap();  
        }
       }
       // add sun (last element of array) to center of map
       ssMap[ShipsInSpace.size/2][ShipsInSpace.size/2] = solarSystem.get(solarSystem.size()-1);
        solarSystemMap = ssMap;
    }
    
}
