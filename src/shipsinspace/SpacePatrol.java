/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;


import java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.Math;


public class SpacePatrol {

    
   //static MainScreenUI mainScreen; //take this out to see where screens need adjusted
    int ship = 5000;
    int maxShip = 5000;
    int shipDivisor = maxShip/480;
     int shipBar = ship/105;
     int shipTemp = 1;
     int crew = 2000;
     int maxCrew = 2000;
     int crewDivisor = maxCrew/480;
     int crewBar = crew/crewDivisor;
     static int gameSpeed = 120; //120 is 10 parsecs per second
     int shieldRegenerationPower = 0;
     int gameDifficulty = 100;
    public SpacePatrol() {
     
    Scanner in = new Scanner(System.in);    
    Random randomNumbers = new Random(); 
    //mainScreen = new MainScreenUI(); 
     /*
     int ship = 50000;
     int shipBar = ship/105;
     int shipTemp = 1;
     int crew = 1;
     int crewBar = crew/105;
     * */
     int deadCrewMembers = 0;
     int reply = 1;
     boolean arrived = false;
     int tripLength = 1;
     int xPos = 40;
     int yPos = 40;
     int trip = 0;
     int newXpos = 1;
     int newYpos = 1;
     int distance = distance(xPos, yPos, newXpos, newYpos);
     int letsGoHome = 0;
     int galaxySize = 100;
     
       
     
     
     
     
     
       System.out.println();
       System.out.println();
       System.out.println("       [[[[ SPACE PATROL ]]]] "  ); 
       shipsinspace.ScreenTest.test1.mainScreenText.append("\n\n\n\n\n\n\n                                  [[[[ SPACE PATROL ]]]] "  );
       System.out.println();
       System.out.println();
       
               pause(20);
       
       //System.out.println("\n\nSet Galaxy size: " );
       //galaxySize = in.nextInt();
       //System.out.println("\n\nGalaxy size: " + galaxySize);
       pause(20);
       shipsinspace.ScreenTest.test1.mainScreenText.setText(null);
     //getGalaxy();
      // shipsinspace.ScreenTest.test1.mainScreenText.append(null);
      // shipsinspace.ScreenTest.test1.mainScreenText.append(null);
       //randomNumbers = new Random();
       //xPos = newXpos(galaxySize);
       //yPos = newYpos(galaxySize);
       xPos = 1;
       yPos = 1;
     
       while (crew > 0 && ship > 0){
           
           if (xPos == 1 && yPos == 1){
              // ship = 50000;
             //  crew = 20000;
           }
           
        
       trip++;
        double crewPercent = ((crew/200));
        double damagePercent = ((ship/500));     
        
        
        
       shipsinspace.ScreenTest.test1.mainScreenText.append("   Trip Number : " + trip + "\n");
       System.out.println("\n\nTrip number: " + trip);
       shipsinspace.ScreenTest.test1.mainScreenText.append("Starting Position : (" + xPos + "," + yPos + ")\n");
       System.out.println("Ship's location: (" + xPos + "," + yPos + ")");
       System.out.println("Crew is at " + crewPercent + "% ");
       System.out.println("Ship is at " + damagePercent + "% ");
       
       
        
       ship = replenishShip(ship, xPos, yPos);
       crew = replenishCrew(crew, xPos, yPos);
       crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
       
       
       if (ship < 20000 || crew < 10000){
        
       pause (20);
       System.out.print("\nCaptain: 'Ok.. Look, let's head back to home base...\nHelmsman: 'Aye,aye, sir! Plotting coordinates to home base...\n");
       newXpos = 1;
       newYpos = 1;
       letsGoHome++;
       }else{
           
       randomNumbers = new Random();
       newXpos = newXpos(galaxySize);
       newYpos = newYpos(galaxySize);
       
       distance = distance(xPos, yPos, newXpos, newYpos);
       tripLength = distance;
       
       System.out.println(); 
       System.out.println(); 
       pause(10);
       shipsinspace.ScreenTest.test1.mainScreenText.append("scanning for planets...\n");
       System.out.println("scanning for planets...");
       pause(10);
       shipsinspace.ScreenTest.test1.mainScreenText.append("suitable planet found: (" + newXpos + "," + newYpos + ")\n");
       System.out.println("suitable planet found: (" + newXpos + "," + newYpos + ")");
       }
       pause(10);
       shipsinspace.ScreenTest.test1.mainScreenText.append("Calculating distance...\n");
       System.out.println("Calculating distance...");
       pause(10);
       shipsinspace.ScreenTest.test1.mainScreenText.append("Distance :" + distance + " parsecs\n");
       System.out.println("Distance :" + distance + " parsecs\n");
       
       tripComment(distance);
       pause(10);
       shipsinspace.ScreenTest.test1.mainScreenText.setText(null);
       
       
      
          
         
             for (int j = 1; j < distance; j++){
                 
                 
              
                
                
             randomNumbers = new Random();
             //int d2 = 1 + randomNumbers.nextInt( 5 * galaxySize );
             int d2 = 1 + randomNumbers.nextInt( gameDifficulty );
             
             switch (d2){
                 
                 case 1 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Zombie Ship!");
                            System.out.println("\nEngineering: 'Captain! A zombie ship has crippled our engines! We're dead in the water!");
                            captainResponse();
                            crew = zombieBattle(crew);
                            System.out.println("We are at " + crew + " crewmembers.\n");
                            ship = ship - 10000;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 2 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Space Bugs!!");
                            System.out.println("\nEngineering: 'Captain! We sucked some space bugs into our intake!  \nBugs are all over the ship's insides, sir!'");
                            captainResponse();
                            crew = spaceBugBattle(crew); 
                            System.out.println("We are at " + crew + " crewmembers.\n");
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break; 
                 case 3 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Space Octopus!");
                            System.out.println("\n\nSPAAAAACE OCTOPUUUUUUUUUUUUUUS!!!!!!!!!!!!!");   
                            captainResponse();
                            crew = octopusBattle(crew);
                            int d67 = 1 + randomNumbers.nextInt( 500 ); 
                            int octoDamage = 80 * d67;
                            ship = ship - octoDamage;
                            System.out.println("Our hull took " + d67 + " damage");
                            pause(10);
                            System.out.println("We are at " + crew + " crewmembers.\n\n\n");
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            pause(20);
                            shipTemp = ship;
                            
                            //ship = shipCombat( ship, crew );
                            //crew = lostCrew( shipTemp, ship, crew);
                            break;
                 case 5 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                            shipsinspace.ScreenTest.test1.mainScreenText.setText(null);
                            shipsinspace.ShipsInSpace.game();
                            captainResponse();
                            pause(2);
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 6 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                            shipsinspace.ShipsInSpace.game();
                            captainResponse();
                            pause(2);
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 7 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                           shipsinspace.ShipsInSpace.game();
                            pause(2);
                            captainResponse();
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 8 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                            shipsinspace.ShipsInSpace.game();
                            pause(2);
                            captainResponse();
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 9 :   shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                            shipsinspace.ShipsInSpace.game();
                            pause(2);
                            captainResponse();
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 case 10 :  shipsinspace.ScreenTest.test1.mainScreenText.append("Incoming Ship!");
                            pause(2);
                            System.out.println("#################\nIncoming ship!!!\n#################");
                            shipsinspace.ShipsInSpace.game();
                            pause(2);
                            captainResponse();
                            shipTemp = ship;
                            ship = shipCombat( ship, crew );
                            crew = lostCrew( shipTemp, ship, crew);
                            crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
                            break;
                 
             }
             crewBar = crew/crewDivisor;
                            shipBar = ship/105;
                            setBars();
             
               //pause(1);
               shipsinspace.ScreenTest.test1.mainScreenText.append("\n\n\n\n\n\n\n\n                              ...arriving in " + ((distance - j)/10) + " seconds\n");
               pause(1);
               shipsinspace.ScreenTest.test1.mainScreenText.setText("");
                System.out.println( "...arriving in " + ((distance - j)/10) + " seconds" );
          
     if (ship < 0){
         
          System.out.println();
          shipsinspace.ScreenTest.test1.mainScreenText.setText("\n\n\n\n\n\n\n\n                                   Game Over.");
          System.out.println("Game Over.");
          System.out.println("\n\nTrip number: " + trip);
          System.out.println("\n\nTrips back to home base: " + letsGoHome);
          System.out.println("\nGame over\nGalaxy size: " + galaxySize);
          pause(3000);
        //System.out.println(" Our ship is dead ");
        //System.out.println("We were blown out of the sky! ");
        j = j + 4000;
        arrived = true;
        
      }
         
        
      } 
      
             //arrived = true;
             
      
      if (ship > 0){
   /*     if (xPos == 1 && yPos == 1){
            ship = 50000;
            crew = 20000; 
         }  */
      System.out.print("Captain, we have arrived");
      System.out.println(" after a " + tripLength + " parsec journey." );
      damagePercent = ((ship/500));
      System.out.println("Ship is at " + damagePercent + "% ");
      if (crew < 0){
      System.out.println("Ghost Ship!");
      shipsinspace.ScreenTest.test1.mainScreenText.setText("\n\n\n\n\n\n\n\n                              Ghost Ship!\n                              Game Over.");
      
      System.out.println("\n\nTrip number: " + trip);
     
      }else{
          crewPercent = ((crew/200));
      System.out.println("Crew is at " + crewPercent + "% ");
     
      }
      //System.out.println("We are at " + crew + " crewmembers.");
      //System.out.println("Ship is at " + ship);
        
            if (crew > 20000){
                crew = zombieBattle(crew);
                System.out.println("We are at " + crew + " crewmembers.");
            }
      
      
      
      xPos = newXpos;
      yPos = newYpos;
      System.out.println("Ship's location: (" + xPos + "," + yPos + ")");
      //System.out.println("\n\nTrips back to home base: " + letsGoHome);
      //System.out.println("\n\nGalaxy size: " + galaxySize);
      }
      //pause(2000);
      arrived = true;
     
      
      
      
     }
        
     
    }
  
    
    
