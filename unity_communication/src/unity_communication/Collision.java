package unity_communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Collision {

	String message;
	
	public String[] Collision() throws IOException
	{
	  InetAddress IPAddress= InetAddress.getLocalHost();
	  byte[] data = ("0,0").getBytes();
	  DatagramPacket packet = new DatagramPacket( data, data.length, IPAddress, 54321 );
	  DatagramSocket datagram = new DatagramSocket() ;
	  datagram.send(packet);	  
	 byte[] reciever = new byte[65535];
	 DatagramPacket rec = new DatagramPacket(reciever, reciever.length,IPAddress, 54321 ); 
	 while (true) {
		datagram.receive(rec);
		message= new String(reciever, 0, rec.getLength());
		System.out.println(rec.getAddress().getHostName() + "the collision information is  : "+ message);
	    String tractor= new String(message.substring(0, 1) );
	    String trailer= new String(message.substring(2,3));
	    //System.out.println( "the tractor collision info is  : "+ tractor);
	    //System.out.println( "the tractor collision info is  : "+ trailer );
	    
	    String[] ret=new String[2];
	    ret[0]=tractor;
	    ret[1]=trailer;
	    return ret;
		//datagram.close();
 }
	 
}
}
