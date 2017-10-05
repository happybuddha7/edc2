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
public class test
{
    // arguments are passed using the text field below this editor
    // you can add other public classes to this editor in any order


    public static void main(String[] args) throws IOException {
    Map map1 = new MapImpl();
    map1.newPlace("test place", 100 , 100 );
    map1.newPlace("Another test", 200 , 600 );
    for (Place place : map1.getPlaces()){
        System.out.println(place.getName()+ " , "+place.getX()+" , "+place.getY());
    }
    System.out.print(map1.toString());

        Writer writer= null;

            writer = new BufferedWriter(new FileWriter("C:\\Users\\Tofu\\Documents\\EDC\\edc2\\src\\assignment2\\output.txt"));


        MapReaderWriter mapReaderWriter=new MapReaderWriter();

            mapReaderWriter.write(writer,map1);

    }
}

