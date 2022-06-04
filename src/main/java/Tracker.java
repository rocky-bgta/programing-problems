import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tracker {

    Map<String,Integer> mapTracker = new HashMap<>();
    Map<String,Integer> removeTracker = new HashMap<>();
    int track = 0;
    private void allocate(String host){
        List<Integer> removePort = new ArrayList<>();

            if(mapTracker.containsKey(host)) {
                track = mapTracker.get(host);
            } else {
                track = 0;
            }
        ++track;
        mapTracker.put(host, track);

        System.out.println(host +":" +track);
    }

    private void deallocate(String host){
        String hostToRemove;
        for (Map.Entry<String, Integer> entry : mapTracker.entrySet()) {

            for(int i=1; i<= entry.getValue();i++){
                hostToRemove = entry.getKey() + ":" +i;

                if(host.equals(hostToRemove)){
                    mapTracker.put(entry.getKey(),entry.getValue() - i);
                }
            }




        }
    }


    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.allocate("apibox");
        tracker.allocate("apibox");
        tracker.allocate("sitebox");
        tracker.deallocate("apibox:1");
        tracker.allocate("apibox");
    }

}
