// coin_change.cpp : https://www.hackerrank.com/challenges/ctci-coin-change/problem
// BUILD UP THE TABLE OF PREVIOUS SOLUTIONS!

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long LL;
typedef vector<LL> L_vec;
typedef vector<int> I_vec;

LL make_change(I_vec coins, int money)
{
	if (coins.size() < 0) return 0;

	int s_y = money + 1; int s_x = coins.size();
	vector<L_vec> table(s_y, L_vec(s_x));

	// 0 value
	for (int i = 0; i < s_x; i++)
		table[0][i] = 1;

	// count the rest
	for (int i = 1; i < s_y; i++)
	{
		for (int j = 0; j < s_x; j++)
		{
			int k = coins[j];
			LL x = (i - k >= 0) ? table[i - k][j] : 0;
			LL y = (j >= 1) ? table[i][j - 1] : 0;
			table[i][j] = x + y;
		}
	}

	return table[s_y - 1][s_x - 1];
}

int main()
{
	int dollars;
	int m;
	cin >> dollars >> m;
	I_vec coins(m);
	for (int coins_i = 0;coins_i < m;coins_i++) {
		cin >> coins[coins_i];
	}

	// sort coins
	sort(coins.begin(), coins.end());
	cout << make_change(coins, dollars) << endl;
	return 0;
}

