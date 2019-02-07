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

long long ways(int dollars, vector<int> coin) {
    sort(coin.begin(), coin.end());

    vector<long long> ways(dollars + 1, 0);
    ways[0] = 1;                // b/c/o way to change 0 dollars!

    for (auto c : coin)
    {
        for (size_t i = c; i < dollars + 1; i++)
        {
            ways[i] += ways[i - c];
        }
    }

    return ways[dollars];
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
	cout << ways(coins, dollars) << endl;
	return 0;
}

