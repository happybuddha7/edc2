import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class MapReaderWriter implements MapIo {
    private Map map;



    @Override
    public void read(Reader r, Map m) throws IOException, MapFormatException {
    
    }

    @Override
    public void write(Writer w, Map m) throws IOException {
        for (Place place: m.getPlaces()){
        w.write("place "+place.getName(), place.getX(), place.getY());
         }
        w.write("/n");
        for (Road road: m.getRoads()){
            w.write("road "+road.firstPlace()+ " "+road.roadName()+" "+ road.length()+" "+ road.secondPlace());
                //road firstPlace roadName length secondPlace
        }

    w.close();

    }
}
