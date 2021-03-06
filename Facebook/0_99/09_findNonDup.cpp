/* XOR WILL DO IT! **YES B/C ITS ONCE IN ARR OPPORTUNITY
   IE EACH NEXT ONE CANCELS THE PREVIOUS ONE

int Solution::singleNumber(const vector<int> &arr)
{
    if (arr.size() == 1) return arr[0];

    int result = arr[0]; 
    for (int i = 1; i < arr.size(); i++) 
        result = result ^ arr[i]; 
  
    return result; 
}

*/


int Solution::singleNumber(string A, string B, string C)
{ 
	sort(_R1(arr));
	
	int i = 0;
	int len = arr.size();

	int repeatCount = 0;

	while (i < len - 1)
	{
		if (arr[i] == arr[i + 1])
		{
			repeatCount++;
		}
		else
		{
			if (repeatCount == 0)
				return arr[i];

			repeatCount = 0;
		}

		i++;
	}

	return repeatCount == 0 ? arr[i] : -1;
} 