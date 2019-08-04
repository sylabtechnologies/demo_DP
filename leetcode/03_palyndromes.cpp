// leetcode palyndromes

#include "stdafx.h"
#include <MyHeaders.h>

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
private: bool allOK{ true };

public:
	// https ://leetcode.com/problems/valid-palindrome-ii/
	bool validPalindrome(string paly)
	{
		if (paly.empty()) return true;
		if (paly.length() == 1) return true;
		return validPalindromeRecursive(paly, 0, paly.length() - 1);
	}

	// recurse, avoid cctors
	bool validPalindromeRecursive(const string &paly, int i, int j)
	{
		while (i < j)
		{
			if (paly.at(i) != paly.at(j))
			{
				if (!allOK) return false; allOK = false;

				bool ans1 = validPalindromeRecursive(paly, i+1, j);
				if (ans1) return true;
				bool ans2 = validPalindromeRecursive(paly, i, j - 1);
				if (ans2) return true;
				return false;
			}

			i++; j--;
		}

		return true;
	}

	bool isPalindrome(string s)
	{
		string paly;
		for (size_t i = 0; i < s.length(); i++)
		{
			if (isalnum(s[i]))
			{
				char c = tolower(s[i]);
				paly += c;
			}
		}

		if (paly.empty()) return true;
		if (paly.length() == 1) return true;

		for (size_t i = 0; i < paly.length() / 2; i++)
		{
			if (paly.at(i) != paly.at(paly.length() - 1 - i)) return false;
		}

		return true;
	}

	bool isPalindrome(ListNode* head)
	{
		if (head == nullptr) return true;

		IV_ allNumbers;
		ListNode *curr = head;
		while (curr != nullptr)
		{
			allNumbers.push_back(curr->val);
			curr = curr->next;
		}

		if (allNumbers.size() == 1) return true;

		for (size_t i = 0; i < allNumbers.size() / 2; i++)
		{
			if (allNumbers.at(i) != allNumbers.at(allNumbers.size() - 1 - i)) return false;
		}

		return true;
	}

	bool isPalindrome(int x)
	{
		if (x == 0) return true;

		string paly;

		if (x < 0) x = -x;

		while (x > 0)
		{
			int dig = x % 10;
			char c = '0' + dig;
			paly += c;
			x = x / 10;
		}

		if (paly.length() == 1) return true;

		for (size_t i = 0; i < paly.length() / 2; i++)
		{
			if (paly.at(i) != paly.at(paly.length() - 1 - i)) return false;
		}

		return true;
	}
};

int main()
{
	Solution sol;

	int ans;
	
	ans = sol.validPalindrome("abb");
	PRN(ans);

	ans = sol.validPalindrome("abc");
	PRN(ans);

	return 0;
}

