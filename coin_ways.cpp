// coin_ways.cpp : https://www.hackerrank.com/challenges/coin-change/problem
// COMPARE FASTER MEMOIZATION VS RECURSIVE WALK

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <iterator>

using namespace std;

long getWays(long n, vector < long > c)
{

	long table[n + 1];
	memset(table, 0, sizeof(table));

	table[0] = 1; // base case

	int m = c.size();

	for (int i = 0; i < m; i++)
		for (int j = c[i]; j <= n; j++)
			table[j] += table[j - c[i]];

	return table[n];

    /* RECURSIVE SEARCH
	long result = 0;

	if (n == 0) return 1;

	if (n < 0) return 0;

	// if no coins there is no solution
	if (c.size() == 0 && n > 0)
		return 0;

	// copy all but first element
	vector<long> allbutone;
	copy(c.begin() + 1, c.end(), back_inserter(allbutone));

	// the solution is (all but one) + (n - c[0] for all)
	// return getWays(n, allbutone) + getWays(n - c[0], c);
	result += getWays(n, allbutone);
	result += getWays(n - c[0], c);
	
	return result;
    */

}

int main() {
	int n;
	int m;
	cin >> n >> m;

	vector<long> c(m);

	for (int c_i = 0; c_i < m; c_i++) {
		cin >> c[c_i];
	}

	cout << getWays(n, c) << endl;

	return 0;
}
