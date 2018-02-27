import java.net.*;
import java.io.*;

class TCPClient2
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost",8765);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
		System.out.println("Enter your message");
		String str=br.readLine();
		pw.println(str);
		
		s.close();
	}
}
