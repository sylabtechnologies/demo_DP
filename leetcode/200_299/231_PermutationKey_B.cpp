// PermutationKey.cpp : https://leetcode.com/problems/queries-on-a-permutation-with-key/
//

#include "stdafx.h"
#include <MyHeaders.h>

class Solution {
public:
	vector<int> processQueries(vector<int>& queries, int m)
	{
		int *permutation{ new int[m]};
		for (int i = 0; i < m; i++)
			permutation[i] = i + 1;

		int count = 0;
		vector<int> result(queries.size(), -1);
		for (auto q : queries)
		{
			int inx = findpos(permutation, m, q);
			result[count++] = inx;

			for (int j = inx; j > 0; j--)
				permutation[j] = permutation[j - 1];

			permutation[0] = q;
		}

		delete[] permutation;

		return result;
	}

	int findpos(int *perm, int size, int qr)
	{
		int res = 0;
		for (size_t i = 0; i < size; i++)
		{
			if (perm[i] == qr) break;
			res++;
		}

		return res;
	}
};

int main()
{
    return 0;
}

