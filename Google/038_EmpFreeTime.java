// https://leetcode.com/problems/employee-free-time/
class Solution
{
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule)
    {
        PriorityQueue<Event> empCount = new PriorityQueue<>();
        for (List<Interval> list : schedule)
        {
            for (Interval iv : list)
            {
                Event open = new Event(iv.start, 1);
                Event close = new Event(iv.end, -1);
                empCount.add(open);
                empCount.add(close);
            }
        }
        
        int count = 0;
        int start = - 1;
        List<Interval> ret = new LinkedList<>();
        
        while (!empCount.isEmpty())
        {
            Event ev = empCount.poll();

            int temp = ev.value;
            int curr = ev.time;
            while (!empCount.isEmpty() && empCount.peek().time == curr)
                temp += empCount.poll().value;

            if (temp > 0)
            {
                if (count == 0)
                {
                    ret.add(new Interval(start, ev.time));
                    start = -2;
                }
            }
            else
            {
                if (count + temp == 0)
                    start = ev.time;
            }
            
            count += temp;
        }
        
        ((LinkedList) ret).removeFirst();
        return ret;
    }

    private static class Event implements Comparable<Event>
    {
        int time;
        int value;

        public Event(int t, int val)
        {
            time = t;
            value = val;
        }

        @Override
        public int compareTo(Event ev)
        {
            return time - ev.time;
        }

        @Override
        public String toString() { return value + "@ " + time;}
    }
}
