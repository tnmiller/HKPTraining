import javax.xml.namespace.QName;

public class House {
    private int numofWindows;
    private int numofDoors;
    private String typeOfRoof;
    private String typeOfWall;

    public House(){ //default constructor
        numofDoors = 0;
        numofWindows = 0;
        typeOfRoof = null;
        typeOfWall = null;
    }    
    public House(int windows, int doors, String roof, String wall){ //constructor with parameters
        numofDoors=doors;
        numofWindows=windows;
        typeOfRoof=roof;
        typeOfWall=wall;
    }

    public House(House house){ //copy constructor (exist in different places in memory)
        numofDoors=house.numofDoors;
        numofWindows=house.numofWindows;
        typeOfRoof=house.typeOfRoof;
        typeOfWall=house.typeOfWall;
    }

    public int getNumOfWindows(){
        return numofWindows;
    }
    public int getNumOfDoors(){
        return numofDoors;
    }
    public String getTypeofRoof(){
        return typeOfRoof;
    }
    public String getTypeOfWall(){
        return typeOfWall;
    }
    public void setNumOfWindows(int newWindows){
        numofWindows=newWindows;
    }
    public void setNumOfDoors(int newDoors){
        numofDoors=newDoors;
    }
    public void setTypeofRoof(String newType){
        typeOfRoof = newType;
    }
    public void setTypeofWall(String newType){
        typeOfWall = newType;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof House){
            House otherHouse = (House) o;
            if(this.getNumOfDoors()==otherHouse.getNumOfDoors()&&this.getNumOfWindows()==otherHouse.getNumOfWindows()&&this.getTypeOfWall()==otherHouse.getTypeOfWall()&&this.getTypeofRoof()==otherHouse.getTypeofRoof()){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString(){
        return "A house with "+this.getNumOfDoors()+" doors and "+this.getNumOfWindows()+" windows.";
    }

    public static void main(String[] args) {
        House house = new House(10, 2, "Tiles", "Brick");
        System.out.println(house.getNumOfDoors());
    }

}
