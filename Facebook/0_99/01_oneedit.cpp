bool distance(const string &a, const string &b)
{
	int lenA = a.length();
	int lenB = b.length();

	int diff = std::abs(lenA - lenB);

	if (diff > 1) return false;

	int countEdits = 0;

	if (diff == 0)
	{
		for (size_t i = 0; i < a.length(); i++)
			if (a[i] != b[i]) countEdits++;

		return (countEdits < 2);
	}

	// abcd vs acd
	while (lenA > 0 && lenB > 0)
	{
		if (a.at(lenA - 1) != b.at(lenB - 1))
		{
			countEdits++;
			
			if (countEdits > 1) return false;

			if (lenA > lenB)
				lenA--;
			else
				lenB--;
		}

		lenA--; lenB--;
	}

	return true;
}

int main()
{
	while (true)
	{
		string a, b;
		cin >> a >> b;

		PRN(distance(a, b));
	}

    return 0;
}

