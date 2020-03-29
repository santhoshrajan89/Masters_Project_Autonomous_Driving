package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathplanner.Astar;
import pathplanner.Path;
import reversecontroller.reverse_controller;
import reversecontroller.reverse_controller_astar;
import unity_communication.position_parser;

public class rev_wpastar {

     double pos[]=new double[6];
	 Path ret;
	 int index;
	 Astar astar;
	  reverse_controller_astar rca;
	 byte[] data =("0,0").getBytes();
	 int s1,s2,d1,d2;

	rev_wpastar(int x, int y) throws IOException, InterruptedException
	{


	position_parser parser=new position_parser();
	pos=parser.position_parser(data);
	s1=(int)pos[2];
	s2= (int)pos[3];
	d1=13;
	d2=47;
	if ((s1==d1)&&(s2==d2))
	{
		System.out.println("Source and Destination Coordinates cannot be similar");
		System.out.println("Kindly make the changes and run the program again");
		System.exit(0);
	}
	System.out.println("the x3 and y3 coordinates are"+pos[4]+pos[5]);
	astar=new Astar((int)pos[2],(int)pos[3],(int)pos[2]+x,(int)pos[3]+y);


	ret=astar.retval();
	index=astar.indret();

	rca=new reverse_controller_astar(index,ret);


	}

}
