package project.event;

import project.common.DateTime;

import java.util.Objects;

public class OnlineEvent extends Event {
    private String link;

    public OnlineEvent(String eventName, int capacity, String type, DateTime dateTime, double minPrice, String link) {
        super(eventName, capacity, type, dateTime, minPrice);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLink: " + link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OnlineEvent that = (OnlineEvent) o;
        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), link);
    }
}
