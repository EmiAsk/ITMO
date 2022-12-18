package misc;

import enums.SpaceState;
import locations.Location;
import locations.Home;
import persons.Person;

import java.util.List;
import java.util.HashSet;

public class Travelers {
    private final HashSet<Person> persons;

    public Travelers(Person... persons) {
        this.persons = new HashSet<Person>(List.of(persons));
    }

    public void goTo(Location location) {
        for (Person person : this.persons) {
            person.setLocation(location);
        }
        System.out.printf("%s ушли в: %s %n", this, location);
    }

    public void goHome(Home home) {
        home.open();
        this.goTo(home);
        home.close();
        home.setState(SpaceState.FILLED);
    }

    @Override
    public String toString() {
        return "<Путешественники>";
    }

    @Override
    public int hashCode() {
        return this.persons.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travelers travelers = (Travelers) o;
        return this.persons.equals(travelers.persons);
    }
}
