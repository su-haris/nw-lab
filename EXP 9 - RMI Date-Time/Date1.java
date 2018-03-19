import java.rmi.*;

public interface Date1 extends Remote
{
	public String date() throws RemoteException;
}
