import java.net.*;
import java.io.*;

class TCPBiClient implements Runnable
{
	Thread t1, t2;
	Socket s;
	BufferedReader br1;
	OutputStream out;
	PrintWriter pw;
	String str1,str2;

	InputStream in;
	BufferedReader br2;
	
	TCPBiClient()
	{
		try
		{
			t1=new Thread(this);
			t2=new Thread(this);
			Socket s=new Socket("localhost",8767);
		
			br1=new BufferedReader(new InputStreamReader(System.in));
			out=s.getOutputStream();
			pw=new PrintWriter(out,true);
			in=s.getInputStream();
			br2=new BufferedReader(new InputStreamReader(in));
		
			t1.start();
			t2.start();
		}
		catch (Exception E)
		{
		}
	}

	public void run()
	{
		try
		{
			if (Thread.currentThread()==t1)
			{
				do
				{
					str1=br2.readLine();
					System.out.println("sever says"+str1);
				}
				while(!str1.equals("exit"));
				System.exit(0);
			}

			else if (Thread.currentThread()==t2)
			{
				do
				{
					System.out.println("enter your message");
					str2=br1.readLine();
					pw.println(str2);
				}
				while(!str2.equals("exit"));
				System.exit(0);
			}
		}
		catch (Exception E)
		{
		}
	}
}


class TCPBiClient1
{
	public static void main(String args[])		
	{
		TCPBiClient c=new TCPBiClient();
	}
}		
