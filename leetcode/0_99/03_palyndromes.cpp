// leetcode palyndromes

#include "stdafx.h"
#include <iostream>
#include <utility>
using namespace std;

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

typedef pair<string, int> MyPair;
typedef vector<string>    S_Vec;

MyPair process(const S_Vec &vec)
{
	if (!vec.empty())
		return { vec.back(), vec.back().size() };
	else
		return MyPair();
}

void prn(const MyPair& x)
{
	cout << "[ " << x.first << ", " << x.second << " ]" << endl;
}

int main()
{
	S_Vec a;
	prn(process(a));

	// Solution sol;


	return 0;
}

