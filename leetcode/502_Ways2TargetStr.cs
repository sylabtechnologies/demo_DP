using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

namespace Way2TargetStr
{
    public class Solution
    {
        private int[,] dp;

        public int NumWays(string[] words, string target)
        {
            dp = new int[1001,1001];
            int[,] wayCount = new int[words[0].Length, 26];

            foreach (var word in words)
            {
                for (int i = 0; i < word.Length; i++)
                    wayCount[i, word[i] - 'a'] += 1;
            }

            return dfs(wayCount, target, 0, 0);
        }

        private int dfs(int[,] wayCount, string target, int i, int j)
        {
            if (j >= target.Length) return 1;

            if (dp[i,j] == 0)
            {
                dp[i, j] = 1;
                for (int k = i; k + target.Length - j <= wayCount.GetLength(0); k++)
                {
                    int cnt = wayCount[k, target[j] - 'a'];
                    if ( cnt > 0)
                    {
                        long res = Convert.ToInt64(wayCount[k, target[j] - 'a']);
                        res = res * dfs(wayCount, target, k + 1, j + 1) + dp[i, j];
                        dp[i, j] = Convert.ToInt32(res % 1000000007);
                    }
                }
            }

            return dp[i, j] - 1;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string[] words = { "acca", "bbbb", "caca" };
            string t = "aba";

            Solution sl = new Solution();
            Console.WriteLine(sl.NumWays(words, t));
        }
    }
}
