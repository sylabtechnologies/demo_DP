// https://www.hackerrank.com/challenges/equal-stacks/problem

#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

typedef vector<int> IV_;

void pushAll(const IV_ &cyl, stack<long> &stk) {
  long currH = 0;

  for (auto iter = cyl.crbegin(); iter != cyl.crend(); ++iter) {
    currH += *iter;
    stk.push(currH);
  }
}

int equalStacks(const IV_ &cyl1, const IV_ &cyl2, const IV_ &cyl3) {
  stack<long> h1, h2, h3;

  pushAll(cyl1, h1);
  pushAll(cyl2, h2);
  pushAll(cyl3, h3);

  int cntr = 0;

  while (true) {
    long curh1 = 0;
    if (!h1.empty())
      curh1 = h1.top();
    long curh2 = 0;
    if (!h2.empty())
      curh2 = h2.top();
    long curh3 = 0;
    if (!h3.empty())
      curh3 = h3.top();
    cout << curh1 << " " << curh2 << " " << curh3 << endl;

    long diff1 = std::abs(curh1 - curh2);
    long diff2 = std::abs(curh2 - curh3);

    if (diff1 == 0 && diff2 == 0)
      break;

    else if (diff1 > diff2) {
      if (curh1 < curh2)
        h2.pop();
      else
        h1.pop();
    }

    else {
      if (curh2 < curh3)
        h3.pop();
      else
        h2.pop();
    }

    cntr++;
  }

  return h1.empty() ? 0 : h1.top();
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n1N2N3_temp;
    getline(cin, n1N2N3_temp);

    vector<string> n1N2N3 = split_string(n1N2N3_temp);

    int n1 = stoi(n1N2N3[0]);

    int n2 = stoi(n1N2N3[1]);

    int n3 = stoi(n1N2N3[2]);

    string h1_temp_temp;
    getline(cin, h1_temp_temp);

    vector<string> h1_temp = split_string(h1_temp_temp);

    vector<int> h1(n1);

    for (int h1_itr = 0; h1_itr < n1; h1_itr++) {
        int h1_item = stoi(h1_temp[h1_itr]);

        h1[h1_itr] = h1_item;
    }

    string h2_temp_temp;
    getline(cin, h2_temp_temp);

    vector<string> h2_temp = split_string(h2_temp_temp);

    vector<int> h2(n2);

    for (int h2_itr = 0; h2_itr < n2; h2_itr++) {
        int h2_item = stoi(h2_temp[h2_itr]);

        h2[h2_itr] = h2_item;
    }

    string h3_temp_temp;
    getline(cin, h3_temp_temp);

    vector<string> h3_temp = split_string(h3_temp_temp);

    vector<int> h3(n3);

    for (int h3_itr = 0; h3_itr < n3; h3_itr++) {
        int h3_item = stoi(h3_temp[h3_itr]);

        h3[h3_itr] = h3_item;
    }

    int result = equalStacks(h1, h2, h3);

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
