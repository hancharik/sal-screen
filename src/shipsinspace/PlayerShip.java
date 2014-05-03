
package shipsinspace;


public class PlayerShip extends Ship{
   
    public static int speed = 1;
    
    public PlayerShip(){
        if (ShipsInSpace.size < 30) {
            super.icon = "|^|";
        } else {
            super.icon = ">";
        }
        
        int x;
        int y;
    }
    //public static void setIcon(){
  //      super.icon = ("|" + ShipsInSpace.stationNumber + "|");
  //  }
    
    public static void move(int x, int y, int dx, int dy, Object[][] spaceMap){
        
        // arive at destination
        if(x==dx && y==dy){
          // this has the ship go to a new random destination on arrival:
          ShipsInSpace.randomCoordinates();
        }
        
        if(x>dx && y==dy){
            goNorth(x,y); 
        }
        
        if(x<dx && y==dy){
            goSouth(x,y); 
        }
        
        if(y<dy && x==dx){
            goEast(x,y);
        }
        
        if(y>dy && x==dx){
            goWest(x,y);
        }
        
        if(x<dx && y<dy){
            goSouthEast(x,y);
        }
        
        if(x<dx && y>dy){
            goSouthWest(x,y);
        }
        
        if(x>dx && y<dy){
            goNorthEast(x,y);
        }
        
        if(x>dx && y>dy){
            goNorthWest(x,y);  
        }
        
        
    }
    
    public static void goNorth(int x, int y){//&& detectEmptySpace(x+speed, y, spaceMap)){
            Thing temp = ShipsInSpace.spaceMap[x-speed][y];
            ShipsInSpace.spaceMap[x-speed][y] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp; 
    }
    public static void goSouth(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x+speed][y];
            ShipsInSpace.spaceMap[x+speed][y] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;  
    }
    public static void goEast(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x][y+speed];
            ShipsInSpace.spaceMap[x][y+speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;
    }
    public static void goWest(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x][y-speed];
            ShipsInSpace.spaceMap[x][y-speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;
    }
    public static void goNorthEast(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x-speed][y+speed];
            ShipsInSpace.spaceMap[x-speed][y+speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp; 
    }
    public static void goNorthWest(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x-speed][y-speed];
            ShipsInSpace.spaceMap[x-speed][y-speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;  
    }
    public static void goSouthEast(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x+speed][y+speed];
            ShipsInSpace.spaceMap[x+speed][y+speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;
    }
    public static void goSouthWest(int x, int y){
            Thing temp = ShipsInSpace.spaceMap[x+speed][y-speed];
            ShipsInSpace.spaceMap[x+speed][y-speed] = ShipsInSpace.spaceMap[x][y];
            ShipsInSpace.spaceMap[x][y] = temp;
    }
    
    
    
    public static boolean detectEmptySpace(int x, int y, Object[][] gameMap){
        boolean detect = false;
        if(gameMap[x][y]==ShipsInSpace.emptySpace){
            detect = true;
        }
        return detect;
    }
}
