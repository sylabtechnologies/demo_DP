vector<int> Solution::wave(vector<int> &A)
{
    if (A.size() <= 1) return A;
    
    vector<int> ans(A.begin(), A.end());
    
    sort(ans.begin(), ans.end());
    
	for (size_t i = 0; i < ans.size() - 1; i += 2)
	{
		int temp = ans[i];
		ans[i] = ans[i + 1];
		ans[i + 1] = temp;
	}
	
    return ans;
    
}
