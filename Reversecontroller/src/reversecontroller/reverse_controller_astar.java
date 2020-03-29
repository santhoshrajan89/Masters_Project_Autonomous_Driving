package reversecontroller;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


import pathplanner.Astar;
import pathplanner.Path;
import pathplanner.pair;

import java.util.Scanner; 
  


import unity_communication.packetsender;
import unity_communication.position_parser;


public class reverse_controller_astar {

	
	pair dest;
	Orientationfinder O;
	pathplanner.Path ret;
	packetsender send;
	byte[] data= ("0,0").getBytes();
	pair source;
	double steering;
	Astar astar;
	int index;
	double orientation_angle;
	int info;
	int rearx;
	int reary;
	Actuator act;
	int time=2;
	double [] pos= new double[6];
	
	NSsteeringanglecalculator anglens;
	SNsteeringanglecalculator anglesn;
	EWsteeringanglecalculator angleew;
	WEsteeringanglecalculator anglewe;
	
	
	public reverse_controller_astar(int index, Path ret) throws IOException, InterruptedException 
	{ 	    
		
	for (int i=0; i<index;i=i+1)
	{
			
			if (ret.x[i+1]==null)
			{
				break;
			}
			
			System.out.println("start"+ret.x[i].x+ret.x[i].y );
			System.out.println("end"+ret.x[i+1].x+ret.x[i+1].y );	
			dest=new pair(ret.x[i+1].x,ret.x[i+1].y );
			source=new pair(ret.x[i].x,ret.x[i].y );
			
		
		O=new Orientationfinder();
		orientation_angle=O.Orientationfinder();
		info=O.Orientationinfo();
		
		System.out.println(info);
		
	
		if (info==3)
		{
			anglens=new NSsteeringanglecalculator();
			steering=anglens.NSsteeringanglecalculator(dest,source);
		}
		else if (info==4)
		{
			anglesn=new SNsteeringanglecalculator();
			steering=anglesn.SNsteeringanglecalculator(dest,source);
		}
		else if (info==1)
		{
			angleew=new EWsteeringanglecalculator();
			steering=angleew.EWsteeringanglecalculator(dest,source);
		}
		
		else if (info==2)
		{
			anglewe=new WEsteeringanglecalculator();
			steering=anglewe.WEsteeringanglecalculator(dest,source);
		}
	
	
		steering=Math.round((steering) * 10) / 10.0;
		
		
	    System.out.println("the steering angle with error that must be fixed is "+steering);
		
	 
		
		act= new Actuator(steering,time);
	 
		 
		
		TimeUnit.SECONDS.sleep(1);
 			
	}
	
    }
}
