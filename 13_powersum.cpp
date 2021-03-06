// 07_powersum.cpp : CLASSIC DP

#include "stdafx.h"
#include <MyHeaders.h>
#include <cmath>

int powerSum(int X, int N)
{
	if (X == 1) return 1;
	if (X < 0)  return 0;

	// get the list
	int curNum = 1; bool doMore = true;
	vector<int> candidate;
	while (doMore)
	{
		int p = std::pow(curNum++, N);
		
		if (p <= X)
			candidate.push_back(p);
		else
			doMore = false;
	}

	vector<int> count(X + 1, 0); count[0] = 1;
	for (int i = 0; i < candidate.size(); i++)
	{
		// PRN(candidate[i]);

		for (int j = X - candidate[i]; j >= 0; j--)
		{
			count[j + candidate[i]] += count[j];
		}

		// PRN(count);
	}

	return count[X];

}



int main()
{
	cout << powerSum(10, 2) << endl;

    return 0;
}

