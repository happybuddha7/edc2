import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;

public class MapReaderWriter implements MapIo {
    private Map map;
    public MapReaderWriter() {
    }
    //This class handles reading and writing map representations as
    //described in the practical specification
    public void scanLine (String line, Map m)throws MapFormatException{
        Scanner scanner = new Scanner(line);
        if (scanner.hasNext()){
            //System.out.println(scanner.next());
            String type = scanner.next();
           // System.out.println("Type: "+type);
            //assumes the line has a certain structure
            if (type.equals("place")){
                String place1 = scanner.next();
             //   System.out.println("place1: "+place1);
                String xPos = scanner.next();
                int xInt = Integer.parseInt(xPos);
                String yPos = scanner.next();
                int yInt = Integer.parseInt(yPos);
                m.newPlace(place1, xInt, yInt);
            }
            else if(type.equals("road")){
                String place1=scanner.next();
               // System.out.println("place1: "+place1);
                String roadName=scanner.next();
                String roadLength=scanner.next();
                int lengthInt = Integer.parseInt(roadLength);
                String place2=scanner.next();
                Place firstPlace = null;
                Place secondPlace = null;
                for (Place place:m.getPlaces()){
                    if (place.getName().equals(place1)){
                     firstPlace=place;
                     break;
                    }
                }
                for (Place place:m.getPlaces()){
                    if (place.getName().equals(place2)){
                        secondPlace=place;
                        break;
                    }
                }
                m.newRoad(firstPlace, secondPlace, roadName, lengthInt);
            }
            else if (type.equals("start")){
                String startPlaceString = scanner.next();
                Place startPlace=null;
                for (Place place:m.getPlaces()){
                    if (place.getName().equals(startPlaceString)){
                        startPlace=place;
                        break;
                    }
                }
                m.setStartPlace(startPlace);
            }
            else if (type.equals("end")){
                String endPlaceString = scanner.next();
                Place endPlace=null;
                for (Place place:m.getPlaces()){
                    if (place.getName().equals(endPlaceString)){
                        endPlace=place;
                        break;
                    }
                }
                m.setEndPlace(endPlace);
            }
        }
        else {
            System.out.println("end of file");
        }
        scanner.close();
    }
    //Read the description of a map from the
    //Reader r, and transfers it to Map, m.
    @Override
    public void read(Reader r, Map m) throws IOException, MapFormatException {
        BufferedReader br = new BufferedReader(r);
        String line="";
        StringBuffer mapString;
        String word;
        while(line!=null) {
            line = br.readLine();
            if(line!=null){scanLine(line, m);}
        }
    }
    //Write a representation of the Map, m, to the Writer w.
    @Override
    public void write(Writer w, Map m) throws IOException {
        for (Place place: m.getPlaces()){
            w.write("place "+place.getName()+" "+ place.getX()+ " "+place.getY());
            w.write(System.getProperty( "line.separator" ));
            System.out.println("writing place:"+place.getName()+" "+ place.getX()+ " "+place.getY());
         }
        w.write(System.getProperty( "line.separator" ));
        for (Road road: m.getRoads()){
            w.write("road "+road.firstPlace().getName()+ " "+road.roadName()+" "+ road.length()+" "+ road.secondPlace().getName());
            w.write(System.getProperty( "line.separator" ));
            //road firstPlace roadName length secondPlace
        }
        if (m.getStartPlace()!=null){
            w.write("start"+m.getStartPlace().getName());
        }
        w.write(System.getProperty( "line.separator" ));
        if (m.getEndPlace()!=null){
            w.write("end"+m.getEndPlace().getName());
        }
        w.write(System.getProperty( "line.separator" ));
    }
}
