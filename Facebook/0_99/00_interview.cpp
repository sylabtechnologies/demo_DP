// compare 2 words if given special alphabet
// assuming it is unique

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

	size_t len1 = word1.length();
	size_t len2 = word2.length();

	if (len1 == 0 && len2 == 0) return 0;
	if (len1 == 0) return -1;
	if (len2 == 0) return 1;

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
	string alphabet = "zcbat";

	string word1 = "zccz", word2 = "bzbt";	// eg compare abba vs cace

	computeOrdinals(alphabet);
	
	cout << compare2words(word1, word2) << endl;

    return 0;
}
