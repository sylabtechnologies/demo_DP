typedef vector<int> IV_;
#define _R1(x) x.begin(), x.end()

struct SumNode
{
	int sum = 0;
	int nodeId = -1;
	SumNode *combo = nullptr;		// leaf = combo
	SumNode(int id, int s = 0) : sum(s), nodeId(id) {}
	void getVec(SumNode *n, vector<int> &vec) {
		vec.push_back(n->sum);
		if (n->combo != nullptr) getVec(n->combo, vec);
	}
};

vector<vector<int> > Solution::avgset(vector<int> &arr)
{
	map<int, int> arrFreq;
	
	auto excludeSubset = [&arrFreq](IV_ &vec)->IV_ { IV_ ans;
		for (auto iter = arrFreq.begin(); iter != arrFreq.end(); ++iter) {
			int myCount = std::count(_R1(vec), iter->first);
			for (size_t i = 0; i < iter->second - myCount; i++)
				ans.push_back(iter->first);
		}
			return ans;
	};
	
	auto MySum = [](IV_& vec)->int { return accumulate(vec.cbegin(), vec.cend(), 0);};

	vector<IV_> ans;
	sort(_R1(arr));

	// compute all frequencies
	for (size_t i = 0; i < arr.size(); i++)
		arrFreq[arr[i]]++;

	int totalSum = MySum(arr);
	size_t totalSize = arr.size();

	for (size_t sz = 1; sz < totalSize - 1; sz++)
	{
		int set1Size = sz;
		int stepSum = totalSum * set1Size;
		if (stepSum % totalSize != 0) continue;
		stepSum /= totalSize;

		vector<vector<SumNode*>> dp(totalSum + 1, vector<SumNode*>());
		int currentSum = 0;

		for (size_t col = 0; col < totalSize; col++)
		{
			currentSum += arr[col];

			for (int s = 1; s <= stepSum; s++)
			{
				if (s > currentSum) continue;

				if (s == arr[col])
				{
					SumNode *addnode = new SumNode(col, s);
					dp[s].push_back(addnode);
				}

				if (s < arr[col]) continue;

				// get leafs
				if (!dp[s - arr[col]].empty())
				{
					for (auto leafnode : dp[s - arr[col]])
					{
						SumNode *addnode = new SumNode(col, arr[col]);

						// and avoid duplicate
						if (addnode->nodeId == leafnode->nodeId) continue;

						addnode->combo = leafnode;
						dp[s].push_back(addnode);
					}
				}

			}

		}

		vector<vector<IV_>> result;
		for (auto node : dp[stepSum])
		{
			IV_ vec;
			node->getVec(node, vec);

			if (vec.size() != set1Size) continue;

			IV_ tail = excludeSubset(vec);
			int sum2 = MySum(tail);
			if (totalSum * tail.size() == sum2 * arr.size())
			{
				sort(_R1(vec));
				result.push_back(vec);
			}
		}

		if (result.empty()) continue;

		sort(_R1(result));
		ans.push_back(result[0]);
		IV_ tail = excludeSubset(result[0]);
		ans.push_back(tail);
		return(ans);
	}

	return ans;
    
}

