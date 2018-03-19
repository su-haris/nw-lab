import java.rmi.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class MyClient
{
	public static void main(String args[])
	{
		try
		{
			Date1 skel=(Date1)Naming.lookup("rmi://localhost/DateServer");
			skel.date();
			String datecur = skel.date();
			System.out.println(datecur);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
