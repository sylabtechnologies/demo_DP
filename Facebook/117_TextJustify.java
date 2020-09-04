// https://leetcode.com/problems/text-justification/

package textpack;
import java.util.*;

class Solution
{
    String text[];
    int width;
    
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        text = words;
        width = maxWidth;
        List<String> res = new ArrayList<>();
        
        int i = 0, currLen = 0, line = 0;
        while (i < words.length)
        {
            currLen += words[i].length() + 1;
            
            if (currLen == maxWidth + 1)
            {
                res.add(padded(line, i));
                currLen = 0;
                line = i + 1;
                i++;
            }
            else if (currLen > maxWidth + 1)
            {
                res.add(padded(line, i-1));
                currLen = 0;
                line = i;
            }
            else i++;
        }

        if (line < words.length)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = line; j < words.length; j++)
            {
                sb.append(words[j]);
                if (j != words.length - 1)
                    sb.append(' ');
            }
            
            while (sb.length() < maxWidth)
                sb.append(' ');
            res.add(sb.toString());
        }
        
        return res;
    }

    private String padded(int start, int end)
    {
        int totLen = 0;
        for (int i = start; i <=  end; i++)
            totLen += text[i].length();
        
        int free = width - totLen, count = end - start + 1;
        StringBuilder res = new StringBuilder();
        
        if (count == 1)
        {
            res = new StringBuilder(text[start]);
            while (res.length() < width)
                res.append(' ');
            return res.toString();
        }
        
        int pads[] = new int[count], curr = 0;
        while(free > 0)
        {
            pads[curr] += 1;
            free--;
            curr++;
            if (curr == count - 1) curr = 0;
        }
            
        for (int i = start; i <=  end; i++)
        {
            res.append(text[i]);
            
            if (i != end)
            {
                for (int j = 0; j < pads[i - start]; j++)
                    res.append(" ");
            }
        }

//        System.out.println(res);
        return res.toString();
    }
}

public class TextPack
{
    public static void main(String[] args)
    {
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(new Solution().fullJustify(words, 16));
    }
    
}
