// beatifulString.cpp : https://www.hackerrank.com/challenges/separate-the-numbers/problem
//

#include "stdafx.h"
#include <MyHeaders.h>

// separate interface, need beatifulString.h,
// class interface outlined as below

int numberFromSubstring(const vector<int> &arr, size_t start, size_t length)
{
	int res = 0;
	for (size_t i = start; i < start + length; i++)
		res = res * 10 + arr[i];
	
	return res;
}

int digitCount(int n)
{
	int count = 0;

	while (n > 0)
	{
		n = n / 10;
		count++;
	}

	return count;
}

vector<int> numbersFromString(string s)
{
	vector<int> res;

	for (auto iter = s.begin(); iter != s.end(); ++iter)
	{
		res.push_back(static_cast<int>(*iter - '0'));
	}

	return res;
}

// find 1st correct number

void separateNumbers(string s)
{
	vector<int> numbers = numbersFromString(s);

	int startNum = 0;
	for (size_t MySize = 1; MySize <= numbers.size()/2; MySize++)
	{
		startNum = numberFromSubstring(numbers, 0, MySize);

		if (numbers[0] == 0) continue;

		bool isBeatiful = true;
		int myIncrement = MySize;
		for (size_t j = MySize; j < numbers.size(); j = j + myIncrement)
		{
			if ((startNum + 1) % 10 == 0)
			{
				if (digitCount(startNum) != digitCount(startNum + 1))
					myIncrement++;
			}

			if (j + myIncrement > numbers.size())
			{
				isBeatiful = false;
				break;
			}

			int nextNum = numberFromSubstring(numbers, j, myIncrement);

			if (numbers[j] == 0 || nextNum != startNum + 1)
			{
				isBeatiful = false;
				break;
			}

			// PRN(nextNum);

			startNum++;
		}

		if (isBeatiful)
		{
			cout << "YES " << s.substr(0, MySize) << endl;
			return;
		}

	}

	cout << "NO" << endl;
}

int main()
{
	separateNumbers("1234567891011121314151617181920");

    return 0;
}

