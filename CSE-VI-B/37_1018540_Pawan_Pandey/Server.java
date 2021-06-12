import java.io.*;
import java.net.*;
public class Server
{
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket sskt = new ServerSocket(8080);
            Socket s = sskt.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
            DataInputStream dis = new DataInputStream(s.getInputStream());
			
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
            String str1="",str2="";

            while(!str1.equalsIgnoreCase("Ok,bye"))
            {
                str1 = dis.readUTF();
                System.out.println("Client Side: "+str1);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            dout.close();
            sskt.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
