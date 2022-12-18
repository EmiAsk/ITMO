package locations;

import enums.LocationType;
import persons.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Street extends Location {

    /* arrangement - описание позиционирования предметов, находящихся рядом друг с другом (предмет - предмет)
     * leftSidePeople - список людей, находящихся на левой стороне
     * rightSidePeople - список людей, находящихся на правой стороне
     * */

    private final Map<Person, Object> arrangement = new HashMap<Person, Object>(); // нарушение DIP
    private final ArrayList<Person> leftSidePeople = new ArrayList<Person>();
    private final ArrayList<Person> rightSidePeople = new ArrayList<Person>();

    public Street(String name) {
        // this.arrangement = arrangement;
        super(name, LocationType.STREET);
    }

    // Поместить человека на левую сторону улицы рядом с объектом
    public void addToLeftSideNearbyTo(Person person, Object neighbour) {
        if (neighbour != null) this.arrangement.put(person, neighbour);
        this.leftSidePeople.add(person);
        person.setLocation(this);
    }

    // Поместить человека на правую сторону улицы рядом с объектом
    public void addToRightSideNearbyTo(Person person, Object neighbour) {
        if (neighbour != null) this.arrangement.put(person, neighbour);
        this.rightSidePeople.add(person);
        person.setLocation(this);
    }

    // Поместить человека на левую сторону улицы
    public void addToLeftSide(Person person) {
        this.addToLeftSideNearbyTo(person, null);
    }

    // Поместить человека на правую сторону улицы
    public void addToRightSide(Person person) {
        this.addToLeftSideNearbyTo(person, null);
    }

    // Описать содержимое улицы
    public void describe() {

        if ((leftSidePeople.size() + leftSidePeople.size()) == 0) {
            System.out.printf("%s пустует %n", this);
            return;
        }
        System.out.printf("На %s остались:\n", this);

        describePersons(leftSidePeople);
        describePersons(rightSidePeople);
    }

    // Описать расположение людей на улице
    public void describePersons(ArrayList<Person> persons) {
        if (persons.size() == 0) return;

        for (Person person : persons) {
            Object place = arrangement.get(person);
            System.out.printf("- %s%s%n", person, place == null ? "" : " около: " + place);
        }
    }

    @Override
    public String toString() {
        return String.format("<Улица %s>", super.toString());
    }
}