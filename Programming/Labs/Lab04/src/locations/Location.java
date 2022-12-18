package locations;

import enums.LocationType;

import java.util.Objects;

abstract public class Location {
    private final LocationType type;
    private final String name;

    public String getName() {
        return name;
    }

    public Location(String name, LocationType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;

        if (!this.name.equals(location.name)) return false;
        return this.type == location.type;
    }
}
