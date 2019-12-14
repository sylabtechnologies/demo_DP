// https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
package mergeintervals;

public class Node
{
    public static enum Color {RED, BLACK};
    
    Interval interval;
    Node parent, left, right;
    int nodeMax;
    int size;       // count subtrees
    Color color;            

    Node(Interval ii)
    {
        interval = ii;
        nodeMax      = interval.end;
        color  = Color.RED;
    }

    public boolean isRed() { return color == Color.RED; }
    public boolean isBlack() { return color == Color.BLACK;}

    Node getParent(Node n)
    {
        // Note that parent is set to null for the root node.
        return n == null ? null : n.parent;
    }

    Node getGrandParent(Node n)
    {
        // Note that it will return null if this is root or child of root
        return getParent(getParent(n));
    }

    Node getSibling(Node n)
    {
        Node p = getParent(n);

        // No parent means no sibling.
        if (p == null) {
            return null;
        }

        if (n == p.left) {
            return p.right;
        } else {
            return p.left;
        }
    }

    Node getUncle(Node n)
    {
        Node p = getParent(n);

        // No parent means no uncle
        return getSibling(p);
    }

    void RotateLeft(Node n) {
        Node nnew = n.right;
        Node p = getParent(n);
        assert(nnew != null);  // Since the leaves of a red-black tree are empty,
                                    // they cannot become internal nodes.
        n.right = nnew.left;
        nnew.left = n;
        n.parent = nnew;
        // Handle other child/parent pointers.
        if (n.right != null) {
            n.right.parent = n;
        }

        // Initially n could be the root.
        if (p != null) {
            if (n == p.left) {
            p.left = nnew;
            } else if (n == p.right) {
            p.right = nnew;
            }
        }
        nnew.parent = p;
    }

    void RotateRight(Node n)
    {
        Node nnew = n.left;
        Node p = getParent(n);
        assert(nnew != null);  // Since the leaves of a red-black tree are empty,
                                    // they cannot become internal nodes.

        n.left = nnew.right;
        nnew.right = n;
        n.parent = nnew;

        // Handle other child/parent pointers.
        if (n.left != null) {
            n.left.parent = n;
        }

        // Initially n could be the root.
        if (p != null) {
            if (n == p.left) {
            p.left = nnew;
            } else if (n == p.right) {
            p.right = nnew;
            }
        }
        nnew.parent = p;
    }

}
