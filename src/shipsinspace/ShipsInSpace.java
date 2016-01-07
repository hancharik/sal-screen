
package shipsinspace;

import java.util.Random;
import java.io.*;


public class ShipsInSpace {


    
    
    public static int size = 28 ;
    public static Thing[][] spaceMap = new Thing [size][size];
    public static GalaxyMap gtest = new GalaxyMap();
    public static PlayerShip playerShip = new PlayerShip();
    public static EnemyShip enemyShip1 = new EnemyShip();
    public static EnemyShip enemyShip2 = new EnemyShip();
    public static Thing station = new Station();
    public static Thing emptySpace = new EmptySpace();
    public static Thing wall = new Wall();
    //public static int playerSpeed = 1;
    public static int playerX;
    public static int playerY;
    public static int enemyX;
    public static int enemyY;
    public static int enemy2X;
    public static int enemy2Y;
    public static int stationX;
    public static int stationY;
    public static int stationNumber = 0;
    public static int randomX;
    public static int randomY;
    public static int move = 1;
    public static int playSpeed = 10;
    public static ScreenTest screenTest;
    public static int gameAmount = 3;
    
    
    
    
    
    public static void main(String[] args) {
     /* 
       SolarSystem ss1 = new SolarSystem();
       SolarSystem ss2 = new SolarSystem();
       SolarSystem ss3 = new SolarSystem();
       SolarSystem ss4 = new SolarSystem();
       SolarSystem ss5 = new SolarSystem();
       SolarSystem ss6 = new SolarSystem();
       System.out.println(ss1.solarSystemNameList);
       System.out.println(ss2.solarSystemNameList);
       System.out.println(ss3.solarSystemNameList);
       GalaxyMap g2 = new GalaxyMap();
       g2.printMap();
       System.out.println(ss4.solarSystemNameList);
       System.out.println(ss5.solarSystemNameList);
       System.out.println(ss6.solarSystemNameList);
       GalaxyMap g1 = new GalaxyMap();
       g1.printMap();
   */  
        //gtest.displayMapNames();
       // gtest.printMap();
      // GalaxyMapUI test = new GalaxyMapUI();
        //SpacePatrol s1 = new SpacePatrol();
        
       screenTest = new ScreenTest();
       //game();
        //SpacePatrol game = new SpacePatrol();
    }
    
    
    
    
    
    
    
   public static void game(){ //maybe should be called combat?
        
        createMap();
        randomCoordinates();
        //buildWall();
        for(int c = 0; c < gameAmount; c++){
            // PlayerShip.move(playerX, playerY, randomX, randomY, spaceMap);
        getCoordinates();
        printMap();
        
       // for(int i=0; i<20;i++){
       //     shipsinspace.ScreenTest.test1.mainScreenText.append("\n");
       // }
        
        printPositions();
        pause(6);
        shipsinspace.ScreenTest.test1.engineeringText.setText(null);
        shipsinspace.ScreenTest.test1.mainScreenText.setText(null);
        //PlayerShip.move(playerX, playerY, stationX, stationY, spaceMap);
        playerShip.move(playerX, playerY, randomX, randomY, spaceMap);
        //quick hack to double the player ship speed
        if(move % 2 == 1){
        enemyShip1.move(enemyX, enemyY, playerX, playerY, spaceMap);
       
        }
        if(move % 3 == 1){
        
        enemyShip2.move(enemy2X, enemy2Y, playerX, playerY, spaceMap);
        //EnemyShip.move(enemyX, enemyY, playerX, playerY, spaceMap);
        }
        move++;
        }
   } 
    
    
   public static void createMap(){
       
       //create empty map
       for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               spaceMap[i][j]= new EmptySpace();
           }
       }
       
       // add player ship
       spaceMap[getNumber()][getNumber()]= playerShip;
       //add enemy ship
       spaceMap[getNumber()][getNumber()]= enemyShip1;
       spaceMap[getNumber()][getNumber()]= enemyShip2;
       //add station
       //spaceMap[size-1][size-1]= station;
       
       
   } 
    
    public static int getNumber(){
        Random rand = new Random();
       int x = 1 + rand.nextInt( spaceMap.length - 1 );
       return x;
    }
    
    public static void getCoordinates(){
       getPlayerShipCoordinates();
       getEnemyShip1Coordinates();
       getEnemyShip2Coordinates();
       getStationCoordinates();
    }
    
    public static void getPlayerShipCoordinates(){
        
        for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               if(spaceMap[i][j]==playerShip){
                   playerX=i;
                   playerY=j;
               }
           }
          
       }
    }
        public static void getEnemyShip1Coordinates(){
        
        for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               if(spaceMap[i][j]==enemyShip1){
                   enemyX=i;
                   enemyY=j;
               }
           }
          
       }
    }
        
                public static void getEnemyShip2Coordinates(){
        
        for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               if(spaceMap[i][j]==enemyShip2){
                   enemy2X=i;
                   enemy2Y=j;
               }
           }
          
       }
    }
        
            public static void getStationCoordinates(){
        
        for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               if(spaceMap[i][j]==station){
                   stationX=i;
                   stationY=j;
               }
           }
          
       }
    }
    public static void printMap(){
        
        for(int i = 0; i < spaceMap.length; i++){
           for(int j = 0; j < spaceMap.length; j++){
               if(spaceMap[i][j]==null){
                System.out.print("   ");
                shipsinspace.ScreenTest.test1.mainScreenText.append("   ");
                shipsinspace.ScreenTest.test1.engineeringText.append("   ");
               }else{
                System.out.print(spaceMap[i][j].icon);
                shipsinspace.ScreenTest.test1.mainScreenText.append(spaceMap[i][j].icon);
                shipsinspace.ScreenTest.test1.engineeringText.append(spaceMap[i][j].icon);
               }
           }
           System.out.println();
           shipsinspace.ScreenTest.test1.mainScreenText.append("\n");
           shipsinspace.ScreenTest.test1.engineeringText.append("\n");
       }
       
        
    }
    
        public static void pause(int time) {
   
      int timeAmount = time * playSpeed; 
      //int timeAmount = time * 1; //this goes to one for testing purposes
     try
        {
            Thread.sleep(timeAmount);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }
    
    }
    
    public static void printPositions(){
        System.out.println("Player position: (" + playerX + "," + playerY + ")");
        System.out.println("Enemy 1 position: (" + enemyX + "," + enemyY + ")");
        System.out.println("Enemy 2 position: (" + enemy2X + "," + enemy2Y + ")");
        System.out.println("Station number " + stationNumber + " position: (" + randomX + "," + randomY + ")");
        for(int i=0; i<40;i++){
            System.out.println("");
        }
    }
    
    public static void randomCoordinates(){
          Random rand = new Random();
          int randX = 1 + rand.nextInt( size - 1 );
          int randY = 1 + rand.nextInt( size - 1 ); 
          //spaceMap[randomX][randomY]= emptySpace;
          randomX = randX;
          randomY = randY;
          stationNumber++;
          //spaceMap[randX][randY]= new Station();
          
    }
    
    public static void buildWall(){
        
        // center the wall
        
        int j = size/2;
        
        for (int i = size/4; i < (size/4)*3; i++){
            spaceMap[i][j]= wall;
        }
    }
    
}
