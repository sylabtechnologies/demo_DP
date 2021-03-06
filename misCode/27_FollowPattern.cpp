// FollowPattern.cpp : https://leetcode.com/problems/word-pattern/
// 1:1 = map + the other set

class Solution
{
public:
	bool wordPattern(string pattern, string str)
	{
		unordered_map<string, char> myMap;
		unordered_set<char> checkBack;

		stringstream ss(str);
		int curr = 0; string currWord;

		while (ss >> currWord)
		{
            char check = pattern[curr];

            auto iter = myMap.find(currWord);
			if ( iter == myMap.end())
            {
                if (checkBack.find(check) != checkBack.end()) return false;
                checkBack.emplace(check);
				myMap.emplace(currWord, check);
            }
			else
			{
				if (pattern[curr] != iter->second)
					return false;
			}

			curr++;
		}
        
		if (curr != pattern.length()) return false;
        
		return true;
	}
};

