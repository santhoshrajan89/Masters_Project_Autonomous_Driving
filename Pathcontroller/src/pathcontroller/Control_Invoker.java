package pathcontroller;

import java.io.IOException;

import pathplanner.Path;
import pathplanner.pair;
import unity_communication.Collision;
import unity_communication.packetsender;
import unity_communication.position_parser;
import java.math.*;
import java.util.concurrent.TimeUnit; 

public class Control_Invoker {
	int index;
	int x2,y2,x3,y3;
	//int time=5;
	position_parser activation;
	double[] pos;
	String message;
	double steering;
	Path ret;
	packetsender send;
	pair dest;
	pair source;
	Collision c;
	pair exp;
	
	pair actual;
	 byte[] data = ("0,0").getBytes();
	Actuator act;
	NSsteeringanglecalculator anglens;
	SNsteeringanglecalculator anglesn;
	EWsteeringanglecalculator angleew;
	WEsteeringanglecalculator anglewe;
	Orientationfinder O;
	double orientation_angle;
	int info;
	int tractor, trailer;
	String[] coll=new String[2];
	double error=0;
	
	public Control_Invoker(Path ret, int index, int time) throws IOException, InterruptedException{
		this.ret=ret;
		this.index=index;
		
	
		
	
		for (int i=0; i<index;i=i+5)
		{
			
			
			
		//	 long st= System.currentTimeMillis();
			
			if (ret.x[i+5]==null)
			{
				break;
			}
			
			System.out.println("start"+ret.x[i].x+ret.x[i].y );
			System.out.println("end"+ret.x[i+5].x+ret.x[i+5].y );	
			dest=new pair(ret.x[i+5].x,ret.x[i+5].y );
			source=new pair(ret.x[i].x,ret.x[i].y );
			
			
			//find the current orientation
			
			O=new Orientationfinder();
			orientation_angle=O.Orientationfinder();
			info=O.Orientationinfo();
			
			System.out.println(info);
			
			//call the steering angle computer
			
			if (info==3)
			{
				anglens=new NSsteeringanglecalculator();
				steering=anglens.NSsteeringanglecalculator(dest,source,orientation_angle);
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
		
		
				
			steering=steering+error/10;
			//error flush
			error=0;
			if (steering<-1)
			{
				steering=-1;
			}
			else if(steering>1)
			{
				steering=1;
			}
			else
				
			steering=Math.round((steering) * 10) / 10.0;
			
			
		    System.out.println("the steering angle with error that must be fixed is "+steering);
			
		 
			
			act= new Actuator(steering,time,1);
		 
			 
			
			TimeUnit.SECONDS.sleep(1);
	 			
		
		
			        activation=new position_parser();
	 			    pos=activation.position_parser(data);
	 			    System.out.println("the difference is");
		 			System.out.println(pos[4]-ret.x[i+5].x);
		 			System.out.println(pos[5]-ret.x[i+5].y);
		 			
		 			
		 			  exp=new pair(ret.x[i+5].x, ret.x[i+5].y);
			 		    actual=new pair((int)pos[4],(int) pos[5]);
			 		   O=new Orientationfinder();
			 			orientation_angle=O.Orientationfinder();
			 			info=O.Orientationinfo();

			 			  if (java.lang.Math.abs(actual.x-exp.x)>2)
			               {
			            	   if (info==1)
			            	   {
			            		   error=(actual.x-exp.x);
			            	   }
			            	   
			            	  if (info==2)
			            	   {
			            	     error=(exp.x-actual.x);
			            	   }
			            	     System.out.println("error is"+error);      
			               }      
			 				
			 			 //   long end= System.currentTimeMillis();
			 			 //   System.out.println("The current time in seconds is");
			 			  //  System.out.println(end/1000);			
     		
	 		}
			
}
}