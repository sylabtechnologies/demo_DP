package goog30;
import java.util.*;

public class Goog30
{
    public static void main(String[] args)
    {

//        System.out.println(getParamsTypes(Solution.class));

          
    }

    // https://stackoverflow.com/questions/21455403/how-to-get-method-parameter-names-in-java-8-using-reflection
    // ret on first pucling method
    private static ArrayList<String> getParamsTypes(Class<?> cls)
    {
        ArrayList<String> ret = new ArrayList<>();
        
        for (Method m : cls.getDeclaredMethods())
        {
            if (m.getModifiers() != 1) continue;
            
            for (Class<?> type : m.getParameterTypes())
                ret.add(type.getCanonicalName());
            
            break;
        }
        
        return ret;
    }
}
