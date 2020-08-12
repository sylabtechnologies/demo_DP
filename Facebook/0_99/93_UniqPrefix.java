// https://www.interviewbit.com/problems/shortest-unique-prefix/

package uniqprefix;
import java.util.Arrays;

class Solution
{
    TrieNode root;
    
    public String[] prefix(String[] arr)
    {
        root = new TrieNode();
        for (String s : arr) insert(s);
        
        String res[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for (char c : arr[i].toCharArray())
            {
                sb.append(c);

                curr = curr.children[c - 'a'];
                if (curr.frequency == 1) break;
            }
            
            res[i] = sb.toString();
        }
        
        return res;
    }

    private void insert(String key)
    {
        TrieNode pCrawl = root; 
        for (int level = 0; level < key.length(); level++) 
        { 
            pCrawl.frequency++;
            int ix = key.charAt(level) - 'a';
            if (pCrawl.children[ix] == null) 
                pCrawl.children[ix] = new TrieNode(); 

            pCrawl = pCrawl.children[ix]; 
        } 

        pCrawl.isEndOfWord = true; 
    }

    private static class TrieNode
    {
        private static final int ALPHABET_SIZE = 26;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
        boolean isEndOfWord;
        int frequency;

        TrieNode()
        { 
            isEndOfWord = false; 
            frequency = 0;
        } 
    }
}

public class UniqPrefix
{
    public static void main(String[] args)
    {
        String arr[] =  {"zebra", "dog", "duck", "dove"};
        System.out.println(Arrays.toString(new Solution().prefix(arr)));
    }
}

