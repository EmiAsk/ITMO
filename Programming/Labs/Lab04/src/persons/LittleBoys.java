package persons;

import locations.Home;
import locations.Location;

public class LittleBoys {
    private Person personOnHands;
    private Location location;

    @Override
    public String toString() {
        return "<Малыши>";
    }

    public void pickUpPerson(Person person) {
        this.personOnHands = person;
        System.out.printf("%s взяли на руки %s %n", this, person);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void goTo(Location location) {
        this.personOnHands.setLocation(location);
        this.setLocation(location);

        System.out.println("%s ушли в %s %n");
    }

    public void goHome(Home home) {
        this.goTo(home);
    }

}
