// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

package conseqnumbers;

import java.util.Arrays;

class Solution
{
    public boolean isPossibleDivide(int[] nums, int k)
    {
        if (k < 1) return false;
        
        if (nums.length % k != 0) return false;
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        Bucket head = new Bucket(copy[0], 1);
        Bucket curr = head;
        for (int i = 1; i < copy.length; i++)
        {
            int next = copy[i];
            
            if (next != curr.number)
            {
                Bucket n = new Bucket(next, 1);
                curr = curr.add(n);
            }
            else curr.inc();
        }
        
        boolean start = true;
        int currNum = 0;
        int mysize = 0;

        curr = head;
        while (curr != null)
        {
            if (start)
            {
                currNum = curr.number;
                curr.dec();
                mysize = 1;
                start = false;
                curr = curr.next;
                continue;
            }
            
            if (curr.howMany == 0)
            {
               curr = curr.next;
               continue;
            }
           
            if (currNum + 1 == curr.number)
            {
                mysize++;
                currNum = curr.number;
                curr.dec();
                curr = curr.next;
            }
            else return false;

            if (mysize == k)
            {
                while (head != null && head.howMany == 0 )
                    head = head.next;

                if (head == null) return true;

                curr = head;
                start = true;
            }            
        }

        return false;

    }
       
}

class Bucket
{
    final int number;
    int howMany;
    Bucket next;

    public Bucket(int number, int howMany)
    {
        this.number = number;
        this.howMany = howMany;
        this.next = null;
    }

    public Bucket add(Bucket next)
    {
        this.next = next;
        return next;
    }
    
    public void inc() {howMany++;}

    public void dec()
    {
        if (howMany <= 0) throw new IllegalArgumentException("cant do");
        howMany--;
    }

    @Override
    public String toString() { return "[" + number + ", " + howMany + "]"; }
}
