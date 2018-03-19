import java.rmi.*;
import java.rmi.registry.*;

public class MyServer
{
	public static void main(String args[])
	{
		try
		{
			DateRemote skel=new DateRemote();
			Naming.rebind("DateServer",skel);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
