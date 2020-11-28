package goog25;
import java.util.*;

// https://leetcode.com/problems/design-front-middle-back-queue/
// front == back || back - 1
class FrontMiddleBackQueue
{
    LinkedList<Integer> front;
    LinkedList<Integer> back;

    public FrontMiddleBackQueue()
    {
        front = new LinkedList<>();
        back  = new LinkedList<>();
    }
    
    public void pushFront(int val)
    {
        front.addFirst(val);
    }
    
    public void pushBack(int val)
    {
        back.addLast(val);
    }
    
    public int popFront()
    {
        if (front.isEmpty() && back.isEmpty()) 
            return -1;

        if (front.isEmpty())
            front.addLast(back.removeFirst());
        
        return front.removeFirst();
    }
    
    public int popBack()
    {
        if (front.isEmpty() && back.isEmpty()) 
            return -1;

        if (back.isEmpty())
            back.addFirst(front.removeLast());
        
        return back.removeLast();
    }
    
    public void pushMiddle(int val)
    {
        int len = front.size() + back.size(), mid = len/2;
        
        while (front.size() < mid)
            front.addLast(back.removeFirst());
        
        while (back.size()  < mid)
            back.addFirst(front.removeLast());
        
        if (back.size() == front.size())
            back.addFirst(val);
        else
            front.addLast(val);
    }
    
    public int popMiddle()
    {
        if (back.isEmpty() && front.isEmpty())
            return -1;

        int len = front.size() + back.size(), mid = len/2;
        
        while (front.size() < mid)
            front.addLast(back.removeFirst());
        
        while (back.size()  < mid)
            back.addFirst(front.removeLast());
        
        if (back.size() == front.size())
            return front.removeLast();
        else
            return back.removeFirst();
    }
}

