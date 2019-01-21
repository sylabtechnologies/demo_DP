// assume binary tree struc
// B#C# - https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_r=next-challenge&h_v=legacy

public class Node
{
    public Node left;
    public Node right;
    public Data data;

    // ctor
    public Node (Data data)
    {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public void insert(Data value)
    {
        // if value <= data
        if (value.CompareTo(data) <= 0)
        {
            if (left == null)
                left = new Node(value);
            else
                left.insert(value);
        }
        else
        {
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);
        }
    }

    public boolean contains(Data value)
    {
        if (value.equals(data)) return true;

        if (value.CompareTo(data) < 0)
        {
            if (left == null) return false;

            return left.contains(value);
        }

        if (right == null) return false;

        return right.contains(value);
    }

}

// #HL#T - under cursor all token
