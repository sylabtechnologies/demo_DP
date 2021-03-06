// pangram.cpp : https://www.hackerrank.com/challenges/pangrams/problem?h_r=next-challenge&h_v=zen
//

#include "stdafx.h"
#include <MyHeaders.h>

string pangrams(const string &s)
{
	const int ABC_SIZE = 26;
	int hits[ABC_SIZE] = { 0 };
	int fillCount = 0;

	for (auto iter = s.begin(); iter != s.end(); ++iter)
	{
		if (*iter == ' ') continue;

		int offset;
		if ('a' <= *iter && *iter <= 'z')
			offset = static_cast<int>(*iter - 'a');
		else
			offset = static_cast<int>(*iter - 'A');

		if (hits[offset] == 0) fillCount++;

		hits[offset]++;
	}

	return fillCount == ABC_SIZE ? "pangram" : "not pangram";
}

int main()
{
	PRN(pangrams("We promptly judged antique ivory buckles for the next prize"));

    return 0;
}

