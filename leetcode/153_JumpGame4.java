/**
 * BBG>4vru&WH 
 * * * H/R snakes and ladders & fix the model
 */

package jumpgame4;
import java.util.*;

class Solution
{
    public static int minJumps(int[] arr)
    {
        if (arr.length <= 1) return 0;
        
        MultiMap map = new MultiMap();
        Deque<Integer> zipped = new LinkedList<>();
        zipped.add(arr[0]);
        boolean canBeZipped = false;
        
        // zip it
        for (int i = 1; i < arr.length; i++)
        {
            int val = arr[i];
            
            if (val == zipped.getLast())
            {
                if (canBeZipped)
                    zipped.removeLast();
                else
                    canBeZipped = true;
            }
            else
                canBeZipped = false;
            
            zipped.add(val);
        }
        
        // System.out.println(zipped);
        
        int ind = 0;
        arr = new int[zipped.size()];
        for (Integer val : zipped)
        {
            arr[ind] = val;
            map.put(val, ind++);
        }
        
        Queue<Integer> bfs = new LinkedList<>();
        int[] visited = new int[arr.length];
        int[] distance =  new int[arr.length];
        bfs.add(0);
        visited[0] = 1;

        while (!bfs.isEmpty())
        {
            int point = bfs.remove();
//            System.out.println("go to " + point);
            int currLevel = distance[point];
            if (point == arr.length - 1) return currLevel;
            
            currLevel++;
            if (point < arr.length - 1)
                bfsAdd(bfs, visited, distance, currLevel, point + 1);
            
            if (point > 0)
                bfsAdd(bfs, visited, distance, currLevel, point - 1);
            
            ArrayList<Integer> row = map.getRow(arr[point]);
            for (Integer i : row)
                if (i != point) bfsAdd(bfs, visited, distance, currLevel, i);
        }
        
        return -1;
    }

    private static void bfsAdd(Queue<Integer> bfs, int[] visited, int[] distance, int level, int node)
    {
        if (visited[node] == 1) return;
        
        // System.out.println("add node " + node + " level " + level);
        visited[node] = 1;
        bfs.add(node);
        distance[node] = level;
    }
}

public class JumpGame4
{

    public static void main(String[] args)
    {
//        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
//         int[] arr = {7,6,9,6,9,6,9,7};
        int[] arr = {11,22,7,7,7,7,7,7,7,22,13};
        System.out.println(Solution.minJumps(arr));
    }
    
}

