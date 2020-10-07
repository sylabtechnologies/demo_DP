import java.util.*;

// https://leetcode.com/problems/expression-add-operators/
class Solution
{
    private int target;
    
    List<String> exprOperators(String num, int target)
    {
        this.target = target;
        
        int[] arr = new int[num.length()];
        int cnt = 0;
        for (char c : num.toCharArray())
            arr[cnt++] = c - '0';
        
        List<String> ret = new ArrayList<>();
        dfs(arr, new ArrayList<String>(), 0, ret);
        return ret;
    }

    private void dfs(int[] arr, ArrayList<String> temp, int start, List<String> res)
    {
        if (start == arr.length)
        {
            if (eval(temp) == target)
            {
                StringBuilder sb = new StringBuilder();
                for (String s : temp)
                    sb.append(s);
                
                if (sb.charAt(0) == '+')
                    sb.deleteCharAt(0);
                
                res.add(sb.toString());
            }

            return;
        }
        
        for (int i = start; i < arr.length; i++)
        {
            int num = arr[start];
            for (int j = start + 1; j < i + 1; j++)
            {
                num *= 10;
                num += arr[j];
            }
            
            temp.add("+");
            temp.add(Integer.toString(num));
            dfs(arr, temp, i + 1, res);
            temp.remove(temp.size() - 1);
            temp.remove(temp.size() - 1);
            
            temp.add("-");
            temp.add(Integer.toString(num));
            dfs(arr, temp, i + 1, res);
            temp.remove(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    private int eval(ArrayList<String> temp)
    {
        int sum = 0;
        for (int i = 0; i < temp.size(); i+=2)
        {
            int sign = temp.get(i).equals("-") ? -1 : 1;
            sum += sign*Integer.parseInt(temp.get(i + 1));
        }

        return sum;
    }
}
