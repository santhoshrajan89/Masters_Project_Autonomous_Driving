package launcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pathcontroller.Actuator;
import pathcontroller.Control_Invoker;
import pathplanner.Astar;
import reversecontroller.reverse_controller;
import reversecontroller.reverse_controller_astar;
import unity_communication.packetsender;
import unity_communication.position_parser;

public class Waypoint_determination {
	public Astar astar;
	pathplanner.Path ret;
	int index;
	double[] pos= new double[6];
	byte[] data= ("0,0").getBytes();
	Control_Invoker invoke;
	packetsender send;
	int ds;
	FirstWP one;
	SecondWP two;
	ThirdWP three;
	Inter_Points inter;
    rev_wp rc;
    rev_wpastar rca;
    position_parser parser;
  
    
	 Waypoint_determination(int dock_choice) throws IOException, InterruptedException{

	if (dock_choice==1)
	{	
		//System.out.println("The current start time in seconds is"+System.currentTimeMillis()/1000);
	//	long st= System.currentTimeMillis();
		
		
	   one=new FirstWP();			    
	    two=new SecondWP(15,0); 
	    three= new ThirdWP(25);// for third waypoint y axis point can be set 
		rc=new rev_wp(5); //for reverser using motion primitive time can be set 
	}
	
	if (dock_choice==2)
	{				
	    one=new FirstWP();
		two=new SecondWP(15,0);
		three= new ThirdWP(25);
		inter= new Inter_Points(0.1,7);//by setting inter points minor movements to extend the previous trajectory could be done 
		rc=new rev_wp(6);
	}
	if (dock_choice==3)
	{			
		    one=new FirstWP();
			two=new SecondWP(20,-1);
			three= new ThirdWP(30);
	        rca=new rev_wpastar(2,4);// for Reverser using Astar These points are x and y coordinates
	}
	if (dock_choice==4)
	{				
		  one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  three= new ThirdWP(35); 
		  rca=new rev_wpastar(2,4);
	}
	
	
	
	if (dock_choice==5)
	{				
		  one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  three= new ThirdWP(40);
		  rca=new rev_wpastar(2,4);
	}
	
	
	
	

	if (dock_choice==6)
	{				
		
		
		  one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  
		  position_parser parser=new position_parser();
			pos=parser.position_parser(data);
			
		System.out.println("The y value is"+(int)pos[5]);
		  three= new ThirdWP((int)pos[5]-1);
		  rca=new rev_wpastar(2,4);	
	}
	if (dock_choice==7)
	{				
		  one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  
		  position_parser parser=new position_parser();
			pos=parser.position_parser(data);
			
		System.out.println("The y value is"+(int)pos[5]);
		  three= new ThirdWP((int)pos[5]);
		  rca=new rev_wpastar(2,4);	
		
	}
	
	
	
	
	
	if (dock_choice==8)
	{	
		 one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  
		  position_parser parser=new position_parser();
			pos=parser.position_parser(data);
			
		System.out.println("The y value is"+(int)pos[5]);
		  three= new ThirdWP((int)pos[5]);
		  rca=new rev_wpastar(2,4);	

	}
	if (dock_choice==9)
	{	  one=new FirstWP();
	  two=new SecondWP(20,-1);	
	  
	  position_parser parser=new position_parser();
		pos=parser.position_parser(data);
		
	System.out.println("The y value is"+(int)pos[5]);
	  three= new ThirdWP((int)pos[5]-1);
	  rca=new rev_wpastar(2,4);	;
	}
	if (dock_choice==10)
	{				
		 one=new FirstWP();
		  two=new SecondWP(20,-1);	
		  three= new ThirdWP(40);
		  inter= new Inter_Points(-0.1,10);
		  inter= new Inter_Points(0.1,10);
		  rca=new rev_wpastar(2,4);
	}
	 
	 }
	
}
