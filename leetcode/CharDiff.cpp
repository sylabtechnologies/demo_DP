// https://leetcode.com/problems/find-the-difference
// - bitwise dups filter 

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
    char findTheDifference(string s, string t)
    {
        char c = 0;
        
        for (auto c1 : s)
            c = c ^ c1;
        
        for (auto c1 : t)
            c = c ^ c1;
        
        return c;
    }
};
