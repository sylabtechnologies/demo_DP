// https://leetcode.com/problems/split-a-string-in-balanced-strings/

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	int balancedStringSplit(string s)
	{
		if (s.empty()) return 0;

		int balance = 0;
		int count = 0;
		for (auto c : s)
		{
			balance += (c == 'R') ? -1 : 1;
			if (balance == 0) count++;
		}

		return count;
	}
};


int main()
{
	Solution s;
	int x = s.balancedStringSplit("RLRRLLRLRL");
	PRN(x);

    return 0;
}

