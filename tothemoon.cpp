// tothemoon: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
// convert to combinatorics

#include <iostream>
#include <string>
#include <list>
#include <vector>
#include <iterator>
#include <algorithm>
#include <fstream>
#include <numeric>
using namespace std;

int ri() {
	int x; cin >> x; return x;
}

// find all pairs of n people
long all_pairs(int d)
{
	if (d <= 2)
		return 1;
	
	return all_pairs(d - 1) + d - 1;
}

typedef vector<int> Myvec;
typedef list<Myvec> Mylist;

class MyCountry
{
public:
	MyCountry();
	~MyCountry();
	void add_pair(int, int);
	long all_singles();

private:
	int _num_countries;
	int _num_people;
	Mylist _people;				// pointer to adjaceny lists
};

MyCountry::MyCountry()
{
	_num_countries = 0;
	_num_people = 0;
}

MyCountry::~MyCountry()
{
}

void MyCountry::add_pair(int x, int y)
{
	// init
	if (_people.empty())
	{
		Myvec temp;
		temp.push_back(x); temp.push_back(y);
		_people.push_back(temp);
		_num_people += 2; _num_countries++;
		return;
	}

	// find x
	for (auto iter = _people.begin(); iter != _people.end(); ++iter)
	{
		for (auto iter2 = iter->begin(); iter2 != iter->end(); ++iter2)
		{
			if (*iter2 == x)
			{
				iter->push_back(y); _num_people += 1;
				return;
			}
		}
	}

	// otherwise add new line
	Myvec temp;
	temp.push_back(x); temp.push_back(y);
	_people.push_back(temp);
	_num_people += 2; _num_countries++;
	return;
}

long MyCountry::all_singles()
{
	Myvec counts;

	// copy all sizes
	for (auto iter = _people.begin(); iter != _people.end(); ++iter)
	{
		counts.push_back(iter->size());
	}

	// count all combos
	long result = 0;
	for (auto iter = counts.begin(); iter != counts.end(); ++iter)
	{
		result += all_pairs(*iter);
	}

	return result;
}

int main()
{
	int n; int m;
	n = ri(); m = ri();

	MyCountry usa;
	for (int mypairs = 0; mypairs < m; mypairs++)
	{
		int x, y;
		x = ri(); y = ri();
		usa.add_pair(x, y);
	}
    
    if (m > 0)
	   cout << all_pairs(n) - usa.all_singles() << endl;
    else
        cout << all_pairs(n) << endl;

	return 0;
}