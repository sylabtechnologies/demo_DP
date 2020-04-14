#include "stdafx.h"
#include "RabinKarp.h"

RabinKarp::RabinKarp(const char *startAt)
{
	current = const_cast<char*>(startAt);

	currHash = getIndex(*startAt);
	for (size_t i = 1; i < HASH_LEN; i++)
	{
		currHash *= ABC_SIZE;
		currHash += getIndex(*(startAt + i));
	}

}

int RabinKarp::move()
{
	currHash -= getIndex(*current)*topR;
	currHash *= ABC_SIZE;

	currHash += getIndex(*(current + HASH_LEN));
	current++;
	return currHash;
}
