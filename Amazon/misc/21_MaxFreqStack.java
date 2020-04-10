package maxfreqstack;
import java.io.IOException;
import java.util.*;

/*
#D1. enhance stack w/ frequency
#D2. keep Multimap stacks stacked by frequency
https://leetcode.com/problems/maximum-frequency-stack/discuss/549001/Java-100%2B100
*/

class FreqStack
{
    LinkedList<Integer> stack;
    PriorityQueue<Elem> freq;
    HashMap<Integer, Elem> index;
    
    public FreqStack()
    {
        stack = new LinkedList<>();
        freq = new PriorityQueue<>();
        index = new HashMap<>();
    }
    
    public void push(int x)
    {
        stack.add(x);
        
        Elem el = index.get(x);
        
        if (el == null)
        {
            el = new Elem(x, 1);
            index.put(x, el);
            freq.add(el);
        }
        else
        {
            el.freq += 1;
            
            // reheapify
            Elem myElem = freq.poll();
            if (myElem == null) throw new IllegalArgumentException("bad heap");
            freq.offer(myElem);
            
            System.out.println(freq.peek());
        }
        
    }
    
    public int pop()
    {
        System.out.println(freq);
        
        ArrayList<Elem> candidates = new ArrayList<>();
        int myfreq = 0;
        do
        {
            Elem el = freq.poll();
            myfreq = el.freq;
            candidates.add(el);
            if (freq.isEmpty()) break;
        }
        while (myfreq == freq.peek().freq);

        if (candidates.isEmpty()) throw new IllegalArgumentException("bad stack");
        
        TreeSet<Integer> candSet = new TreeSet<>();
        for (Elem el : candidates)
            candSet.add(el.number);
        
        int inx = stack.size() - 1;
        while (inx >= 0)
        {
            int elem = stack.get(inx);
            if (candSet.contains(elem)) break;
            inx--;
        }
        
        if (inx < 0) throw new IllegalArgumentException("bad stack");

        int elem = stack.get(inx); stack.remove(inx);
        
        Elem myElem = index.get(elem);
        myElem.freq -= 1;
        
        if (myElem.freq == 0)
            index.remove(myElem.number);

        for (Elem cand : candidates)
        {
            if (cand.number == myElem.number)
            {
                if (myElem.freq == 0) continue;
            }
            
            freq.offer(cand);
        }

        return myElem.number;
    }

    private static class Elem implements Comparable<Elem>
    {
        int number, freq;

        public Elem(int number, int freq)
        {
            this.number = number;
            this.freq = freq;
        }

        @Override
        public int compareTo(Elem o)
        {
            if (this.freq < o.freq)
                return 1;
            else if (this.freq > o.freq)
                return -1;
            else
            {
                if (this.number < o.number)
                    return -1;
                else if (this.number > o.number)
                    return 1;
                else return 0;
            }
        }

        @Override
        public String toString() {
            return "[" + number + ", " + freq + "]";
        }
        
        
    }
}

/*
"pop","push","pop","push","pop",
[],[1],[],[4],[],
"pop","pop","pop","pop","pop"]
[],[],[],[],[]]
*/

public class MaxFreqStack
{
    public static void main(String[] args) throws IOException
    {
        FreqStack frs = new FreqStack();

        frs.push(4);
        frs.push(0);
        frs.push(9);
        frs.push(3);
        frs.push(4);
        
        frs.push(2);
        System.out.println(frs.pop());
        frs.push(6);
        System.out.println(frs.pop());
        frs.push(1);

        System.out.println(frs.pop());
        frs.push(1);
        System.out.println(frs.pop());
        frs.push(4);                    /// CANT REHEAPIFY
        System.out.println(frs.pop());
        
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        
/*        
        TestList lst = new TestList();
        
        int count = 0;
        for (String str : lst.oper)
        {
            if (str.equals("push"))
                frs.push(lst.test[count]);
            else
                System.out.println(frs.pop());
            
            count++;
        }
*/
                
    }

}

/*
        frs.push(4);
        frs.push(0);
        frs.push(9);
        frs.push(3);
        frs.push(4);
        
        frs.push(2);
        System.out.println(frs.pop());
        frs.push(6);
        System.out.println(frs.pop());
        frs.push(1);

        System.out.println(frs.pop());
        frs.push(1);
        System.out.println(frs.pop());
        frs.push(4);
        System.out.println(frs.pop());
        
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());

        frs.push(5);
        frs.push(7);
        frs.push(5);
        frs.push(7);
        frs.push(4);
        frs.push(5);
        
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());
        System.out.println(frs.pop());

*/