package project;

import project.common.*;
import project.event.*;
import project.client.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PlatformService service = new PlatformService();

        List<Location> locations = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<OnlineEvent> onlineEvents = new ArrayList<>();
        List<PhysicalEvent> physicalEvents = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt();
        while (true){

            switch (option) {
                case 0:
                    return;
                case 1:
                    service.display(locations);
                    break;
                case 2:
                    service.display(clients);
                    break;
                case 3:
                    service.display(onlineEvents);
                    break;
                case 4:
                    service.display(physicalEvents);
                    break;
                case 5:
                    locations.add(service.generateLocation());
                    break;
                case 6:
                    clients.add(service.generatePerson());
                    break;
                case 7:
                    onlineEvents.add((OnlineEvent) service.generateEvent(true));
                    break;
                case 8:
                    physicalEvents.add((PhysicalEvent) service.generateEvent(false));
                    break;
                case 9:
                    service.display(service.filter(new ClientAgeFilter(), clients, 18L));
                    break;
                case 10:
                    System.out.println("Enter event type (concert, movie, sport, fashion, theatre, gaming, art)");
                    String type = scanner.next();
                    service.display(service.filter(new EventTypeFilter(), service.combineEvents(onlineEvents, physicalEvents), type));
                    break;
                case 11:
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int index = scanner.nextInt();
                    System.out.println(service.age(clients.get(index)));
                    break;
                case 12:
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int ind = scanner.nextInt();
                    System.out.println(service.totalMoneySpent(clients.get(ind)));
                    break;
                case 13:
                    service.sortClientsAge(clients);
                    service.display(clients);
                    break;
                case 14:
                    service.sortClientsNrTickets(clients);
                    service.display(clients);
                    break;
                case 15:
                    service.sortClientsNrTicketsAge(clients);
                    service.display(clients);
                    break;
                case 16:
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int clientIndex = scanner.nextInt();
                    Event event = service.chooseEvent(onlineEvents, physicalEvents);
                    System.out.println("Select ticket type (GENERAL, EARLY, VIP):");
                    String ticketType = scanner.next();
                    service.buyTicket(clients.get(clientIndex), event, ticketType);
                    break;
                case 17:
                    Event chosenEvent = service.chooseEvent(onlineEvents, physicalEvents);
                    System.out.println(service.remainingDays(chosenEvent));
                    break;
                case 18:
                    service.listLocations(locations);
                    System.out.println("Select location index:");
                    int locationIndex = scanner.nextInt();
                    service.remove(locations, locationIndex);
                    break;
                case 19:
                    service.listClients(clients);
                    System.out.println("Select client index:");
                    int clIndex = scanner.nextInt();
                    service.remove(clients, clIndex);
                    break;
                case 20:
                    service.listOnlineEvents(onlineEvents);
                    System.out.println("Select event index:");
                    int oeIndex = scanner.nextInt();
                    service.remove(onlineEvents, oeIndex);
                    break;
                case 21:
                    service.listPhysicalEvents(physicalEvents);
                    System.out.println("Select event index:");
                    int peIndex = scanner.nextInt();
                    service.remove(physicalEvents, peIndex);
                    break;
                default:
                    System.out.println("Incorrect option! Number must be between 0 and 21");

            }

            showMenu();
            option = scanner.nextInt();

        }

    }

    private static void showMenu(){
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
