package goog25;
import java.util.*;

// Design a queue that supports push and pop operations in the front, middle, and back
// front == back || back - 1
class FrontMiddleBackQueue
{
    private LinkedList<Integer> front;
    private LinkedList<Integer> back;

    public FrontMiddleBackQueue()
    {
        front = new LinkedList<>();
        back  = new LinkedList<>();
    }
    
    public void pushFront(int val)
    {
        front.addFirst(val);

        if (front.size() > back.size())
            back.addFirst(front.removeLast());
    }
    
    public void pushMiddle(int val)
    {
        if (front.size() == back.size())
            back.addFirst(val);
        else
            front.addLast(val);
        
        System.out.println(front + " : " + back);
    }
    
    public void pushBack(int val)
    {
        if (front.size() == back.size() - 1)
            front.addLast(back.removeFirst());

        back.addLast(val);
    }
    
    public int popFront()
    {
        if (front.isEmpty())
            return back.isEmpty() ? -1 : back.removeFirst();

        if (back.size() > front.size())
            front.addLast(back.removeFirst());
        
        return front.removeFirst();
    }
    
    public int popBack()
    {
        if (front.isEmpty() && back.isEmpty())
            return -1;
        
        if (front.size() == back.size())
            back.addFirst(front.removeLast());
        
        return back.removeLast();
    }
    
    public int popMiddle()
    {
        if (back.isEmpty() && front.isEmpty())
            return -1;

        if (front.size() == back.size())
            return front.removeLast();

        return back.removeFirst();
    }
}


