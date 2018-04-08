import java.net.*;
import java.io.*;
class server{
	public static void main(String args[]) throws Exception{
		DatagramSocket s=new DatagramSocket(6789);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		InetAddress IP=InetAddress.getByName("localhost");
		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
		String sentence;
		String message;
		do{
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              	s.receive(receivePacket);
              	sentence = new String( receivePacket.getData());
              	System.out.println("Client says : " + sentence);
              	InetAddress IPAddress = receivePacket.getAddress();
		System.out.println("Enter your message :");
		message=br.readLine();
		sendData=message.getBytes();
		DatagramPacket sendpacket=new DatagramPacket(sendData,sendData.length,IPAddress,receivePacket.getPort());
		s.send(sendpacket);
		}while(!message.equals("exit"));	
	}
}

