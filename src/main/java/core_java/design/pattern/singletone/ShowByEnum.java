package core_java.design.pattern.singletone;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public enum ShowByEnum {

    INSTANCE;


    private final Set<String> availableSeats;


    private ShowByEnum(){
        availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

    private static void ticketAgentBooks(String seat){
        ShowByEnum show = ShowByEnum.INSTANCE;
        System.out.println(show.bookSeat(seat));
    }


    public static void main(String[] args) throws NoSuchMethodException {
        ticketAgentBooks("1A");
        ticketAgentBooks("2A");
    }
}
