// simpleEditor.cpp : https://www.hackerrank.com/challenges/simple-text-editor/problem
// stack reversal ops

#include "stdafx.h"
#include <MyHeaders.h>

struct MyOperation
{
	int type;
	int arg;
	string strArg;
};

int main()
{
	ifstream cin("sample.txt");

	int numOps; cin >> numOps;

	stack<MyOperation> opStack;
	string myString;

	while (numOps > 0)
	{
		string sArg;
		int    iArg;
		int type; cin >> type;

		if (type == 1)
		{
			cin >> sArg;
			int len = sArg.length();
			MyOperation op { 2, len, ""};
			opStack.push(op);

			myString += sArg;
		}
		else if (type == 2)
		{
			cin >> sArg;
			iArg = stoi(sArg);

			MyOperation op{ 1, iArg, myString.substr(myString.length() - iArg) };
			opStack.push(op);

			if (iArg > myString.length())
				iArg = myString.length();

			myString = myString.substr(0, myString.length() - iArg);

		}
		else if (type == 3)
		{
			int pos;
			cin >> pos;
			cout << myString.at(pos - 1) << endl;
		}
		else
		{
			MyOperation op = opStack.top(); opStack.pop();

			if (op.type == 1)
				myString += op.strArg;
			else
				myString = myString.substr(0, myString.length() - op.arg);
		}


		numOps--;
	}


    return 0;
}

