// https://leetcode.com/problems/get-watched-videos-by-your-friends/

package videosbyfriends;
import java.util.*;

class Solution
{
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
    
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos, int[][] friends, int id, int level)
    {
        if (level < 1) throw new IllegalArgumentException("fix level");
        
        Set<Integer> bfs = new HashSet<>();
        for (int i : friends[id])
            bfs.add(i);
        
        for (int i = 1; i < level; i++)
        {
            ArrayList<Integer> curr = new ArrayList();
            curr.addAll(bfs);
            bfs.clear();
            
            for (Integer n : curr)
            {
                for (Integer f : friends[n])
                    if (f != id) bfs.add(f);
            }
            
            if (bfs.isEmpty()) break;
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
}
