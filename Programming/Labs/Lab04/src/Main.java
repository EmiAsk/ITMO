import locations.Home;
import locations.Street;
import misc.Fence;
import persons.Dunno;
import persons.Flower;
import persons.Gunka;
import misc.Travelers;
import persons.Person;


public class Main {

    public static void main(String[] args) {
        Street street = new Street("Цветочная");
        Fence fence = new Fence();

        Flower flower = new Flower();

        Home home = new Home("Путешественников");
        home.describeState();

        Travelers travelers = new Travelers();
        travelers.goHome(home);

        Dunno dunno = new Dunno();

        street.addToLeftSide(dunno);
        street.describe();

        dunno.lookAfter(travelers);
        dunno.lookAround();
        dunno.upset();

        Gunka gunka = new Gunka();

        street.addToRightSideNearbyTo(gunka, fence);
        street.describe();

        gunka.wonder();

        dunno.lookAt(gunka);

        gunka.lookAt(dunno);
    }
}
