package persons;

import enums.Emotions;
import interfaces.*;

public class Dunno extends Person implements Looking {

    public Dunno() {
        super("Незнайка");
    }

    @Override
    public void lookAt(Object target) {
        System.out.printf("%s увидел: %s %n", this, target);
    }

    public void lookAfter(Object target) {
        System.out.printf("%s смотрел вслед: %s %n", this, target);
    }

    public void lookAround() {
        System.out.printf("%s огляделся %n", this);
    }

    public void upset() {
        this.setEmotion(Emotions.SAD);
        System.out.printf("Глаза у %s стали печальными %n", this);
    }
}
