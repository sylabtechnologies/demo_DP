// PaintGrid3.cpp : https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
//
#include "stdafx.h"

class Solution {
public:
    int numOfWays(int n)
	{
		// paint 1st row
		long paint2same = 6;
		long paint3diff = 6;
		long modulo = (long) 1e9 + 7, next2same, next3diff;

		for (int i = 1; i < n; i++)
		{
			next2same = paint2same * 3 + paint3diff * 2;
			next3diff = paint2same * 2 + paint3diff * 2;
			
			// reset for another painting
			paint2same = next2same % modulo;
			paint3diff = next3diff % modulo;
		}

		return static_cast<int>((paint2same + paint3diff) % modulo);
	}
};


int main()
{
	Solution s;
	int test = s.numOfWays(7);

    return 0;
}

