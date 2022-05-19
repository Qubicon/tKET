package project.entity.event;

import project.entity.common.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Event {

    protected String eventName;
    protected int capacity;
    protected String type;
    protected DateTime dateTime;
    protected double minPrice;

    public Event(String eventName, int capacity, String type, DateTime dateTime, double minPrice) {
        this.eventName = eventName;
        this.capacity = capacity;
        this.type = type;
        this.dateTime = dateTime;
        this.minPrice = minPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public long remainingDays() {
        LocalDate eventDate = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay());
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(currentDate, eventDate);
    }

    public void boughtTicket() {
        if (capacity > 0) {
            capacity--;
        } else {
            System.out.println("There are no more tickets available for this event!");
        }
    }

    @Override
    public String toString() {
        return eventName + " (" + type + ")\n" + "Remaining tickets: " + capacity +
                "\nDate and Time: " + dateTime.toString() + "\nBase Price: " + minPrice + " $";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return capacity == event.capacity && Double.compare(event.minPrice, minPrice) == 0 && Objects.equals(eventName, event.eventName) && Objects.equals(type, event.type) && Objects.equals(dateTime, event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, capacity, type, dateTime, minPrice);
    }
}
