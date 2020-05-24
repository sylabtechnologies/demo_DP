// https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

package favcompanysubset;
import java.util.*;

class Elem implements Comparable<Elem>
{
    public final int index;
    private int data[];
    private int dataLen;

    public Elem(List<String> row, HashMap<String, Integer> index, int i)
    {
        this.index = i;
        
        TreeSet<Integer> set = new TreeSet<>();
        for (String word : row)
            set.add(index.get(word));
        
        dataLen = set.size();
        data = new int[dataLen];
        
        int cnt = 0;
        for (Integer n : set)
            data[cnt++] = n;
    }

    public int size() {       return dataLen; }
    
    boolean isSubsetOf(Elem el)
    {
        if (this.dataLen >= el.dataLen) return false;
        
        int i = 0, j = 0;
        while (i < this.dataLen && j < el.dataLen)
        {
            int el1 = this.data[i];
            int el2 = el.data[j];
            
            if (el1 == el2)
            {
                i++; j++;
            }
            else if (el1 > el2)
                j++;
            else
                return false;
        }
        
        return i == this.dataLen;
    }
    
    @Override
    public String toString()
    {
        return "[" + index + " : " + Arrays.toString(data) + "]";
    }

    @Override
    public int compareTo(Elem s2)
    {
        if (this.size() < s2.size())
            return -1;
        else if (this.size() > s2.size())
            return 1;
        else
            return 0;
    }
}

class Solution
{
    public List<Integer> peopleIndexes(List<List<String>> favs)
    {
        HashMap<String, Integer> index = new HashMap<>();
        int count = 0;
        for (List<String> row : favs)
        {
            for (String word : row)
            {
                if (index.containsKey(word)) continue;
                index.put(word, count++);
            }
        }
        
        ArrayList<Elem> otherFavs = new ArrayList<>();
        count = 0;
        for (List<String> row : favs)
            otherFavs.add(new Elem(row, index, count++));
        Collections.sort(otherFavs);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < otherFavs.size(); i++)
        {
            boolean isSubset = false;
            Elem set1 = otherFavs.get(i);
            
            for (int j = i + 1; j < otherFavs.size(); j++)
            {
                if (j == i) continue;
                
                Elem set2 = otherFavs.get(j);
                if (set1.isSubsetOf(set2))
                {
                    isSubset = true; break;
                }
            }
            
            if (!isSubset) ans.add(set1.index);
        }
        
        Collections.sort(ans);
        return ans;
    }
}

public class FavCompanySubset
{
    public static void main(String[] args)
    {
        List<List<String>> favs = new ArrayList<>();
        favs.add(Arrays.asList("leetcode","google","facebook"));
        favs.add(Arrays.asList("google","microsoft"));
        favs.add(Arrays.asList("google","facebook"));
        favs.add(Arrays.asList("google"));
        favs.add(Arrays.asList("amazon"));
        
        System.out.println(new Solution().peopleIndexes(favs));
    }
    
}