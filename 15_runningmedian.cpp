// 03_runningmedian.cpp : https://www.hackerrank.com/challenges/find-the-running-median/problem
//

vector<double> runningMedian(const vector<int> &a)
{
	vector<double> ans;

	if (a.empty()) return ans;

	priority_queue<int, vector<int>, greater<int>> minHeap;
	priority_queue<int> maxHeap;

	for (size_t i = 0; i < a.size(); i++)
	{
		if (maxHeap.empty())
		{
			maxHeap.push(a[i]);
		}
		else if (maxHeap.size() == minHeap.size())
		{
			if (a[i] < minHeap.top())
			{
				maxHeap.push(a[i]);
			}
			else
			{
				minHeap.push(a[i]);
				int minTop = minHeap.top(); minHeap.pop();
				maxHeap.push(minTop);
			}
		}
		else if (maxHeap.size() > minHeap.size())
		{
			if (a[i] > maxHeap.top())
			{
				minHeap.push(a[i]);

			}
			else
			{
				maxHeap.push(a[i]);
				int maxTop = maxHeap.top(); maxHeap.pop();
				minHeap.push(maxTop);
			}
		}

		double median = 0;

		if (maxHeap.empty())
			;
		else if (maxHeap.size() == minHeap.size())
			median = (maxHeap.top() + minHeap.top()) / 2.0;
		else
			median = maxHeap.top();

		ans.push_back(median);
	}

	return ans;
}


