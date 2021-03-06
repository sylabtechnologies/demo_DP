// https://www.hackerrank.com/challenges/making-anagrams/problem

#include <bits/stdc++.h>

using namespace std;

// Complete the makingAnagrams function below.
int makingAnagrams(string s1, string s2) {
  const int ABC_SIZE = 26;
  int freqCount[ABC_SIZE] = {0};

  // get freq
  for (const auto c : s1) {
    int index = static_cast<int>(c - 'a');
    freqCount[index]++;
  }

  // subtract identical
  for (auto c : s2) {
    int index = static_cast<int>(c - 'a');
    freqCount[index]--;
  }

  int ans = 0;
  for (size_t i = 0; i < ABC_SIZE; i++) {
    ans += std::abs(freqCount[i]);
  }

  return ans;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s1;
    getline(cin, s1);

    string s2;
    getline(cin, s2);

    int result = makingAnagrams(s1, s2);

    fout << result << "\n";

    fout.close();

    return 0;
}
