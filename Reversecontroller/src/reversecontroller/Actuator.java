package reversecontroller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import unity_communication.packetsender;
import unity_communication.position_parser;

import java.lang.Math;
public class Actuator {

	
	int index;
	int x2,x3,y2,y3;
	double[] info=new double[2];
	packetsender send;
	position_parser activation;
	int[] pos;
	byte[] data;
	int x=5;
	
	 public Actuator( double steering, int time) throws IOException, InterruptedException
	{
		 
		 
		
		 if (steering==0)
		 {
			 data = ("0,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
		 if (steering==0.1)
			 
		 {
			 data = ("0.1,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
		 if (steering==0.2||steering==0.25)
		 {
			 data = ("0.2,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
		 if (steering==0.3)
		 {
		 data = ("0.3,-0.2").getBytes();
	        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.4)
			 
		 {
			 data = ("0.4,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.5)
			 
		 {
			 data = ("0.5,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.6)
			 
		 {
			 data = ("0.6,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.7)
			 
		 {
			 data = ("0.7,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.8)
			 
		 {
			 data = ("0.8,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==0.9)
			 
		 {
			 data = ("0.9,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        if (steering==1)
			 
		 {
			 data = ("1,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
        
        
        
        
       
		 if (steering==-0.1)
			 
		 {
			 data = ("-0.1,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
		 if (steering==-0.2||steering==-0.25)
		 {
			 data = ("-0.2,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
		 if (steering==-0.3)
		 {
		 data = ("-0.3,-0.2").getBytes();
	        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-0.4)
			 
		 {
			 data = ("-0.4,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
    
       if (steering==-0.5)
			 
		 {
			 data = ("-0.5,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-0.6)
			 
		 {
			 data = ("-0.6,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-0.7)
			 
		 {
			 data = ("-0.7,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-0.8)
			 
		 {
			 data = ("-0.8,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-0.9)
			 
		 {
			 data = ("-0.9,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
       if (steering==-1)
			 
		 {
			 data = ("-1,-0.2").getBytes();
		        
			  send= new packetsender(data);
			 TimeUnit.SECONDS.sleep(time+1);
			 data=("0,0").getBytes();
			 send= new packetsender(data);
		 }
	   }
	
	
	
}
			
			
			
	
	

