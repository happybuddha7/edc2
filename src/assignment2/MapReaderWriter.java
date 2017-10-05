import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class MapReaderWriter implements MapIo {
    private Map map;


    public MapReaderWriter() {
    }

    //This class handles reading and writing map representations as
    //described in the practical specification

    //Read the description of a map from the
    //Reader r, and transfers it to Map, m.
    @Override
    public void read(Reader r, Map m) throws IOException, MapFormatException {
    
    }

    //Write a representation of the Map, m, to the Writer w.
    @Override
    public void write(Writer w, Map m) throws IOException {
        for (Place place: m.getPlaces()){
        w.write("place "+place.getName()+" "+ place.getX()+ " "+place.getY());
            w.write(System.getProperty( "line.separator" ));
         }

        for (Road road: m.getRoads()){
            w.write("road "+road.firstPlace()+ " "+road.roadName()+" "+ road.length()+" "+ road.secondPlace());
            w.write(System.getProperty( "line.separator" ));
            //road firstPlace roadName length secondPlace
        }

        if (m.getStartPlace()!=null){
            w.write("start"+m.getStartPlace().getName());
        }
        w.write(System.getProperty( "line.separator" ));
        if (m.getEndPlace()!=null){
            w.write("start"+m.getEndPlace().getName());
        }
    w.close();

    }
}
