import java.net.*;
import java.io.*;

class TCPClient1
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost",8765);
		InputStream in=s.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String str=br.readLine();
		System.out.println("server says:"+str);
		s.close();
	}
}
