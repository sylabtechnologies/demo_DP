// https://leetcode.com/problems/add-and-search-word-data-structure-design/
package worddic;

class WordDictionary
{
    private Trie mytrie;

    public WordDictionary()
    {
        mytrie = new Trie();
    }
    
    public void addWord(String word)
    {
        mytrie.insert(word);        
    }
    
    /** Returns if the word is in the data structure. A word could contain the
     * dot character '.' to represent any one letter. */
    public boolean search(String word)
    {
        return mytrie.search(word);
    }
}

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

class Trie
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
    
    // make recursive
    public boolean search(String key)
    {
        return searchRec(root, key);
    }
    
    public boolean searchRec(TrieNode crawl, String key)
    {
        StringBuilder prefix = new StringBuilder();
        
        int len = key.length(), i = 0;
        while (i < len)
        {
            char cc = key.charAt(i);
            if (cc == '.')
            {
                if (prefix.length() > 0)
                {
                    crawl = searchAtNode(crawl, prefix, i);
                    if (crawl == null) return false;
                }
                
                Map<Character, TrieNode> checkAll = getChildren(crawl);
                if (checkAll == null) return false;
                
                if (i == len - 1)
                {
                    for (Map.Entry<Character, TrieNode> elem : checkAll.entrySet())
                    {
                        if (elem.getValue().isEndOfWord) return true;
                    }
                    return false;
                }
                    

                boolean found = false;
                if (i > len - 2) return false;
                for (Map.Entry<Character, TrieNode> elem : checkAll.entrySet())
                {
                    found = searchRec(elem.getValue(), key.substring(i + 1));
                    if (found) return true;
                }

                return false;
            }
            else
                prefix.append(cc);
            
            i++;
        }
        
        TrieNode found = searchAtNode(crawl, prefix, len);
        return (found != null && found.isEndOfWord); 
    }

    //A#1hr 
    private TrieNode searchAtNode(TrieNode crawl, StringBuilder key, int depth)
    {
        for (int level = 0; level < depth; level++) 
        { 
            int index = key.charAt(level) - 'a'; 

            if (crawl.children[index] == null) 
                return null; 

            crawl = crawl.children[index]; 
        } 

        return crawl; 
    }

    private Map<Character, TrieNode> getChildren(TrieNode crawl)
    {
        Map<Character, TrieNode> result = new TreeMap<>();

        int cnt = 0;
        for (TrieNode node : crawl.children)
        {
            if (node != null)
                result.put( (char) (cnt + 'a'), node);
            
            cnt++;
        }
        
        if (!result.isEmpty())
        {
//            System.out.println(result);
            return result;
        }
        else
            return null;
    }
}

public class WordDic
{
    public static void main(String[] args)
    {
        WordDictionary wd = new WordDictionary();
        
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");

        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));

        wd.addWord("bat");
        
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
        

        
        
    }
    
}
