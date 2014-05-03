
package shipsinspace;


import java.util.Random;

public class EnemyShip extends Ship{

    
    public EnemyShip(){
        if (ShipsInSpace.size < 30) {
            super.icon = "<->";
        } else {
            super.icon = "^";
        }
        
        int x;
        int y;
    }
    
    
    public static void move(int x, int y, int dx, int dy, Object[][] spaceMap){
   
       // south
        if(x<dx && y==dy){
            Object temp = spaceMap[x+1][y];
            spaceMap[x+1][y] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // north
        if(x>dx && y==dy){
            Object temp = spaceMap[x-1][y];
            spaceMap[x-1][y] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // east
        if(y<dy && x==dx){
            Object temp = spaceMap[x][y+1];
            spaceMap[x][y+1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // west
        if(y>dy && x==dx){
            Object temp = spaceMap[x][y-1];
            spaceMap[x][y-1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // southeast
        if(x<dx && y<dy){
            Object temp = spaceMap[x+1][y+1];
            spaceMap[x+1][y+1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // southwest
        if(x<dx && y>dy){
            Object temp = spaceMap[x+1][y-1];
            spaceMap[x+1][y-1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
       // northeast
        if(x>dx && y<dy){
            Object temp = spaceMap[x-1][y+1];
            spaceMap[x-1][y+1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        // northwest
        if(x>dx && y>dy){
            Object temp = spaceMap[x-1][y-1];
            spaceMap[x-1][y-1] = spaceMap[x][y];
            spaceMap[x][y] = temp; 
        }
        
        
        //  Random rand = new Random();
    //  int move = (1 + rand.nextInt( 3 ))-2; 
    //  int d1 = 1 + rand.nextInt( 2 );
      //  switch(d1){
           // case 1: [i+move][j]; break;
           // case 2: [i][j+move]; break;
       // }
       // int temp = spaceMap[i][j];
       // spaceMap[i][j] = spaceMap[i+move][j];
       // spaceMap[i+move][j] = temp;
    }
    
    public static boolean detectWall(int x, int y, Object[][] gameMap){
        boolean detect = false;
        if(gameMap[x][y]==ShipsInSpace.wall){
            detect = true;
        }
        return detect;
    }
}
