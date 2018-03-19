import java.rmi.*;

public class MyClient
{
	public static void main(String args[])
	{
		try
		{
			Adder skel=(Adder)Naming.lookup("rmi://localhost/AddServer");
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
			int c=skel.add(a,b);
			System.out.println("Sum of "+a+" and "+b+" is "+c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
