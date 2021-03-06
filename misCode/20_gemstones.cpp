// gemstones.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <MyHeaders.h>

int gemstones(vector<string> arr)
{
	map<char, int> occurs;

	for (auto iter = arr.begin(); iter != arr.end(); ++iter)
	{
		// find minerals
		set<char> minerals;
		for (auto iter1 = iter->begin(); iter1 != iter->end(); ++iter1)
			minerals.insert(*iter1);

		// count occurencies
		for (auto iter1 = minerals.begin(); iter1 != minerals.end(); ++iter1)
			occurs[*iter1]++;
	}

	int gems = 0;
	for (auto iter = occurs.begin(); iter != occurs.end(); ++iter)
	{
		if (iter->second == arr.size())
			gems++;
	}

	return gems;
}

int main()
{
	SV_ test = { "abcdde", "baccd", "eeabg" };

	PRN(gemstones(test));

    return 0;
}

