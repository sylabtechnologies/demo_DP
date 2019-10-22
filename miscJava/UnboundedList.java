/**
 * https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html
 */
package objcast;
import java.util.*;

public class ObjCast {
    
    // use unbounded wildcard to virtually use proper function
    public static void printList(List<?> list)
    {
        System.out.print("[");
        boolean first = true;
        
        for (Object elem : list)
        {
            if (first)
                first = false;
            else
                System.out.print(", ");
            
            System.out.print(elem);
        }

        System.out.print("]");

    }
    
    public static void main(String[] args)
    {
        List<String> ls = Arrays.asList("one", "two", "three");
        ObjCast.printList(ls);
        System.out.println();
    }
    
}
