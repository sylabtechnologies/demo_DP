using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

namespace CountSubstrDiff
{
    public class Solution
    {
        public int CountSubstrings(string s, string t)
        {
            char[] ss = s.ToCharArray();
            char[] tt = t.ToCharArray();

            int ret = 0;
            for (int i = 0; i < ss.Length; i++)
            {
                for (int j = 0; j < tt.Length; j++)
                {
                    int misMatch = 0;
                    // all good w/ one char diff
                    for (int p = 0; i + p < ss.Length && j + p < tt.Length; p++)
                    {
                        if (s[i + p] != t[j + p])
                        {
                            misMatch++;
                            if (misMatch > 1) break;
                        }

                        if (misMatch == 1) ret++;
                    }
                }

            }

            return ret;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var sl = new Solution();
            Console.WriteLine(sl.CountSubstrings("ab", "bb"));
            Console.WriteLine(sl.CountSubstrings("aba", "baba"));
        }
    }
}