    public static void tripComment(int time) {
      if (time > 100){
            System.out.println("Helmsman: 'Oh no, we'll never make it!!'"); 
         
         }
          if (time < 50){
            System.out.println("Captain: 'This should be an easy trip'"); 
         
         }  
    }
    
    
    public static int replenishShip(int ship, int xPos, int yPos) {
        if (xPos == 1 && yPos == 1){
            ship = 50000;
        }
        return ship;
    }
    
    
    
    public static int replenishCrew(int crew, int xPos, int yPos) {
        Random randomNumbers = new Random();   
      int newCrewMembs = (1 + randomNumbers.nextInt( crew )) / 3;
      int localTrouble = 1 + randomNumbers.nextInt( 10000 );
      if(xPos == 1 && yPos == 1){
        
            crew = 20000;   
      }else if(localTrouble % 3 == 0){
          //pause(20);
          shipsinspace.ScreenTest.test1.mainScreenText.setText("\n\n\n\n\n\n\n           Oh no, trouble with the locals!\nWe lost " + localTrouble + " crew!");
          pause(20);
          shipsinspace.ScreenTest.test1.mainScreenText.setText(null);
          System.out.println("Oh no, trouble with the locals!\nWe lost " + localTrouble + " crew!");
          crew = crew - localTrouble;
      }else if (crew < 20000){
            crew = crew + newCrewMembs;
            System.out.println("Replenishing crew...");
            double crewPercent = ((crew/200));
       System.out.println("Crew is at " + crewPercent + "% ");
        }
        return crew;
    }
    
    
    public static int deadCrewMembers(int reaper, int crew) {
        
        if( crew < 100){
                    crew = 10;
                    return crew;
                }
        
      Random randomNumbers = new Random();   
      int deadCrewMembs = (1 + randomNumbers.nextInt( reaper )) / 2;
      return deadCrewMembs;  
    }
    
    
    
    
    
