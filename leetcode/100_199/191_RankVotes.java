// https://leetcode.com/problems/rank-teams-by-votes/

package rankvotes;
import java.util.*;

class Vote implements Comparable<Vote>
{
    char team;
    int  size;
    int[] vote;

    public Vote(char team, int size)
    {
        this.team = team;
        this.size = size;
        this.vote = new int[size];
    }
    

    @Override
    public int compareTo(Vote o)
    {
        if (size != o.size)
            throw new IllegalArgumentException();
        
        int result = 0;
        for (int i = 0; i < size; i++)
        {
            if (vote[i] != o.vote[i])
            {
                Integer left = new Integer(vote[i]);
                return left.compareTo(o.vote[i]);
            }
            
        }
        
        return (int) - Math.signum(team - o.team);
    }

    @Override
    public String toString()
    {
        return "team=" + team  + ", vote=" + Arrays.toString(vote);
    }

    
}

class Solution
{
    public static String rankTeams(String[] votes)
    {
        char[] teams = votes[0].toCharArray();
        Arrays.sort(teams);
        System.out.println(Arrays.toString(teams));
        
        ArrayList<Vote> res = new ArrayList<>();
        HashMap<Character, Vote> map = new HashMap<>();
        for (char team : teams)
        {
            Vote v = new Vote(team, teams.length);
            res.add(v);
            map.put(team, v);
        }
        
        for (String vote : votes)
        {
            for (int i = 0; i < vote.length(); i++)
            {
                Vote team = map.get(vote.charAt(i));
                team.vote[i]++;
            }
        }
        
        Collections.sort(res);
        
        StringBuilder ans = new StringBuilder();
        for (Vote v : res)
        {
            System.out.println(v);
            ans.append(v.team);
        }

        return ans.reverse().toString();
    }
}

public class RankVotes
{

    public static void main(String[] args)
    {
        // String votes[] = {"ABC","ACB","ABC","ACB","ACB"};
        
        String votes[] = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(Solution.rankTeams(votes));
        
    }
    
}
