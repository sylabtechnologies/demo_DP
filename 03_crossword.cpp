#include <bits/stdc++.h>

using namespace std;

#define WHITE    '-'
#define BLACK    '+'

// aggregate!
struct CwdPlace { size_t row; size_t start;  size_t length; };

void findCwdPlace(string line, size_t rowIndex, vector<CwdPlace>& hplace)
{
    size_t i = 0;
    while (i < line.length())
    {
        if (line[i] == WHITE)
        {
            if (i < line.length() - 1 && line[i + 1] == WHITE)
            {
                size_t i1 = i + 1;
                while (i1 < line.length())
                {
                    if (line[i1] != WHITE) break;
                    i1++;
                }

                size_t len = (i1 == line.length()) ? (line.length() - i) : (i1 - i);
                
                CwdPlace newPlc{ rowIndex, i, len };
                hplace.push_back(newPlc);

                i = (i1 == string::npos) ? line.length() : i + i1;
            }
        }

        i++;
    }

}

vector<string> flipCwd(const vector<string> &cwd)
{
    vector<string> vcopy;

    for (size_t col = 0; col < cwd[0].length(); col++)
    {
        string column;
        for (size_t row = 0; row < cwd.size(); row++)
            column += cwd[row][col];

        vcopy.push_back(column);
    }

    return vcopy;
}

vector<string> mySolution;
bool IHaveSolved = false;;

bool testCwd(const vector<string>& cwd, const vector<string>& puzzle)
{
    vector<string> hcopy(cwd);
    vector<string> vcopy = flipCwd(cwd);

    vector<CwdPlace> hplace;
    for (size_t i = 0; i < hcopy.size(); i++)
    {
        findCwdPlace(hcopy[i], i, hplace);
    }

    vector<CwdPlace> vplace;
    for (size_t i = 0; i < vcopy.size(); i++)
    {
        findCwdPlace(vcopy[i], i, vplace);
    }

    // test h length
    for (size_t i = 0; i < hplace.size(); i++)
        if (puzzle[i].length() != hplace[i].length)
            return false;

    // test v length
    for (size_t i = 0; i < vplace.size(); i++)
        if (puzzle[i + hplace.size()].length() != vplace[i].length)
            return false;

    // write h rows
    for (size_t i = 0; i < hplace.size(); i++)
        for (size_t j = 0; j < hplace[i].length; j++)
            hcopy[hplace[i].row][j + hplace[i].start] = puzzle[i][j];

    // cross test v rows
    vcopy = flipCwd(hcopy);
    for (size_t i = 0; i < vplace.size(); i++)
        for (size_t j = 0; j < vplace[i].length; j++)
        {
            char &curr = vcopy[vplace[i].row][j + vplace[i].start];
            if (curr == WHITE)
                curr = puzzle[hplace.size() + i][j];
            else
                if (curr != puzzle[hplace.size() + i][j]) return false;
        }

    vector<string> ans = flipCwd(vcopy);

    for (auto s : ans)
        mySolution.push_back(s);
 
    IHaveSolved = true;
    return true;
}


void testPermutations(const vector<string>& cwd, vector<string> puzzle, size_t whereAt)
{
    if (IHaveSolved) return;

    // #N
    if (whereAt == puzzle.size())
    {

        if (testCwd(cwd, puzzle))
        {
            IHaveSolved = true;
            return;
        }
    }

    vector<string> myVersions(puzzle.begin() + whereAt, puzzle.end());

    for (string s : myVersions)
    {
        vector<string> nextPuzzle(puzzle.begin(), puzzle.begin() + whereAt);
        nextPuzzle.push_back(s);

        for (auto it = puzzle.begin() + whereAt; it != puzzle.end(); it++)
        {
            if (*it == s) continue;

            nextPuzzle.push_back(*it);
        }

        testPermutations(cwd, nextPuzzle, whereAt + 1);
    }

}

vector<string> crosswordPuzzle(vector<string> crossword, string words)
{
    std::replace(words.begin(), words.end(), ';', ' ');
    istringstream strm(words);

    string token;
    vector<string> puzzle;
    while (strm >> token)
    {
        puzzle.push_back(token);
    }

    testPermutations(crossword, puzzle, 0);

    return mySolution;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<string> crossword(10);

    for (int i = 0; i < 10; i++) {
        string crossword_item;
        getline(cin, crossword_item);

        crossword[i] = crossword_item;
    }

    string words;
    getline(cin, words);

    vector<string> result = crosswordPuzzle(crossword, words);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}
