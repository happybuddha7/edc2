//*******************************************************************
// Dear CompileJava users,
//
// CompileJava has been operating since 2013 completely free. If you
// find this site useful, or would otherwise like to contribute, then
// please consider a donation (link in 'More Info' tab) to support
// development of the new CompileJava website (stay tuned!).
//
// Most sincerely, Z.
//*******************************************************************

import java.io.*;
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class test {
    // arguments are passed using the text field below this editor
    // you can add other public classes to this editor in any order


    public static void main(String[] args) throws IOException {
        Map map1 = new MapImpl();
        Place here = map1.newPlace("testPlace", 100, 100);
        Place there = map1.newPlace("AnotherTest", 200, 600);
        map1.newRoad(here, there, "route66", 666);

        System.out.println("Test Places:.....");
        for (Place place : map1.getPlaces()) {
            System.out.println(place.toString());
            System.out.println("Test Roads in " + place.getName());
            for (Road road : place.toRoads()) {
                System.out.println(road.toString());
            }
        }
        System.out.println("Test Roads:.....");
        for (Road road : map1.getRoads()) {
            System.out.println(road.toString());
        }
        System.out.println("Test Map:....");
        System.out.print(map1.toString());
        Writer writer = null;
        writer = new BufferedWriter(new FileWriter("C:\\Users\\Tofu\\Documents\\EDC\\edc2\\src\\assignment2\\output.txt"));
        MapReaderWriter mapReaderWriter = new MapReaderWriter();
        mapReaderWriter.write(writer, map1);
        System.out.println("Test reader:.....");
        writer.close();

        Reader reader = null;
        reader = new BufferedReader((new FileReader("C:\\Users\\Tofu\\Documents\\EDC\\edc2\\src\\assignment2\\exampleMap.map")));
        Map map2 = new MapImpl();
        try {
            mapReaderWriter.read(reader, map2);
        } catch (MapFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Test Map for reader:.....");
        System.out.print(map2.toString());
        /*for (Place place : map2.getPlaces()) {
            System.out.println(place.toString());
            System.out.println("Test Roads in " + place.getName());
            for (Road road : place.toRoads()) {
                System.out.println(road.toString());
            }
        }*/
        reader.close();
    }
}