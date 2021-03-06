// https://leetcode.com/problems/find-common-characters/
// adapt to intersect2 or FIND MIN FREQUENCY FOR EACH LETTER

class Solution {
public:
    vector<string> commonChars(vector<string>& A)
    {
        vector<string> res;
        
        if (A.size() == 0) return res;

        if (A.size() == 1)
        {
            for (char c: A[0])
                res.push_back(to_string(c));
            return res;
        }

        sort(A.begin(), A.end(), compareLen);

        vector<int> cmp = toIntVec(A[0]);
        for(int i = 1; i < A.size(); i++)
        {
            vector<int> next = toIntVec(A[i]);
            cmp = intersect(cmp, next);
        }

        for (int i : cmp)
        {
            char c = 'a' + i;
            string temp(1, c);
            res.push_back(temp);
        }

        return res;
    }

    vector<int> toIntVec(string s)
    {
        vector<int> res;
        for (char c : s)
            res.push_back(((int) c - 'a'));
        return res;
    }

    static bool compareLen(string s1, string s2) { return s1.length() > s2.length(); }

    vector<int> intersect(vector<int>& nums1, vector<int>& nums2)
    {
        unordered_map<int,int> map;
        vector<int> *first, *second;

        if (nums1.size() > nums2.size())
        {
            first = &nums1;
            second = &nums2;
        }
        else
        {
            first = &nums2;
            second = &nums1;
        }
            
        for (auto x : *(first)) map[x]++;
        
        vector<int> res;
        for (auto x : *(second))
        {
            auto test = map.find(x);

            if (test != map.end())
            {
                if (test->second > 1)
                {
                    res.push_back(test->first);
                    map[x]--;
                }
                else
                {
                    res.push_back(test->first);
                    map.erase(test);
                }
            }
        }
            
        return res;
    }

};
