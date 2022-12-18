package misc;

import enums.*;
import interfaces.OpenedClosed;

public class Gate implements OpenedClosed {

    private OpenedClosedState state = OpenedClosedState.CLOSED;

    @Override
    public void open() {
        this.state = OpenedClosedState.OPENED;
    }

    @Override
    public void close() {
        this.state = OpenedClosedState.CLOSED;
    }

    @Override
    public String toString() {
        return "Калитка";
    }
}
