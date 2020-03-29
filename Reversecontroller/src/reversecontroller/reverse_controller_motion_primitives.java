package reversecontroller;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


import pathplanner.Astar;
import pathplanner.Path;
import pathplanner.pair;

import java.util.Scanner;



import unity_communication.packetsender;
import unity_communication.position_parser;


public class reverse_controller_motion_primitives {


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
	
	double [] pos= new double[6];

	NSsteeringanglecalculator anglens;
	SNsteeringanglecalculator anglesn;
	EWsteeringanglecalculator angleew;
	WEsteeringanglecalculator anglewe;
	





	public reverse_controller_motion_primitives(int time) throws IOException, InterruptedException

	{
		int [] x= {0,0,1};
		int [] y= {0,0,1};

	for (int i=0; i<2;i=i+1)
	{

			if (i==2)
			{
				break;
			}

	    System.out.println("loop");
		dest=new pair(x[i+1],y[i+1] );
		source=new pair(x[i],y[i] );
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
	

		steering=Math.round((steering) * 10) / 20.0;


	    System.out.println("the steering angle that must be fixed is "+steering);



		act= new Actuator(steering,time);



		TimeUnit.SECONDS.sleep(1);

	}

    }
}
