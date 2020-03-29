package pathcontroller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import unity_communication.packetsender;
import unity_communication.position_parser;

public class Orientationfinder {

	
	//find the angle between x1,y1 and x3,y3

	int index;
	double x2,x3,y2,y3,x1,y1;
	int info;
	packetsender send;
	position_parser activation;
	double[] pos;
	double steering;
	double retsteer;
	int Orientationinfo()
	{
		return info;
		
	}
	
	double  Orientationfinder() throws IOException, InterruptedException
	 {
	 
	 byte[] data = ("0,0").getBytes();
	 send= new packetsender(data);
	 activation=new position_parser();
	 pos=activation.position_parser(data);	
	x2=pos[0];
	y2=pos[1];
	x3=pos[2];
	y3=pos[3];
    x1=pos[4];
    y1=pos[5];
    
 
	steering=Math.toDegrees(Math.atan((double)(x1-x3)/(double)(y1-y3)));

	 retsteer=steering;
	  
        if (steering<0)
       {
    	  steering=-steering;
       }
       
        if (java.lang.Math.abs(y3-y1)<5)
        {
        
           if (x2>x3)
     	  {
     		System.out.println("NS");
     		info=3;
     	  }
     	 
     	  if (x3>x2)
     	  {
     		  System.out.println("SN");
     		  info=4;
     	  }
         }

     
        if (java.lang.Math.abs(y3-y1)==5)
        {

            if (x2>x3)
      	  {
      		System.out.println("NS");
      		info=3;
      	  }
      	 
      	  if (x3>x2)
      	  {
      		  System.out.println("SN");
      		  info=4;
      	  }
        	 
		
        }
        
        
        if (java.lang.Math.abs(y3-y1)>5)
        {
    	
    	   
    	   if (y1>y2)
           {
        	   System.out.println("EW ");    
        	   info=1;
           }
           
           if(y1<y2)
           {
        	   System.out.println("WE"); 
        	   info=2;
           }
    	 
        }
		
    
        return  retsteer;
      
 }
}
