/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.ArrayList;
import java.util.Collections;


public class SolarSystemJPanel extends JPanel implements ActionListener, KeyListener{
    
    Timer t;
    int delay = 500;
    int size = 7;
    ArrayList<PlanetJButton> buttonList = new ArrayList<PlanetJButton>();
    PlanetJButton playerShip;
    SolarSystem thisSolarSystem;
    
    /*
    
    PlanetJButton b1 = new PlanetJButton(1);
    PlanetJButton b2 = new PlanetJButton(2);
    PlanetJButton b3 = new PlanetJButton(3);
    PlanetJButton b4 = new PlanetJButton(4);
    PlanetJButton b5 = new PlanetJButton(5);
    PlanetJButton b6 = new PlanetJButton(6);
    */
    
   public SolarSystemJPanel(SolarSystem tss){
       
       super();
    
       thisSolarSystem = tss;
       
        for(int i = 0; i < thisSolarSystem.solarSystem.size(); i++){
        buttonList.add(new PlanetJButton(i, thisSolarSystem)) ;   
        }
       
       initializeComponents();
       
       
       setFocusable(true);
		//addKeyListener((KeyListener) this);
       //b1.addActionListener(this);
       t = new Timer(delay, this);
       t.start();
       //t.setDelay(1);
       //repaint();
       this.requestFocusInWindow();
       playerShip.requestFocusInWindow();
   } // end constructor
    
    public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       	String choice = event.getActionCommand();
    
    
   

		if (obj == t)
		{
                    
                    for(int i = 0; i < size; i++){
                        
                        buttonList.get(i).moveButton();
                    }
		    /*     b1.moveButton();
                 b2.moveButton();
                 b3.moveButton();
                 b4.moveButton();
                 b5.moveButton();
                // b6.moveButton();
                 * */
                 
		}
    
    }
public void keyPressed(KeyEvent e){
		
		int k = e.getKeyCode();
		if(k == e.VK_UP){
			playerShip.moveUp();
		}
		if(k == e.VK_DOWN){
			playerShip.moveDown();
		}
		if(k == e.VK_LEFT){
		
                    playerShip.moveLeft();
		}
		if(k == e.VK_RIGHT){
			playerShip.moveRight();
		}
		
	}
   public void createButtons(){
	   for(int i = 1; i < 7; i++){
	    	//buttonList[i]  =  new PlanetJButton(i);
	    }
	   
   }

    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }
   
   public void createEmptySpace(){
       for(int i = 0; i < buttonList.size()-1; i++){
         buttonList.clear();
         initializeComponents();
       }
   }

    private void initializeComponents() {
               this.size = thisSolarSystem.solarSystem.size();
       setLayout(null);
       setBackground(Color.black);
      /* add(b1);
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       */
       playerShip = new PlanetJButton(11, thisSolarSystem);
       playerShip.addActionListener(this);
       playerShip.addKeyListener(this);
       this.add(playerShip);
       
       
      
       
       colorButtons();
       
       
       
       
       for(int i = 0; i <  buttonList.size(); i++){
    	// for(int i = buttonList.size() - 1; i >= 0; i--){   
           System.out.println("ssjpanel line 69: " + i);
    	   this.add(buttonList.get(i));
       }
       /*
         for(int i = buttonList.size() - 1; i >= 0; i--){
    	// for(int i = buttonList.size() - 1; i >= 0; i--){   
           System.out.println("ssjpanel line 69" + i);
    	   this.add(buttonList.get(i));
       }
        */ 
     
    } // end init components

    private void colorButtons() {
      
        
          ArrayList<SolarSystemObject> tempList  = new ArrayList<SolarSystemObject>();
       tempList = thisSolarSystem.solarSystem;
      Collections.reverse(tempList);
        
        
        
        for(int i = 0; i < thisSolarSystem.solarSystem.size(); i++){
        buttonList.get(i).setBackground(tempList.get(i).color);//add(new PlanetJButton(i, thisSolarSystem)) ;   
        } 
        
        
        
    } // end color buttons
   
} // end
