vector<int> Solution::primesum(int sumNum)
{
	vector<int> prime(sumNum + 1, 1);

	for (int p = 2; p*p <= sumNum; p++)
	{
		if (prime[p] == 1)
		{
			// Update multiples
			for (int i = p * p; i <= sumNum; i += p)
				prime[i] = 0;
		}
	}

	vector<int> sieve;
	for (size_t i = 2; i <= sumNum; i++)
	{
		if (prime[i] == 1)
			sieve.push_back(i);
	}

	vector<int> ans;
	auto iter_beg = sieve.begin();
	auto iter_end = sieve.end() - 1;	// upper_bound(_R1(sieve), num);

	while (iter_beg <= iter_end)
	{
		int sum = *iter_beg + *iter_end;

		if (sum == sumNum)
		{
			ans.push_back(*iter_beg);
			ans.push_back(*iter_end);
			break;
		}
		else if (sum > sumNum)
			--iter_end;
		else
			++iter_beg;
	}

	return ans;

}
