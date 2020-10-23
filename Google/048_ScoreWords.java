package goog17;

// https://leetcode.com/problems/maximum-score-words-formed-by-letters/
class Solution
{
    public int maxScoreWords(String[] words, char[] letters, int[] score)
    {
        Felem[] elems = new Felem[words.length];
        for (int i = 0; i < elems.length; i++)
            elems[i] = new Felem(words[i]);
        
        Felem top = new Felem(new String(letters));
        boolean seen[] = new boolean[words.length];
        return dfs(elems,top,seen,score);
    }

    private int dfs(Felem[] elems, Felem top, boolean[] visited, int[] scores)
    {
        int score = 0;
        
        for (int i = 0; i < visited.length; i++)
        {
            if (visited[i]) continue;
            
            if (top.canDo(elems[i]))
            {
                top.subtract(elems[i]);
                visited[i] = true;
                int nextscore = elems[i].compute(scores);

                score = Math.max(score, nextscore + dfs(elems, top, visited, scores));
                visited[i] = false;
                top.add(elems[i]);
            }
        }
        
        return score;
    }

    private static class Felem
    {
        int freq[] = new int[26];
        String word;
        
        private Felem(String word)
        {
            this.word = word;
            for (char c : word.toCharArray())
                freq[c - 'a']++;
        }

        private boolean canDo(Felem elem)
        {
            for (int i = 0; i < freq.length; i++)
                if (freq[i] < elem.freq[i]) return false;
            return true;
        }

        private void subtract(Felem elem)
        {
            for (int i = 0; i < freq.length; i++)
                freq[i] -= elem.freq[i];
        }

        private void add(Felem elem)
        {
            for (int i = 0; i < freq.length; i++)
                freq[i] += elem.freq[i];
        }

        private int compute(int[] scores)
        {
            int score = 0;
            for (int i = 0; i < freq.length; i++)
                score += freq[i]*scores[i];
            return score;
        }

        @Override
        public String toString() { return this.word; }
    }
}

public class Goog17
{
    public static void main(String[] args)
    {
        String words[] = {"dog","cat","dad","good"};
        char letters[] = {'a','a','c','d','d','d','g','o','o'};
        int score[] = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new Solution().maxScoreWords(words, letters, score));
    }
}
