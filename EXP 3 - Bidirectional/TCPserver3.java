import java.net.*;
import java.io.*;

class TCPServer3
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(8765);
		Socket s=ss.accept();
	
		while(true)
		{
		System.out.println("1 - Client to Server");

		InputStream in=s.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String str=br.readLine();
		if (str.equals("close"))
			s.close();
		System.out.println("client says:"+str);


		System.out.println("2 - Server to Client");

		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
		System.out.println("Enter your message");
		String str1=br1.readLine();
		pw.println(str1);
		if (str1.equals("close"))
			s.close();
		}
		//s.close();
	}
}
