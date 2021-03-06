// Calc2.cpp : https://leetcode.com/problems/basic-calculator-ii/

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	int calculate(string s)
	{
		stack<long> stk;
		set<char> signs = {'*', '/', '+', '-'};

		long lastnum = 0;
		char lastSign = '+';

		for (size_t i = 0; i < s.size(); i++)
		{
			char c = s[i];
			
			if ('0' <= c && c <= '9')
				lastnum = lastnum * 10 + c - '0';

			if (signs.find(c) == signs.end() && i < s.size() - 1)
				continue;

			if (lastSign == '+')
				stk.push(lastnum);
			else if (lastSign == '-')
				stk.push(-lastnum);
			else if (lastSign == '*')
			{
				lastnum = stk.top()*lastnum;
				stk.pop();
				stk.push(lastnum);
			}
			else if (lastSign == '/')
			{
				lastnum = stk.top()/lastnum;
				stk.pop();
				stk.push(lastnum);
			}

			lastnum = 0;
			lastSign = c;
		}

		int ret = 0;
		while (!stk.empty())
		{
			ret += stk.top();
			stk.pop();
		}

		return ret;
	}
};

int main()
{
	Solution sl;

	auto x = sl.calculate("3+2*2");
	PRN(x);
	
    return 0;
}

