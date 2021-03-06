// maxstack.cpp : https://www.hackerrank.com/challenges/maximum-element/problem
//

#include "stdafx.h"
#include <MyHeaders.h>

int main()
{
	ifstream cin("sample.txt");
	auto ri = [&]()->int { int x; cin >> x; return x; };

	stack<int> myStack;
	stack<int> maxStack;

	int t = ri();

	while (t > 0)
	{
		int type = ri();

		if (type == 1)
		{
			int x = ri();

			int curMax = 0;

			if (!maxStack.empty()) curMax = maxStack.top();

			if (x > curMax) curMax = x;

			myStack.push(x);
			maxStack.push(curMax);
		}
		else if (type == 2)
		{
			myStack.pop();
			maxStack.pop();
		}
		else
			cout << maxStack.top() << endl;

		t--;
	}

    return 0;
}

