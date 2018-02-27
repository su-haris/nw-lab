import java.net.*;
import java.io.*;

class FileServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(8765);
		Socket s=null;
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		OutputStream os=null;

		
			System.out.println("Waiting Client");
			try
			{
				s=ss.accept();
				System.out.println("Connection to : "+s);

				File myFile = new File ("1.txt");
				byte [] mybytearray = new byte [(int)myFile.length()];
				fis = new FileInputStream(myFile);
				bis = new BufferedInputStream(fis);
				bis.read(mybytearray,0,mybytearray.length);
				os=s.getOutputStream();
				System.out.println("Sending 1.txt " +mybytearray.length+ "bytes");
				os.write(mybytearray,0,mybytearray.length);
				os.flush();
 
				System.out.println("Done");
			}
			finally
			{
				bis.close();
				os.close();
				fis.close();
				s.close();
			}
		
	}
}
				
