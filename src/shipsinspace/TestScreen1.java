/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Mark
 */
public class TestScreen1 extends JFrame{
    
    
    
    
    
    
    public GalaxyMapPanel galMapPanel;
    public SolarSystemMapPanel ssMapPanel;
    public int ssAmount = 0;
    public SolarSystemJPanel ssPanel = new SolarSystemJPanel(ssAmount);
    
    public int mainScreenChoice = 1;
    public JPanel mainScreen = new JPanel(); // this is the bridge main screen
    public SolarSystem ssTemp = ShipsInSpace.gtest.galaxyMap[4][3];
    
    public JButton shipLevel = new JButton();
    public JButton crewLevel = new JButton();
    
    JPanel mainPanel = new JPanel();
    
    public JButton bottomButton1 = new JButton();
    public JButton bottomButton2 = new JButton();
    public JButton sideButton1 = new JButton();
    public JButton sideButton2 = new JButton();
    public JButton sideButton3 = new JButton();
    public JButton sideButtonr1 = new JButton();
    public JButton sideButtonr2 = new JButton();
    public JButton sideButtonr3 = new JButton();
    public JPanel gMap = new JPanel();
    public JPanel ssMap = new JPanel();
    public JPanel gMapInfo = new JPanel();
    public JPanel ssMapInfo = new JPanel();
    public JLabel shipLabel = new JLabel("SHIP:");
    public JLabel crewLabel = new JLabel("CREW:");
    JTextArea mainScreenText = new JTextArea();
    JTextArea helmsmanText = new JTextArea();
    JTextArea engineeringText = new JTextArea();
    
    
    
    
    
    public Obutton[][] galaxyMapButtonArray;
    public Obutton galaxyMapButton;
    public JPanel galaxyMapButtonPanel;
    
    public Obutton[][] solarSystemMapButtonArray;
    public Obutton solarSystemMapButton;
    public JPanel solarSystemMapButtonPanel;
    public JPanel controlButtonPanel;
    public JButton backButton;
    public SolarSystem ss;
    
    
    
    
    
