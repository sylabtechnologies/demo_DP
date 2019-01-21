#include <bits/stdc++.h>

using namespace std;

const int mySize = 6;

vector<vector<int>> hourglass(const vector<vector<int>>& arr, int y, int x)
{
    vector<vector<int>> ans;

    // set up row 1, 2, 3
    vector<int> row;
    for (size_t i = 0; i < 3; i++)
        row.push_back(arr[y][x+i]);
    ans.push_back(row);

    row.clear();
    for (size_t i = 0; i < 3; i++)
        row.push_back(0);
    row[1] = arr[y + 1][x + 1];
    ans.push_back(row);

    row.clear();
    for (size_t i = 0; i < 3; i++)
        row.push_back(arr[y+2][x + i]);
    ans.push_back(row);

    return ans;

}

void hourglassPrint(vector<vector<int>> arr)
{
    for (size_t i = 0; i < 3; i++)
    {
        for (size_t j = 0; j < 3; j++)
            cout << arr[i][j] << " ";
        
        cout << endl;
    }

}


int hourglassSum(vector<vector<int>> arr)
{
    int sum = 0;

    for (size_t i = 0; i < 3; i++)
        for (size_t j = 0; j < 3; j++)
            sum += arr[i][j];

    return sum;
}


int hourglassMax(vector<vector<int>> arr)
{
    int myMax = INT_MIN;

    for (size_t i = 0; i < mySize - 3 + 1; i++)
    {
        for (size_t j = 0; j < mySize - 3 + 1; j++)
        {
            // cout << i << " " << j << endl;
            vector<vector<int>> cut = hourglass(arr, i, j);
            // hourglassPrint(cut);

            int nextsum = hourglassSum(cut);

            if (myMax < nextsum) myMax = nextsum;
        }
    }

    return myMax;
}



int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = hourglassMax(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
