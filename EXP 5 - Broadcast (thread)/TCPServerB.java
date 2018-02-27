import java.net.*;
import java.io.*;

class TCPServerB implements Runnable
{
		Thread t1,t2;
		ServerSocket ss;
		Socket[] s;
		OutputStream[] out;
		BufferedReader br;
		PrintWriter[] pw;
		String str2 = " ";
		int n, i;

		TCPServerB()
		{
			try
			{
				t1=new Thread(this);
				t2=new Thread(this);
				ss=new ServerSocket(8765);
				s=new Socket[20];
				out=new OutputStream[20];
				br=new BufferedReader(new InputStreamReader(System.in));
				pw=new PrintWriter[20];
				t1.start();
				t2.start();
				n=0;
			}

			catch (Exception E)
			{
			}
		}

		public void run()
		{
			try
			{
				while(true)
				{
					if(Thread.currentThread()==t1)
					{
						
						s[n]=ss.accept();
						out[n]=s[n].getOutputStream();
						pw[n]=new PrintWriter(out[n],true);
						n++;
						System.out.println("New Client added");
						System.out.println("No of clients " +n);
						
					}

				
					else if (Thread.currentThread()==t2)
					{
						
						System.out.println("enter your message");
						str2=br.readLine();
						
						for (i=0; i<n; i++)
						{
							pw[i].println(str2);
							
						}
						
						if (str2.equals("exit"))
							System.exit(0);
						
					}
				}
			}

			catch (Exception E)
			{
			}

		
		}

}

class TCPServerB1
{
	public static void main(String args[])		
	{
		TCPServerB s=new TCPServerB();
	}
}		
		