    public static int lostCrew(int shipStart, int shipEnd, int crew) {
        
        if( crew < 100){
                    crew = 10;
                   
                    System.out.println("\nWe are down to ten crew members.\n");
                    return crew;
                }
        else if( shipStart > shipEnd){
            int reaperLevel = shipStart - shipEnd;
            
            
            //System.out.println("Crew is at " +  crew + " \n we started at " + crewTemp + " crew members.");
            Random randomNumbers = new Random();   
            int deadCrewMembs = (1 + randomNumbers.nextInt( reaperLevel )) / 3;
            crew = crew - deadCrewMembs;
            pause(20);
            System.out.println("\nWe lost " + deadCrewMembs + " crew members.\n");
            System.out.println("Crew is at " +  crew);
            System.out.println();
            pause(20);
        } 
      return crew;
    }
    
    
    
    public static void pause(int time) {
   
      int timex = time * gameSpeed; //120 is 10 parsecs per second  
     try
        {
            Thread.sleep(timex);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }
    
    }
  
     private static int octopusBattle( int crew ) {
        
         System.out.println("\n*****************");
         System.out.println("   Attacked by");
         //System.out.println("*****************");
            
                    
                
                //System.out.println("*****************");
                    System.out.println("a space octopus!!!!!!!");
                    System.out.println("*****************\n");
                    pause(20);
          int tempCrew = crew;
        int spaceOctopus = 1;
         
         
            while (spaceOctopus > 0){
              for(int i = 0; i < 5; i++){
                
                
                
                Random randomNumbers = new Random();
                int crewHit = 1 + randomNumbers.nextInt( 10 );
                int spaceOctopusHit = 1 + randomNumbers.nextInt( 20 );
                if (spaceOctopusHit > crewHit + 5){
                   int crewDown = crew / 2;
                   int o2 = 1 + randomNumbers.nextInt( Math.abs(crewDown) );
                    crew = crew - o2;
                   System.out.println("Space Octopus kills " + o2 + " crew!");
                   pause(5);
                }else{
                    spaceOctopus--;
                    
                }
                 
               
            }
            
            }
            int crewLost = (tempCrew - crew); 
            System.out.println("We lost " + crewLost + " to a space octopus attack!");
             pause(20);
         return crew;
     }
     
