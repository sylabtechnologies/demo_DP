/**
 * greedy solution wont work
 */

package houserobber;

import java.util.*;

class Solution
{
    private class Plan implements Comparable<Plan>
    {
        int money;
        int index;

        public Plan(int money, int index)
        {
            this.money = money;
            this.index = index;
        }

        @Override
        public int compareTo(Plan p)
        {
            if (money < p.money)
                return -1;
            else if (money == p.money)
                return 0;
            else
                return 1;
        }
                
    }
    
    int rob(int[] houses)
    {
        ArrayList<Plan> plans = new ArrayList<>();
        for (int i = 0; i < houses.length; i++)
        {
            plans.add(new Plan(houses[i], i));
        }
        Collections.sort(plans);
     
        int ans = 0;
        for (int i = plans.size() - 1; i >= 0; i--)
        {
            int next = plans.get(i).index;
            
            if (next > 0)
            {
                if (houses[next - 1] == -1) continue;
            }

            if (next < houses.length - 1)
            {
                if (houses[next + 1] == -1) continue;
            }
                        
            ans += houses[next];
            houses[next] = -1;
        }
        
        return ans;
    }
}

public class HouseRobber
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] houses = {2,7,9,3,1}; 
        
        System.out.println(sol.rob(houses));
    }
    
}
