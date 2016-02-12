package OpenDoor;

import java.util.*;

public class OpenDoor {

    private static List<Home> homes = new ArrayList<>();

    public Home[] getSimilarHomes(Home home, int n) {

        double latHome = home.getLat();
        double longHome = home.getLon();

        PriorityQueue<Double> minDistanceQueue = new PriorityQueue<>();
        Map<Double, Set<Integer>> distanceIndexMap = new HashMap<>();

        for (int i = 0; i < homes.size(); i++) {

            Home refHome = homes.get(i);

            if(home.dwelling_type == refHome.dwelling_type){

                double dist = distance(latHome, refHome.lat, longHome, refHome.lon);
                minDistanceQueue.offer(dist);

                Set<Integer> indexes = distanceIndexMap.getOrDefault(dist, new HashSet<>());
                indexes.add(i);
                distanceIndexMap.put(dist, indexes);
            }

            if(minDistanceQueue.size() == n){
                break;
            }
        }

        Home[] similarHomes = new Home[n];

        int size = minDistanceQueue.size();

        for (int i = 0; i < size; i++) {

            double dist = minDistanceQueue.poll();

            if(distanceIndexMap.containsKey(dist)) {

                for (int index : distanceIndexMap.get(dist)) {
                    similarHomes[i] = homes.get(index);
                }

                distanceIndexMap.remove(dist);
            }
        }

        return similarHomes;
    }

    private double distance(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 1000;
    }
}
