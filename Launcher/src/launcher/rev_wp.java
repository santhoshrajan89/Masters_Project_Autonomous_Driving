package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathplanner.Astar;
import pathplanner.Path;
import reversecontroller.reverse_controller;
import unity_communication.position_parser;

public class rev_wp {
	
     double pos[]=new double[6];
	 Path ret;
	 int index;
	 Astar astar;
	 reverse_controller rc;
	 byte[] data =("0,0").getBytes();
	 
	rev_wp(int time) throws IOException, InterruptedException
	{

	rc=new reverse_controller(time);
	}
	
}
