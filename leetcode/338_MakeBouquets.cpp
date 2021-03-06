// MakeBouquets.cpp : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution
{
public:
	// bin search in [1, e9]
	int minDays(const vector<int>& bloomDay, int m, int k)
	{
		int mylen = bloomDay.size();
		int begin = 1, end = 1'000'000'000;
		if (m * k > mylen) return -1;

		while (begin < end)
		{
			int mid = begin + (end - begin) / 2;
			int flower = 0, bouquet = 0;

			for (int j = 0; j < mylen; ++j)
			{
				if (bloomDay[j] > mid)
					flower = 0;
				else if (++flower >= k)
				{
					bouquet++;
					flower = 0;
				}
			}

			if (bouquet < m)
				begin = mid + 1;
			else
				end = mid;
		}

		return begin;
	}
};

int main()
{
	vector<int> blooms = { 1,10,3,10,2 };
	Solution s;
	cout << s.minDays(blooms, 3, 1);

    return 0;
}

