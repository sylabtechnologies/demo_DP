// bomberman
// 1. we public final
// 2. we break the steps

package solution;
import java.util.*;

class Location
{
    public final int i;
    public final int j;
    
    public Location(int x, int y)
    {
        i = x; j = y;
    }
    
    @Override
    public String toString()
    {
        return new String("(" + i + ", "+ j + ")");
    }
}

class Bomb
{
    private boolean weHaveBomb = false;
    private int sec2detonate   = 0;

    public Bomb()
    {
        weHaveBomb = true;
        sec2detonate = 3;
    }

    public boolean exists() {return weHaveBomb;}
    
    public void detonate()
    {
        weHaveBomb = false;
        sec2detonate = 0;
    }
    
    
    public boolean canDetonate()
    {
        return weHaveBomb & sec2detonate == 0;
    }

    public void tick()
    {
        if (sec2detonate > 0) sec2detonate--;
    }
}

public class Solution
{
    private static String[] printGrid(Bomb[][] game, int col)
    {
        String[] grid = new String[game.length];
        
        for (int i = 0; i < game.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < col; j++)
            {
                if (game[i][j] != null)
                    sb.append('O');
                else
                    sb.append('.');
            }
            
            grid[i] = sb.toString();
        }

        return grid;
    }
    
    private static ArrayList<Location> getAdjacent(int rows, int columns, int i, int j)
    {
        ArrayList<Location> ans = new ArrayList<Location>();
        
        // ans.add(new Location(i, j));
        
        if (i > 0)
            ans.add(new Location(i-1, j));
            
        if (i < rows - 1)
            ans.add(new Location(i+1, j));
        
        if (j > 0)
            ans.add(new Location(i, j-1));
            
        if (j < columns - 1)
            ans.add(new Location(i, j + 1));
        
        // System.out.println(Arrays.toString(ans.toArray()));

        return ans;
    }
    
    private static void tickAll(Bomb[][] grid, int col)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j] != null)
                    grid[i][j].tick();
            }
        }
    }
    
    static String[] bomberMan(int n, String[] grid)
    {
        if (grid.length == 0)
            throw new IllegalArgumentException("cant use empty grid");

        int col = grid[0].length();
        
        Bomb[][] game = new Bomb[grid.length][col];

        // plant 1st batch
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i].charAt(j) == 'O')
                {
                    game[i][j] = new Bomb();
                }
            }
        }

        // s1: tick all
        n--;
        tickAll(game, col);

        while ( n > 0)
        {

            // s2: plant the rest of bombs
            n--;
            tickAll(game, col);
            for (int i = 0; i < grid.length; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (game[i][j] == null)
                        game[i][j] = new Bomb();
                }
            }
            if (n == 0) break;

            // s3 - detonate existing bombs
            n--;
            tickAll(game, col);

            ArrayList<Location> locations = new ArrayList<>();

            for (int i = 0; i < grid.length; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (game[i][j].canDetonate())
                    {
                        locations.addAll(getAdjacent(grid.length, col, i,j));
                        game[i][j] = null;
                    }
                }
            }

            for (Location loc : locations)
            {
                game[loc.i][loc.j] = null;
            }

            // if (n == 0) break;
        }
        
        // print solution
        return printGrid(game, col);
    }

    
    public static void main(String []args)
    {
        int r = 6;
        int c = 7;

        /*
        
        //Input
        Scanner sc = new Scanner(System.in);
        String[] s =new String[r];
        
        for(int i=0; i < r; i++)
        {
            s[i]=sc.next();
        }
        sc.close();
        */

        String[] s =new String[6];
        s[0] = ".......";
        s[1] = "...O...";
        s[2] = "....O..";
        s[3] = ".......";
        s[4] = "OO.....";
        s[5] = "OO.....";

        s = bomberMan(3, s);

        for(int i=0; i < r; i++)
            System.out.println(s[i]);
        
    }

}
