import java.net.*;
import java.io.*;

class TCPClient3
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost",8765);

		while(true)
		{
		System.out.println("1 - Client to Server");

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
		System.out.println("Enter your message");
		String str=br.readLine();
		pw.println(str);
		if (str.equals("close"))
			s.close();


		System.out.println("2 - Server to Client");

		InputStream in=s.getInputStream();
		BufferedReader br1=new BufferedReader(new InputStreamReader(in));
		String str1=br1.readLine();
		if (str1.equals("close"))
			s.close();
		System.out.println("server says:"+str1);
		}

		//s.close();
	}
}
