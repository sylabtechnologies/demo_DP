// https://www.hackerrank.com/challenges/bomber-man/problem

package solution;

import java.math.BigDecimal;
import java.util.*;

class Location
{
    int i;
    int j;
    
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
    boolean weHaveBomb = false;
    int sec2detonate   = 0;

    public Bomb()
    {
    }

    public void plant()
    {
        weHaveBomb = true;
        sec2detonate = 3;
    }

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
    
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid)
    {
        if (grid.length == 0)
            throw new IllegalArgumentException("grid must be full");

        int c = grid[0].length();
        
        Bomb[][] game = new Bomb[grid.length][c];

        // step 0: plant bombs
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < c; j++)
            {
                game[i][j] = new Bomb();
                
                if (grid[i].charAt(j) == 'O')
                    game[i][j].plant();
            }
        }
        
        // step 1: tick existing and plant the rest
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < c; j++)
            {
                game[i][j].tick();
            }
        }
        
        // step 2: plant the rest of bombs
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (game[i][j].weHaveBomb)
                    game[i][j].tick();
                else
                    game[i][j].plant();
            }
        }
        
        // step3 - we detonate
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < c; j++)
            {
                game[i][j].tick();
                
                if (game[i][j].canDetonate())
                {
                    ArrayList<Location> adjacent = getAdjacent(grid.length, c, i,j);

                    game[i][j].weHaveBomb = false;
                    
                    for (Location loc : adjacent)
                    {
                        if (game[loc.i][loc.j].weHaveBomb)
                        {
                            if (!game[loc.i][loc.j].canDetonate())
                                game[loc.i][loc.j].weHaveBomb = false;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < grid.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < c; j++)
            {
                if (game[i][j].weHaveBomb)
                    sb.append('O');
                else
                    sb.append('.');
            }
            
            grid[i] = sb.toString();
        }

        return grid;
    }

    // make the cross
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
