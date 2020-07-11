package rotate;
import java.util.*;

class Solution
{
    /// construction site for https://leetcode.com/problems/rotate-image/
    public void rotate(ArrayList<ArrayList<Integer>> a)
    {
        int n = a.size();
        
        for (int circle = 0; circle < n/2; circle++)
        {
            int start = circle;
            int end = n - circle;
            Point c1 = new Point(circle, circle);
            Point c2 = new Point(end - 1, circle);
            Point c3 = new Point(end - 1, end - 1);
            Point c4 = new Point(circle, end - 1);
            
            for (int i = start; i < end - 1; i++)
            {
                ArrayList<Integer> row1 = a.get(c1.y);
                int val1 = row1.get(c1.x + i);

                ArrayList<Integer> row2 = a.get(c2.y + i);
                int val2 = row2.get(c2.x);

                ArrayList<Integer> row3 = a.get(c3.y);
                int val3 = row3.get(c3.x - i);
                
                ArrayList<Integer> row4 = a.get(c4.y - i);
                int val4 = row4.get(c4.x);

                row2.set(c2.x, val1);
                row3.set(c3.x - i, val2);
                row4.set(c4.x, val3);
                row1.set(c1.x + i, val4);
                
                System.out.println(a);
            }
        }
    }
    
    private class Point 
    {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
        @Override
        public String toString() { return x + ", " + y; }
    }
}


public class Rotate
{
    public static void main(String[] args)
    {
    int arr[][] = {{27, 35, 36, 47, 94, 133, 163, 164, 235, 253, 280, 310, 339, 352},
            {46, 72, 77, 95, 144, 149, 158, 174, 242, 243, 317, 371, 378, 386},
            {13, 14, 80, 83, 121, 157, 158, 163, 215, 220, 308, 325, 388, 397},
            {11, 38, 45, 84, 105, 132, 134, 145, 184, 219, 282, 298, 380, 381},
            {23, 27, 42, 118, 120, 139, 168, 225, 243, 271, 274, 349, 393, 395},
            {22, 27, 49, 85, 103, 167, 175, 234, 241, 258, 283, 296, 352, 385},
            {24, 78, 117, 119, 137, 147, 173, 189, 193, 216, 281, 304, 332, 358},
            {27, 71, 108, 109, 112, 133, 137, 145, 150, 171, 195, 225, 260, 336},
            {5, 56, 65, 114, 123, 200, 220, 222, 248, 264, 285, 317, 350, 367},
            {2, 20, 60, 72, 75, 130, 136, 149, 189, 254, 264, 295, 315, 349},
            {23, 35, 68, 77, 104, 129, 153, 165, 248, 253, 290, 316, 321, 394},
            {34, 127, 129, 154, 186, 202, 203, 210, 235, 269, 331, 344, 376, 387},
            {11, 98, 99, 118, 119, 183, 250, 252, 277, 280, 291, 307, 360, 368},
            {42, 74, 93, 119, 178, 186, 198, 221, 234, 295, 296, 319, 322, 335}};
    
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        for (int[] row : arr)
        {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i : row) next.add(i);
            test.add(next);
        }
        
        System.out.println("mine");
        Solution s1 = new Solution();
        s1.rotate(test);
        for (ArrayList<Integer> row : test)
            System.out.println(row);
        
//        System.out.println(test);
        
        System.out.println("not mine");
        Solution1 stst = new Solution1();
        stst.rotate(arr);
        for (int[] row : arr)
            System.out.println(Arrays.toString(row));
        
    }
    
}

/*
        ArrayList<Integer> next = new ArrayList<>();
        next.addAll(Arrays.asList(0, 1, 2)); test.add(next);
        next = new ArrayList<>();
        next.addAll(Arrays.asList(3, 4, 5)); test.add(next);
        next = new ArrayList<>();
        next.addAll(Arrays.asList(6, 7, 8)); test.add(next);
        System.out.println(test);
*/

/*
    {27, 35, 36, 47, 94, 133, 163, 164, 235, 253, 280, 310, 339, 352},
    {46, 72, 77, 95, 144, 149, 158, 174, 242, 243, 317, 371, 378, 386},
    {13, 14, 80, 83, 121, 157, 158, 163, 215, 220, 308, 325, 388, 397},
    {11, 38, 45, 84, 105, 132, 134, 145, 184, 219, 282, 298, 380, 381},
    {23, 27, 42, 118, 120, 139, 168, 225, 243, 271, 274, 349, 393, 395},
    {22, 27, 49, 85, 103, 167, 175, 234, 241, 258, 283, 296, 352, 385},
    {24, 78, 117, 119, 137, 147, 173, 189, 193, 216, 281, 304, 332, 358},
    {27, 71, 108, 109, 112, 133, 137, 145, 150, 171, 195, 225, 260, 336},
    {5, 56, 65, 114, 123, 200, 220, 222, 248, 264, 285, 317, 350, 367},
    {2, 20, 60, 72, 75, 130, 136, 149, 189, 254, 264, 295, 315, 349},
    {23, 35, 68, 77, 104, 129, 153, 165, 248, 253, 290, 316, 321, 394},
    {34, 127, 129, 154, 186, 202, 203, 210, 235, 269, 331, 344, 376, 387},
    {11, 98, 99, 118, 119, 183, 250, 252, 277, 280, 291, 307, 360, 368},
    {42, 74, 93, 119, 178, 186, 198, 221, 234, 295, 296, 319, 322, 335}};

*/