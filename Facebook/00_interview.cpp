// compare 2 words if given special alphabet
// assuming it is unique
string alphabet = "cba";

unordered_map<char, int> alphaMap;

void computeOrdinals(const string& alphabet)
{
	int ordinal = 0;
	for (auto c : alphabet)
	{
		alphaMap[c] = ordinal;

		ordinal++;
	}

}

int compare2words(string word1, string word2)
{
	auto getRank = [](char c)->int { return alphaMap[c];};

	if (word1.length() == 0) return -1;

	if (word2.length() == 0) return 1;

	char char1 = word1[0];
	char char2 = word2[0];

	if (getRank(char1) < getRank(char2))
		return -1;

	else if (char1 == char2)
		return compare2words(word1.substr(1), word2.substr(1)); //word1=ccc, word2=ccb
	else
		return 1;

}

int main()
{
	string alphabet = "cba";

	string word1 = "ccc", word2 = "cba";

	computeOrdinals(alphabet);
	
	cout << compare2words(word1, word2) << endl;

    return 0;
}

