// RunningSum.cpp : https://leetcode.com/problems/running-sum-of-1d-array/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	vector<int> runningSum(vector<int>& nums) {
		int sum = 0;
		vector<int> ans;

		for (auto &n : nums)
		{
			sum += n;
			ans.push_back(sum);
		}

		return ans;
	}
};

int main()
{
	vector<int> nums = { 1, 2, 3, 4 };
	Solution s;

	for (auto n : s.runningSum(nums))
		cout << n  << endl;

    return 0;
}

