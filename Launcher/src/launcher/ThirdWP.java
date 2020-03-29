package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathcontroller.Control_Invoker;
import pathplanner.Astar;

import unity_communication.packetsender;
import unity_communication.position_parser;

public class ThirdWP {
	public Astar astar;
	pathplanner.Path ret;
	int index;
	double[] pos= new double[6];
	byte[] data= ("0,0").getBytes();
	Control_Invoker invoke;
	packetsender send;

	int preprex;
	int s1,s2,d1,d2;

	ThirdWP(int x) throws IOException, InterruptedException
	{
		
		position_parser parser=new position_parser();
		pos=parser.position_parser(data);
		s1=(int)pos[4];
		s2= (int)pos[5];
		d1=13;
		d2=47;
		if ((s1==d1)&&(s2==d2))
		{
			System.out.println("Source and Destination Coordinates cannot be similar");
			System.out.println("Kindly make the changes and run the program again");
			System.exit(0);
		}
		astar=new Astar((int)pos[4], (int)pos[5], (int)pos[4],(int)pos[5]-x); 
		ret=astar.retval();
	    index=astar.indret();
	    invoke=new Control_Invoker(ret,index,5);   
		TimeUnit.SECONDS.sleep(4);
			 
	}
}
