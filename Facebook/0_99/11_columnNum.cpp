	int myNumber = 0;
	string A = { "AAA" };

	for (auto c : A)
	{
		myNumber *= 26;
		myNumber += static_cast<int>(1+ c - 'A');
	}
