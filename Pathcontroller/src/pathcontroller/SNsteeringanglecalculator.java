package pathcontroller;

import pathplanner.pair;

public class SNsteeringanglecalculator {


	double cosangle;
	double tanangle;
	double steering=0;
	double hyp;
	double sinangle;

	double SNsteeringanglecalculator(pair dest, pair source)
	{

        hyp=Math.sqrt(Math.pow(dest.x-source.x, 2)+Math.pow(dest.y-source.y, 2));
		cosangle=Math.toDegrees(Math.acos((double)(dest.y-source.y)/hyp));
		tanangle=Math.toDegrees(Math.atan((double)(dest.x-source.x)/(double)(dest.y-source.y)));
		sinangle=Math.toDegrees(Math.asin((double)(dest.x-source.x)/hyp));
		System.out.println("the sinangle in degrees is"+sinangle);
		System.out.println("the cosangle in degrees is"+cosangle);
		System.out.println("the tanangle in degrees is"+tanangle);

		if (sinangle>0)
		{
			 System.out.println("TURN INFEASIBLE");
			 steering=0;
		}

		else if (cosangle==0)
		{
			steering=-0.5;
		}

	     else if (cosangle==180)
		{
			steering=0.5;
		}
		else if (cosangle==90)
		{
			steering=0;
		}
		else
		{
			steering=-tanangle/45;
		}


	System.out.println("the returned steering angle is "+steering);
	return steering;


	}


}
