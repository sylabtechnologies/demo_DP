// loveLetter.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <MyHeaders.h>

int theLoveLetterMystery(string s)
{
	int start = 0;
	int end = s.length() - 1;

	int count = 0;
	while (start < end)
	{
		count += std::abs(s[start] - s[end]);

		start++;
		end--;

		if (start == end) break;
	}

	return count;
}

int main()
{
	cout << theLoveLetterMystery("abcd") << endl;

    return 0;
}