    public TestScreen1(){
        
        this.initializeComponents();
      //this.setSize(640, 960);
        this.setSize(800, 1000);
        this.setLocationRelativeTo(null);
        this.setTitle("                                                                                                       SHIPS IN SPACE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public void initializeComponents(){
        
        mainPanel.removeAll();
        mainPanel = new JPanel();
       createMainPanel();
        
    }
    
     public void initializeMainScreen(){
        
        mainScreen.removeAll();
        mainScreen = new JPanel();
       mainPanel.add(mainScreen);
        
    }
    
    
    
    
    
    public void createMainPanel(){
        
        
        
        
        mainPanel.setLayout(null);
        
        
        sideButton1.setBounds(40, 30, 60, 60);
        sideButton2.setBounds(40, 144, 60, 60);
        sideButton3.setBounds(40, 260, 60, 60);
        sideButtonr1.setBounds(700, 30, 60, 60);
        sideButtonr2.setBounds(700, 144, 60, 60);
        sideButtonr3.setBounds(700, 260, 60, 60);
      
        
        bottomButton1.setBounds(160, 890, 110, 50);
        bottomButton2.setBounds(540, 890, 110, 50);
       
        
        sideButton1.addActionListener(new TestScreen1.ControlButtonListener());
        sideButton2.addActionListener(new TestScreen1.ControlButtonListener());
        sideButton3.addActionListener(new TestScreen1.ControlButtonListener());
        sideButtonr1.addActionListener(new TestScreen1.ControlButtonListener());
        sideButtonr2.addActionListener(new TestScreen1.ControlButtonListener());
        sideButtonr3.addActionListener(new TestScreen1.ControlButtonListener());
        bottomButton1.addActionListener(new TestScreen1.ControlButtonListener());
        bottomButton2.addActionListener(new TestScreen1.ControlButtonListener());
        
        sideButton1.setText("L1");
        sideButton2.setText("L2");
        sideButton3.setText("L3");
        sideButtonr1.setText("R1");
        sideButtonr2.setText("R2");
        sideButtonr3.setText("R3");
        bottomButton1.setText("B1");
        bottomButton2.setText("B2");
        
        
        
        shipLabel.setBounds(140, 350, 60, 20);
        crewLabel.setBounds(140, 380, 60, 20);
        shipLevel.setBounds(180, 350, 480, 20);
        crewLevel.setBounds(180, 380, 480, 20);
        //shipLabel.setFont();
        //ssMap.setBackground(Color.black);
        
        ssMap = createSolarSystemMap(ssTemp);
        gMap = createGalaxyMap();
        ssMap.setBackground(Color.black);
        gMap.setBackground(Color.black);
        gMap.setBounds(60, 580, 300, 300);
        ssMap.setBounds(440, 580, 300, 300);
        gMapInfo.setBounds(60, 440, 300, 140);
        ssMapInfo.setBounds(440, 440, 300, 140);
        gMapInfo.setBackground(Color.white);
        ssMapInfo.setBackground(Color.white);
        mainScreen.setBounds(140, 30, 520, 300);
        mainScreen.setBackground(Color.white);
        
        //mainScreenText.setColumns(20);
        //mainScreenText.setRows(20);
        
        
        
        
        //if(mainScreenChoice == 0){
        //mainScreen.add(mainScreenText);
        //}else{
            //ssPanel = new SolarSystemJPanel(ssAmount);
        ssPanel.setBounds(140, 30, 520, 300);
         //mainScreen.add(ssPanel);   
       // }
        
        
        
        
        helmsmanText.setColumns(10);
        helmsmanText.setRows(10);
        engineeringText.setColumns(20);
        gMapInfo.add(helmsmanText);
        ssMapInfo.add(engineeringText);
        
        mainPanel.add(shipLabel);
        mainPanel.add(crewLabel);
        mainPanel.add(shipLevel);
        mainPanel.add(crewLevel);
        mainPanel.add(sideButton1);
        mainPanel.add(sideButton2);
        mainPanel.add(sideButton3);
        mainPanel.add(sideButtonr1);
        mainPanel.add(sideButtonr2);
        mainPanel.add(sideButtonr3);
        mainPanel.add(bottomButton1);
        mainPanel.add(bottomButton2);
        mainPanel.add(gMapInfo);
        mainPanel.add(ssMapInfo);
        mainPanel.add(gMap);
        mainPanel.add(ssMap);
        mainPanel.add(ssPanel);
        //mainPanel.add(mainScreen);
        
        this.add(mainPanel);
        //SpacePatrol game = new SpacePatrol();
        //createGalaxyMap();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public JPanel createGalaxyMap(){
        
        galaxyMapButtonArray = new Obutton[ShipsInSpace.size][ShipsInSpace.size];
        
        
        
        galaxyMapButtonPanel = new JPanel(); //new BoxLayout(mainPanel, BoxLayout.Y_AXIS) from oracle site http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
        galaxyMapButtonPanel.setLayout(new GridLayout(ShipsInSpace.size,ShipsInSpace.size));
        galaxyMapButtonPanel.setSize(400, 400);
        
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
                  galaxyMapButton.addActionListener(new TestScreen1.GalaxyMapButtonListener());
                  galaxyMapButton.setA(i);
                  galaxyMapButton.setB(j);
                  galaxyMapButton.setVisible(true);
                  galaxyMapButton.setBorderPainted(false);
                  galaxyMapButton.setBackground(ShipsInSpace.gtest.galaxyMap[i][j].color);
                 
                  galaxyMapButtonPanel.add(galaxyMapButton);
                  
                  //arrayNumber++;
                }
            }
        
