/* anagram.cpp : https://www.hackerrank.com/challenges/anagram/problem
*/

#include "stdafx.h"
#include <MyHeaders.h>

/* #n
void printMap(const MyMap &freq)
{
	for (const auto &elem : freq)
		cout << elem.first << "\t" << elem.second << endl;
}
*/

int anagram(const string &s)
{
	const int ABC_SIZE = 26;

	if (s.length() % 2 != 0) return -1;

	int half = s.length() / 2;

	string s1 = s.substr(0, half);
	string s2 = s.substr(half, half);

	int freqCount[ABC_SIZE] = { 0 };

	// get freq
	for (const auto c : s1)
	{
		int index = static_cast<int>(c - 'a');
		freqCount[index]++;
	}

	// subtract same
	for (auto c : s2)
	{
		int index = static_cast<int>(c - 'a');
		freqCount[index]--;
	}

	// diff = abs sum - 1
	int ans = 0;
	for (size_t i = 0; i < ABC_SIZE; i++)
	{
		ans += std::abs(freqCount[i]);
	}

	return ans/2;
}

int main()
{
	// PRN(anagram("xaxbbbxx"));

	PRN(anagram("aaabbb"));

    return 0;
}

