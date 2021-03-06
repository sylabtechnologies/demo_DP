https://www.hackerrank.com/challenges/find-digits/problem

int findDigits(int n)
{
	int next = n;

	vector<int> digits;

	while (next != 0)
	{
		int dig = next % 10;

		if (dig != 0)
			digits.push_back(dig);

		next = next / 10;

		// cout << dig << endl;
	}

	int cnt = 0;

	for (auto d : digits)
	{
		if (n % d == 0)
			cnt++;
	}

	return cnt;
}
