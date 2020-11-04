using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// https://leetcode.com/problems/count-sorted-vowel-strings/
namespace CountVowelStr
{
    public class Solution
    {
        public int CountVowelStrings(int n)
        {
            var dp = new int[n, 5];
            for (int j = 0; j < 5; j++)
                dp[0, j] = 1;

            // $ST : "aa" = 1 "ae" "ee" = 2 "ai" "ei" "ii" = 3
            // "ao" "oo" "eo" "io" =  4 "iu" "au" "ou" "uu" "eu" = 5
            for (int i = 1; i < n; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    var countEndingInVowNo = dp[i - 1, j];
                    for (int k = j; k < 5; k++)
                        dp[i, k] += countEndingInVowNo;
                }
            }

            var ret = 0;
            for (int j = 0; j < 5; j++)
                ret += dp[n - 1, j];
            return ret;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var sl = new Solution();
            Console.WriteLine(sl.CountVowelStrings(33));
        }
    }
}
