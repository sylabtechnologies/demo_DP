// HistogramRect.cpp : https://leetcode.com/problems/largest-rectangle-in-histogram/

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

typedef pair<int, int> Pair; // get height and start

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        
        stack<Pair> stk;
        int maxArea = 0;

        for (size_t i = 0; i <= heights.size(); i++)
        {
            int h = (i == heights.size()) ? -1 : heights[i];

            int sav = i;
            while (!stk.empty()) // work out the exact procedure OK WALK THRU A LOT
            {
                Pair elem = stk.top();
                if (elem.first <= h) break;

                stk.pop(); sav = elem.second;

                int area = elem.first * (i - sav);
                if (area > maxArea) maxArea = area;
            }

            stk.push(Pair{h, sav});
        }

        return maxArea;
    }
};

int main()
{
    vector<int> arr{ 2,1,5,6,2,3 };
    Solution sl;
    cout << "Max area " << sl.largestRectangleArea(arr);
}

