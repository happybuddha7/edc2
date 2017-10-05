public class Main {

    public static void main (String args[]){

        Map map = new MapImpl();
        Place place = new PlaceImpl("testplace", 0, 0);

        map.newPlace("test1",100,100);
        for (Place place1 : map.getPlaces()){
            System.out.println(place1.getName()+" , "+ place1.getX()+ " , "+ place1.getY());
        }
        System.out.println(place.getName());

    }
}
