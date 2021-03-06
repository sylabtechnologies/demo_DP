// MatchStrings.cpp : https://leetcode.com/problems/string-matching-in-an-array/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
	const int ABCSIZE = 26;
public:
	vector<string> stringMatching(vector<string>& words)
	{
		map<int, vector<string>> sorter;
		vector<string> ordered;
		for (auto w : words)
		{
			auto iter = sorter.find(w.size());

			if (iter == sorter.end())
				sorter.emplace( w.size(), vector<string>(1, w) );
			else
				iter->second.push_back(w);
		}
		
	    for (auto elem : sorter)
		{
			std::sort(elem.second.begin(), elem.second.end());
			auto iter = elem.second.begin();
			while (iter != elem.second.end())
			{
				ordered.push_back(*iter); ++iter;
			}
		}

		vector<vector<int>> frequencies;
		for (auto str : ordered)
			frequencies.emplace_back(setfreq(str));

		set<string> result;
		for (size_t i = 0; i < frequencies.size() - 1; i++)
		{
			string word = ordered[i];
			for (size_t j = i + 1; j < frequencies.size(); j++)
			{
				if (!match(frequencies[i], frequencies[j])) continue;

				int pos = ordered[j].find(word);
				if (pos >= 0) result.emplace(word);
			}
		}

		return vector<string>(result.begin(), result.end());
	}

	bool match(const vector<int> vec1, const vector<int> vec2)
	{
		for (size_t i = 0; i < ABCSIZE; i++)
			if (vec1[i] > vec2[i]) return false;
		return true;
	}

	vector<int> setfreq(const string &word)
	{
		vector<int> frq(ABCSIZE, 0);
		for (char c : word)
			frq[c - 'a']++;

		return frq;
	}

};

int main()
{
	// vector<string> words = { "leetcoder","leetcode","od","hamlet","am" };

	// vector<string> words = { "blue", "green", "bu" };

	vector<string> words = { "mass", "as", "hero", "superhero" };
	Solution s;
	vector<string> test = s.stringMatching(words);

    return 0;
}

