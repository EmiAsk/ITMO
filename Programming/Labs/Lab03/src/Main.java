import locations.Home;
import locations.Street;
import misc.Fence;
import persons.Dunno;
import persons.Flower;
import persons.LittleFigurine;
import misc.Travelers;


public class Main {

    public static void main(String[] args) {
        Street street = new Street("Цветочная");
        Fence fence = new Fence();

        Flower flower = new Flower();

        Home home = new Home("Путешественников");
        home.describeState();

        Travelers travelers = new Travelers(flower);
        travelers.goHome(home);

        Dunno dunno = new Dunno();

        street.addToLeftSide(dunno);
        street.describe();

        dunno.lookAfter(travelers);
        dunno.lookAround();
        dunno.upset();

        LittleFigurine figurine = new LittleFigurine();

        street.addToRightSideNearbyTo(figurine, fence);
        street.describe();

        figurine.wonder();

        dunno.lookAt(figurine);

        figurine.lookAt(dunno);
    }
}
