import java.util.*;

// https://leetcode.com/problems/expression-add-operators/ ALLCOMBOS
class Solution
{
    private int target;
    private boolean allZeros;
    
    List<String> addOperators(String num, int target)
    {
        this.target = target;
        
        int[] arr = new int[num.length()];
        this.allZeros = true;
        for (int i = 0; i < num.length(); i++)
        {
            arr[i] = num.charAt(i) - '0';
            if (arr[i] != 0) allZeros = false;
        }
        
        List<String> ret = new ArrayList<>();
        dfs(arr, new ArrayList<String>(), 0, ret);
        return ret;
    }

    private void dfs(int[] arr, ArrayList<String> temp, int start, List<String> res)
    {
        if (start == arr.length)
        {
            // zap unaries
            if (temp.get(0).equals("*") || temp.get(0).equals("-")) return;
            
            if (allZeros && target == 0)
            {
                if (temp.size() == 2*arr.length)
                {
                    String str = parseArr(temp, false);
                    str = str.substring(1);
                    res.add(str);
                    System.out.println(res);
                }
            }
            else if (eval(temp) == target)
            {
                String str = parseArr(temp, true);
                res.add(str);
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

            temp.add("*");
            // zap zero start
            if (arr[start] == 0) num = 0;
            temp.add(Integer.toString(num));
            dfs(arr, temp, i + 1, res);
            temp.remove(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    private int eval(ArrayList<String> temp)
    {
        LinkedList<String> elems = new LinkedList<>();
        for (int i = 0; i < temp.size(); i+=2)
        {
            String nxt = temp.get(i + 1);
            switch (temp.get(i))
            {
                case "-":
                case "+":
                    elems.add(temp.get(i));
                    elems.add(nxt);
                break;

                case "*":
                    int mul = Integer.parseInt(elems.removeLast());
                    if (mul != 0)
                        mul *= Integer.parseInt(nxt);
                    
                    elems.add(Integer.toString(mul));
                break;

                default: throw new IllegalStateException();
            }
        }
        
        int sum = 0;
        for (int i = 0; i < elems.size(); i+=2)
        {
            int sign = elems.get(i).equals("-") ? -1 : 1;
            sum += sign*Integer.parseInt(elems.get(i + 1));
        }

        return sum;
    }

    private String parseArr(ArrayList<String> str, boolean delplus)
    {
        StringBuilder sb = new StringBuilder();
        for (String s : str)
            sb.append(s);

        if (delplus && sb.charAt(0) == '+') sb.deleteCharAt(0);
        return sb.toString();
    }
}
