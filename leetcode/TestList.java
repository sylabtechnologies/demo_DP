package maxfreqstack;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

class TestList
{
    String oper[];
    int test[];

    TestList() throws IOException
    {
        Path path = Paths.get("C:\\Users\\Dennis\\Desktop\\SPRING\\30days\\MaxFreqStack\\test\\testfile");
        System.out.println(path.getParent());
        
        List<String> lines = Files.readAllLines(path);
        
        oper = lines.get(0).split(",");
        int count = 0;
        for (String str : oper)
        {
            str = str.trim();
            oper[count++] = str.substring(1, str.length() - 1);
        }
        
        test = new int[oper.length];
        count = 0;
        String val[] = lines.get(1).split(",");
        for (String str : val)
        {
            if (oper[count].equals("push"))
            {
                str = str.trim();
                str = str.substring(1, str.length() - 1);
                test[count] = Integer.parseInt(str);
            }
            
            count++;
        }
        
        if (count != oper.length) throw new IllegalArgumentException("bad file");
    }
    
}
