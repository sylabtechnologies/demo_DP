// https://leetcode.com/problems/next-closest-time/
class Solution
{
    private int myNext      = Integer.MAX_VALUE;
    private int myMinmins   = Integer.MAX_VALUE;
    private int myMinutes;
    
    public String nextClosestTime(String time)
    {
        TreeSet<Integer> digits = new TreeSet<>();
        for (char c : time.toCharArray())
        {
            if (c != ':') digits.add(c - '0');            
        }
        
        if (digits.size() == 1) return time;
        
        int stamp = Integer.parseInt(time.substring(0,2) + time.substring(3));
        myMinutes = getMinutes(stamp);
        
        dfs(digits, 0, 0);
        
        int ret = (myNext < 1_000_000) ? myNext : myMinmins;
        return String.format("%02d:%02d", ret / 60, ret % 60);
    }

    private void dfs(TreeSet<Integer> digits, int level, int tmp)
    {
        if (level == 4)
        {
            int tm = getMinutes(tmp);
            if (tm > 0)
            {
                if (tm > myMinutes)
                    myNext = Math.min(myNext, tm);
                else
                    myMinmins = Math.min(myMinmins, tm);
            }
            
            return;
        }
        for (Integer dg : digits)
        {
            tmp *= 10;
            tmp += dg;
            dfs(digits, level + 1, tmp);
            tmp /= 10;
        }
    }

    private int getMinutes(int stamp)
    {
        int mm = stamp % 100;
        int hh = stamp / 100;
        if (mm > 59) return -1;
        if (hh > 23) return -1;
        return hh*60 + mm;
    }
}
