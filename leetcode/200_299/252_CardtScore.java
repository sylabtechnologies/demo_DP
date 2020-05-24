// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution
{
    public int maxScore(int[] cardPoints, int pivot)
    {
        int len = cardPoints.length;
        if (len == 1) return cardPoints[0];
        if (pivot >= len) return getSum(cardPoints, 0, len);
        
        int leftSum = 0, rghtSum = getSum(cardPoints, len - pivot, len);
        int max = rghtSum;
        
        for (int i = 0; i < pivot; i++)
        {
            leftSum += cardPoints[i];
            rghtSum -= cardPoints[len - pivot + i];
            max = Math.max(max, leftSum + rghtSum);
        }

        return max;
    }
    
    private int getSum(int[] cards, int beg, int end)
    {
        int res = 0;
        for (int i = beg; i < end; i++)
            res += cards[i];
        return res;
    }
}
