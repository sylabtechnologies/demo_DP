// https://leetcode.com/problems/design-underground-system/

package underground;
import java.util.*;

class UndergroundSystem
{
    int numStations;
    HashMap<String, Integer>  stations;
    HashMap<Integer, Trip> customerTrips;
    HashMap<Long, TripStats> stats;
    
    public UndergroundSystem()
    {
        customerTrips = new HashMap<>();
        stations = new HashMap<>();
        numStations = 0;
        stats = new HashMap<>();
    }
    
    private int addStation(String stationName)
    {
        numStations++;
        stations.put(stationName, numStations);
        return numStations;
    }

    
    public void checkIn(int id, String stationName, int t)
    {
        Integer statId = stations.get(stationName);
        
        if (statId == null)
            statId = addStation(stationName);;
        
        Trip trp = new Trip(statId, t);
        customerTrips.put(id, trp);
    }
    
    public void checkOut(int id, String stationName, int t)
    {
        Trip tr = customerTrips.get(id);
        
        if (tr == null)
            throw new IllegalArgumentException("trip");
        
        int time = t - tr.startTime;

        Integer end = stations.get(stationName);
        if (end == null)
            end = addStation(stationName);

        long tripcode = getTripCode(tr.startId, end);
        
        TripStats stat = stats.get(tripcode);
        if (stat == null)
        {
            stat = new TripStats();
            stats.put(tripcode, stat);
        }

        stat.totalTime += t - tr.startTime;
        stat.numTrips += 1;
        
        customerTrips.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation)
    {
        int start = stations.get(startStation);
        int end = stations.get(endStation);
        long tripcode = getTripCode(start, end);
        TripStats stat = stats.get(tripcode);
        double count = stat.numTrips;
        return stat.totalTime/count;
    }

    class Trip
    {
        int startId;
        int startTime;

        public Trip(int startStation, int time)
        {
            this.startId = startStation;
            this.startTime = time;
        }
    }

    class TripStats
    {
        int  numTrips;
        long totalTime;

        public TripStats()
        {
            this.numTrips = 0;
            this.totalTime = 0;
        }

    }
    
    private static long getTripCode(int start, int end)
    {
        long ans = start * 10000;
        ans += end;
        return ans;
    }

}

