package bodyParts;

import interfaces.*;
import enums.*;

public class Mouth implements OpenedClosed, Emotional {
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
