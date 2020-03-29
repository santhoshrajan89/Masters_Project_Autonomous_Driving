package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathcontroller.Control_Invoker;
import pathplanner.Astar;

import unity_communication.packetsender;
import unity_communication.position_parser;

public class FirstWP {
	public Astar astar;
	pathplanner.Path ret;
	int index;
	double[] pos= new double[6];
	byte[] data= ("0,0").getBytes();
	Control_Invoker invoke;
	packetsender send;
	int time=5;
	int s1,s2,d1,d2;

	int preprex;
	
	FirstWP() throws IOException, InterruptedException
	{
        long st= System.currentTimeMillis();
		position_parser parser=new position_parser();
		pos=parser.position_parser(data);
		System.out.println("the x1 and y1 coordinates are"+pos[4]+pos[5]);
		System.out.println("the x2 and y2 coordinates are"+pos[0]+pos[1]);
		System.out.println("the x3 and y3 coordinates are"+pos[2]+pos[3]);
		
		
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
		astar=new Astar((int)pos[4],(int)pos[5],13,47);
        ret=astar.retval();
		index=astar.indret();
		invoke=new Control_Invoker(ret,index, time);
	    pos=parser.position_parser(data);
	    System.out.println("WE HAVE ARRIVED AT");
	    System.out.println(pos[4]);
	    System.out.println(pos[5]);
	    long end= System.currentTimeMillis();
	    System.out.println("Time in milliseconds unti first waypoint is");
	    System.out.println(end-st);
        TimeUnit.SECONDS.sleep(3);
     
	}
}
