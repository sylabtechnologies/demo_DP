// 03_IceCream.cpp : https://www.hackerrank.com/challenges/icecream-parlor/problem
//

#include "stdafx.h"
#include <MyHeaders.h>
#include <MyReadFile.h>

ifstream myfile("sample.txt");

IV_ icecreamParlor(int, IV_);

int main()
{
	MyRead cases;

	for (size_t i = 0; i < cases; i++)
	{
		int money;
		int numFlavors;
		myfile >> money >> numFlavors;

		IV_ flavor(numFlavors); 
		myfile >> flavor;

		IV_ result = icecreamParlor(money, flavor);
		cout << result << endl;
	}


    return 0;
}

vector<int> icecreamParlor(int amount, IV_ flavor)
{
	// write indices to a map
	multimap<int, size_t> myIndices;
	for (size_t i = 0; i < flavor.size(); i++)
		myIndices.emplace(flavor[i], i);

	// for each pair find indices of interest
	for (size_t i = 0; i < flavor.size(); i++)
	{
		int myTry = amount - flavor[i];

		auto lowerb = myIndices.lower_bound(myTry);
		auto upperb = myIndices.upper_bound(myTry);

		for (auto iter = lowerb; iter != upperb; ++iter)
		{
			if (iter->first == myTry && iter->second != i)
			{
				vector<int>ans{ static_cast<int>(i) + 1, static_cast<int>(iter->second) + 1 };
				return ans;
			}
		}
	}

	return vector<int>();
}

