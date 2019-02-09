#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

using namespace std;
typedef vector<int> I_vec;

// Complete the longestCommonSubsequence function below.
// #tab it
I_vec longestCommonSubsequence(const I_vec &a, const I_vec &b)
{
  size_t m = a.size();
  size_t n = b.size();

  vector<vector<I_vec>> table;

  vector<I_vec> row;
  for (size_t i = 0; i < n + 1; i++) {
    I_vec empty;
    row.push_back(empty);
  }

  for (size_t i = 0; i < m + 1; i++) {
    table.push_back(row);
  }

  for (size_t i = 0; i < m + 1; i++) {
    for (size_t j = 0; j < n + 1; j++) {
      if (i == 0 || j == 0)
        continue;

      if (a[i - 1] == b[j - 1]) {
        // cout << "[" << i - 1 << ", " << j - 1 << "]" << endl;

        table[i][j] = table[i - 1][j - 1];
        table[i][j].push_back(a[i - 1]);

        // cout << table[i][j] << endl;
      } else {
        I_vec v1, v2;

        v1 = table[i - 1][j];
        v2 = table[i][j - 1];

        if (v1.size() > v2.size())
          table[i][j] = v1;
        else
          table[i][j] = v2;
      }
    }
  }

  return table[m][n];
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nm_temp;
    getline(cin, nm_temp);

    vector<string> nm = split_string(nm_temp);

    int n = stoi(nm[0]);

    int m = stoi(nm[1]);

    string a_temp_temp;
    getline(cin, a_temp_temp);

    vector<string> a_temp = split_string(a_temp_temp);

    vector<int> a(n);

    for (int i = 0; i < n; i++) {
        int a_item = stoi(a_temp[i]);

        a[i] = a_item;
    }

    string b_temp_temp;
    getline(cin, b_temp_temp);

    vector<string> b_temp = split_string(b_temp_temp);

    vector<int> b(m);

    for (int i = 0; i < m; i++) {
        int b_item = stoi(b_temp[i]);

        b[i] = b_item;
    }

    vector<int> result = longestCommonSubsequence(a, b);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << " ";
        }
    }

    fout << "\n";

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
