// reducedString.cpp : https://www.hackerrank.com/challenges/reduced-string/problem
// use add/pop stack

#include "stdafx.h"
#include <MyHeaders.h>

string superReducedString(const string &s)
{
	vector<char> stak;

	for (_R2(s))
	{
		if (stak.empty())
			stak.push_back(*iter);
		else if (stak.back() != *iter)
			stak.push_back(*iter);
		else
			stak.pop_back();
	}

	if (stak.empty())
		return "Empty String";

	string res;
	for (_R2(stak))
		res.push_back(*iter);

	return res;
}

int main()
{
	string reduce = "aa";

	PRN(superReducedString(reduce));

    return 0;
}

