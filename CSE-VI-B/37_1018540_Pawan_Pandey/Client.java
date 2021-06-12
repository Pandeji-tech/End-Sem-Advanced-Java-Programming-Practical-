import java.io.*;
import java.net.*;
public class Client
{
    public static void main(String[] args) 
    {
        try
        {
            Socket s = new Socket("169.254.74.24",8080);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str1="",str2="";
            while(!str1.equalsIgnoreCase("ok,bye"))
            {
                str1 = br.readLine();
                dout.writeUTF(str1);
                dout.flush();
                str2 = dis.readUTF();
                System.out.println("Server side: "+str2);
            }
            dout.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
