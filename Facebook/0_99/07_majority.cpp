/*
If we cancel out each occurrence of an element e with all the other elements that are different
from e then e will exist till end if it is a majority element. Loop through each
element and maintains a count of the element that has the potential of being the majority element.
If next element is same then increments the count, otherwise decrements the count.
If the count reaches 0 then update the potential index to the current element and reset count to 1.
*/


class Solution {
    public:
        int majorityElement(vector<int> &num) {
            int majorityIndex = 0;
            for (int count = 1, i = 1; i < num.size(); i++) {
                num[majorityIndex] == num[i] ? count++ : count--;
                if (count == 0) {
                    majorityIndex = i;
                    count = 1;
                }
            }

            return num[majorityIndex];
        }
};


/*

int Solution::majorityElement(const vector<int> &arr)
{
    int len = arr.size();
    if (len == 1) return arr[0];

    unordered_map<int, int> freq;
    int maxFreq = 0;
    int maxFreqNum = 0;

    for (auto num : arr)
    {
        freq[num]++;
        if (freq[num] > maxFreq)
        {
            maxFreq = freq[num];
            maxFreqNum = num;
        }
    }

    return maxFreqNum;
    
}

*/