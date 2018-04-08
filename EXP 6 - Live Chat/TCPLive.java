import java.net.*;
import java.io.*;

class TCPLive implements Runnable
{
		Thread t1,t2;
		Thread[] t;
		ServerSocket ss;
		Socket[] s;
		OutputStream[] out;
		InputStream[] in;
		//BufferedReader br;
		BufferedReader[] br2;
		PrintWriter[] pw;
		String str2 = " ";
		int n, i;

		TCPLive()
		{
			try
			{
				t1=new Thread(this);
				ss=new ServerSocket(8765);
				s=new Socket[20];
				t=new Thread[20];
				out=new OutputStream[20];
				in=new InputStream[20];
				br=new BufferedReader(new InputStreamReader(System.in));
				br2=new BufferedReader[20];
				pw=new PrintWriter[20];


				n=0;

				while(true)
				{
						s[n]=ss.accept();
						out[n]=s[n].getOutputStream();
						in[n]=s[n].getInputStream();
						br2[n]=new BufferedReader(new InputStreamReader(in[n]));
						pw[n]=new PrintWriter(out[n],true);
						t[n]=new Thread(this);
						t[n].start();
						n++;
						System.out.println("New Client added");
						System.out.println("No of clients " +n);

				}

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
					int k;


					for(k=0;k<n;k++)
					{
						if (Thread.currentThread()==t[k])
						{

							str2=br2[k].readLine();
							for (i=0; i<n; i++)
							{
								if (i!=k)
									pw[i].println("Client"+k+" says "+str2);

							}

							if (str2.equals("exit"))
								System.exit(0);

						}
					}
				}
			}

			catch (Exception E)
			{
			}


		}

}

class TCPLive1
{
	public static void main(String args[])
	{
		TCPLive s=new TCPLive();
	}
}
