#include "stdafx.h"
#include <MyHeaders.h>

int diffPossible(const vector<int> &A, int B)
{
	unordered_map<int, int> freq;
	for (auto elem : A)
		freq[elem]++;

	if (A.size() <= 1)
		return 0;
	else if (B == 0)
	{
		int maxFreq = 0;
		for (auto &elem : freq)
		{
			if (elem.second > maxFreq)
				maxFreq = elem.second;
		}

		if (maxFreq <= 1) return 0;
	}

	for (auto elem : A)
	{
		auto iter = freq.find(elem - B);

		if (iter != freq.end())
			return 1;
	}

	return 0;

}


int main()
{
	IV_ vec{ 10 };

	cout << diffPossible(vec, 0) << endl;

    return 0;
}

