// Plus1count.cpp : 
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution
{
public:
	int countElements(vector<int>& arr)
	{
		set<int> present;

		for (auto ii : arr)
			present.emplace(ii);

		int count = 0;
		for (auto ii : arr)
		{
			if (present.find(ii + 1) != present.end())
				count++;
		}

		return count;
	}
};

int main()
{
	vector<int> arr = { 1,1,2,2 };
	Solution s;
	int ans = s.countElements(arr);
	PRN(ans);

    return 0;
}

