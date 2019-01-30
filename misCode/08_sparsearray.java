// https://www.hackerrank.com/challenges/sparse-arrays/problem


static int[] matchingStrings(String[] strings, String[] queries)
{
    Map<String, Integer> stringCount = new HashMap<>();

    for (String s: strings)
    {
        stringCount.put(s, stringCount.getOrDefault(s, 0) + 1);
    }

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; i++)
    {
        ans[i] = stringCount.getOrDefault(queries[i], 0);
    }
}
