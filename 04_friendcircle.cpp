// 07_friendcircle.cpp : https://www.hackerrank.com/challenges/friend-circle-queries

#include "stdafx.h"
#include <MyHeaders.h>
#include <MyReadFile.h>

ifstream myfile("input.txt");

vector<int> maxCircle(const vector<vector<int>>& queries)
{
	int circleCount = 0;		// make zero base!
	map<int, int> circleId;
	int circleCounts[100000] = {0};
	vector<int> ans;

	for (auto q : queries)
	{
		int friend1 = q[0];
		int friend2 = q[1];

		auto iter1 = circleId.find(friend1);

		if (iter1 == circleId.end())
		{
			auto iter2 = circleId.find(friend2);

			if (iter2 == circleId.end())
			{
				// add both
				circleCounts[circleCount] = 2;
				circleId[friend1] = circleCount;
				circleId[friend2] = circleCount;
				circleCount++;
			}
			else
			{
				circleId[friend1] = iter2->second;
				circleCounts[iter2->second]++;
			}
		}
		else
		{
			auto iter2 = circleId.find(friend2);

			if (iter2 == circleId.end())
			{
				circleCounts[iter1->second]++;
				circleId[friend2] = iter1->second;
			}
			else
			{
				// combine circles
				int seek = iter1->second;
				int reset = iter2->second;

				if (seek != reset)
				{
					circleCounts[reset] += circleCounts[seek];
					circleCounts[seek] = 0;

					for (auto &entry : circleId)
					{
						if (entry.second == seek)
							entry.second = reset;
					}
				}
			}

		}

		int mymax = INT_MIN;
		for (int i = 0; i < circleCount; i++)
		{
			if (circleCounts[i] > mymax) mymax = circleCounts[i];
		}

		ans.push_back(mymax);

	}

	return ans;

}

int main()
{
	MyRead q;
	vector<int> queryLine(2);
	vector<vector<int>> queries;

	for (size_t i = 0; i < q; i++)
	{
		myfile >> queryLine[0] >> queryLine[1];
		queries.push_back(queryLine);
	}

	vector<int> ans = maxCircle(queries);
	PRN(ans);

	return 0;
}

