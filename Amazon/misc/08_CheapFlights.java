package cheapflights;
import java.util.*;

//// #DD ONLY Djikstra1 w/ MinHeap and restrictions + ###D7^7

class Solution
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int maxStops)
    {
        Graph g = new Graph(n);
        for (int[] flight : flights)
            g.addEdge(flight[0], flight[1], flight[2]);

        int best = Integer.MAX_VALUE;
        int cheapest[]    = new int[n];
        Arrays.fill(cheapest, Integer.MAX_VALUE);
        
        LinkedList<Weight> queue = new LinkedList<>();
        
        queue.add(new Weight(src, 0));
        while (!queue.isEmpty())
        {
            Weight curr = queue.poll();
            
            if (curr.myStops > maxStops + 1) continue;
            if (curr.totalPrice > cheapest[curr.node]) continue;
            
            cheapest[curr.node] = curr.totalPrice;
            if (curr.node == dst)
                best = Math.min(best, curr.totalPrice);

            for (Weight flight : g.getAdjacency(curr.node))
            {
                Weight update = new Weight(flight.node, flight.totalPrice + curr.totalPrice);
                update.myStops = curr.myStops + 1;
                queue.add(update);
            }
            
//            System.out.println("from " + curr.node + " : " + queue);
        }

        return (best != Integer.MAX_VALUE) ? best : -1;
    }
}

public class CheapFlights
{
    public static void main(String[] args)
    {
//        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
//        int[][] edges = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},
//                    {7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},
//                    {4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},
//                    {1,9,1},{7,8,10},{0,4,2},{7,2,8}};
//        int[][] edges = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        int[][] edges = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        Solution sl = new Solution();
        System.out.println(sl.findCheapestPrice(4, edges, 0, 3, 1));
        
    }
    
}

