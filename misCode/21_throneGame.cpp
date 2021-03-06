// gameofthrones.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <MyHeaders.h>

string gameOfThrones(string s)
{
	map<char, int> occurs;

	for (auto iter = s.begin(); iter != s.end(); ++iter)
	{
		occurs[*iter]++;
	}

	int numEven = 0;
	for (auto iter = occurs.begin(); iter != occurs.end(); ++iter)
	{
		if (iter->second % 2 == 0) numEven++;
	}

	return numEven == occurs.size() || numEven == occurs.size() - 1 ? "YES" : "NO";
}


int main()
{
	PRN(gameOfThrones("aaabbbb"));

    return 0;
}

