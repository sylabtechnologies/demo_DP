// https://leetcode.com/problems/best-team-with-no-conflicts/submissions/
class Solution
{
    public int bestTeamScore(int[] scores, int[] ages)
    {
        final int len = scores.length;
        if (len == 1) return scores[0];
        
        ArrayList<Player> team = new ArrayList<>();
        for (int i = 0; i < ages.length; i++)
            team.add(new Player(scores[i], ages[i]));
        
        Collections.sort(team);
        int cnt = 0;
        for (Player p : team)
            scores[cnt++] = p.score;
        
        int dp[] = new int[len], max = 0;
        dp[len-1]   = scores[len-1];
        for (int i = len-2; i >= 0; --i)
        {
            int currMax = 0;
            for (int j = i+1; j < len; j++)
            {
                if (scores[j] < scores[i]) continue;
                currMax = Math.max(currMax, dp[j]);
            }
                        
            dp[i] = currMax + scores[i];
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }    
   
    private static class Player implements Comparable<Player>
    {
        int score, age;

        public Player(int score, int age)
        {
            this.score = score;
            this.age = age;
        }
        @Override
        public String toString() { return "(" + score + " @ " + age + ')';}

        @Override
        public int compareTo(Player p2)
        {
            if (this.age != p2.age)
                return Integer.compare(this.age, p2.age);
            else
                return Integer.compare(this.score, p2.score);
        }
    }  
}
