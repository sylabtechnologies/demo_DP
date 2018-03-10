// choco_ways.cpp : https://www.hackerrank.com/challenges/equal/problem
// ## arr[n] -> arr[n-1] recursion, convert to DP

// 2 3 7 ** pairs: 2 7, 2 3, 3 7; if (2, 7) = 1

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

Myvec make_unique(Myvec arr)
{
	Myvec result;

	sort(arr.begin(), arr.end());
	auto cutoff = unique(arr.begin(), arr.end());
	copy(arr.begin(), cutoff, back_inserter(result));

	return result;
}


int equal(Myvec origin)
{
	Myvec result, arr = make_unique(origin);

	if (arr.size() <= 1) return 0;

	if (arr.size() == 2) return delta(arr);

	// do the recursion
	Myvec allbutone, v_tmp;
	for (auto iter = arr.begin(); iter != arr.end(); ++iter)
	{
		Myvec allbutone, v_tmp;
		copy(arr.begin(), iter, back_inserter(allbutone));
		copy(iter + 1, arr.end(), back_inserter(allbutone));

		v_tmp.push_back(*iter);
		v_tmp.push_back(*min_element(allbutone.begin(), allbutone.end()));

		int temp = equal(v_tmp) + equal(allbutone);
		result.push_back(temp);
	}

	return *min_element(result.begin(), result.end());
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
