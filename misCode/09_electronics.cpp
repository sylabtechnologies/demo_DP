// https://www.hackerrank.com/challenges/electronics-shop/problem

#define _R1(x) x.begin(), x.end()
int getMoneySpent(vector<int> keyboards, vector<int> drives, int b) {
    sort(_R1(keyboards));
    sort(_R1(drives));

    vector<int> money;

    for (auto elem : keyboards)
    {
        if (elem >= b) break;

        for (auto elem2 : drives)
        {
            int current = elem + elem2;

            if (current > b) break;

            if (current == b) return b;

            if (current < b)
                money.push_back(current);
        }
    }

    if (money.empty())
        return -1;
    else
        return *max_element(_R1(money));

}
