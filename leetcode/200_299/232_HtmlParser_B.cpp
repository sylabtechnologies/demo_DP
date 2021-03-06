// HtmlParser.cpp : https://leetcode.com/problems/html-entity-parser/
//

#include "stdafx.h"
#include <MyHeaders.h>
#include "RabinKarp.h"

class Solution
{
	static unordered_map<string, char> symbol;
	static unordered_map<string, string> fullSymbol;
	static map<int, string> rkMap;

public:
	string entityParser(string text)
	{
		const char *str = text.c_str();
		string result;

		auto scan = text.begin();
		size_t count = 0;
		for (size_t i = 0; i < text.size(); i++)
		{
			if ( *(str + i) != '&')
			{
				count++; continue;
			}

			RabinKarp rk(str + i + 1);
			int hash = rk.getHash();
			auto iter = rkMap.find(hash);
			if (iter == rkMap.end())
			{
				count++; continue;
			}

			string match = fullSymbol[iter->second];
			if (i + 1 + match.size() > text.size())
			{
				count++; continue;
			}

			if (text.substr(i + 1, match.size()) == match)
			{
				result.append(scan, scan + count);
				result.push_back(symbol[iter->second]);
				i += match.size();
				scan += count + 1 + match.size();
				count = 0;
			}
		}

		if (count > 0)
			result.append(scan, scan + count);

		return result;
	}

private:
	static map<int, string> initRKMap()
	{
		map<int, string> hmap;

		for (auto pair : symbol)
		{
			RabinKarp rk(pair.first.c_str());
			hmap.emplace(rk.getHash(), pair.first);
		}

		return hmap;
	}
};

unordered_map<string, char> Solution::symbol =
{
	{ "quo", '\"' },
	{ "apo", '\'' },
	{ "amp", '&' },
	{ "gt;", '>' },
	{ "lt;", '<' },
	{ "fra", '/' }
};

unordered_map<string, string> Solution::fullSymbol =
{
	{ "quo", "quot;" },
	{ "apo", "apos;" },
	{ "amp", "amp;" },
	{ "gt;", "gt;" },
	{ "lt;", "lt;" },
	{ "fra", "frasl;" }
};

map<int, string> Solution::rkMap = Solution::initRKMap();

int main()
{
	Solution s;
	// cout << s.entityParser("x &gt; y &amp;&amp; x &lt; y is always false") << endl;
	cout << s.entityParser("and I quote: &quot;...&quot;") << endl;

	return 0;
}

