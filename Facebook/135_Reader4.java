class Solution
{
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n)
    {
        char buf4[] = new char[4];
        int i = 1, j = 0, b4 = 0;
        
        boolean eof = false;
        for (; i <= n; i++)
        {
            if (b4 == 0)
            {
                b4 = read4(buf4);
                j = 0;
                
                if (b4 != 4) eof = true;
            }

            buf[i-1] = buf4[j];
            j++; b4--;
            
            if (b4 == 0 && eof) break;
        }
        
        return i;
    }
}
