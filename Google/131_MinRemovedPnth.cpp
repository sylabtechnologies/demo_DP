// MinRemParenth.cpp : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
/// #S = keep balanced stack

#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;

class Solution
{
typedef pair<size_t, char> Pair;
typedef stack<Pair> Stack;
typedef vector<char> Vector;

public:
    string minRemoveToMakeValid(string s)
    {
        int balance = 0;
        Vector vect; Stack mothball;

        for (size_t i = 0; i < s.length(); i++)
        {
            char c = s[i];
            if (c == ')')
            {
                if (balance > 0)    // demothball
                {
                    if (mothball.top().second == '(')
                    {
                        balance--;
                        auto p = mothball.top(); mothball.pop();
                        vect[p.first] = p.second;
                    }
                }
                else
                    c = ' ';        // skip 4vr
            }
            else if (c == '(')
            {
                balance++;          // mothball
                mothball.push(Pair{ i, c });
                c = ' ';
            }

            vect.push_back(c);
        }

        string ret;
        for (auto c : vect)
        {
            if (c != ' ')
                ret.push_back(c);
        }

        return ret;
    }
};

int main()
{
    Solution s;
    std::cout << s.minRemoveToMakeValid("))((") << endl;
}
