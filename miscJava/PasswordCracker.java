/** add memoization, add bloom filters?
 * https://www.hackerrank.com/challenges/password-cracker/problem
 */
package passwordcracker;
import java.util.*;

public class PasswordCracker
{
    private final static Scanner scan = new Scanner(System.in);
    private static Set<String> goodSet = new HashSet<>();
    private static Set<Integer> goodSizes = new HashSet<>();

    private static void eliminatePasswords(List<String> passwords, String attempt)
    {
        for (String pwd : passwords)
        {
            if (attempt.indexOf(pwd) >= 0)
            {
                goodSet.add(pwd);
                goodSizes.add(pwd.length());
            }
        }
    }

    private static List<String> getSolution(String loginAttempt)
    {
        List<String> answer = new ArrayList<>();
        
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

                List<String> nextSol = getSolution(loginAttempt.substring(nextSize));

                if (!nextSol.isEmpty())
                {
                    answer.add(test);
                    answer.addAll(nextSol);
                    break;
                }
            
            }
        }
        
        return answer;
    }
    
    public static String passwordCracker(List<String> passwords, String loginAttempt)
    {
        eliminatePasswords(passwords, loginAttempt);
        
        if (goodSet.isEmpty()) return "WRONG PASSWORD";
        
        List<String> sol = getSolution(loginAttempt);
        
        if (sol.isEmpty()) return "WRONG PASSWORD";
            
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
