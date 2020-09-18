// https://leetcode.com/problems/number-of-distinct-islands/
class Solution
{
    private int[][] myGrid;
    private int nrows, ncols;    
    
    public int numDistinctIslands(int[][] grid)
    {
        myGrid = grid;
        nrows = grid.length;
        ncols = grid[0].length;
        
        ArrayList<ArrayList<Point>> islands = new ArrayList<>();
        for (int i = 0; i < nrows; i++)
        {
            for (int j = 0; j < ncols; j++)
            {
                if (grid[i][j] != 1) continue;
                
                ArrayList<Point> isle = new ArrayList<>();
                floodfill(i, j, 2, isle);
                Collections.sort(isle);
                
                islands.add(isle);
            }
        }
        
        boolean deleted[] = new boolean[islands.size()];
        int delCount = 0;
        for (int i = 0; i < islands.size(); i++)
        {
            if (deleted[i]) continue;
            
            ArrayList<Point> isle1 = islands.get(i);
            
            for (int j = i + 1; j < islands.size(); j++)
            {
                if (deleted[j]) continue;;
                
                ArrayList<Point> isle2 = islands.get(j);
                if (match(isle1, isle2))
                {
                    delCount++;
                    deleted[j] = true;
                }
            }
        }
        
        return islands.size() - delCount;
    }

    private boolean match(ArrayList<Point> one, ArrayList<Point> two)
    {
        if (one.size() != two.size()) return false;

        Point start1 = one.get(0);
        Point start2 = two.get(0);
        
        for (int i = 0; i < two.size(); i++)
        {
            Point a = one.get(i);
            Point b = two.get(i);
            
            if ( (a.y - start1.y) != (b.y - start2.y) || (a.x - start1.x) != (b.x - start2.x))
                return false;           
        }
        
        return true;
    }
    
    private void floodfill(int sr, int sc, int target, ArrayList<Point> island)
    {
        if (sr < 0 || sr >= nrows) return;
        if (sc < 0 || sc >= ncols) return;
        
        int curr = myGrid[sr][sc];

        if (curr != 1) return;
            
        myGrid[sr][sc] = target;
        island.add(new Point(sr, sc));
        
        floodfill(sr-1, sc, target, island);
        floodfill(sr+1, sc, target, island);
        floodfill(sr, sc-1, target, island);
        floodfill(sr, sc+1, target, island);
    }    

    private static class Point implements Comparable<Point>
    {
        int y, x;
        public Point(int y, int x) { this.y = y; this.x = x; }
        @Override
        public int compareTo(Point pt)
        {
            if (this.y != pt.y) return Integer.compare(this.y, pt.y);
            return Integer.compare(this.x, pt.x);
        }
    }
}

