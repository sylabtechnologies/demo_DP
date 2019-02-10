/* 14_avgSet.cpp : 

Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal. 
Return both parts (If exist).
If there is no solution. return an empty list.

*** dp over set size and use mutlimap

*/

typedef vector<int> IV_;
#define _R1(x) x.begin(), x.end()

auto printVecVec = [](vector< IV_> &vec) { for (auto &elem : vec) cout << elem << endl; };

vector<vector<int> > Solution::avgset(vector<int> &arr)
{
	map<int, int> arrFreq;

	auto MySum = [](IV_& vec)->int { return accumulate(vec.cbegin(), vec.cend(), 0);};

	auto MyInsert = [](IV_ &vec, int arg) { auto iterUpper = upper_bound(_R1(vec), arg); vec.insert(iterUpper, arg);};

	auto DuplicatesOK = [&arrFreq](IV_ &vec)->bool {
		for (auto elem : vec)
		{
			if (std::count(_R1(vec), elem) > arrFreq[elem])
				return false;
		}

		return true;
	};

	auto excludeSubset = [&arrFreq](IV_ &vec)->IV_ { IV_ ans;
		for (auto iter = arrFreq.begin(); iter != arrFreq.end(); ++iter) {
			int myCount = std::count(_R1(vec), iter->first);
			for (size_t i = 0; i < iter->second - myCount; i++)
				ans.push_back(iter->first);
		}
			return ans;
	};

	auto notFoundInMap = [](IV_ &vec, vector<IV_>& loc)->bool
	{
		for (auto &elem : loc)
			if (elem == vec) return false;

		return true;
	};

	vector<IV_> ans;

	sort(_R1(arr));

	// compute all frequencies
	for (size_t i = 0; i < arr.size(); i++)
		arrFreq[arr[i]]++;

	int totalSum = MySum(arr);
	size_t len = arr.size();

	for (size_t sz = 1; sz < len - 1; sz++)
	{
		int set1Size = sz;
		int stepSum = totalSum * set1Size;
		if (stepSum % len != 0) continue;
		stepSum /= len;

		unordered_map<int, vector<IV_>> sumMap;

		// dp for sum x len
		for (int i = 1; i <= stepSum; i++)
		{
			for (int j = 0; j < arr.size(); j++)
			{
				int test = i - arr[j];
				if (test < 0) continue;

				if (test == 0)
				{
					IV_ temp{ arr[j] };

					auto iter = sumMap.find(arr[j]);

					if (iter == sumMap.end())
					{
						sumMap.emplace(i, vector<IV_>());
						sumMap[i].push_back(temp);

					}
					else iter->second.push_back(temp);

					continue;
				}

				auto iter = sumMap.find(test);

				if (iter != sumMap.end())
				{
					// for each subentry
					for (auto iter2 = sumMap[test].begin(); iter2 != sumMap[test].end(); ++iter2)
					{
						IV_ mycopy = *iter2;
						MyInsert(mycopy, arr[j]);

						if (!DuplicatesOK(mycopy))
							continue;

						if (notFoundInMap(mycopy, sumMap[i]))
						{
							sumMap[i].push_back(mycopy);
						}
					
					}
				}

			}
		}

		if (sumMap[stepSum].empty()) continue;

		// test resulting vectors
		bool found = false;
		int foundSum = 0;

		// a. find sum2
		for (auto subset : sumMap[stepSum])
		{
			if (subset.empty()) continue;

			IV_ tail = excludeSubset(subset);
			int sum2 = MySum(tail);
			if (totalSum * tail.size() == sum2 * arr.size())
			{
				found = true;
				foundSum = sum2;
				break;
			}
		}

		if (!found) continue;

		// b. populate the list
		vector<IV_> result;
		for (auto subset : sumMap[stepSum])
		{
			if (totalSum - MySum(subset) != foundSum) continue;
			result.push_back(subset);
		}

		if (result.empty()) return ans;

		sort(_R1(result));
		ans.push_back(result[0]);
		IV_ tail = excludeSubset(ans[0]);
		ans.push_back(tail);
		return ans;

	}

	return ans;

}



