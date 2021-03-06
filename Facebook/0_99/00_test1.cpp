// test1.cpp : find row w/ minimum 1's
//

#include "stdafx.h"
#include <MyHeaders.h>
vector<int> carParking(int n, vector<vector<int>> available)
{
	vector<int> ans = { 0, 0 };

	int min = n * n;
	int minRow = -1;
	for (size_t i = 0; i < n; i++)
	{
		int cars = 0;
		for (size_t j = 0; j < n; j++)
		{
			cars += available[i][j];
		}

		if (cars < min)
		{
			min = cars;
			minRow = i;
		}
	}

	if (min == n) return ans;

	int fstAvailable = 0;
	for (size_t j = 0; j < n; j++)
	{
		if (available[minRow][j] == 0)
		{
			fstAvailable = j;
			break;
		}
	}

	ans[0] = minRow + 1;
	ans[1] = fstAvailable + 1;
	return ans;

}

int main()
{
	vector<vector<int>> vec;

	IV_ row(5, 0);

	for (size_t i = 0; i < 5; i++)
	{
		cin >> row;
		vec.push_back(row);
		// row.clear();
	}

	IV_ ans = carParking(5, vec);
	PRN(ans);

    return 0;
}

