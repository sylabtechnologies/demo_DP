vector<int> Solution::primesum(int sumNum)
{
    vector<unordered_set<int>> primes;
	const int myBlock = 200000;
	auto myBlockNum = [myBlock](int size)->int { return (size / myBlock) + 1;};

	primes.resize(myBlockNum(sizeNum));
	primes[0].emplace(2);
	primes[0].emplace(3);

	for (size_t number = 5 ; number <= sizeNum; number++)
	{
		if (number % 2 == 0 || number % 3 == 0) continue;

		for (int i = 5; i*i <= number; i = i + 6)
		{
			if (number % i == 0 || number % (i + 2) == 0)
				continue;
		}

		primes[myBlockNum(number) - 1].emplace(number);
	}

	vector<int> ans;
	for (auto yyy : primes)
	{
		for (auto x : yyy)
		{
			bool found = false;

			for (auto innerYyy : primes)
			{
				auto test = innerYyy.find(num - x);
				if (test != innerYyy.end())
				{
					ans.push_back(x);
					ans.push_back(*test);
					return ans;
				}

			}

		}

	}

	return ans;
}