     private static int zombieBattle( int crew ) {
         int tempCrew = crew;
        int zombies = 0;
         System.out.println("*****************");
         System.out.println("   Attacked by");
         //System.out.println("*****************");
                
                    Random randomNumbers = new Random();
                    zombies = 1 + randomNumbers.nextInt( 1000 ); 
                    
                
                //System.out.println("*****************");
                    System.out.println("  " + zombies + " zombies!!!");
                    System.out.println("*****************");
                    pause(20);
         int beginningZombies = zombies;
         int wave = 1;
         
         int deadZombies = 0;
            while (zombies > 0){
              for(int i = 0; i < 1000; i++){
                
                
                
                randomNumbers = new Random();
                int crewHit = 1 + randomNumbers.nextInt( 10 );
                int zombieHit = 1 + randomNumbers.nextInt( 10 );
                if (zombieHit > crewHit){
                   zombies++;
                   crew--;
                }else{
                    zombies--;
                    deadZombies++;
                }
                  
               
            }
              if(zombies > 0){
              System.out.println("After "  + wave + " hours of hand to hand combat,\nIt's our " + crew + " against " + zombies + " zombies!"); 
                pause(20);
                wave++;
              }
            }
            int crewLost = (tempCrew - crew); 
            System.out.println("\nAfter "  + wave + " hours of hand to hand combat,\n");
            System.out.println("We lost " + crewLost + " to a zombie attack!\n");
             pause(20);
         return crew;
     }
    
     
     private static int spaceBugBattle( int crew ) {
          int tempCrew = crew;
        int spaceBugs = 0;
         System.out.println("*****************");
         System.out.println("   Attacked by");
         //System.out.println("*****************");
                
                    Random randomNumbers = new Random();
                    spaceBugs = 1 + randomNumbers.nextInt( 40000 ); 
                    
               
                //System.out.println("*****************");
                    System.out.println("  " + spaceBugs + " space bugs!!!");
                    System.out.println("*****************");
                     pause(20);
         int beginningSpacebugs = spaceBugs;
         int wave = 1;
         
         int deadspaceBugs = 0;
            while (spaceBugs > 0){
              for(int i = 0; i < 1000; i++){
                
                
                
                randomNumbers = new Random();
                int crewHit = 1 + randomNumbers.nextInt( 20 );
                int spaceBugsHit = 1 + randomNumbers.nextInt( 10 );
                if (spaceBugsHit > crewHit + 3){
                    randomNumbers = new Random();
                    int b1 = 1 + randomNumbers.nextInt( 3 );
                    //crew = crew - b1;
                    crew--;
                   
                }else{
                    spaceBugs--;
                    deadspaceBugs++;
                }
                  
               
            }
              if(spaceBugs > 0){
              System.out.println("After "  + wave + " hours of heavy fighting,\nIt's our " + crew + " against " + spaceBugs + " space bugs!"); 
                pause(1);
                wave++;
              }
            }
            System.out.println("...we fought off " + spaceBugs + " spacebugs for " + wave + " hours!\n");
            int crewLost = (tempCrew - crew); 
            System.out.println("We lost " + crewLost + "!\n");
             pause(20);
         return crew;
     }
    
    
     private static void seeYa(){ 
                             Random randomNumbers = new Random(); 
                            int c1 =  (1 + randomNumbers.nextInt( 8 ));
                            
                            switch(c1){
                                case 1 : System.out.println("\nCaptain: 'Let's get the nertz out of here! Maximum warp!'\n"); break;
                                case 2 : System.out.println("\nCaptain: 'Let's blow this popstand! Full Thrust!'\n"); break;
                                case 3 : System.out.println("\nCaptain: 'HIT THAT WARP BUTTON NOW! NOW! NOW!'\n"); break;
                                case 4 : System.out.println("\nCaptain: 'I don't get paid enough for this! \nMaximum warp, let's loose these guys!'\n"); break;
                                case 5 : System.out.println("\nCaptain: 'Let's get gone, people!!! Maximum warp!'\n"); break;
                                case 6 : System.out.println("\nCaptain: 'We'll outrun them!  Full Thrust!'\n"); break;
                                case 7 : System.out.println("\nCaptain: 'HIT THAT WARP BUTTON NOW! NOW! NOW!'\n"); break;
                                case 8 : System.out.println("\nCaptain: 'Who needs this! \nFull Throttle, let's loose 'em!'\n"); break;
                                            
                            }
       
                            
                            
                            
     }
     
     
     
