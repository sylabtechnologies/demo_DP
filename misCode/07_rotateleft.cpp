// Arr_lrotate.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <iterator>
#include <limits>
#include <fstream>
#include "StreamVec.h"
using namespace std;

vector<int> rotateLeft(const vector<int>& arr, int shift)
{
	vector<int> ans(arr.begin() + shift, arr.end());

	for (size_t i = 0; i < shift; i++)
	{
		ans.push_back(arr[i]);
	}

	return ans;
}


int main()
{
	int n, d;
	cin >> n >> d;

	vector<int> myNumbers(n); cin >> myNumbers;

	vector<int> ans = rotateLeft(myNumbers, d);

	cout << ans << endl;

	return 0;
}

