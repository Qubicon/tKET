package project.client;

import project.common.*;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Client implements Comparable<Client>{
    private String name;
    private String surname;
    private Date birthday;
    private Set<Ticket> tickets;
    private Location address;

    public Client(String name, String surname, Date birthday, Location address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.tickets = new TreeSet<>();
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Location getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setAddress(Location address) {
        this.address = address;
    }


    @Override
    public String toString() {
        String showClient = name + " " + surname + " " + birthday + "\nAddress: " + address + "\n";
        showClient += "Tickets bought: ";
        if (tickets.size() == 0){
            showClient += "No tickets bought yet";
        }
        else {
            showClient += "\n----------------------------------------\n";
            for (Ticket ticket : tickets) {
                showClient += ticket.toString() + "\n";
            }
        }
        return showClient;
    }

    @Override
    public int compareTo(Client o) {
        if (this.surname.equals(o.surname)){
            return this.name.compareTo(o.name);
        }
        else {
            return this.surname.compareTo(o.surname);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(birthday, client.birthday) && Objects.equals(tickets, client.tickets) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday, tickets, address);
    }
}

