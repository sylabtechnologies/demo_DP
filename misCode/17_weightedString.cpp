// weightString.cpp : https://www.hackerrank.com/challenges/weighted-uniform-string/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
//

#include "stdafx.h"
#include <MyHeaders.h>

inline int charOrdinal(char c)
{
	return static_cast<int>(c - 'a' + 1);
}

vector<string> weightedUniformStrings(string s, vector<int> queries)
{
	vector<char> stak;
	set<int> result;

	for (auto iter = s.begin(); iter != s.end(); ++iter)
	{
		if (stak.empty())
		{
			stak.push_back(*iter);
			result.insert(charOrdinal(*iter)*stak.size());
		}
		else if (stak.back() == *iter)
		{
			stak.push_back(*iter);
			result.insert(charOrdinal(*iter)*stak.size());
		}
		else
		{
			stak.clear();
			stak.push_back(*iter);
			result.insert(charOrdinal(*iter)*stak.size());
		}
	}

	SV_ ans;
	for (auto iter = queries.begin(); iter != queries.end(); ++iter)
	{
		if (result.find(*iter) != result.end())
			ans.push_back("Yes");
		else
			ans.push_back("No");
	}

	return ans;
}

int main()
{
	string test = "aaabbbbcccddd";
	IV_ testVec = { 9, 7, 8, 12, 5 };

	SV_ ans = weightedUniformStrings(test, testVec);

	PRN(ans);

    return 0;
}

