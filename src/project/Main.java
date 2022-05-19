package project;

import project.entity.common.*;
import project.entity.event.*;
import project.entity.client.*;


import java.util.List;
import java.util.Scanner;

import project.ioservice.*;


public class Main {
    public static void main(String[] args) {
        PlatformService service = new PlatformService();
        Logger logger = Logger.getInstance();

        Reader reader = Reader.getInstance();
        List<Location> locations = reader.readLocationsCSV();
        List<Client> clients = reader.readClientsCSV();
        List<OnlineEvent> onlineEvents = reader.readOnlineEventsCSV();
        List<PhysicalEvent> physicalEvents = reader.readPhysicalEventsCSV();


        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt();
        while (true) {

            switch (option) {
                case 0 -> {
                    Writer writer = Writer.getInstance();
                    writer.writeLocationsCSV(locations);
                    writer.writeClientsCSV(clients);
                    writer.writeOnlineEventsCSV(onlineEvents);
                    writer.writePhysicalEventsCSV(physicalEvents);
                    logger.close();
                    return;
                }
                case 1 -> {
                    service.display(locations);
                    logger.write("Show locations");
                }
                case 2 -> {
                    service.display(clients);
                    logger.write("Show clients");
                }
                case 3 -> {
                    service.display(onlineEvents);
                    logger.write("Show Online Events");
                }
                case 4 -> {
                    service.display(physicalEvents);
                    logger.write("Show Physical Events");
                }
                case 5 -> {
                    locations.add(service.generateLocation());
                    logger.write("Add location");
                }
                case 6 -> {
                    clients.add(service.generatePerson());
                    logger.write("Add client");
                }
                case 7 -> {
                    onlineEvents.add((OnlineEvent) service.generateEvent(true));
                    logger.write("Add Online Event");
                }
                case 8 -> {
                    physicalEvents.add((PhysicalEvent) service.generateEvent(false));
                    logger.write("Add Physical Event");
                }
                case 9 -> {
                    service.display(service.filter(new ClientAgeFilter(), clients, 18L));
                    logger.write("Show overage clients");
                }
                case 10 -> {
                    System.out.println("Enter event type (concert, movie, sport, fashion, theatre, gaming, art)");
                    String type = scanner.next();
                    service.display(service.filter(new EventTypeFilter(), service.combineEvents(onlineEvents, physicalEvents), type));
                    logger.write("Filter events by type");
                }
                case 11 -> {
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int index = scanner.nextInt();
                    System.out.println(service.age(clients.get(index)));
                    logger.write("Show age of client");
                }
                case 12 -> {
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int ind = scanner.nextInt();
                    System.out.println(service.totalMoneySpent(clients.get(ind)));
                    logger.write("Calculate total amount of money spent by client");
                }
                case 13 -> {
                    service.sortClientsAge(clients);
                    service.display(clients);
                    logger.write("Sort clients by age descending");
                }
                case 14 -> {
                    service.sortClientsNrTickets(clients);
                    service.display(clients);
                    logger.write("Sort clients by number of tickets bought descending");
                }
                case 15 -> {
                    service.sortClientsNrTicketsAge(clients);
                    service.display(clients);
                    logger.write("Sort clients by number of tickets descending and by age descending");
                }
                case 16 -> {
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int clientIndex = scanner.nextInt();
                    Event event = service.chooseEvent(onlineEvents, physicalEvents);
                    System.out.println("Select ticket type (GENERAL, EARLY, VIP):");
                    String ticketType = scanner.next();
                    service.buyTicket(clients.get(clientIndex), event, ticketType);
                    logger.write("Buy ticket selecting client and event");
                }
                case 17 -> {
                    Event chosenEvent = service.chooseEvent(onlineEvents, physicalEvents);
                    System.out.println(service.remainingDays(chosenEvent));
                    logger.write("Days left until event");
                }
                case 18 -> {
                    service.listLocations(locations);
                    System.out.println("Select location index:");
                    int locationIndex = scanner.nextInt();
                    service.remove(locations, locationIndex);
                    logger.write("Remove location");
                }
                case 19 -> {
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int clIndex = scanner.nextInt();
                    service.remove(clients, clIndex);
                    logger.write("Remove client");
                }
                case 20 -> {
                    service.listOnlineEvents(onlineEvents);
                    System.out.println("Select event index:");
                    int oeIndex = scanner.nextInt();
                    service.remove(onlineEvents, oeIndex);
                    logger.write("Remove Online Event");
                }
                case 21 -> {
                    service.listPhysicalEvents(physicalEvents);
                    System.out.println("Select event index:");
                    int peIndex = scanner.nextInt();
                    service.remove(physicalEvents, peIndex);
                    logger.write("Remove Physical Event");
                }
                default -> System.out.println("Incorrect option! Number must be between 0 and 21");
            }

            showMenu();
            option = scanner.nextInt();

        }

    }

    private static void showMenu() {
        System.out.println("""
                Menu:
                0) Exit
                1) Show Locations
                2) Show Clients
                3) Show Online Events
                4) Show Physical Events
                5) Add a location
                6) Add a client
                7) Add an online event
                8) Add a physical event
                9) Show overage clients
                10) Filter events by type
                11) Show age of client
                12) Calculate total amount of money spent by client
                13) Sort clients by age descending
                14) Sort clients by number of tickets bought descending
                15) Sort clients by number of tickets descending and by age descending
                16) Buy ticket selecting client and event
                17) Days left until event
                18) Remove location
                19) Remove client
                20) Remove online event
                21) Remove physical event
                """);
    }
}
