// https://leetcode.com/problems/get-watched-videos-by-your-friends/

package videosbyfriends;
import java.util.*;

class Solution
{
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos, int[][] friends, int id, int level)
    {
        int len = friends.length;
        boolean[] visited = new boolean[len];
        
        // make bfs into l = level
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(id); visited[id] = true;
        
        while (level-- > 0)
        {
            int currSize = bfs.size();
            
            while (currSize-- > 0)
            {
                for (Integer i : friends[bfs.poll()])
                {
                    if (!visited[i])
                    {
                        visited[i] = true;
                        bfs.add(i);
                    }
                    
                }
            }
        }
        
        Map<String, Video> freq = new HashMap<>();

        for (Integer friend : bfs)
        {
            for (String v : watchedVideos.get(friend))
            {
                Video elem = freq.get(v);
                
                if (elem == null)
                    freq.put(v, new Video(v));
                else
                    elem.increment();
            }
        }
        
        ArrayList<Video> res = new ArrayList<>();
        for (Map.Entry<String, Video> elem : freq.entrySet())
            res.add(elem.getValue());
        Collections.sort(res);
        
        ArrayList<String> res2 = new ArrayList<>();
        for (Video v : res)
            res2.add(v.name);

        return res2;
    }    

    public class Video implements Comparable<Video>
    {
        public final String name;
        public int freq;

        public Video(String name)
        {
            this.name = name;
            this.freq = 1;
        }

        public void increment() { freq++;}

        @Override
        public int compareTo(Video v)
        {
            if (this.freq == v.freq)
                return this.name.compareTo(v.name);
            else
            {
                return (this.freq < v.freq) ? -1 : 1;
            }
        }

        @Override
        public String toString() { return "[" + name + ", " + freq + "]";}
    }

}
