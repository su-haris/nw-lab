import java.net.*;
import java.io.*;

class TCPServerB
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(8766);
		Socket[] s=new Socket[20];
		OutputStream[] out=new OutputStream[20];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter[] pw=new PrintWriter[20];
		for(int i=0;i<3;i++)
		{	s[i]=ss.accept();
			out[i]=s[i].getOutputStream();
			pw[i]=new PrintWriter(out[i],true);
		}
		
		System.out.println("Enter Your message:");
		String str=br.readLine();
		for(int i=0;i<3;i++)
		{	
			pw[i].println(str);
			s[i].close();
		}
		
	}
}
		

