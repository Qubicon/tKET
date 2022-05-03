package project.ioservice;

import project.entity.client.Client;
import project.entity.common.Location;
import project.entity.event.OnlineEvent;
import project.entity.event.PhysicalEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    private static Writer writerInstance = null;

    public static Writer getInstance() {
        if (writerInstance == null) {
            writerInstance = new Writer();
        }
        return writerInstance;
    }

    public void writeLocationsCSV(List<Location> locations) {
        try (FileWriter out = new FileWriter("locations.csv")) {
            for (Location l : locations) {
                out.write(l.getCountry() + "," + l.getCity() + "," + l.getStreetName() + "," + l.getStreetNr() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeClientsCSV(List<Client> clients) {
        try (FileWriter out = new FileWriter("clients.csv")) {
            for (Client c : clients) {
                out.write(c.getName() + "," + c.getSurname() + "," + c.getBirthday().getYear() + "," +
                        c.getBirthday().getMonth() + "," + c.getBirthday().getDay() + "," + c.getAddress().getCountry()
                        + "," + c.getAddress().getCity() + "," + c.getAddress().getStreetName() + "," +
                        c.getAddress().getStreetNr() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeOnlineEventsCSV(List<OnlineEvent> onlineEvents) {
        try (FileWriter out = new FileWriter("onlineEvents.csv")) {
            for (OnlineEvent oe : onlineEvents) {
                out.write(oe.getEventName() + "," + oe.getCapacity() + "," + oe.getType() + "," +
                        oe.getDateTime().getYear() + "," + oe.getDateTime().getMonth() + "," + oe.getDateTime().getDay() +
                        "," + oe.getDateTime().getHour() + "," + oe.getDateTime().getMinutes() + "," +
                        oe.getMinPrice() + "," + oe.getLink() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writePhysicalEventsCSV(List<PhysicalEvent> physicalEvents) {
        try (FileWriter out = new FileWriter("physicalEvents.csv")) {
            for (PhysicalEvent pe : physicalEvents) {
                out.write(pe.getEventName() + "," + pe.getCapacity() + "," + pe.getType() + "," +
                        pe.getDateTime().getYear() + "," + pe.getDateTime().getMonth() + "," + pe.getDateTime().getDay() +
                        "," + pe.getDateTime().getHour() + "," + pe.getDateTime().getMinutes() + "," +
                        pe.getMinPrice() + "," + pe.getLocation().getCountry() + "," + pe.getLocation().getCity() +
                        "," + pe.getLocation().getStreetName() + "," + pe.getLocation().getStreetNr() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
