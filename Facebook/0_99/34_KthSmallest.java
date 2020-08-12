class Solution
{
    public int kthsmallest(final List<Integer> lst, int k)
    {
        // max heapify
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++)
        {
            int next = lst.get(i);
            pq.add(next);
        }
        
        // bump
        for (int i = k; i < lst.size(); i++)
        {
            int next = lst.get(i);
            
            if (next > pq.peek()) continue;
            
            pq.poll();
            pq.offer(next);
        }
        
        return pq.peek();
    }
}
/*

2 1 4 3 2 k = 3

2 1 4 3 2  
    3 4
2 1 2

*/
