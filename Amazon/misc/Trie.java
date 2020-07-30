package wordbreak2;
import java.util.*;

class TrieNode 
{ 
    TrieNode[] children = new TrieNode[Trie.ALPHABET_SIZE]; 
    boolean isEndOfWord; 

    TrieNode()
    { 
        isEndOfWord = false; 
        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) 
            children[i] = null; 
    } 
}; 

public class Trie
{
    public static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }
    
    public void insert(String key)
    {
        int level; 
        int length = key.length(); 
        int index; 

        TrieNode pCrawl = root; 

        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 

            pCrawl = pCrawl.children[index]; 
        } 

        pCrawl.isEndOfWord = true; 
    }
    
    public boolean search(String key)
    {
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode pCrawl = root; 

        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 

            if (pCrawl.children[index] == null) 
                    return false; 

            pCrawl = pCrawl.children[index]; 
        } 

        return (pCrawl != null && pCrawl.isEndOfWord); 
    }
    
    public boolean startsWith(String prefix)
    {
        int level; 
        int length = prefix.length(); 
        int index; 
        TrieNode pCrawl = root; 

        for (level = 0; level < length; level++) 
        { 
            index = prefix.charAt(level) - 'a'; 

            if (pCrawl.children[index] == null) 
                    return false; 
            
            pCrawl = pCrawl.children[index]; 
        }

        return (pCrawl != null); 
    }

    public List<String> allPrefixes(String s)
    {
        ArrayList<String> keys = new ArrayList<>();
        
        TrieNode pCrawl = root; 
        for (int level = 0; level < s.length(); level++) 
        { 
            int index = s.charAt(level) - 'a'; 

            if (pCrawl.children[index] == null) break;

            pCrawl = pCrawl.children[index]; 
            if (pCrawl.isEndOfWord)
                keys.add(s.substring(0, level + 1));
        } 
        
        return (keys.isEmpty()) ? null : keys ;
    }


}


