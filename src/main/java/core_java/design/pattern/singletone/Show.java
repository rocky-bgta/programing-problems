package core_java.design.pattern.singletone;

import java.util.HashSet;
import java.util.Set;
//Singleton Pattern For Available Ticket For Show
public class Show {



    private static final Show INSTANCE =
            new Show();

    public static Show getInstance(){
        return INSTANCE;
    }

    private final Set<String> availableSeats = new HashSet<>();

    private Show(){
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    private boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

    private static void ticketAgentBooks(String seat){
        Show show = Show.getInstance();
        System.out.println(show.bookSeat(seat));
    }

    public static void main(String[] args) {
        ticketAgentBooks("1A");
        ticketAgentBooks("1A");
    }

}
