// https://leetcode.com/problems/validate-ip-address/

class Solution
{
    public String validIPAddress(String ip)
    {
        if (ip.length() < 7) return "Neither";
        
        // check beg/end
        char beg = ip.charAt(0), end = ip.charAt(ip.length() - 1);
        if (beg == '.' || beg == ':') return "Neither";
        if (end == '.' || end == ':') return "Neither";
        
        String[] elems = ip.split(":");
        
        if (elems.length == 8)
        {
            for (String el : elems)
            {
                if (el.length() == 0 || el.length() > 4) return "Neither";
                
                int hexNum = -1;
                try
                {
                    hexNum = Integer.valueOf(el, 16);
                } catch (NumberFormatException ex)
                {
                    return "Neither";
                }

                if (leaderFound(el, '-')) return "Neither"; 

            }

            return "IPv6";
        }
        
        elems = ip.split("\\.");
        if (elems.length == 4)
        {
            for (String el : elems)
            {
                if (el.length() == 0 || el.length() > 3) return "Neither";
                
                if (leaderFound(el, '-')) return "Neither"; 
                
                int num = -1;
                try
                {
                    num = Integer.valueOf(el);
                } catch (NumberFormatException ex)
                {
                    return "Neither";
                }
                
                if (num < 0 || num > 255) return "Neither";
                
                if (num > 0)
                {
                    if (leaderFound(el, '0')) return "Neither";
                }
                else
                {
                    if (el.length() != 1) return "Neither";
                }
                    
                    
            }
            
            return "IPv4";
        }

        return "Neither";
    }

    private boolean leaderFound(String elem, char lead)
    {
        for (char c : elem.toCharArray())
        {
            if (c == lead)
                return true;
            else 
                return false;                    
        }
        
        return false;
    }
}
