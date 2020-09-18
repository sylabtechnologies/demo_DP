// https://leetcode.com/problems/read-n-characters-given-read4/
public class Solution extends Reader4
{
    public int read(char[] buf, int n)
    {
        if (n == 0) return 0;
    
        char buf4[] = new char[4];
        int writeLen = 0, readIndex = 0, readLen = 0;

        readLen = read4(buf4);
        while ( readLen > 0 )
        {
            buf[writeLen] = buf4[readIndex];
            
            writeLen++;
            readIndex++;
            readLen--;

            if (readLen == 0)
            {
                readLen = read4(buf4);
                readIndex = 0;
            }
            
            if (writeLen == n) break;
        }
        
        return writeLen;
    }
}