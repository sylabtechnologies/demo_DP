// we require:
// 1. force only one object creation
// 2. get static access -> getInstance
// 3. keep a String value (make it final through getValue/setValue?)

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