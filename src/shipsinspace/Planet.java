/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import java.awt.Color;
import java.util.Random;
/**
 *
 * @author mark
 */
public class Planet extends SolarSystemObject{
    
    boolean isHabitable;
    int size;
    int number;
    int[] elements = new int[120];
    
    public Planet(String sunName, int n){
        super.color = Color.LIGHT_GRAY;
        this.number = n;
        super.name = sunName + " " + number;
        super.icon = "P";
        
        Random rChance = new Random();
        int habitableChance = 1 + rChance.nextInt( 100 );
        if (habitableChance > 80){
            isHabitable = true;
        } else {
            isHabitable = false;
        }
        // set size between 40-800
        Random rSize = new Random();
        size = 40 + rSize.nextInt( 760 );
        generateResources();
        
        
    }
    
    
    public void drawMap(){
        
    }
    public String canLiveThere(){
        String result = "";
        if(isHabitable){
          result = "Habitable planet";  
        }else{
          result = "Not habitable";  
        }
        return result;
    }
    private void generateResources(){
        for(int i = 0; i < 120; i++){
           Random rElement = new Random();
           Random chance = new Random();
           int amount = 1 + chance.nextInt( 100 );
           int controlNumber;
           
           if(amount > 90){
             controlNumber = 4;  
           } else if(amount > 70){
             controlNumber = 3;  
           } else if(amount > 50){
             controlNumber = 2;  
           } else {
             controlNumber = 1;  
           } 
           
           
           
           switch(controlNumber){
               case 1: elements[i] = 1 + rElement.nextInt( 1000 ); break;
               case 2: elements[i] = 1 + rElement.nextInt( 20000 ); break;
               case 3: elements[i] = 1 + rElement.nextInt( 100000 ); break;
               case 4: elements[i] = 1 + rElement.nextInt( 300000 ); break;    
           }
           
           
            
        }
        
    }
    
}
