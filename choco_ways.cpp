// choco_ways.cpp : https://www.hackerrank.com/challenges/equal/problem
// ## arr[n] -> arr[n-1] recursion, convert to DP

// 2 3 7 ** pairs: 3 7, 2 7, 2 3; if (2, 7) = 1

#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
#include <iterator>
#include <algorithm>
using namespace std;

void process_error(const string, const int);
#define MAX(a,b) (a > b ? a : b)
#define MIN(a,b) (a < b ? a : b)
#define ERR(X) process_error(X, __LINE__)
#define PRN(X) std::cout << X << std::endl

typedef vector<int> Myvec;

bool all_same(Myvec arr)
{
	if (arr.size() <= 1) return 0;

	int first = arr[0];

	for (auto iter = arr.begin() + 1; iter != arr.end(); ++iter)
	{
		if (*iter != first) return false;
	}

	return true;
}


// can give 1 or 3 or 5
int delta(Myvec arr)
{
	int a, b, resmod, delta, result;

	if (arr.size() != 2) exit(1);

	if (arr[0] > arr[1])
	{
		a = arr[1];
		b = arr[0];
	}
	else
	{
		a = arr[0];
		b = arr[1];
	}

	delta = b - a;
	resmod = delta % 5;

	// return delta / 5 + resmod / 2 + resmod % 2;

	result = delta / 5;

	if (resmod == 0) return result;

	switch (resmod)
	{
	case 1:
		result += 1;
		break;

	case 2:
		result += 2;
		break;

	case 3:
		result += 1;
		break;

	case 4:
		result += 2;
		break;

	default:		// something is wrong
		exit(1);
	}

	return result;
}

int equal(Myvec arr)
{
	Myvec result;

	if (arr.size() <= 1) return 0;

	if (arr.size() == 2) return delta(arr);

	if (all_same(arr)) return 0;

	// do the recursion
	Myvec allbutone, v_tmp;
	for (auto iter = arr.begin(); iter != arr.end(); ++iter)
	{
		Myvec allbutone, v_tmp;
		copy(arr.begin(), iter, back_inserter(allbutone));
		copy(iter + 1, arr.end(), back_inserter(allbutone));

		int temp = equal(allbutone);

		v_tmp.push_back(*iter);
		v_tmp.push_back(*min_element(allbutone.begin(), allbutone.end()));

		temp += delta(v_tmp);
		result.push_back(temp);
	}

	int temp = *min_element(result.begin(), result.end());
	PRN(temp); return temp;
}

int main() {

	int t;
	cin >> t;

	for (int a0 = 0; a0 < t; a0++) {
		int n, temp; cin >> n;

		Myvec arr;
		for (int arr_i = 0; arr_i < n; arr_i++) {
			cin >> temp;
			arr.push_back(temp);
		}

		if (arr.size() <= 1)
			PRN(0);
		else
			PRN(equal(arr));

	}
	return 0;
}

// process_error
void process_error(const string msg, const int line)
{
	cerr << __FILE__ << ", line " << line << endl;
	cerr << "Error: " << msg << endl;
	cerr << msg << endl;
	exit(1);
}
