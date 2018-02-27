import java.net.*;
import java.io.*;

class FileClient
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost",8765);
		int bytesread, current=0;
		
		InputStream in = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		
			System.out.println("Connecting to Server");
			try
			{
				
				in=s.getInputStream();
				fos=new FileOutputStream("2.txt");
				bos=new BufferedOutputStream(fos);
				byte [] mybytearray = new byte [600000];
				bytesread=in.read(mybytearray,0,mybytearray.length);
				
				current=bytesread;

				do
				{
					System.out.println("Current :" +current);
					bytesread=in.read(mybytearray,current,(mybytearray.length-current));
					if(bytesread>=0) current += bytesread;
				}while(bytesread>-1);
					
				bos.write(mybytearray,0,current);
				bos.flush();
 
				System.out.println("File downloaded to 2.txt - Size -"+current"bytes");
			}
			finally
			{
				bos.close();
				in.close();
				fos.close();
				s.close();
			}
		
	}
}
