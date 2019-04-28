// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

package solution;

import java.io.*;
import java.util.*;
import java.util.Map;

public class Solution
{
    private static Map<Integer, Integer> rank = new HashMap<>();
    private static Integer currentMaxRank = 1;
    private static Integer currentMax = 0;
    
    // emulate the scores w/ hash map ranking
    // for next version = sort scores, sort alice
    // and iterate only one time of alice over scores keeping alice updated rank
    static int[] climbingLeaderboard(int[] scores, int[] alice)
    {
        rank = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        rank.put(scores[0], currentMaxRank);
        currentMax = scores[0];
        
        for (int i = 1; i < scores.length; i++)
        {
            if (rank.containsKey(scores[i]))
                continue;

            if (scores[i] > currentMax)
            {
                rank.put(scores[i], ++currentMaxRank);
                currentMax = scores[i];
                continue;
            }
        
            insertUpdateScore(scores[i]);
            
        }

        for (Map.Entry<Integer, Integer> entry : rank.entrySet())
        {
            System.out.println(entry.toString());
        }

        // process alice
        for (int i = 0; i < alice.length; i++)
        {
            if (!rank.containsKey(alice[i]))
                insertUpdateScore(alice[i]);
            
            result.add(rank.get(alice[i]));
        }

        for (Map.Entry<Integer, Integer> entry : rank.entrySet())
        {
            System.out.println(entry.toString());
        }

        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            resArray[i] = result.get(i);
        
        return resArray;

    }

    private static void insertUpdateScore(Integer score)
    {
        int below = 0;
        
        for (Map.Entry<Integer, Integer> entry : rank.entrySet())
        {
            if (entry.getKey() < score)
            {
                entry.setValue(entry.getValue() + 1);
                below++;
                continue;
            }
            
        }
        
        ++currentMaxRank;
        
        rank.put(score, currentMaxRank - below);
     
    }
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        int n = scanner.nextInt();
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            scores[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] alice = new int[m];
        
        for (int i = 0; i < m; i++)
        {
            alice[i] = scanner.nextInt();
        }
        
        int[] res = climbingLeaderboard(scores, alice);
        
        scanner.close();
        
        for (int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }

}
