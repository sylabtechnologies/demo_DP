package polish;
import java.util.*;

class Solution
{
    public int evalRPN(ArrayList<String> exp)
    {
        Stack<String> stk = new Stack<>();
        
        for (String elem : exp)
        {
            elem = elem.trim();
            
            boolean isOper = true, isNegative = false;
            int oper1, oper2, result = 0;
            
            if (elem.charAt(0) == '-' && elem.length() > 1)
            {
                elem = elem.substring(1);
                isNegative = true;                                
            }
            
            switch (elem.charAt(0))
            {
                case '+' :
                    oper1 = Integer.parseInt(stk.pop());
                    oper2 = Integer.parseInt(stk.pop());
                    result = oper1 + oper2;
                    break;
                    
                case '-' :
                    oper1 = Integer.parseInt(stk.pop());
                    oper2 = Integer.parseInt(stk.pop());
                    result = oper2 - oper1;
                    break;
                    
                case '*' :
                    oper1 = Integer.parseInt(stk.pop());
                    oper2 = Integer.parseInt(stk.pop());
                    result = oper1 * oper2;
                    break;
                    
                case '/' :
                    oper1 = Integer.parseInt(stk.pop());
                    oper2 = Integer.parseInt(stk.pop());
                    result = oper2 / oper1;
                    break;

                default :
                    isOper = false;
                    if (isNegative) elem = '-' + elem;
                    stk.push(elem);
            }
            
            if (isOper)
                stk.push(Integer.toString(result));
            
//            System.out.println(stk);
        }
        
        return Integer.parseInt(stk.peek());
    }
}

public class Polish
{
    public static void main(String[] args)
    {
        String arr[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+" };
        ArrayList<String> exp = new ArrayList<>(Arrays.asList(arr));
        
        System.out.println(new Solution().evalRPN(exp));
    }
}
