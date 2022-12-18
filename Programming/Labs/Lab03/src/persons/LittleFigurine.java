package persons;

import enums.Emotions;
import locations.*;
import interfaces.*;

public class LittleFigurine extends Person implements Looking {
    public LittleFigurine() {
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
}
