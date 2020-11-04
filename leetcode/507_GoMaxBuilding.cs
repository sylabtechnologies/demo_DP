using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// https://leetcode.com/problems/furthest-building-you-can-reach/
// put ladders as far as possible
namespace GoMaxBuilding
{
    public class Solution
    {
        public int FurthestBuilding(int[] heights, int bricks, int ladders)
        {
            var pq = new MyPriorityQueue();
            for (int i = 0; i < heights.Length - 1; i++)
            {
                int climb = heights[i + 1] - heights[i];
                if (climb <= 0) continue;

                pq.add(climb);

                if (pq.size() > ladders)
                {
                    var first = pq.poll();
                    bricks -= first;
                }

                if (bricks < 0) return i;
            }

            return heights.Length - 1;
        }

        private class MyPriorityQueue
        {
            private SortedDictionary<int, int> data;
            private int mysize;

            public MyPriorityQueue()
            {
                data = new SortedDictionary<int, int>();
                mysize = 0;
            }

            public void add(int key)
            {
                int fr = 0;
                if (data.ContainsKey(key))
                { 
                    fr = data[key];
                    data.Remove(key);
                }

                data.Add(key, fr + 1);
                mysize++;
            }

            public int poll()
            {
                var first = data.First();
                int key = first.Key;
                int fr = data[key];
                data.Remove(key);

                if (fr > 1)
                    data.Add(key, fr - 1);

                mysize--;

                return key;
            }

            public int size()
            {
                return mysize;
            }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            int[] h = { 4, 2, 7, 6, 9, 14, 12 };
            var sl = new Solution();
            Console.WriteLine(sl.FurthestBuilding( h, 5, 1));
        }
    }
}
