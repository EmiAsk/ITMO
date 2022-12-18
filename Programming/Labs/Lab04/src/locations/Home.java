package locations;


import enums.LocationType;
import enums.SpaceState;
import interfaces.OpenedClosed;
import misc.Gate;


public class Home extends Location implements OpenedClosed {
    private Gate gate;
    private SpaceState state = SpaceState.EMPTY;

    public Home(String name) {
        super(name, LocationType.BUILDING);
        this.gate = new Gate();
    }

    public void open() {
        this.gate.open();
    }

    public void close() {
        this.gate.close();
    }

    public void describeState() {
        String describedState = switch (this.state) {
            case EMPTY -> String.format("%s пустует", this);
            case FILLED -> String.format("%s заполнен гостями", this);
            default -> String.format("У %s неопределённое состояние", this);
        };

        System.out.println(describedState);
    }

    public void setState(SpaceState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("<Дом %s>", super.toString());
    }

}