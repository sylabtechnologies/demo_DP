// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution
{
public:
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
