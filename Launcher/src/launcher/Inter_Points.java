package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathcontroller.Actuator;
import pathplanner.Astar;
import pathplanner.Path;
import reversecontroller.reverse_controller;
import unity_communication.position_parser;
import pathcontroller.Actuator;

public class Inter_Points {
	
     double pos[]=new double[6];
	 Path ret;
	 int index;
	 Astar astar;
	 reverse_controller rc;
	  Actuator act;
	 byte[] data =("0,0").getBytes();
	 
	Inter_Points(double steer, int time) throws IOException, InterruptedException
	{

		act= new Actuator(steer,time,1);
	}
	
}
