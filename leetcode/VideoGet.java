/**
 * copy mp4 from akamai
 * https://stackoverflow.com/questions/42901942/how-do-we-download-a-blob-url-video/50950602
 * 
 * record net req, sort by akamai, loop w/ 1 & append
 */

package videoget;
import java.net.*;
import java.io.*;

public class VideoGet
{
    public static void main(String[] args) throws Exception
    {
        final boolean APPEND_MODE = true;

        String video = "https://cnbcmbr-vh.akamaihd.net/i/mp4/VCPS/Y2020/M04D23/7000132979/1587655948549-200423SApatricof_MBR_,0240,0300,0500,0700,0900,1300,1700,4500,.mp4.csmil/segment##_2_av.ts?null=0";
        StringBuilder sb = new StringBuilder(video);
        int loc = sb.indexOf("##");
        
        for (int i = 10; i <= 68; i++)
        {
            String temp = Integer.toString(i);
            sb.setCharAt(loc, temp.charAt(0));
            sb.setCharAt(loc + 1, temp.charAt(1));

            URL url = new URL(sb.toString());
            URLConnection conn = url.openConnection();

            try (
                OutputStream outStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Dennis\\Desktop\\" + "myvideo.mp4", APPEND_MODE));
                InputStream is = conn.getInputStream();
            )
            {
                byte[] buf;
                int byteRead, byteWritten = 0;

                buf = new byte[1024];
                while ((byteRead = is.read(buf)) != -1)
                {
                    outStream.write(buf, 0, byteRead);
                    byteWritten += byteRead;
                }

                System.out.println(sb);
                System.out.println("write " + byteWritten + " bytes");
            }
            catch (Exception e) {e.printStackTrace();};
        }
    }
}

