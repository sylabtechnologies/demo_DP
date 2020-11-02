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
        private int[,] memo;

        public int NumWays(string[] words, string tar)
        {
            char[] target = tar.ToCharArray();
            memo = new int[1001,1001];
            int[,] wayCount = new int[words[0].Length, 26];

            foreach (var word in words)
            {
                for (int i = 0; i < word.Length; i++)
                    wayCount[i, word[i] - 'a'] += 1;
            }

            return dfs(wayCount, target, 0, 0);
        }

        private int dfs(int[,] wayCount, char[] target, int loc, int charLoc)
        {
            if (charLoc >= target.Length) return 1;

            if (memo[loc,charLoc] == 0)
            {
                memo[loc, charLoc] = 1;
                for (int k = loc; k + target.Length - charLoc <= wayCount.GetLength(0); k++)
                {
                    int cnt = wayCount[k, target[charLoc] - 'a'];
                    if ( cnt > 0)
                    {
                        long res = Convert.ToInt64(wayCount[k, target[charLoc] - 'a']);
                        res = res * dfs(wayCount, target, k + 1, charLoc + 1) + memo[loc, charLoc];
                        memo[loc, charLoc] = Convert.ToInt32(res % 1000000007);
                    }
                }
            }

            return memo[loc, charLoc] - 1;
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
