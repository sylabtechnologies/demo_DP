// 01_QHEAP.cpp : https://www.hackerrank.com/challenges/qheap1/problem

int main()
{
	ifstream cin("sample.txt");
	
	set<int> s;	// set wil work identically

	int q; cin >> q;

	while (q > 0)
	{
		int type, v; cin >> type;

		switch (type)
		{
		case 1:
			cin >> v;
			s.insert(v);
			break;
		case 2:
			cin >> v;
			s.erase(s.find(v));
			break;
		case 3:
			cout << *s.begin() << endl;
			break;
		default:
			throw runtime_error("I/O error");
			break;
		}


		q++;
	}

    return 0;
}

