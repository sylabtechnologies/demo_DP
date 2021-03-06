// Prototype stream search w/ circular buffer and hash filters
//

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
using std::string;
using std::ifstream;

class CircularBuffer		// keep lat N characters here
{
public:
    CircularBuffer(size_t);
	~CircularBuffer();
	char front() { return _buffer[_currentPos]; }
	void fill(char);
	void update(char);
	bool compare(const string&);
	void print();

private:
	char *_buffer;
	size_t _size;
	size_t _currentPos;
	bool _ready;
};

CircularBuffer::CircularBuffer(size_t size) : _size(size), _currentPos(0), _ready(false)
{
	_buffer = new char[size];
}

CircularBuffer::~CircularBuffer()
{
	delete _buffer;
}

void CircularBuffer::fill(char c)
{
	if (_ready)
		throw std::runtime_error("Cant initialize CircularBuffer");

	_buffer[_currentPos] = c;
	_currentPos++;

	if (_currentPos == _size)
	{
		_ready = true;
		_currentPos = 0;
	}
}

void CircularBuffer::update(char c)
{
	if (!_ready)
		throw std::runtime_error("Cant initialize CircularBuffer");

	_buffer[_currentPos] = c;

	_currentPos++;
	if (_currentPos == _size)
		_currentPos = 0;

}

bool CircularBuffer::compare(const string &str)
{
	size_t seek = _currentPos, i = 0;

	while (i < str.length())
	{
		if (str[i] != _buffer[seek])
			return false;

		i++;
		seek++;

		if (seek == _size) seek = 0;
	}

	return true;
}

void CircularBuffer::print()
{
	size_t seek = _currentPos, i = 0;

	while (i < _size)
	{
		std::cout << _buffer[seek];

		i++;
		seek++;

		if (seek == _size) seek = 0;
	}

	std::cout << std::endl;

}



class StreamSearch
{
public:
	static const int npos = -1;
	StreamSearch(const string&, std::istream&);
	bool valid();
	int nextString();

private:
	string _match;
	size_t _size;
	int _lastHashSum;
	int _currentPos;
	std::istream *_streamPtr;
	CircularBuffer _buffer;
	int _hash2Seek;
	bool _isStreamValid;
private:
	int myHash() { return _lastHashSum % 26; }
};

StreamSearch::StreamSearch(const string& str, std::istream &is = std::cin)
	: _match(str), _streamPtr(&is), _currentPos(0), _lastHashSum(0), _isStreamValid(false), _size(str.length()), _buffer(_size)
{
	char c;
	int count = _match.length();
	
	for (size_t i = 0; is.good() && i < count; i++)
	{
		is >> c;
		_buffer.fill(c);
		_lastHashSum += c;
	}

	// return invalid state
	if (count != _size) return;

	_hash2Seek = myHash();
	_isStreamValid = true;

	return;
};

int StreamSearch::nextString()
{
	if (!_isStreamValid)
		throw std::runtime_error("Cant initialize StreamSearch");

	char ch;
	size_t _pos = 0;
	int result = StreamSearch::npos;

	do
	{
		if (myHash() == _hash2Seek)
		{
			if (_buffer.compare(_match))
			{
				_currentPos = (_currentPos + _pos) % _size;
				result = _currentPos;
				found = true;
			}
		}

		_streamPtr->get(ch);
		_lastHashSum = ch - _buffer.front();
		_buffer.update(ch);
		_pos++;

	} while (!found && _streamPtr->good());

	return result;
}

bool StreamSearch::valid()
{ 
	if (!_isStreamValid) return false;
	return _streamPtr->good();
}



int main()
{
	ifstream ifs("sample.txt");

	StreamSearch search("abc", ifs);

	while (search.valid())
	{
		std::cout << search.nextString() << std::endl;
	}

    return 0;
}

