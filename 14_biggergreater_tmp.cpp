// 09_biggergreater.cpp : https://www.hackerrank.com/challenges/bigger-is-greater/problem

// sort tail, delete/insert w/ binsearch

string biggerIsGreater(string s)
{
	if (s.length() < 2) return "no answer";

	string tail;
	bool found = false;
	int i = s.length() - 1;
	while(i > 0)
	{
		tail += s[i];

		if (s[i] > s[i - 1])
		{
			found = true; break;
		}

		i--;
	}

	if (!found)  return "no answer";

	// copy up to it
	int replacePos = i - 1;

	sort(tail.begin(), tail.end());

	auto iter = std::upper_bound(tail.begin(), tail.end(), s[replacePos]);
	if (iter == tail.end()) throw std::runtime_error("internal error");

	char temp = *iter;
	tail.erase(iter);

	iter = std::lower_bound(tail.begin(), tail.end(), s[replacePos]);
	tail.insert(iter, s[replacePos]);
	s[replacePos] = temp;

	return s.substr(0, replacePos + 1) + tail;
}
