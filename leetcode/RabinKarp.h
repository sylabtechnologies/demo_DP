#pragma once
class RabinKarp
{
public:
	static const int HASH_LEN = 3;
	static const int ABC_SIZE = 256;

public:
	RabinKarp(const char *startAt);
	int getHash() { return currHash; };
	int move();

private:
	char *current;
	int   currHash;
	int getIndex(char c) { return (int)c; };
	static const int topR = ABC_SIZE * ABC_SIZE;
};

