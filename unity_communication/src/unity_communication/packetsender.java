package unity_communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class packetsender  {

	 String message;
	 String message2;
	 byte[] data;


 public	 packetsender( byte[] data) throws IOException
	{
	 this.data=data;
 	 InetAddress IPAddress= InetAddress.getLocalHost();
	 DatagramPacket packet = new DatagramPacket( data, data.length, IPAddress, 54320 );
 	 DatagramSocket datagram = new DatagramSocket() ;
     datagram.send(packet);
 	 datagram.close();
 	}
 public String recieve( byte[] data) throws IOException
	{
	 InetAddress IPAddress= InetAddress.getLocalHost();
     DatagramPacket packet = new DatagramPacket( data, data.length, IPAddress, 54320 );
	 DatagramSocket datagram = new DatagramSocket() ; 
	 datagram.send(packet);		  
	 byte[] reciever = new byte[65535];
     DatagramPacket rec = new DatagramPacket(reciever, reciever.length,IPAddress, 54321 );	 
	 while (true) {
		datagram.receive(rec);
		message= new String(reciever, 0, rec.getLength());
		System.out.println(rec.getAddress().getHostName() + ": "+ message);
		datagram.close();
		return message;
         }
	 
      }
 
}


