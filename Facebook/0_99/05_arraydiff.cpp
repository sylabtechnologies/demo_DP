vector<int> Solution::diffPossible(vector<int> &num, int diff)
{
    if (num.size() < 2 || diff < 0) return false;

    int j = 0, len = num.size();
    for (int i = 0; i < len - 1; i++) {
        j = max(j, i + 1);

        // #N: keep the running total
        while (j < len && num[j] - num[i] < diff) j += 1;

        if (j < len && num[j] - num[i] == diff) return true;
    }
    return false;
}

/*
vector<int> Solution::diffPossible(vector<int> &A, int B)
{
    if (A.size() <= 1) return false;
    
    vector<int> temp(A.begin(), A.end());
    sort(temp.begin(), temp.end());

    auto start = temp.begin();
    auto end   = start + 1;
    int sum = *end - *start;

    while (end != temp.end())
    {
        if (sum == B)
            return true;
        else if (sum < B)
        {
            ++end;
            sum += *end;

        }
        else
        {
            sum -= *start;
            ++start;
            if (start == end) ++end;
        }

    }

    return false;
}
*/

