// MAR26TASK1.cpp
//

#include "stdafx.h"
#include <MyHeaders.h>

/*
A circuit expression consists of following symbols:
[] denotes the operation precedence
& denotes the logical AND operation
| denotes the logical OR operation
! denotes the logical NOT operation
1 denotes logical true
0 denotes logical false

*/

const char leftBrace = '[';
const char rightBrace = ']';
const char skip1 = ' ';
const char skip2 = ',';
const set<char> oper = { '&', '|', '!'};

void error(const char *msg)
{
	cout << msg << endl;
	exit(1);
}

int myEval(char op, char arg1, char arg2)
{
	bool a1 = (arg1 == '0') ? false : true;
	bool a2 = (arg2 == '0') ? false : true;

	if (op == '&')
		return (int)a1 & a2;
	else if (op == '|')
		return (int) a1 | a2;
	else if (op == '!')
		return (int) !a1;
	else
		exit(1);
}

int evaluate(string expr)
{
	stack<char> stk;
	stack<char> ops;
	char nextOp, lastOp = ' ';

	for (size_t i = 0; i < expr.length(); i++)
	{
		char c = expr[i];
		if (c == skip1 || c == skip2) continue;

		if (c == leftBrace)
		{
			;
		}
		else if (c == rightBrace)
		{
			lastOp = ops.top();
			ops.pop();

			char arg1 = stk.top(); stk.pop();

			char arg2;
			if ((lastOp == '!'))
				arg2 = '0';
			else
			{
				arg2 = stk.top();
				stk.pop();
			}

			int res = myEval(lastOp, arg1, arg2);
			stk.push((char) res + '0');
		}
		else if (oper.find(c) != oper.end())
		{
			ops.push(c);
		}
		else
		{
			stk.push(c);
		}
	}

	return (int) stk.top() - '0';
}

vector<int> circuitsOutput(vector<string> circuitsExpression)
{
	vector<int> ans;

	for (auto expr : circuitsExpression)
	{
		int res = evaluate(expr);
		ans.push_back(res);
	}

	return ans;
}

int main()
{
	/*
	[|, [&, 1, [!,0]], [!,   ]] ]
	*/

	string test = "[&, [|, [|, 1, 0], [!, 0]], [&, 1, [!,0]] ] ";
	int e = evaluate(test);
	PRN(e);
}

