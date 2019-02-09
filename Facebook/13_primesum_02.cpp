vector<int> Solution::primesum(int sumNum)
{
    unordered_set<int> primes;
	primes.emplace(2);
	primes.emplace(3);

	for (size_t number = 5 ; number <= sumNum; number++)
	{
		if (number % 2 == 0 || number % 3 == 0) continue;

		for (int i = 5; i*i <= number; i = i + 6)
		{
			if (number % i == 0 || number % (i + 2) == 0)
				continue;
		}

		primes.emplace(number);
	}

	vector<int> ans;
	for (auto x : primes)
	{
		auto test = primes.find(sumNum - x);

		if (test != primes.end())
		{
		    if ( x < *test)
		    {
    			ans.push_back(x);
    			ans.push_back(*test);
		    }
		    else
		    {
    			ans.push_back(*test);
    			ans.push_back(x);
		    }
		    
			break;
		}

	}


	return ans;

}
