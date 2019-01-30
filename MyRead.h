#pragma once

#ifdef myfile
extern std::ifstream myfile;
#endif

class MyRead
{
private:
	std::size_t _value;
	std::string _title;

public:
	MyRead(std::string s) : _title(s)
    {

#ifndef myfile
		cin >> _value;
#endif

#ifdef myfile
		if (!myfile)
			myfile >> _value;
		else
		{
			std::cout << "Cant read " << _title << endl;
			std::exit(1);
		}
#endif

    }

	MyRead(const MyRead &r)
    {
        _value = r._value;
        _title = r._title;
    }

#ifdef myfile
	~MyRead() { myfile.close(); }
#endif

	operator size_t() const { return _value; }
	std::size_t get() const { return _value; }

};
