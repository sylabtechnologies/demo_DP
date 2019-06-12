// we require:
// 1. get static access getInstance
// 2. keep a String value

public class Singleton
{
    public String value;
    private static Singleton instance = null;    
    
    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        
        return instance;
    }
    
    private Singleton() {};
}