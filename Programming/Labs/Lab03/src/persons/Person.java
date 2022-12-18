package persons;

import bodyParts.Eyes;
import bodyParts.Mouth;

import enums.Emotions;
import locations.Location;

abstract public class Person {
    private final Eyes eyes;
    private final Mouth mouth;
    private final String name;
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(String name) {
        this.eyes = new Eyes();
        this.mouth = new Mouth();
        this.name = name;
    }

    public void setEmotion(Emotions emotion) {
        this.eyes.setEmotion(emotion);
        this.mouth.setEmotion(emotion);
    }

    @Override
    public String toString() {
        return String.format("<Человек по имени %s>", this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.name.equals(person.name);
    }
}
