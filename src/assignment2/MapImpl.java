import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class MapImpl implements Map{
    private Set<Place> Places;
    private Set<Road> Roads;
    private Place startPlace;
    private Place endPlace;
    public int tripDistance=0;

    public MapImpl(){
        this.Places=new HashSet<Place>();
        this.Roads=new HashSet<Road>();
        this.startPlace=null;
        this.endPlace=null;
        this.tripDistance=0;
    }
    @Override
    public void addListener(MapListener ml) {
    }

    @Override
    public void deleteListener(MapListener ml) {
    }

    @Override
    public Place newPlace(String placeName, int xPos, int yPos) throws IllegalArgumentException {
        char charCheck =placeName.charAt(0);
        if (!Character.isLetter(charCheck)){
            throw new IllegalArgumentException();
        }
        PlaceImpl place = new PlaceImpl(placeName, xPos,yPos);
        this.Places.add(place);
        return place;
    }

    @Override
    public void deletePlace(Place s) {
    this.Places.remove(s);
    }

    @Override
    public Place findPlace(String placeName) {
        for (Place place : Places){
            if (place.getName()==placeName){
                return place;
                }
        }
        return null;
    }
    @Override
    public Set<Place> getPlaces() {
        return this.Places;
    }
    @Override
    public Road newRoad(Place from, Place to, String roadName, int length) throws IllegalArgumentException {
        RoadImpl road= new RoadImpl(from,to,roadName,length);
        Roads.add(road);
        return road;
    }
    @Override
    public void deleteRoad(Road r) {
    this.Roads.remove(r);
    }
    @Override
    public Set<Road> getRoads() {
        return this.Roads;
    }
    @Override
    public void setStartPlace(Place p) throws IllegalArgumentException {
        if (p==null){this.startPlace=null;}
        else if (Places.contains(p)){
            this.startPlace=p;
        }
        else {
            throw new IllegalArgumentException("bad start place");
        }
    }
    @Override
    public Place getStartPlace() {
        return this.startPlace;
    }
    @Override
    public void setEndPlace(Place p) throws IllegalArgumentException {
        if (p==null){this.startPlace=null;}
        if (Places.contains(p)){
            this.endPlace=p;
        }
        else {
            throw new IllegalArgumentException("bad end place");
        }
    }
    @Override
    public Place getEndPlace() {
        return this.endPlace;
    }
    @Override
    public int getTripDistance() {
        return this.tripDistance;
    }


    public class PlaceImpl implements Place {
        public Set<Road> toRoads;
        public String name;
        public int x;
        public int y;
        private boolean startPlace;
        private boolean endPlace;


        public PlaceImpl(String name, int x, int y){
            this.toRoads= new HashSet<Road>();
            this.name=name;
            this.x=x;
            this.y=y;
            this.startPlace=false;
            this.endPlace=false;
        }
        @Override
        public void addListener(PlaceListener pl) {
        }
        @Override
        public void deleteListener(PlaceListener pl) {
        }
        @Override
        public Set<Road> toRoads() {
            return this.toRoads;
        }
        @Override
        public Road roadTo(Place dest) {
           for (Road road : this.toRoads){
               if(road.firstPlace()==dest){
                   return road;
               }else if (road.secondPlace()==dest){
                   return road;
               }
           }
            return null;
        }
        @Override
        public void moveBy(int dx, int dy) {
            this.x=this.x+dx;
            this.y=this.y+dy;
        }
        @Override
        public String getName() {
            return this.name;
        }
        @Override
        public int getX() {
            return this.x;
        }
        @Override
        public int getY() {
            return this.y;
        }
        @Override
        public boolean isStartPlace() {
            return this.startPlace;
        }
        @Override
        public boolean isEndPlace() {
            return this.endPlace;
        }
        @Override
        public String toString(){
            String string= this.name+"("+this.getX()+","+this.getY()+")";
            return string;
        }
    }


    public class RoadImpl implements Road {
        public Set<Place> places;
        public Place firstPlace;
        public Place secondPlace;
        public String roadNameString;
        public int roadLength;

        public RoadImpl(Place from, Place to, String roadName, int roadLength){
            places.add(from);
            firstPlace=from;
            places.add(to);
            secondPlace=to;
            this.roadNameString=roadName;
            this.roadLength=roadLength;

        }
        @Override
        public void addListener(RoadListener rl) {

        }
        @Override
        public void deleteListener(RoadListener rl) {
        }
        public void sortPlaces(){
            for(int i = 0; i<this.firstPlace.getName().length(); i++){
                if (this.firstPlace.getName().charAt(i)<this.secondPlace.getName().charAt(i)){
                    //already alphabetical ahead
                    break;
                }else if (this.firstPlace.getName().charAt(i)>this.secondPlace.getName().charAt(i)){
                    //firstplace is alphabetically second, swap position with second place
                    Place tempPlace = this.firstPlace;
                    this.firstPlace=this.secondPlace;
                    this.secondPlace=tempPlace;
                    break;
                } else if (this.firstPlace.getName().charAt(i)==this.secondPlace.getName().charAt(i)){
                    //i++ called by loop
                }
            }
        }
        @Override
        public Place firstPlace() {
            this.sortPlaces();
            return this.firstPlace;
        }
        @Override
        public Place secondPlace() {
            this.sortPlaces();
            return this.secondPlace;
        }
        @Override
        public boolean isChosen() {
            return false;
        }
        @Override
        public String roadName() {
            return roadNameString;
        }
        @Override
        public int length() {
            return this.roadLength;
        }
        //Return a string containing information about this road
        //in the form (without quotes, of course!):
        //"firstPlace(roadName:length)secondPlace"
        @Override
        public String toString(){
            return "firstplace("+this.roadName()+":"+this.roadLength+")"+this.secondPlace();}
    }




}
