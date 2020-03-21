package echocompete;
import java.util.*;

/*
Amazon wants to develop a more efficient way of evaluating their top N competitors for the latest
Echo device (Alexa-enabled voice assistant). For this analysis, Amazon has developed an
automated web crawler that identifies websites where users have written reviews about
Amazon's competitors. To get a sense of the different competitors out there, Amazon wants to
review these websites to see how often a competitor is mentioned i.e. a competitor is considered
to be a strong competitor if its name occurs in more unique reviews.
Write an algorithm to help Amazon identify the top N competitors mentioned online

Input
The input to the function/method consists of five arguments -
numCompetitors, an integer representing the number of competitors for the Echo device;
topNCompetitors, is an integer representing the maximum number of competitors that Amazon
wants to identify;
competitors, a list of strings representing the competitors;
numReviews, an integer representing the number of reviews from different websites that are
identified by the automated webcrawler;
reviews, a list of strings where each element is a string that consists of space-separated words
representing user reviews.

Output
Return a list of strings representing Amazons’ top N competitors in order of most frequently
mentioned to least frequent.

*/

class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
        int numReviews, List<String> reviews)
    {
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String cmp : competitors)
            count.put(cmp, 0);
        
        for (String review : reviews)
        {
            HashSet<String> words = new HashSet<>(Arrays.asList(review.split(" ")));
            
            for (String word : words)
            {
                if (count.containsKey(word))
                {
                    int val = count.get(word);
                    count.put(word, val + 1);
//                    break;
                }
            }
        }

        MultiMap<Integer, String> res = new MultiMap<>();
        for (Map.Entry<String, Integer> el : count.entrySet())
            res.put(el.getValue(), el.getKey());

        System.out.println(res);
        
        ArrayList<Integer> res1 = res.getKeys(true);
        System.out.println(res1);
        
        int cut = 0;
        ArrayList<String> ans = new ArrayList<>();

        for (int i = res1.size() - 1; i >= 0; i--)
        {
            ArrayList<String> row = res.getRow(res1.get(i));

            for (String str : row)
            {
                ans.add(str);
                cut++;
                if (cut >= topNCompetitors)
                    return ans;
                    
            }
        }
        
        return ans;
    }
}

public class EchoCompete {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
        String[] cc = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        List<String> comp = Arrays.asList(cc);

        String[] rr = { "I love anacell Best services provided by anacell in the town",
"betacellular has great services",
"deltacellular provides much better services than betacellular",
"cetracular is worse than eurocell",
"betacellular is better than deltacellular"};
        List<String> revw = Arrays.asList(rr);
        
        System.out.println(sol.topNCompetitors(5, 2, comp, 5, revw));
    }
        
        /*        
        ArrayList<String> comp = new ArrayList<>();
        comp.add( "newshop");
        comp.add("shopnow" );
        comp.add("afshion" );
        comp.add("fashionbeats" );
        comp.add("mymarket" );
        comp.add("tcellular" );

        List<String> revw = new ArrayList<>();
        revw.add("newshop is providing good services in the city; everyone should use newshop" );
        revw.add("best services by newshop" );
        revw.add("fashionbeats has great services in the city" );
        revw.add("I am proud to have fashionbeats" );
        revw.add("mymarket has awesome services" );
        revw.add("Thanks Newshop for the quick delivery" );
        
        
    }
  
*/
}
