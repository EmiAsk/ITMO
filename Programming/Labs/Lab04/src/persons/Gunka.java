package persons;

import enums.Emotions;
import interfaces.*;

public class Gunka extends Person implements Looking {
    public Gunka() {
        super("Маленькая фигурка");
    }

    @Override
    public void lookAt(Object target) {
        System.out.printf("%s глядел на: %s %n ", this, target);
    }

    public void wonder() {
        this.setEmotion(Emotions.OPENED_WIDELY);
        System.out.printf("%s разинул рот и широко открыл глаза %n", this);
    }

    public void scream() {
        this.setEmotion(Emotions.JOY);
        System.out.printf("%s взвизгнул от радости %n", this);
    }

    public void runTo(Object target) {
        System.out.printf("%s побежал к %s %n", this, target);
    }





}
