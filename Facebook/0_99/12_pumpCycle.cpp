int Solution::canCompleteCircuit(const vector<int> &gas, const vector<int> &cost)
{
    int start = 0;
	int end = 1;
	int tank = gas[0] - cost[0];

	while (start != end)
	{
		while (tank < 0 && start != end)
		{
			tank -= gas[start] - cost[start];
			start = (start + 1) % gas.size();

			if (start == 0)
			{
				return -1;
			}
		}

		tank += gas[end] - cost[end];

		end = (end + 1) % gas.size();

	}

    return start;
}

/*

	IV_ gas{ 684, 57, 602, 987 };
	IV_ cost{ 909, 535, 190, 976 };

	int start = 0;
	int end = 1;
	int tank = gas[0] - cost[0];

	queue<int> pumps;

	while (start != end)
	{
		while (tank < 0 && start != end)
		{
			tank -= gas[start] - cost[start];
			start = (start + 1) % gas.size();

			if (start == 0)
			{
				return -1;
			}
		}

		tank += gas[end] - cost[end];

		end = (end + 1) % gas.size();
    }

    return start;

*/