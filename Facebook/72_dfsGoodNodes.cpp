int result;
int limit;
void dfs(int v, int count, vector<int> &A, vector<bool> visited, vector<vector<int>> &arr)
{
    visited[v]=1;
    
    for(int child: arr[v]){
        if(visited[child]==0){
            if(A[child-1]) dfs(child, count+1, A, visited, arr);
            else dfs(child, count, A, visited, arr);
        }
    }
    if(arr[v].size()==1 && count<=limit) result++;
}
 
int Solution::solve(vector<int> &A, vector<vector<int> > &B, int C)
{
    int n=A.size();
    result=0;
    limit=C;
    vector<bool> visited(n+1, false);
    vector<vector<int>> arr(n+1);
    
    for(int i=0; i<n-1; i++){
        arr[B[i][0]].push_back(B[i][1]);
        arr[B[i][1]].push_back(B[i][0]);
    }
 
    if(A[0]==1) dfs(1, 1, A, visited, arr);
    else dfs(1, 0, A, visited, arr);
    return result;
}
