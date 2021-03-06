/*
BinString.cpp : https://www.hackerrank.com/challenges/beautiful-binary-string/problem
0100101010100010110100100110110100011100111110101001011001110111110000101011011111011001111100011101
one must be greedy, replace 010 -> 011 and recurse
*/

#include "stdafx.h"
#include <MyHeaders.h>

int beautifulBinaryString(string &b)
{
	int start = b.find("010");
	
	if (start < 0) return 0;

	b.erase(b.begin(), b.begin() + start + 2);

	b[0] = '1';
	return 1 + beautifulBinaryString(b);

}

int main()
{
	// cout << beautifulBinaryString("0101010") << endl;
	string test("0100101010100010110100100110110100011100111110101001011001110111110000101011011111011001111100011101");

	cout << beautifulBinaryString(test) << endl;

    return 0;
}

