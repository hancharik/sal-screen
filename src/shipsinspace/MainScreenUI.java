/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainScreenUI extends JFrame{
  
    MainScreenCntl MainScreenCntl;
    public GalaxyMapPanel galaxyMap;
    public JPanel mainPanel;
    public JButton galaxyMapButton;
    public JLabel ShipLocationFixedLabel;
    public JLabel arrivingLabel;
    public JLabel captainDialogLabel;
    public JLabel captainNameLabel;
    public JLabel distanceLabel;
    public JLabel engineeringDialogLabel;
    public JLabel engineeringNameLabel;
    public JLabel helmsmanDialogLabel;
    public JLabel helmsmanNameLabel;
    public JLabel planetLabel;
    public JLabel shipLocationDisplayLabel;
    public JLabel tripNumberDisplayLabel;
    public JLabel tripNumberFixedLabel;
    public JLabel blankLabel;
    public JLabel attackAlertLabel;
    public JLabel attackUpdateLabel;
    public JPanel blackBox;
    
    
    public MainScreenUI(){
        
       
        this.initializeComponents();
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initializeComponents(){
        //galaxyMap = new GalaxyMapUI();
        GridLayout grid = new GridLayout(1,3);
                setLayout(grid);
        galaxyMapButton = new JButton("Galaxy Map");
        galaxyMapButton.addActionListener(new GalaxyMapListener());
        planetLabel = new JLabel("planet");
        distanceLabel = new JLabel("distance");
        tripNumberDisplayLabel= new JLabel("Trip number");
        shipLocationDisplayLabel= new JLabel("");
        arrivingLabel= new JLabel("                       ");
        captainDialogLabel= new JLabel("                               ");
        helmsmanDialogLabel= new JLabel("                            ");
        engineeringDialogLabel= new JLabel("                         ");
        blankLabel = new JLabel("  ");
        attackAlertLabel = new JLabel("  ");
        attackUpdateLabel = new JLabel("  ");
        galaxyMap = new GalaxyMapPanel();
        blackBox = new JPanel();
        blackBox.setSize(600,600);
        blackBox.setBackground(Color.black);
        //usernameLabel = new JLabel("Username");
       // username = new JTextField();
        //username.setColumns(10);
        //username.setPreferredSize(new Dimension(200, 40));
        
        //usernameLabel = new JLabel("Username");
        
        mainPanel = new JPanel(); //new BoxLayout(mainPanel, BoxLayout.Y_AXIS) from oracle site http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        
        mainPanel.add(tripNumberDisplayLabel);
        mainPanel.add(shipLocationDisplayLabel);
        mainPanel.add(blankLabel);
        mainPanel.add(planetLabel);
        mainPanel.add(distanceLabel);
        mainPanel.add(blankLabel);
        mainPanel.add(arrivingLabel);
        mainPanel.add(blankLabel);
        mainPanel.add(attackAlertLabel);
        mainPanel.add(attackUpdateLabel);
        mainPanel.add(captainDialogLabel);
        mainPanel.add(helmsmanDialogLabel);
        mainPanel.add(engineeringDialogLabel);
        mainPanel.add(galaxyMapButton);
        mainPanel.add(galaxyMap);
        mainPanel.add(blackBox);
        //mainPanel.add(galaxyMap);
    /*    buttonPanel = new JPanel(new FlowLayout());
        fieldPanel = new JPanel(new GridLayout(5,2));
        //JPanel[][] 
        
        fieldPanel.add(usernameLabel);
        fieldPanel.add(username);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(password);
        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        * */
        
        
        this.add(mainPanel);
    }
    
    public class GalaxyMapListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
            GalaxyMapUI test = new GalaxyMapUI();
            
            
        }
    }
    
    public void addPanel(Component e){
        this.add(e);
    }
    
    
    
}
