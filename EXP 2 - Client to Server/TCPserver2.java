import java.net.*;
import java.io.*;

class TCPServer2
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(8765);
		Socket s=ss.accept();


		InputStream in=s.getInputStream();

		
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String str=br.readLine();
		System.out.println("client says:"+str);
		s.close();
	}
}
