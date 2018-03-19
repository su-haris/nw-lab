import java.rmi.*;
import java.rmi.server.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;   

public class DateRemote extends UnicastRemoteObject implements Date1
{
	DateRemote() throws RemoteException 
	{
	}

	public String date() throws RemoteException
	{   
   		Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);  
                System.out.println(strDate);
		return strDate;  
	}
}
