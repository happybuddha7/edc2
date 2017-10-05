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
        w.write(place.getName(), place.getX(), place.getY());
    }

    w.close();

    }
}
