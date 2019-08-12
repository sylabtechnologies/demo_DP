package minstack;
import java.util.ArrayList;

public class MinStack
{
    ArrayList<Integer> stack;
    ArrayList<Integer> mins;
    int curLen = 0;
    
    int stackMin = Integer.MIN_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        mins  = new ArrayList<>();
    }
    
    public void push(int x) {
        int lastMin = 0;
        
        if (curLen == 0)
            lastMin = x;
        else
            lastMin = Math.min(x, mins.get(stack.size() - 1));
            
        stack.add(x);
        mins.add(lastMin);
        curLen++;
    }
    
    public void pop() {
        stack.remove(curLen - 1);
        mins.remove(curLen - 1);
        curLen--;
    }
    
    public int top() {
        return stack.get(curLen - 1);
    }
    
    public int getMin()
    {
        return mins.get(curLen - 1);
    }
    
    
    public static void main(String[] args)
    {
        MinStack test = new MinStack();
        
        test.push(-2);
        test.push(-0);
        test.push(-3);
        
        System.out.println(test.getMin());

        test.pop();
        System.out.println(test.top());
        System.out.println(test.getMin());


    }
    
}


