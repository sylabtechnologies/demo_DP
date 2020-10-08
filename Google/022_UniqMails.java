class Solution
{
    public int numUniqueEmails(String[] emails)
    {
        HashSet<String> uniq = new HashSet<>();
        
        for (String email : emails)
        {
            int amp = email.indexOf('@');
            if (amp < 0) throw new IllegalArgumentException();
            
            String rht = email.substring(amp + 1);
            
            StringBuilder lft = new StringBuilder();
            int cnt = 0;
            for (char c : email.toCharArray())
            {
                if (cnt == amp) break;
                cnt++;
                
                if (c == '.') continue;
                if (c == '+') break;
                
                lft.append(c);
            }
            
            lft.append('@');
            lft.append(rht);
            
            uniq.add(lft.toString());
        }
        
        return uniq.size();
    }
}
