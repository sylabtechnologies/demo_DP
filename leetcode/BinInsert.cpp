// BinInsert.cpp : 99% rate on *iter
// https://leetcode.com/problems/search-insert-position

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	static int searchInsert(vector<int>& nums, int target) {

		auto beg = nums.begin();
		auto end = nums.end();

		auto mid = beg + (end - beg) / 2;
		while (mid != end)
		{
			if (target < *mid)
				end = mid;
			else if (target > *mid)
				beg = mid + 1;
			else break;

			mid = beg + (end - beg) / 2;
		}

		return std::distance(nums.begin(), mid);
	}
};

int main()
{
	IV_ arr = {1, 3, 5 , 6};
	PRN(Solution::searchInsert(arr, 2));

    return 0;
}

