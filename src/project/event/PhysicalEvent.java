package project.event;

import project.common.DateTime;
import project.common.Location;

import java.util.Objects;

public class PhysicalEvent extends Event {
    private Location location;

    public PhysicalEvent(String eventName, int capacity, String type, DateTime dateTime, double minPrice, Location location) {
        super(eventName, capacity, type, dateTime, minPrice);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLocation: " + location.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhysicalEvent that = (PhysicalEvent) o;
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }
}