     private static void getGalaxy() {
         
         
         for(int i = 0; i < 11; i++){
             
                Random randomNumbers = new Random(); 
                int newXpos = 1 + randomNumbers.nextInt( 100 );
                int newYpos = 1 + randomNumbers.nextInt( 100 );
         
         
         
             
             
             
         }
         
   /*      
    ArrayList<Integer> myNumbers()    {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(11);
    numbers.add(3);
    return(numbers);
}
    
         */
         
         return;
     }
     
   
    
    private void setBars(){
         shipsinspace.ScreenTest.test1.shipLevel.setBounds(180, 350, shipBar, 20);
        shipsinspace.ScreenTest.test1.crewLevel.setBounds(180, 380, crewBar, 20);
    }
    
     private static int newXpos(int galaxySize) { 
       Random randomNumbers = new Random(); 
      int newXpos = 1 + randomNumbers.nextInt( galaxySize );
       return newXpos;
   }
     private static int newYpos(int galaxySize) { 
       Random randomNumbers = new Random(); 
      int newYpos = 1 + randomNumbers.nextInt( galaxySize );
       return newYpos;
   }
     
   private static int distance(int xPos, int yPos, int newXpos, int newYpos) { 
       Random randomNumbers = new Random(); // random number generator
      
       double dis = ((xPos - newXpos) * (xPos - newXpos)) + ((yPos - newYpos) * (yPos - newYpos));
       int distance = (int)Math.sqrt(dis);
       
       
       return distance;
   }
    
    
    
    
    
