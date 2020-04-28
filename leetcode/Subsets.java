// // https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
// https://leetcode.com/problems/subsets/
package lettercase;
import java.util.*;

public class Subsets
{
    public List<List<Integer>> listOfSubsets;

    public Subsets(int[] nums)
    {
        this.listOfSubsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(listOfSubsets, new ArrayList<>(), nums, 0);
    }

    public Subsets(ArrayList<Integer> nums)
    {
        this(nums.stream().mapToInt(i -> i).toArray());
    }
    
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start)
    {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
