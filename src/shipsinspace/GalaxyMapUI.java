/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GalaxyMapUI extends JFrame{
    
    public Obutton[][] galaxyMapButtonArray;
    public Obutton galaxyMapButton;
    public JPanel galaxyMapButtonPanel;
   // public JPanel bottomButtonPanel;
   // public JButton backButton;
    
   public GalaxyMapUI(){
        
        this.initializeComponents();
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Galaxy Map");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    } 
  
   public void initializeComponents(){
       
        galaxyMapButtonArray = new Obutton[ShipsInSpace.size][ShipsInSpace.size];
        
        
        
        galaxyMapButtonPanel = new JPanel(); //new BoxLayout(mainPanel, BoxLayout.Y_AXIS) from oracle site http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
        galaxyMapButtonPanel.setLayout(new GridLayout(ShipsInSpace.size,ShipsInSpace.size));
        //galaxyMapButtonPanel.setSize(400, 400);
        
        //bottomButtonPanel = new JPanel();
        //bottomButtonPanel.setSize(600, 100);
        
        //backButton = new JButton("Back");
        
        //int arrayNumber = 1;
        for(int i = 0; i < ShipsInSpace.size; i++){
                for(int j = 0; j < ShipsInSpace.size; j++){
                   //galaxyMapButton = new Obutton("" + arrayNumber + "", ShipsInSpace.gtest.galaxyMap[i][j].solarSystemNameList, arrayNumber); 
                  //galaxyMapButton = new Obutton(ShipsInSpace.gtest.galaxyMap[i][j].icon, ShipsInSpace.gtest.galaxyMap[i][j].solarSystemNameList, arrayNumber); 
                  //galaxyMapButton = new Obutton(i,j,ShipsInSpace.gtest.galaxyMap[i][j].icon);
                  galaxyMapButton = new Obutton();
                  galaxyMapButtonArray[i][j] = galaxyMapButton;//galaxyMapButtonArray[i][j] = new JButton(ShipsInSpace.gtest[i][j].icon); 
                  galaxyMapButton.setA(i);
                  galaxyMapButton.setB(j);
                  galaxyMapButton.addActionListener(new GalaxyMapButtonListener());
                  galaxyMapButton.setVisible(true);
                  galaxyMapButton.setBackground(ShipsInSpace.gtest.galaxyMap[i][j].color);
                  galaxyMapButtonPanel.add(galaxyMapButton);
                  galaxyMapButton.repaint();
                  //arrayNumber++;
                }
            }
        
        //bottomButtonPanel.add(backButton);
        //this.add(bottomButtonPanel);
        this.add(galaxyMapButtonPanel);
    }
    
   public class GalaxyMapButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
           Obutton thisButton = (Obutton) evt.getSource();
           System.out.println(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].SolarSystemName);
          //System.out.println("and...");
           System.out.println(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.toString());
           System.out.println();
           //if(ShipsInSpace.gtest.galaxyMap[thisButton.getX()][thisButton.getY()].equals(EmptySolarSystem)){
           SolarSystemMapUI ss = new SolarSystemMapUI(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()]);
           //}
            
        }
    }
    
}