  public int shipCombat(int ship, int crew) {
   
      Random randomNumbers = new Random(); // random number generator
      Scanner in = new Scanner(System.in);
      
      int ourShip = ship;
      int ourCrew = 1;
      
      int enemyShip = 4000 + (1 + randomNumbers.nextInt( 6000 ));
      int shipEnergy = 1000;
      int enemyShipEnergy = 1000;
      int battleDamage = 0;
      
       pause(10);
       System.out.println(); 
       System.out.println("Our crew : " + crew + "\nOur ship : " + ourShip + "\nEnemy ship : " + enemyShip );
       //System.out.println("Our ship energy: \t" + shipEnergy + "\tenemy ship energy: \t" + enemyShipEnergy );
       System.out.println();
       
       
      while( ourShip > 0 && enemyShip > 0 ){
        
       Random randomNumbersBattle = new Random(); // random number generator   
       
       int damage = (1 + randomNumbersBattle.nextInt( 8000 )) ;
       /*
       pause(10);
       System.out.println(); 
       System.out.println("Our ship: \t" + ourShip + "\tEnemy ship : \t" + enemyShip );
       //System.out.println("Our ship energy: \t" + shipEnergy + "\tenemy ship energy: \t" + enemyShipEnergy );
       System.out.println(); 
       System.out.println(" What do we do, captain?"); 
       System.out.println(" 1: Fire Phasers"); 
       System.out.println(" 2: Fire Torpedos"); 
       System.out.println(" 3: Increase shields"); 
       System.out.println(" 4: Try to escape"); 
       System.out.println(); 
       int choice = in.nextInt();
       System.out.println(); */
       pause(10);
       int d4 = (1 + randomNumbers.nextInt( 4 ));
       int d1 = (1 + randomNumbers.nextInt( 100 ));
       switch(d4){
                            case 1 :  System.out.println(); 
                                        System.out.println("Captain: 'Fire Phasers!'\n"); 
                                        pause(15); 
                                            if (d1 > 45){ 
                                                System.out.println("\nHelmsman: 'Enemy ship hit!!!!'  " + damage);
                                                enemyShip = enemyShip - damage;
                                                if (enemyShip < 0){
                                                 System.out.println("\n/////////////////////\nEnemy Ship Destroyed!\n/////////////////////");   
                                                }
                                            }else{
                                                System.out.print("\n        We missed, sir!!\n");
                                            } 
                                                shipEnergy = shipEnergy - 100; 
                                                break;
                                
                            case 2 :  System.out.println();
                            System.out.println("     \nCaptain: 'Fire Torpedos!'\n");shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Fire Torpedos!'");
                                    pause(15); 
                                    if (d1 > 40){ 
                                        System.out.println("\nHelmsman: 'Enemy ship hit!!!!'  " + (damage * 2)); shipsinspace.ScreenTest.test1.mainScreenText.setText("Helmsman: 'Enemy ship hit!!!!'  " + (damage * 2)); 
                                        enemyShip = enemyShip - (damage * 2);
                                        if (enemyShip < 0){
                                                 System.out.println("\n\n/////////////////////\nEnemy Ship Destroyed!\n/////////////////////");  shipsinspace.ScreenTest.test1.mainScreenText.setText("Enemy Ship Destroyed!"); 
                                                }
                                    }else{
                                        System.out.print("\nHelmsman: 'We missed, sir!!'\n");
                                    } break;
                            case 3 :   
                                
                                if(ourShip < 20000){
                                System.out.println(); 
                                        System.out.println("\nCaptain: 'Charge shields!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Charge shields!'");
                                        pause(15); System.out.println(); 
                                        System.out.println("============================\n     Wummm wummm wummm!\n============================"); shipsinspace.ScreenTest.test1.mainScreenText.setText("    Wummm wummm wummm!");
                                            ourShip = ourShip + shieldRegenerationPower;
                                           
                                            shipBar = ourShip/105;
                                            setBars();
                                            }else{
                                    System.out.print("Engineering: 'Shields at full power, Captain!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Engineering: 'Shields at full power, Captain!'");
                                }
                                            break;
                            case 4 :  System.out.println(); 
                                                                seeYa();        
                                                                            if (d1 > 50){
                                                                             enemyShip = enemyShip - 99999; 
                                                                             System.out.print("\n      -----------\n");
                                                                             System.out.print("\n      we escaped!\n"); shipsinspace.ScreenTest.test1.mainScreenText.setText("      we escaped!");
                                                                             System.out.print("\n      -----------\n");
                                                                             System.out.print("Captain: 'Thank God!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Thank God!'");
                                                                            }else{
                                                                                System.out.println();
                                                                                int d9 =  (1 + randomNumbers.nextInt( 4 ));
                                                                                switch(d9){
                            
                                                                          case 1 :      pause(10); System.out.println("\nHelmsman: 'Oh no! they're still behind us!!!!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Oh no! they're still behind us!!!!!'");break;
                                                                           case 2 :      pause(10);System.out.println("\nHelmsman: 'Didn't work!!!!\nScanner shows them right behind us!!!!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Didn't work!!!!Scanner shows them right behind us!!!!!'");break;
                                                                            case 3 :     pause(10);System.out.println("\nHelmsman: 'Sir! they're right behind us!!!!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Sir! they're right behind us!!!!!'");break;
                                                                                case 4 :     pause(10);System.out.println("\nHelmsman: 'Warp drive failure!! Here they come!!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Warp drive failure!! Here they come!!!'");break;
                                                                                }
                                                                                System.out.println();
                                                                                captainResponse();
                                                                            }
                                                                                    break;
       }
       
       if (enemyShip > 0){
       System.out.println(); 
       System.out.println("Helmsman: 'Enemy ship firing...'"); 
       pause(10);
       int enemyFire = (1 + randomNumbersBattle.nextInt( 100 )); 
         if (enemyFire > 50){
             System.out.println();
             int totalDamage = (( enemyFire * 15) + damage );
             
            System.out.println("Helmsman: 'WE'RE HIT!!!'  :" + totalDamage);shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'WE'RE HIT!!!'  :" + totalDamage);
            
          
            
            battleDamage = battleDamage + (( enemyFire * 15) + damage);
            ourShip = ourShip - ( enemyFire * 15) - damage;
           
                            shipBar = ourShip/105;
                            setBars();
                            
            if (ourShip > 0){
            captainResponse(); 
            engineeringResponse(ourShip);
                        
            }else{
                shipsinspace.ScreenTest.test1.mainScreenText.setText("\n\n\n\n\n\n\n\n                             We were blown out of the sky! ");
                System.out.println("We were blown out of the sky! ");
            }
            
            
            //System.out.println("      ship :" + ourShip);
         }else{
             System.out.println();
                         System.out.println("Helmsman: 'Captain, they missed us!'");shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Captain, they missed us!'");

         }
         
         
       }
         
      }
      
      ship = ourShip;
      System.out.println();
       if (ourShip > 0){
           //System.out.println("We survived!");
           if (ourShip < 6000){
          System.out.println();
        System.out.println("Our ship is messed up." );  
      }
      
       }
      System.out.println();
      System.out.println("We took " + battleDamage + " damage.\n Ship is at " + ourShip );
       pause(20);
      
      return ship;
    }  
  
  
  public static void captainResponse(){
      pause(10);
      Random randomNumbers3 = new Random();
     int c1 = (1 + randomNumbers3.nextInt( 8 ));
     System.out.println();
      switch(c1){
                            case 1 :  System.out.println("Captain: 'My God!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'My God!!!'");  break;
                            case 2 :  System.out.println("Captain: 'Damage report!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Damage report!!!'"); break;
                            case 3 :  System.out.println("Captain: 'Engineering! Get on it!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Engineering! Get on it!!!'"); break;
                            case 4 :  System.out.println("Captain: 'Evasive manouvers!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Evasive manouvers!!!'");break;
                            case 5 :  System.out.println("Captain: 'I need more power!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'I need more power!!!'"); break;
                            case 6 :  helmsmanResponse(); System.out.println("Captain: 'Not today! NOT TODAY!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Not today! NOT TODAY!!'");break;
                            case 7 :  System.out.println("Captain: 'Is that the best you got, you...!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'Is that the best you got, you...!!!'");break;
                          case 8 :  System.out.println("Captain: 'C'mon, you bucket of bolts, get me outta this!!!'"); shipsinspace.ScreenTest.test1.mainScreenText.setText("Captain: 'C'mon, you bucket of bolts, get me outta this!!!'"); break;
      }
  }
  
