/**
 * we must memoize:
 * * 
 * https://www.hackerrank.com/challenges/password-cracker/problem
 */

package passwordcracker;
import java.util.*;
import static toolz.Util.*;

public class PasswordCracker
{
    private final static Scanner scan = new Scanner(System.in);
    private static Set<String> goodSet = set();
    private static Set<Integer> goodSizes = set();
    
    private static void eliminatePasswords(List<String> passwords, String attempt)
    {
        for (String pwd : passwords)
        {
            if (attempt.contains(pwd))
            {
                goodSet.add(pwd);
                goodSizes.add(pwd.length());
            }
        }
    }

    private static List<String> getSolution(String loginAttempt, int recursionLevel)
    {
        List<String> answer = list();
        
        Integer maxSize = new Integer(loginAttempt.length());
        
        for (Integer nextSize: goodSizes)
        {
            if (nextSize > maxSize) continue;
            
            String test = loginAttempt.substring(0, nextSize);

            if (goodSet.contains(test))
            {
                if (test.length() == loginAttempt.length())
                {
                    answer.add(test);
                    break;
                }
                
                if (recursionLevel < 3000) {
                    List<String> nextSol = getSolution(loginAttempt.substring(nextSize), recursionLevel + 1);

                    if (!nextSol.isEmpty())
                    {
                        answer.add(test);
                        answer.addAll(nextSol);
                        break;
                    }
                }
            
            }
        }
        
        return answer;
    }
    
    public static String passwordCracker(List<String> passwords, String loginAttempt)
    {
        eliminatePasswords(passwords, loginAttempt);
        
        if (goodSet.isEmpty()) return "WRONG PASSWORD";
        
        List<String> sol = getSolution(loginAttempt, 0);
        
        if (sol.isEmpty()) return "WRONG PASSWORD";
        
        // writeFile("solved.txt", sol);
            
        String res = new String(sol.get(0));
        
        for (int i = 1; i < sol.size(); i++)
            res = res + " " + sol.get(i);
            
        return res;
    }
    
    public static void main(String[] args)
    {
        String[] passwords = scan.nextLine().split(" ");
        String attempt = scan.nextLine();
        
        String solved = passwordCracker(Arrays.asList(passwords), attempt);
        
        System.out.println(solved);
        
    }
    
}