        //bottomButtonPanel.add(backButton);
        //this.add(bottomButtonPanel);
        //this.add(galaxyMapButtonPanel); 
        return galaxyMapButtonPanel;
    }
    
    
    public JPanel createSolarSystemMap(SolarSystem sSystem){
        
        ss = sSystem;
        
        
        solarSystemMapButtonArray = new Obutton[ShipsInSpace.size][ShipsInSpace.size];
        
        
        
        solarSystemMapButtonPanel = new JPanel(); 
        solarSystemMapButtonPanel.setLayout(new GridLayout(ShipsInSpace.size,ShipsInSpace.size));
        //solarSystemMapButtonPanel.setSize(400, 400);
        
        //controlButtonPanel = new JPanel();
        //controlButtonPanel.setSize(600, 100);
        
        backButton = new JButton("Back");
        
        
        for(int i = 0; i < ShipsInSpace.size; i++){
                for(int j = 0; j < ShipsInSpace.size; j++){
                  //solarSystemMapButton = new Obutton(i,j,ss.solarSystemMap[i][j].icon);
                  solarSystemMapButton = new Obutton();
                  solarSystemMapButtonArray[i][j] = solarSystemMapButton;
                  solarSystemMapButton.setBackground(ss.solarSystemMap[i][j].color);
                  solarSystemMapButton.setA(i);
                  solarSystemMapButton.setB(j);
                  solarSystemMapButton.setBorderPainted(false);
                  solarSystemMapButton.addActionListener(new TestScreen1.SolarSystemMapButtonListener());
                  //solarSystemMapButton.addActionListener(new SolarSystemMapPanel.SolarSystemMapButtonListener());
                  solarSystemMapButtonPanel.add(solarSystemMapButton);
                 
                }
            }
        
        //controlButtonPanel.add(backButton);
        //this.add(controlButtonPanel);
        return solarSystemMapButtonPanel;
        
        
        
        
    }
    
    
    public class GalaxyMapButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
           Obutton thisButton = (Obutton) evt.getSource();
           
           Random random = new Random();
           int randomNumber = 1 + random.nextInt( ShipsInSpace.size - 1 );
           //System.out.println(ShipsInSpace.gtest.galaxyMap[thisButton.getX()][thisButton.getY()].SolarSystemName);
          helmsmanText.setText(null);
           helmsmanText.append(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].SolarSystemName + " (" + (ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.size() - 1) + " planets)");
         // helmsmanText.append("\n" + ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.toString());
          mainScreenText.setText(null);
           mainScreenText.append(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].SolarSystemName);
          mainScreenText.append("\n" + ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.toString());
          //System.out.println("and...");
           //System.out.println(ShipsInSpace.gtest.galaxyMap[thisButton.getX()][thisButton.getY()].solarSystemNameList.toString());
           //System.out.println();
           //if(ShipsInSpace.gtest.galaxyMap[thisButton.getX()][thisButton.getY()].equals(EmptySolarSystem)){
           //ssMap.remove(solarSystemMapButtonPanel);
          //ssMap = new JPanel(); 
         // mainPanel.remove(ssMap);
           //ssMap.removeAll();
          // ssMap.repaint();
           //ssMap = new JPanel();
           //ssMap = createSolarSystemMap(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()]);//new SolarSystemMapUI(ShipsInSpace.gtest.galaxyMap[thisButton.getX()][thisButton.getY()]);
           //ssMap.setBounds(440, 580, 300, 300);
         
           //mainPanel.add(ssMap);
           //ssMap.setVisible(false);
           //ssMap.repaint();
           //mainPanel.repaint();
           //}
          ssPanel = new SolarSystemJPanel(ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.size());
          //mainScreenText.setVisible(false);
          ssAmount = ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].solarSystemNameList.size();
          mainScreenChoice = 1;
          //mainScreen.remove(mainScreenText);
          //mainScreen.add(ssPanel);
          engineeringText.setText(null);
           engineeringText.append("              " + ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()].SolarSystemName);
           ssTemp = ShipsInSpace.gtest.galaxyMap[thisButton.getA()][thisButton.getB()];
          initializeComponents(); 
          ssPanel.playerShip.requestFocusInWindow();
        }
    }
    
    
    public class SolarSystemMapButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
           Obutton thisButton = (Obutton) evt.getSource();
           String temp = ss.solarSystemMap[thisButton.getA()][thisButton.getB()].getClass().toString();
           engineeringText.setText(null);
           engineeringText.append(ss.solarSystemMap[thisButton.getA()][thisButton.getB()].name + "\n");
           System.out.println(ss.solarSystemMap[thisButton.getA()][thisButton.getB()].name);
           //ss.solarSystemMap[thisButton.getA()][thisButton.getB()]//System.out.println(temp);
           if(temp.equals("class shipsinspace.Planet")){
           //System.out.println("almost there");  
           Planet pleaseWork;
          pleaseWork = (Planet) ss.solarSystemMap[thisButton.getA()][thisButton.getB()];
          System.out.println(pleaseWork.canLiveThere());
          System.out.println("Gold : " + pleaseWork.elements[79]);
          System.out.println("Iron : " + pleaseWork.elements[26]);
          System.out.println("Phosphorous : " + pleaseWork.elements[15]);
          System.out.println("Element ZERO : " + pleaseWork.elements[0]);
          engineeringText.append(pleaseWork.canLiveThere());
          engineeringText.append("\nPlanet Size: " + sizeToString(pleaseWork.size));
          engineeringText.append("\nGold : " + pleaseWork.elements[79]);
          engineeringText.append("\nIron : " + pleaseWork.elements[26]);
          engineeringText.append("\nPhosphorous : " + pleaseWork.elements[15]);
          engineeringText.append("\nElement ZERO : " + pleaseWork.elements[0]);
          //mainScreenText.setVisible(false)
          //ss.solarSystem.size()
          //initializeComponents(); 
          for(int i = 0; i < ss.solarSystem.size(); i++){
              if(ssPanel.buttonList.get(i).getBackground().equals(Color.red)){
               ssPanel.buttonList.get(i).setBackground(Color.gray);   
              }
          }
          ssPanel.buttonList.get(pleaseWork.number).setBackground(Color.red);
          ssPanel.playerShip.requestFocusInWindow();//.setText("#");
            }
            
        }
    }
    
     public class ControlButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
          
           JButton thisButton = (JButton) evt.getSource();
           
            if (thisButton == bottomButton1) {
               // ShipsInSpace.screenTest.test1.removeAll();
              //  ShipsInSpace.screenTest.test1 =  new TestScreen();
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton B1");
              //ShipsInSpace.screenTest.game = new SpacePatrol();  
            }
            if (thisButton == bottomButton2) {
             //bottomButton2.setText("Planet Map");
             mainScreenChoice = 1;
             initializeMainScreen();
             //mainScreenText.setText(null);
               // mainScreenText.append("\n\n\n\n\n\n\n\n\nButton B2");  
            }
            if (thisButton == sideButton1) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton L1");
                //ShipsInSpace.screenTest.
               // ShipsInSpace.game();
            }
            if (thisButton == sideButton2) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton L2");
            }
            if (thisButton == sideButton3) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton L3");  
            }
            if (thisButton == sideButtonr1) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton R1");
            }
            if (thisButton == sideButtonr2) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton R2");
            }
            if (thisButton == sideButtonr3) {
                mainScreenText.setText(null);
                mainScreenText.append("\n\n\n\n\n\n\n\n\nButton R3");
            }

    
           
           
           
           
           
           
           
           
            
        }
    }   
    
    public String sizeToString(int size){
        String planetSize = "";
        
        if(size > 600){
          planetSize = "Large";  
        }else if(size > 400){
          planetSize = "Medium";  
        }else{
          planetSize = "Small";   
        }
        
        
        
        return planetSize;
    }
    
}
