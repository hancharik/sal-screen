
package shipsinspace;


public class Station extends Thing {
    
    public Station(){
       // super.icon = "O";
        super.icon = ("(" + ShipsInSpace.stationNumber + ")");
         //super.icon = String.valueOf(ShipsInSpace.stationNumber);
    }
    
}
