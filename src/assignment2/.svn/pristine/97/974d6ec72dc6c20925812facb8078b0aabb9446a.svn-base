import java.util.Set;

public class PlaceImpl implements Place{
    public Set<Road> toRoads;
    public Set<Road> fromRoads;
    public String name;
    public int x;
    public int y;

    public PlaceImpl(String name, int x, int y){
        this.toRoads=null;
        this.fromRoads=null;
        this.name=name;
        this.x=x;
        this.y=y;
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
        return null;
    }
    @Override
    public void moveBy(int dx, int dy) {
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
        return false;
    }
    @Override
    public boolean isEndPlace() {
        return false;
    }
}
