// https://www.hackerrank.com/challenges/largest-rectangle/problem

#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

long largestRectangle(const vector<int> &height)
{
    if (height.empty()) return 0;
    if (height.size() == 1) return height[0];

    stack<int> barIndices;
    long maxArea = 0;

    for (size_t i = 0; i < height.size(); i++)
    {
      while (!barIndices.empty() && height[i] <= height[barIndices.top()]) {
        size_t index = barIndices.top();
        barIndices.pop();

        size_t width = 0;
        if (!barIndices.empty())
          width = barIndices.top() + 1;

        long area = height[index] * (i - width);

        if (area > maxArea)
          maxArea = area;
      }

      barIndices.push(i);
    }

    return maxArea;
}


int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string h_temp_temp;
    getline(cin, h_temp_temp);

    vector<string> h_temp = split_string(h_temp_temp);

    vector<int> h(n + 1); h[n] = 0;

    for (int i = 0; i < n; i++) {
        int h_item = stoi(h_temp[i]);

        h[i] = h_item;
    }

    long result = largestRectangle(h);

    fout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
