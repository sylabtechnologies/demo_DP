// findsqrt.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	int mySqrt(int x)
	{
		int beg = 0, end = x;
		int mid, ans;

		while (beg <= end)
		{
			mid = beg + (end - beg) / 2;

			long sq = mid;
			sq *= mid;

			if (sq == x) return mid;

			if (sq < x)
			{
				beg = mid + 1;
				ans = mid;
			}
			else
				end = mid - 1;
		}

		return ans;
	}
};

int main()
{
	Solution s;

	int res = s.mySqrt(8);
	PRN(res);

    return 0;
}

/* valid perfect square (== 220 perfect blue)

class Solution {
public:
bool isPerfectSquare(int x)
{

int beg = 0, end = x;
int mid;

while (beg <= end)
{
mid = beg + (end - beg) / 2;

long sq = mid;
sq *= mid;

if (sq == x) return true;

if (sq < x)
beg = mid + 1;
else
end = mid - 1;
}

return false;

}
};

*/

