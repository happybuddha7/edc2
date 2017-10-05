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
        boolean exists=false;
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
        if (Places.contains(p)){
            this.startPlace=p;
        }
        else {
            this.newPlace(p.getName(),p.getX(),p.getY());
            this.startPlace=p;
        }
    }

    @Override
    public Place getStartPlace() {
        return this.startPlace;
    }

    @Override
    public void setEndPlace(Place p) throws IllegalArgumentException {
        if (Places.contains(p)){
            this.endPlace=p;
        }
        else {
            this.newPlace(p.getName(),p.getX(),p.getY());
            this.endPlace=p;
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
}
