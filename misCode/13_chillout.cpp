// https://www.hackerrank.com/challenges/encryption/problem

#include <cmath>
string encryption(string s)
{
	int len = s.length();

	size_t row = static_cast<size_t>(std::floor(sqrt(len)));
	size_t col = static_cast<size_t>(std::ceil(sqrt(len)));

	vector<string> ans;

	for (size_t i = 0; i < row; i++)
	{
		string next = s.substr(i*col, col);
		ans.push_back(next);
	}

	if (row*col < len)
	{
		string next = s.substr(row*col);
		ans.push_back(next);
		row++;
	}

	string answer;
	for (size_t i = 0; i < col; i++)
	{
		string next;
		for (size_t j = 0; j < row; j++)
		{
			if (i >= ans[j].length()) continue;
			next += ans[j][i];
		}

		answer += next;
		if (i != col - 1) answer += ' ';
	}

	return answer;
}
