#include "Solution.h"

/*
https://leetcode.com/problems/set-matrix-zeroes/
#S : 1st Jwk
*/

void Solution::setZeroes(vector<vector<int>>& mtrx)
{
    const size_t m = mtrx.size();
    const size_t n = mtrx[0].size();

    bool zeroTop = false, zeroLeft = false;
    for (size_t i = 0; i < m; i++)
    {
        if (mtrx[i][0] == 0)
        {
            zeroLeft = true; break;
        }
    }

    for (size_t j = 0; j < n; j++)
    {
        if (mtrx[0][j] == 0)
        {
            zeroTop = true; break;
        }
    }

    // we go 1..m, 1..n
    for (size_t i = 1; i < m; i++)
    {
        vector<int> row = mtrx[i];
        for (size_t j = 0; j < n; j++)
        {
            if (row[j] == 0)
                mtrx[i][0] = 0;
        }
    }

    for (size_t j = 1; j < n; j++)
    {
        for (size_t i = 0; i < m; i++)
        {
            if (mtrx[i][j] == 0)
                mtrx[0][j] = 0;
        }
    }


    for (size_t i = 1; i < m; i++)
    {
        if (mtrx[i][0] != 0) continue;

        for (size_t j = 0; j < n; j++)
            mtrx[i][j] = 0;
    }

    for (size_t j = 1; j < n; j++)
    {
        if (mtrx[0][j] != 0) continue;

        for (size_t i = 0; i < m; i++)
            mtrx[i][j] = 0;
    }

    if (zeroTop)
    {
        for (size_t j = 0; j < n; j++)
            mtrx[0][j] = 0;
    }

    if (zeroLeft)
    {
        for (size_t i = 0; i < m; i++)
            mtrx[i][0] = 0;
    }
}

void Solution::print(const vector<vector<int>>& mtrx)
{
    for (auto& v : mtrx)
    {
        for (auto x : v)
            cout << x << " ";

        cout << endl;
    }

    cout << endl;
}

