package ACO15.GIT.src.ua.artcode.classWork.week1.Parking;

/**
 * Created by work on 07.08.2016.
 */
public class Parking {

    private Car[] places;
    private int freePlaceIndex; // default 0

    private Ticket[] tickets;
    private int freeTicketIndex;

    public void build(int placesCount){
    places = new Car[placesCount];
    tickets = new Ticket[1000];
    }

    public Ticket acceptCar(Car car){

    if(freePlaceIndex >= places.length){
    System.out.println("Sorry, No free places");
    return null;
    }

    places[freePlaceIndex] = car;

    Ticket ticket = new Ticket();
    ticket.open(freePlaceIndex);

    freePlaceIndex++;

    ensureCapacity();

    tickets[freeTicketIndex++] = ticket;

    return ticket;
    }


    public Car takeCar(Ticket ticket){

    if(!hasTicket(ticket)){
    System.out.println("No ticket!");
    return null;
    }

    ticket.close();
    long duration = ticket.getDuration();
    double price = duration * 15;
    System.out.println("Where is my " + price + "hrn");

    Car forRet = places[ticket.getPlaceId()];

    // fix problem
    places[ticket.getPlaceId()] = null;

     // Смещение индексов на единицу со смещением всех данных в массиве, последниму елементу присвоение null
    recovery(ticket.getPlaceId());

    return forRet;
    }

    public void recovery (int Index) {

        for (int i = Index; i < places.length; i++){
            if (places[i+1] == null) {
                places[i] = null;
                freePlaceIndex = i;
                break;
            }
        places[i] = places[i + 1];
        }
    }


    private boolean hasTicket(Ticket ticket) {
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i].getNumber() == ticket.getNumber()){
            return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if(freeTicketIndex >= tickets.length){
        Ticket[] newTickets = new Ticket[tickets.length * 2];
        System.arraycopy(tickets,0,newTickets,0,tickets.length);
        tickets = newTickets;
        }
    }


}