// anagram.cpp : https://leetcode.com/problems/valid-anagram/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	bool isAnagram(string s, string t) {
		if (s.length() != t.length()) return false;

		vector<int> freq1(26, 0);
		vector<int> freq2(26, 0);

		for (size_t i = 0; i < s.length(); i++)
		{
			int index1 = s[i] - 'a';
			int index2 = t[i] - 'a';
			freq1[index1]++;
			freq2[index2]++;
		}

		return freq1 == freq2;
	}
};


int main()
{
	Solution *sol = new Solution();
	cout << sol->isAnagram("nagaram", "anagram") << endl;

    return 0;
}

