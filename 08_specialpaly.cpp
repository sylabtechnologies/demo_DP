// https://www.hackerrank.com/challenges/special-palindrome-again/problem
//

#include "stdafx.h"
#include <MyHeaders.h>

typedef pair<long, char> MyCount;

long substrCount(const string &s)
{
	if (s.empty()) return 0;

	vector<MyCount> count;		// count same char sequencies

	size_t i = 1;
	char currChar = s[0];
	long currCnt = 1;
	while (i < s.length())
	{
		if (s[i] != currChar)
		{
			MyCount temp{ currCnt, currChar };
			count.push_back(temp);
			currCnt = 1;
			currChar = s[i];
		}
		else
			currCnt++;

		i++;
	}
	MyCount temp{ currCnt, currChar };
	count.push_back(temp);

	// count same char
	long totalCnt = 0;
	for (auto elem : count)
	{
		int n = elem.first;
		totalCnt += (n*(n + 1)) / 2;
	}

	// cpunt same char + one middle
	for (size_t i = 1; i < count.size() - 1; i++)
	{
		if (count[i].first != 1) continue;

		if (count[i - 1].second != count[i + 1].second) continue;

		totalCnt += std::min(count[i - 1].first, count[i + 1].first);
	}

	return totalCnt;
}

int main()
{
	cout << substrCount("asasd") << endl;

    return 0;
}