   public static void engineeringResponse( int ship){
      pause(10);
      Random randomNumbers3 = new Random();
     int c1 = (1 + randomNumbers3.nextInt( 8 ));
     System.out.println();
      switch(c1){
                            case 1 :  System.out.println("Engineering: 'Ship is at " + ship + ", sir!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'Ship is at " + ship + ", sir!!'"); break;
                            case 2 :  System.out.println("Engineering: 'Ship is at " + ship + "\n-- AAAAGH! *****SHOWER OF SPARKS******"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'Ship is at " + ship + "\n-- AAAAGH! *****SHOWER OF SPARKS******"); break;
                            case 3 :  System.out.println("Engineering: 'We're pretty messed up down here, captain!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'We're pretty messed up down here, captain!!'");break;
                            case 4 :  System.out.println("Engineering: 'We're way past what she can put out, captain!'");shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'We're way past what she can put out, captain!'"); break;
                            case 5 :  System.out.println("Engineering: 'Ship is at " + ship + ", sir!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'Ship is at " + ship + ", sir!!'");break;
                            case 6 :  System.out.println("Engineering: '-- AAAAGH! *****SHOWER OF SPARKS******");shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: '-- AAAAGH! *****SHOWER OF SPARKS******"); break;
                            case 7 :  System.out.println("Engineering: 'AAAAgh My arm!! MY ARM!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'AAAAgh My arm!! MY ARM!!'");break;
                            case 8 :  System.out.println("Engineering: 'Ship is at " + ship + ", sir!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Engineering: 'Ship is at " + ship + ", sir!!'");break;
      }
  }
  
 public static void helmsmanResponse(){
      pause(10);
      Random randomNumbers3 = new Random();
     int h1 = (1 + randomNumbers3.nextInt( 8 ));
     int level = (1 + randomNumbers3.nextInt( 30 ));
     System.out.println();
      switch(h1){
                            case 1 :  System.out.println("Helmsman: 'Aye aye, sir!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Aye aye, sir!!'");break;
                            case 2 :  System.out.println("Helmsman: 'Nooo!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Nooo!!'");break;
                            case 3 :  System.out.println("Helmsman: 'We have casualties on level " + level + "!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'We have casualties on level " + level + "!'");break;
                            case 4 :  System.out.println("Helmsman: 'What the...! what the...!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'What the...! what the...!'");break;
                            case 5 :  System.out.println("Helmsman: 'We're doomed!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'We're doomed!!'");break;
                            case 6 :  System.out.println("Helmsman: 'Captain! I'm reading fires on level " + level + "!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Captain! I'm reading fires on level " + level + "!'");break;
                            case 7 :  System.out.println("Helmsman: 'Oh no! Oh no!!'"); shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Oh no! Oh no!!'");break;
                            case 8 :  System.out.println("Helmsman: 'Sir! We've lost life support on level " + level + "!'");  shipsinspace.ScreenTest.test1.helmsmanText.setText("Helmsman: 'Sir! We've lost life support on level " + level + "!'");break;
      }
  } 
  
} 
  

