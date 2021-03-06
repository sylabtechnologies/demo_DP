// funnyString.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <MyHeaders.h>

string funnyString(string s)
{
	vector<int> diff;

	for (auto iter = s.begin(); iter != s.end()-1; ++iter)
	{
		int d = std::abs(*iter - *(iter + 1));
		diff.push_back(d);
	}

	int count = 0;
	for (auto iter = s.rbegin(); iter != s.rend() - 1; ++iter)
	{
		int d = std::abs(*iter - *(iter + 1));
		if (diff[count] != d) return "Not Funny";
		count++;
	}

	return "Funny";

}

int main()
{
	cout << funnyString("acxz") << endl;

    return 0;
}

