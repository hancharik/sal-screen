/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SolarSystemMapPanel extends GalaxyMapPanel{
    
    public Obutton[][] solarSystemMapButtonArray;
    public Obutton solarSystemMapButton;
    public JPanel solarSystemMapButtonPanel;
    public JPanel controlButtonPanel;
    public JButton backButton;
    public SolarSystem ss;
    
    
    
    public SolarSystemMapPanel(SolarSystem sSystem){
        super();
        ss = sSystem;
        this.initializeComponents();
        this.setSize(600, 600);
        //this.setLocationRelativeTo(null);
       //this.setTitle(ss.SolarSystemName);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);   
    }
    
   public void initializeComponents(){
       
        solarSystemMapButtonArray = new Obutton[ShipsInSpace.size][ShipsInSpace.size];
        
        
        
        solarSystemMapButtonPanel = new JPanel(); 
        solarSystemMapButtonPanel.setLayout(new GridLayout(ShipsInSpace.size,ShipsInSpace.size));
        solarSystemMapButtonPanel.setBackground(Color.black);
        solarSystemMapButtonPanel.setForeground(Color.black);
        //solarSystemMapButtonPanel.setSize(400, 400);
        
        //controlButtonPanel = new JPanel();
        //controlButtonPanel.setSize(600, 100);
        
        backButton = new JButton("Back");
        
        
        for(int i = 0; i < ShipsInSpace.size; i++){
                for(int j = 0; j < ShipsInSpace.size; j++){
                  //solarSystemMapButton = new Obutton(i,j,ss.solarSystemMap[i][j].icon);
                  solarSystemMapButton = new Obutton();
                  solarSystemMapButton.setA(i);
                  solarSystemMapButton.setB(j);
                  solarSystemMapButtonArray[i][j] = solarSystemMapButton;
                  solarSystemMapButton.addActionListener(new SolarSystemMapButtonListener());
                  solarSystemMapButton.setVisible(true);
                  solarSystemMapButtonPanel.add(solarSystemMapButton);
                  solarSystemMapButtonPanel.repaint();
          
                }
            }
        
        //controlButtonPanel.add(backButton);
        //this.add(controlButtonPanel);
        this.add(solarSystemMapButtonPanel);
    }
    
   public class SolarSystemMapButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
           Obutton thisButton = (Obutton) evt.getSource();
           String temp = ss.solarSystemMap[thisButton.getA()][thisButton.getB()].getClass().toString();
           System.out.println(ss.solarSystemMap[thisButton.getA()][thisButton.getB()].name);
           //System.out.println(temp);
           if(temp.equals("class shipsinspace.Planet")){
           //System.out.println("almost there");  
           Planet pleaseWork;
          pleaseWork = (Planet) ss.solarSystemMap[thisButton.getX()][thisButton.getY()];
          System.out.println(pleaseWork.canLiveThere());
          System.out.println("Gold : " + pleaseWork.elements[79]);
          System.out.println("Iron : " + pleaseWork.elements[26]);
          System.out.println("Phosphorous : " + pleaseWork.elements[15]);
          System.out.println("Element ZERO : " + pleaseWork.elements[0]);
           }
            
        }
    }
    
    
    
    
}
