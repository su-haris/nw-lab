import java.rmi.*;
import java.rmi.registry.*;

public class MyServer
{
	public static void main(String args[])
	{
		try
		{
			AdderRemote skel=new AdderRemote();
			Naming.rebind("AddServer",skel);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
