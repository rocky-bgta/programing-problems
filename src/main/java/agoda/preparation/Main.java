package agoda.preparation;

import java.util.*;

class City {
    int days;
    int cost;

    public City(int days, int cost) {
        this.days = days;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<String, List<City>> cities = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String city = scanner.next();
            int days = scanner.nextInt();
            int cost = scanner.nextInt();
            cities.computeIfAbsent(city, k -> new ArrayList<>()).add(new City(days, cost));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int maxDays = 0, minCost = Integer.MAX_VALUE, totalDays = 0, totalCost = 0;

        for (List<City> trips : cities.values()) {
            trips.sort(Comparator.comparingInt(a -> a.cost));
            int cityCost = trips.get(0).cost;
            totalCost += cityCost;
            totalDays += trips.get(0).days;
            pq.offer(new int[]{trips.get(0).days, 0, cityCost});
        }

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int days = top[0];
            int cityIndex = top[1];
            int cityCost = top[2];
            totalCost += (days - totalDays) * cityCost;
            totalDays = days;

            if (cityIndex + 1 < cities.get(cities.keySet().toArray()[cityIndex]).size()) {
                City nextTrip = cities.get(cities.keySet().toArray()[cityIndex]).get(cityIndex + 1);
                pq.offer(new int[]{days + nextTrip.days, cityIndex + 1, nextTrip.cost});
            }

            int maxDaysPossible = totalDays * pq.size();
            if (maxDaysPossible >= maxDays) {
                if (maxDaysPossible == maxDays) {
                    minCost = Math.min(minCost, totalCost);
                } else {
                    minCost = totalCost;
                }
                maxDays = maxDaysPossible;
            }
        }

        System.out.println(maxDays + " " + minCost);
    }
}
