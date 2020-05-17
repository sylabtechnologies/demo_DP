// https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

package favcompanysubset;
import java.util.*;

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
        {
            TreeSet<Integer> other = new TreeSet<>();
            for (String word : row)
                other.add(index.get(word));
            
            otherFavs.add(new Elem(other, count++));
        }
        
        Collections.sort(otherFavs, new Compare());
//        System.out.println(otherFavs);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < otherFavs.size(); i++)
        {
            Elem row = otherFavs.get(i);
            int currSize = row.set.size();
            
            boolean isSubset = false;
            for (int j = i + 1; j < otherFavs.size(); j++)
            {
                if (j == i) continue;
                
                TreeSet<Integer> cmp = otherFavs.get(j).set;
                if (cmp.size() == currSize) continue;
                
                isSubset = cmp.containsAll(row.set);

                if (isSubset) break;
            }
            
            if (!isSubset) ans.add(row.index);
        }
        
        Collections.sort(ans);
        return ans;
    }

    private static class Elem
    {
        TreeSet<Integer> set;
        int index;
        
        private Elem(TreeSet<Integer> other, int ind)
        {
            this.set = new TreeSet<>(other);
            this.index = ind;
        }

        @Override
        public String toString()
        {
            return "[" + index + " : " + set.toString() + "]";
        }
    }

    private static class Compare implements Comparator<Elem>
    {
        @Override
        public int compare(Elem s1, Elem s2)
        {
            if (s1.set.size() < s2.set.size())
                return -1;
            else if (s1.set.size() > s2.set.size())
                return 1;
            else
                return 0;
        }
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
