import java.net.*;
import java.io.*;

class TCPServer1
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(8765);
		Socket s=ss.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out=s.getOutputStream();
		PrintWriter pw=new PrintWriter(out,true);
		System.out.println("Enter your message");
		String str=br.readLine();
		pw.println(str);
		s.close();
	}
}
