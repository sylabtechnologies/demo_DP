package convert2bst;

import java.util.ArrayList;

class Solution
{
    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null) return null;
        
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null)
        {
            list.add(curr.val);
            curr = curr.next;
        }
        
        return list2bst(list, 0, list.size() - 1);
    }

    private TreeNode list2bst(ArrayList<Integer> list, int beg, int end)
    {
        if (beg > end) return null;
        int mid = beg + (end - beg) / 2;
        
        TreeNode root = new TreeNode(list.get(mid));
        root.left = list2bst(list, beg, mid - 1);
        root.right = list2bst(list, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums)
    {
        return list2bst(nums, 0, nums.length - 1);
    }

    private TreeNode list2bst(int[] nums, int beg, int end)
    {
        if (beg > end) return null;
        int mid = beg + (end - beg) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = list2bst(nums, beg, mid - 1);
        root.right = list2bst(nums, mid + 1, end);
        return root;
    }
}

public class Convert2BST
{
    public static void main(String[] args)
    {
        int arr[] = {-10,-3,0,5,9};
        
        ListNode lst = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++)
            lst.append(arr[i]);
        
        System.out.println(new Solution().sortedListToBST(lst));
    }
    
}
