// Contiguous.cpp : https://leetcode.com/problems/contiguous-array/
//
#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	int findMaxLength(vector<int>& nums) {
		int checkSum = 0, ans = 0;
		unordered_map<int, int> level;

		for (size_t i = 0; i < nums.size(); i++)
		{
			int n = nums[i];
			checkSum = checkSum + ((n > 0) ? 1 : -1);

			if (checkSum == 0)
			{
				ans = max<int>(ans, i + 1);
			}
			else
			{
				auto iter = level.find(checkSum);
				if (iter == level.end())
					level[checkSum] = i;
				else
					ans = max<int>(i - iter->second, ans);
			}

		}

		return ans;
	}
};


int main()
{
	Solution s;
	vector<int> arr = { 0,0,1,0,0,0,1,1 };

	int test = s.findMaxLength(arr);
	PRN(test);

    return 0;
}

