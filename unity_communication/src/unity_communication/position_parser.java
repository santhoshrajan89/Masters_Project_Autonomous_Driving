package unity_communication;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class position_parser {

	double[] pos= new double[6];
	String message;
    packetsender send;
	  
 
	
 public double[] position_parser( byte[] data) throws IOException, InterruptedException
	{

	  send= new  packetsender(data);
	  message=send.recieve(data);   
	  String x1p = new String(message.substring(7, 12) );
	  String y1p = new String(message.substring(21,27) );
	  String x2p = new String(message.substring(27, 34) );
	  String y2p;
	  String x3p = new String(message.substring(51, 58) );
	  String y3p;
	  if (message.length()==70)
	  {
		  y2p= new String(message.substring(42,48) );
	  }
	  else if (message.length()==69)
	  {
		  y2p= new String(message.substring(42,47) );
	  }
	  else if (message.length()==71)
	  {
		  y2p= new String(message.substring(42,49) );
	  }
	 
	  else
	  {
		  y2p= new String(message.substring(42,49));
	  }
	
	  if (message.length()==75)
	  {
		  y3p= new String(message.substring(67,75) );
	  }
	  else if (message.length()==72)
	  {
		  y3p= new String(message.substring(65,72) );
	  }
	  else if (message.length()==73)
	  {
		  y3p= new String(message.substring(66,73) );
	  }
	  else if (message.length()==74)
	  {
		  y3p= new String(message.substring(67,74) );
	  }
	  else if (message.length()==76)
	  {
	      y3p= new String(message.substring(67,76) );
	  }
	  else
	  {
		  y3p= new String(message.substring(message.length()-8,message.length()) );
	  }
	  System.out.println("x1,y1,x2,y2,x3,y3"+x1p+","+y1p+","+x2p+","+y2p+","+x3p+","+y3p);
	  String comma= new String(",");
	  

     if ( comma.equals(x1p.substring(0,1)))
      {
         pos[4]=  (25+Double.parseDouble(x1p.substring(1)));
      }
     else if (x1p.substring(0,1).matches(".*\\d.*")&&comma.equals(x1p.substring(1,2)))
	  {
		pos[4]=  (25+Double.parseDouble(x1p.substring(2)));
	  }
      else
	    pos[4]=  (25+Double.parseDouble(x1p));//x1
 
       if ( comma.equals(y1p.substring(0,1)))
       {
         pos[5]= (25-Double.parseDouble(y1p.substring(1)));
        }
       else if (y1p.substring(0,1).matches(".*\\d.*")&&comma.equals(y1p.substring(1,2)))
	    {
		  pos[5]=  (25-Double.parseDouble(y1p.substring(2)));
	    }
       else if (y1p.substring(0,2).matches(".*\\d.*")&&comma.equals(y1p.substring(2,3)))
       {
	      pos[5]=  (25-Double.parseDouble(y1p.substring(3)));
        }
       else
	       pos[5]=  (25-Double.parseDouble(y1p));//y1
 
 
 
		
	    if ( comma.equals(x2p.substring(0,1)))
	    {
	      pos[0]= (25+Double.parseDouble(x2p.substring(1)));//x2
	    }
	  else if (x2p.substring(0,1).matches(".*\\d.*")&&comma.equals(x2p.substring(1,2)))
		 {
			 pos[0]= (25+Double.parseDouble(x2p.substring(2)));//x2
		 }
	  else if (x2p.substring(0,2).matches(".*\\d.*")&&comma.equals(x2p.substring(2,3)))
		 {
			 pos[0]= (25+Double.parseDouble(x2p.substring(3)));//x2
		 }
	  else if (x2p.substring(0,3).matches(".*\\d.*")&&comma.equals(x2p.substring(3,4)))
		 {
			 pos[0]= (25+Double.parseDouble(x2p.substring(4)));//x2
		 }
	  else if (x2p.substring(0,4).matches(".*\\d.*")&&comma.equals(x2p.substring(4,5)))
		 {
			 pos[0]= (25+Double.parseDouble(x2p.substring(5)));//x2
		 }
	  else
		  pos[0]= (25+Double.parseDouble(x2p));//x2
	  
	  
	    if ( comma.equals(y2p.substring(0,1)))
	    {
	       pos[1]= (25-Double.parseDouble(y2p.substring(1)));//y2
	    }
	   else if (y2p.substring(0,1).matches(".*\\d.*")&&comma.equals(y2p.substring(1,2)))
	   {
		  pos[1]= (25-Double.parseDouble(y2p.substring(2)));//y2
	    }
	   else if (y2p.substring(0,2).matches(".*\\d.*")&&comma.equals(y2p.substring(2,3)))
		 {
			 pos[1]= (25-Double.parseDouble(y2p.substring(3)));//y2
		 }
		 else if (y2p.substring(0,3).matches(".*\\d.*")&&comma.equals(y2p.substring(3,4)))
		 {
			 pos[1]= (25-Double.parseDouble(y2p.substring(4)));//y2
		 }
		 else if (y2p.substring(0,4).matches(".*\\d.*")&&comma.equals(y2p.substring(4,5)))
		 {
			 pos[1]= (25-Double.parseDouble(y2p.substring(5)));//y2
		 }
	      else
		  pos[1]= (25-Double.parseDouble(y2p));//y2
	  
	    
	    if ( comma.equals(x3p.substring(0,1)))
	     {
		 pos[2]= (25+Double.parseDouble(x3p.substring(1)));//x3
	     }
	    else if (x3p.substring(0,1).matches(".*\\d.*")&&comma.equals(x3p.substring(1,2)))
	    {
		  pos[2]=  (25+Double.parseDouble(x3p.substring(2)));//x3
	     }
	    else if (x3p.substring(0,2).matches(".*\\d.*")&&comma.equals(x3p.substring(2,3)))
	    {
		 pos[2]= (25+Double.parseDouble(x3p.substring(3)));//x3
	     }
	    else if (x3p.substring(0,3).matches(".*\\d.*")&&comma.equals(x3p.substring(3,4)))
	    {
		 pos[2]= (25+Double.parseDouble(x3p.substring(4)));//x3
	      }
		else if(comma.equals(x3p.substring(4,5)))
	     {
		 pos[2]=  (25+Double.parseDouble(x3p.substring(0,4)));//x3
	      }
	     else 
	      {
		  pos[2]=  (25+Double.parseDouble(x3p.substring(0,4)));//x3
	      }
	 
	      if ( comma.equals(y3p.substring(0,1)))
	      {
	        pos[3]= (25-Double.parseDouble(y3p.substring(1)));//y3
	       }
	       else if (y3p.substring(0,1).matches(".*\\d.*")&&comma.equals(y3p.substring(1,2)))
	       {
		   pos[3]=  (25-Double.parseDouble(y3p.substring(2)));//y3
	      }
	        else if (y3p.substring(0,2).matches(".*\\d.*")&&comma.equals(y3p.substring(2,3)))
	       {
		    pos[3]= (25-Double.parseDouble(y3p.substring(3)));//y3
	        }
	        else if (y3p.substring(0,3).matches(".*\\d.*")&&comma.equals(y3p.substring(3,4)))
	        {
	 	     pos[3]= (25-Double.parseDouble(y3p.substring(4)));//y3
	        }	  
	       else 
		      pos[3]= (25-Double.parseDouble(y3p));
	 
	 pos[0]=Math.abs(Math.round(pos[0]*100)/100);
	 pos[1]=Math.abs(Math.round(pos[1]*100)/100);
	 pos[2]=Math.abs(Math.round(pos[2]*100)/100);
	 pos[3]=Math.abs(Math.round(pos[3]*100)/100);
	 pos[4]=Math.abs(Math.round(pos[4]*100)/100);
	 pos[5]=Math.abs(Math.round(pos[5]*100)/100);
	 
	 System.out.println("The trace x1,y1 is "+pos[4]+pos[5]);
	 System.out.println("The trace x3,y3 is "+pos[2]+pos[3]);
	
	 return pos;
	  
	}	    
}
