// https://leetcode.com/problems/remove-comments/ - fix to backtrack
package comments;
import java.util.*;

class Solution
{
    private enum MyState { open, close, none, cut};

    public List<String> removeComments(String[] src)
    {
        MyState prev = MyState.none, curr = MyState.close;
        int ind1 = 0, ind2 = 0, ind3 = 0, ind4 = 0;
        String temp = ""; StringBuilder sbtemp = null;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < src.length; i++)
        {
            System.out.println(src[i]);

            switch(prev)
            {
                case none:
                    ind1 = src[i].indexOf("/*");
                    ind2 = src[i].indexOf("//");
                    ind3 = min(ind1, ind2);
                    if (ind3 >= 0)
                    {
                        if (src[i].substring(ind3, ind3 + 2).equals("//"))
                            curr = MyState.cut;
                        else
                        {
                            curr = MyState.open;
                            sbtemp = new StringBuilder(src[i].substring(0, ind3));
                        }
                    }
                    else
                        curr = MyState.none;
                break;

                case open:
                    ind1 = src[i].indexOf("*/");
                    if (ind1 >= 0)
                    {
                        curr = MyState.close;
                        sbtemp.append(src[i].substring(ind1 + 2));
                    }
                    else
                        curr = MyState.open;
                break;
                
                default: throw new IllegalStateException();
            }

            switch(curr)
            {
                case none:
                    res.add(src[i]);
                break;
                
                case cut:
                    temp = src[i].substring(0, ind3);
                    if (temp.length() != 0) res.add(temp);
                    curr = MyState.none;
                break;
                
                case open:
                    if (prev == MyState.none)
                    {
                        temp = src[i].substring(ind3 + 2);
                        ind4 = temp.indexOf("*/");
                        if ( ind4 >= 0)
                        {
                            sbtemp.append(temp.substring(ind4 + 2));
                            if (sbtemp.length() != 0) res.add(sbtemp.toString());
                            curr = MyState.none;
                        }
                    }
                break;

                case close:
                    if (sbtemp.length() != 0) res.add(sbtemp.toString());
                    curr = MyState.none;
                break;
            }
            
            prev = curr;
        }

        return res;
    }

    private int min(int ind1, int ind2)
    {
        if (ind1 < 0 && ind2 < 0 ) return -1;
        if (ind1 < 0) return ind2;
        if (ind2 < 0) return ind1;
        return Math.min(ind1, ind2);
    }
}

public class Partition
{
    public static void main(String[] args)
    {
        String src[] = {"a/*/b//*c","blank","d/*/e*//f"};
        
        System.out.println(new Solution().removeComments(src));
    }
}

