package toolz;
import java.io.*;
import java.util.*;

public class Util
{
    public static <K,V> Map<K,V> map() {
        return new HashMap<K,V>();
    }
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }
    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }
    public static <T> Set<T> set() {
        return new HashSet<T>();
    }	
    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }
    
    public static <T> void printList(List<T> list)
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

    public static List<String> readFile(String fname)
    {
        return readFile(new File(fname));
    }

    public static List<String> readFile(File ff)
    {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ff));)
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                lines.add(line);

            bufferedReader.close();
        }
        catch (Exception ex)
        {
            System.out.println("Util.readFile " + ff.getName());
            // System.out.println("error " + ex.getMessage());
            ex.printStackTrace();
        }

        return lines;
    }
 
    
    public static void writeFile(String location, List<String> lineList)
    {
        try
        {
            // System.out.println("Write to " + location);
            FileWriter writer = new FileWriter(location);
            Writer outp = new BufferedWriter(writer);
            
            for (String s : lineList)
                outp.write(s + "\n");
            
            outp.close();
        }
        catch (Exception ex)
        {
            System.out.println("Util.writeFile " + location);
            ex.printStackTrace();
        }
        
    }
    
}
