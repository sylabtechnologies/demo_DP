class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    void addLeft(int x) { left = new TreeNode(x); }
    void addRight(int x) { right = new TreeNode(x); }

    @Override
    public String toString() { return "[ " + val + ", " + left + ", " + right + " ]"; }
}