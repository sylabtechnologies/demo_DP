// https://leetcode.com/problems/task-scheduler/

package schedule;
import java.util.*;

class Solution
{
    public int leastInterval(char[] tasks, int cooldown)
    {
        PriorityQueue<Elem> maxHeap = new PriorityQueue<>(new Comparator<Elem>()
        {
            @Override
            public int compare(Elem a, Elem b)
            {
                if (b.amount != a.amount)
                    return Integer.compare(b.amount, a.amount);
                else
                    return Integer.compare(a.myChar, b.myChar);
            }
        });

        int freq[] = getFreq(tasks);
        for (int i = 0; i < freq.length; i++)
        {
            if (freq[i] > 0)
                maxHeap.add(new Elem(freq[i], (char)(i + 'A')));
        }

        int ans = 0;
        LinkedList<Elem> stack = new LinkedList<>();
        while (!maxHeap.isEmpty())
        {
            for (int i = 0; i <= cooldown; i++)
            {
                Elem curr = maxHeap.poll();
                ans++;
                
                if (--curr.amount > 0)
                    stack.add(curr);
                
                if (maxHeap.isEmpty())
                {
                    if (stack.isEmpty()) return ans;
                        
                    ans += cooldown - i;
                    break;
                }
            }
            
            while (!stack.isEmpty())
                maxHeap.add(stack.removeLast());
        }
        
        return ans;
    }

    private int[] getFreq(char[] tasks)
    {
        int ans[] = new int[26];
        for (int i = 0; i < tasks.length; i++)
        {
            int ix = tasks[i] - 'A';
            ans[ix] += 1;
        }
        return ans;
    }
    
    private static class Elem
    {
        int  amount;
        char myChar;

        public Elem(int howMany, char myChar)
        {
            this.amount = howMany;
            this.myChar = myChar;
        }

        @Override
        public String toString()
        {
            return "[" + amount + ", " + myChar + "]";
        }
    }    
}

public class Schedule
{
    public static void main(String[] args)
    {
        char tasks[] = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new Solution().leastInterval(tasks, 2));
    }
    
}
