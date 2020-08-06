// https://leetcode.com/problems/add-and-search-word-data-structure-design/
package trieregex;

class WordDictionary
{
    private TrieNode root;

    public WordDictionary()
    {
        root = new TrieNode();
    }
    
    public void addWord(String key)
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
    
    public boolean search(String word)
    {
        TrieNode pCrawl = root;
        return helper(pCrawl, word, 0);
    }
    
    public boolean helper(TrieNode pCrawl, String key, int level)
    {
        int length = key.length(); 

        for (; level < length; level++) 
        { 
            char c  = key.charAt(level);
            
            if (c == '.') return helper2(pCrawl, key, level);
            
            int ix = c - 'a';
            
            if (pCrawl.children[ix] == null) 
                    return false; 

            pCrawl = pCrawl.children[ix]; 
        } 

        return (pCrawl != null && pCrawl.isEndOfWord); 
    }

    private boolean helper2(TrieNode pCrawl, String key, int level)
    {
        boolean found = false;
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i++)
        {
            if (pCrawl.children[i] == null) continue;

            found = helper(pCrawl.children[i], key, level + 1);
            if (found) break;
        }

        return found;
    }
}

class TrieNode 
{ 
    public static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
    boolean isEndOfWord; 

    TrieNode()
    { 
        isEndOfWord = false; 
        for (int i = 0; i < ALPHABET_SIZE; i++) 
            children[i] = null; 
    } 
}; 

public class TrieRegex
{
    public static void main(String[] args)
    {
        WordDictionary wd = new WordDictionary();
        
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("dad"));

        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}
