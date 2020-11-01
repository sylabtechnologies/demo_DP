using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

namespace WidestArea
{
    public class Solution
    {
        public int MaxWidthOfVerticalArea(int[][] points)
        {
            SortedSet<int> xpts = new SortedSet<int>();
            foreach (var pt in points)
                xpts.Add(pt[0]);

            int prev = xpts.First();
            int max = Int32.MinValue;
            foreach (var pt in xpts)
            {
                int dist = pt - prev;
                max = Math.Max(max, dist);
                prev = pt;
            }

            return max;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
