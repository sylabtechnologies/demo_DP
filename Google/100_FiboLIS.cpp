// FiboLIS.cpp : https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
//

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

/*
* 1. map all ints
* 2. dp{i,j) = length of subseq; init all i, j as one pairs
* 3. do LIS
*
*/


class Solution
{
public:
    int lenLongestFibSubseq(vector<int>& arr)
    {
        const size_t len = arr.size();

        map<int, int> numMap;
        for (size_t i = 0; i < len; i++)
            numMap.emplace(arr[i], i);

        vector<vector<int>> dp(len, vector<int>(len, 0));
        for (size_t i = 0; i < len - 1; i++)
            for (size_t j = i + 1; j < len; j++)
                dp[j][i] = 1;

        // print(dp);

        int maxFibo = 0;
        for (size_t i = 2; i < len; i++)
        {
            int x3 = arr[i];

            for (size_t j = i - 1; j >= 1; j--)
            {
                int x2 = arr[j];
                int x1 = x3 - x2;

                if (x1 >= x2) continue;
                if (numMap.find(x1) == numMap.end()) continue;

                dp[i][j] = max(dp[j][numMap[x1]] + 1, dp[i][j]);

                if (dp[i][j] > maxFibo)
                    maxFibo = dp[i][j];
            }

            // print(dp);

        }

        return (maxFibo == 0) ? 0 : maxFibo + 1;
    }

    /*
    void print(const vector<vector<int>>& mtrx)
    {
        for (auto& v : mtrx)
        {
            for (const auto &x : v)
                cout << x << " ";

            cout << endl;
        }

        cout << endl;
    }
    */
};


int main()
{
    Solution sl;

    vector<int> arr = { 2392,2545,2666,5043,5090,5869,6978,7293,7795 };
    for (auto x : arr)
        cout << x << " ";
    cout << endl;
    cout << endl;

    cout << sl.lenLongestFibSubseq(arr) << endl;
}

