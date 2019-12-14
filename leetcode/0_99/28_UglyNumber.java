package uglynumber;

public class UglyNumber {

    public static void main(String[] args)
    {
        System.out.println(isUgly(6));
    }

    public static boolean isUgly(int num)
    {
        if (num == 0 ) return false;
        if (num == 1 ) return true;
        
        if (num % 2 == 0)
        {
            if (num == 2) return true;
            return isUgly(num / 2 );
        }
        
        if (num % 3 == 0)
        {
            if (num == 3) return true;
            return isUgly(num / 3 );
        }
            
        if (num % 5 == 0)
        {
            if (num == 5) return true;
            return isUgly(num / 5 );
        }
        
        return false;
    }
    
}
