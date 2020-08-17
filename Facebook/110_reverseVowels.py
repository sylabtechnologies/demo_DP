# J/R https://leetcode.com/problems/reverse-vowels-of-a-string/ got it Bedospok

class Solution:
    def reverseVowels(self, s: str) -> str:
        lst = list(s)

        i = 0
        j = len(lst) - 1
        while i < j :
            i = self.nextVowel(lst, i, 1)
            if i < 0 : break
            j = self.nextVowel(lst, j, -1)
            if j < 0 : break

            if i >= j : break
            lst[i], lst[j] = lst[j], lst[i]
            i += 1
            j -= 1

        return "".join(lst)

    def nextVowel(self, lst : List[str], i : int, step : int) -> int :
        vowels = set('aeiouAEIOU')

        while i >= 0 and i < len(lst) :
            if lst[i] in vowels : return i
            i += step

        return -1
