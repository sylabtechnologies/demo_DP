// UniqInts.cpp : https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
		if (arr.size() == 1) return arr.size() - k;

		unordered_map<int, int> freqs;
		int maxFreq = 0;
		for (auto const &x : arr)
			freqs[x]++;

		map<int, int> numsbyFreq;
		for (auto iter = freqs.begin(); iter != freqs.end(); ++iter)
			numsbyFreq[iter->second]++;

		int removeCount = 0;
		for (auto iter = numsbyFreq.begin(); iter != numsbyFreq.end(); ++iter)
		{
			int freq  = iter->first;
			int fsize = iter->second;

			if (k >= freq*fsize)
			{
				k -= freq * fsize;
				removeCount += fsize;
			}
			else
			{
				removeCount += k / freq;
				break;
			}

		}

		return freqs.size() - removeCount;
	}
};

int main()
{
	vector<int> arr = { 4,3,1,1,3,3,2 };
	Solution s;
	cout << s.findLeastNumOfUniqueInts(arr, 3) << endl;

	return 0;
}

