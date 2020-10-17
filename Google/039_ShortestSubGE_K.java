/* https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/ */

class Solution
{
    public int shortestSubarray(int[] arr, int K)
    {
        int N = arr.length;
        long prefix[] = new long[N+1];
        for (int i = 0; i < arr.length; i++)
            prefix[i+1] = prefix[i] + arr[i];
        
        LinkedList<Integer> deque = new LinkedList<>();
        int ret = N + 1;
        for (int i = 0; i <= N; i++)
        {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.getFirst()] >= K)
                ret = Math.min(ret, i - deque.removeFirst());
            
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.getLast()])
                deque.removeLast();
            
            deque.add(i);
        }
        
        return ret <= N ? ret : -1;
    }
}

