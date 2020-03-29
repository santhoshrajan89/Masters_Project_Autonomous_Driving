package pathcontroller;

import pathplanner.pair;

public class EWsteeringanglecalculator {

	
	double cosangle,sinangle;
	double tanangle;
	double steering=0;
	double hyp;
	double EWsteeringanglecalculator(pair dest, pair source)
	{
		hyp=Math.sqrt(Math.pow(dest.x-source.x, 2)+Math.pow(dest.y-source.y, 2));
		
		sinangle=Math.toDegrees(Math.asin((double)(dest.x-source.x)/hyp));
		cosangle=Math.toDegrees(Math.acos((double)(dest.y-source.y)/hyp));
		tanangle=Math.toDegrees(Math.atan((double)(dest.x-source.x)/(double)(dest.y-source.y)));
		System.out.println("the cosangle in degrees is"+sinangle);
		System.out.println("the cosangle in degrees is"+cosangle);
		System.out.println("the tanangle in degrees is"+tanangle);
		
	     if (cosangle>90)
		{
		 System.out.println("TURN INFEASIBLE");
		 steering=0;
		
		}
	     else
	     {
			steering=-(sinangle)/90;
			
	     }
			
		return steering;
		
		
	}
	
	
}
