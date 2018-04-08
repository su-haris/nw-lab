import java.net.*;
import java.io.*;
class client{
	public static void main(String args[]) throws Exception{
		DatagramSocket s=new DatagramSocket();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		InetAddress IP=InetAddress.getByName("localhost");
		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
		String sentence;
		String message;
		do{
		System.out.println("Enter your message :");
		message=br.readLine();
		sendData=message.getBytes();
		DatagramPacket sendpacket=new DatagramPacket(sendData,sendData.length,IP,6789);
		s.send(sendpacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              	s.receive(receivePacket);
              	sentence =new String(receivePacket.getData());
              	System.out.println("Server says : " + sentence);
              	InetAddress IPAddress = receivePacket.getAddress();
		}while(!message.equals("exit"));
	}
}
