// MaxMatrRect.cpp : sweep https://leetcode.com/problems/maximal-rectangle/ to #84
//

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution
{
    typedef pair<int, int> Pair;

public:
    int maximalRectangle(vector<vector<char>>& matr)
    {
        if (matr.size() == 0) return 0;

        int maxRect = 0;
        vector<vector<int>> heights(matr.size(), vector<int>(matr[0].size(), 0));

        for (size_t i = 0; i < matr.size(); i++)
        {
            for (size_t j = 0; j < matr[0].size(); j++)
            {
                heights[i][j] = (matr[i][j] == '0') ? 0 : 1;

                if (i > 0 && heights[i][j] != 0)
                    heights[i][j] += heights[i - 1][j];
            }

            maxRect = max(maxRect, largestRectangleArea(heights[i]));
        }

        return maxRect;
    }

    int largestRectangleArea(vector<int>& heights) {

        stack<Pair> stk;
        int maxArea = 0;

        for (size_t i = 0; i <= heights.size(); i++)
        {
            int h = (i == heights.size()) ? -1 : heights[i];

            int sav = i;
            while (!stk.empty())
            {
                Pair elem = stk.top();
                if (elem.first <= h) break;

                stk.pop(); sav = elem.second;

                int area = elem.first * (i - sav);
                if (area > maxArea) maxArea = area;
            }

            stk.push(Pair{ h, sav });
        }

        return maxArea;
    }
};


int main()
{
    Solution sl;
    vector<vector<char>> mat = {{'1', '0', '1', '0', '0'},
    {'1', '0', '1', '1', '1'},
    {'1', '1', '1', '1', '1'},
    {'1', '0', '0', '1', '0'}};

    std::cout << sl.maximalRectangle(mat) << endl;
}

