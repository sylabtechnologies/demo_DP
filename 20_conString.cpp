// constructString.cpp : https://www.hackerrank.com/challenges/string-construction/problem?h_r=next-challenge&h_v=zen
//

#include "stdafx.h"
#include <MyHeaders.h>

// go to freq domain
int stringConstruction(string s)
{
	const int ABC_SIZE = 26;
	int freqCount[ABC_SIZE] = { 0 };

	// get freq
	for (const auto c : s)
	{
		int index = static_cast<int>(c - 'a');
		freqCount[index]++;
	}

	int ans = 0;
	for (size_t i = 0; i < ABC_SIZE; i++)
	{
		if (freqCount[i] == 0) continue;

		ans += 1;
	}

	return ans;
}


int main()
{
	PRN(stringConstruction("abab"));

    return 0;
}

