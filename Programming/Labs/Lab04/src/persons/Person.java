package persons;

import enums.Emotions;
import enums.OpenedClosedState;
import exceptions.NameUndefinedException;
import interfaces.Droppable;
import interfaces.Emotional;
import interfaces.OpenedClosed;
import locations.Location;

import java.util.Random;

public class Person implements Emotional {
    private final Eyes eyes;
    private final Mouth mouth;
    private final String name;
    private Location location;

    private class Mouth implements OpenedClosed, Emotional {
        private OpenedClosedState state = OpenedClosedState.CLOSED;
        private Emotions emotion = Emotions.NONE;

        @Override
        public void open() {
            this.state = OpenedClosedState.OPENED;
        }

        @Override
        public void close() {
            this.state = OpenedClosedState.CLOSED;
        }

        @Override
        public void setEmotion(Emotions emotion) {
            this.emotion = emotion;
        }

        @Override
        public String toString() {
            return "Рот";
        }
    }

    private class Eyes implements OpenedClosed, Emotional {
        private OpenedClosedState state = OpenedClosedState.OPENED;
        private Emotions emotion = Emotions.NONE;

        public void cry() {
            Random rnd = new Random();
            int tearsNumber = rnd.nextInt(1, 4);

            for (int i = 0; i < tearsNumber; i++) {
                Droppable tear = new Droppable() {
                    @Override
                    public void drop() {
                        System.out.printf("%s делает Плак :(", Person.this);
                    }
                };
                tear.drop();
            }
        }

        @Override
        public void open() {
            this.state = OpenedClosedState.OPENED;
        }

        @Override
        public void close() {
            this.state = OpenedClosedState.CLOSED;
        }

        @Override
        public void setEmotion(Emotions emotion) {
            this.emotion = emotion;
        }

        @Override
        public String toString() {
            return "Глаза";
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(String name) throws NameUndefinedException {
        this.eyes = new Eyes();
        this.mouth = new Mouth();

        if (name == null) throw
        this.name = name;

    }

    public void setEmotion(Emotions emotion) {
        this.eyes.setEmotion(emotion);
        this.mouth.setEmotion(emotion);
    }

    public static void hug(Person... persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = i + 1; j < persons.length; j++) {
                System.out.printf("%s и %s обнялись", persons[i], persons[j]);
            }
        }
    }

    public void cry() {
        System.out.printf("%s заплакал", this);
        this.eyes.cry();
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
