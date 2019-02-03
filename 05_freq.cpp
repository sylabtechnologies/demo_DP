// 05_frequency.cpp : https://www.hackerrank.com/challenges/frequency-queries/problem
#include "stdafx.h"
#include <MyHeaders.h>
#include <MyReadFile.h>

vector<int> freqQuery(vector<vector<int>> queries)
{
	map<int, size_t> numberToFreq;
	map<size_t, size_t> freqToHowMany;
	vector<int> ans;

	for (auto s : queries)
	{
		int type = s[0];
		int val = s[1];

		if (type == 1)
		{
			numberToFreq[val]++;

			size_t index = numberToFreq[val];
			freqToHowMany[index]++;

			auto iter = freqToHowMany.find(index - 1);
			if (iter != freqToHowMany.end())
			{
				iter->second--;

				if (iter->second == 0)
					freqToHowMany.erase(iter);
			}

		}
		else if (type == 2)
		{
			auto iter = numberToFreq.find(val);
            if (iter != numberToFreq.end())
            {
				size_t index = iter->second;

				if (iter->second == 1)
					numberToFreq.erase(iter);
				else
					iter->second--;

				auto iter2 = freqToHowMany.find(index);

				if (iter2->second == 1)
					freqToHowMany.erase(iter2);
				else
					iter2->second--;
            }
		}
		else if (type == 3)
		{
			auto iter = freqToHowMany.find(val);

			if (iter != freqToHowMany.end())
				ans.push_back(1);
			else
				ans.push_back(0);
		}
		else ERR("invalid argument");

	}
	
	return ans;

}

ifstream myfile("test.txt");

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

	vector<int> ans = freqQuery(queries);
	PRN(ans);

    return 0;
}

