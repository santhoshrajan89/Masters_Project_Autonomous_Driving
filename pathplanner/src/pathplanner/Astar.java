package pathplanner;

public class Astar
{
	int s1;
	int s2;
	int d1;
	int d2;
	int index=0;  
	
	//constructor
	public  Astar(int s1, int s2, int d1, int d2)
	{
	  this.s1=s1;
	  this.s2=s2;
	  this.d1=d1;
	  this.d2=d2;
	  
	
	}
	public int indret()
	{
		
		
		return index;
	}
	public Path retval()
	{
	int x_size=55;
	int y_size=60;
	
	
	
	pair source=new pair(s1,s2);
	pair dest=new pair(d1,d2);
	
	
	int n=10;
	double min;
	int neighbour_counter=0;
	int [][]GRID=new int[x_size][y_size];
	double [][]G_cost=new double[100][100];
	double [][]H_cost=new double[100][100];
	double [][]F_cost=new double[100][100];
	 neighbours neighbour=new neighbours();
	  Path closed=new Path();
	
	   for (int i=0;i<x_size;i++)
	    {
		   for (int j=0;j<y_size;j++)
		  {
			GRID[i][j]=1;
		  }
	    }
	
	
	   for (int i=13;i<=44;i++)
		  {
		  GRID[21][i]=0;
			GRID[20][i]=0;
			GRID[19][i]=0;
		  }
	   
	   for (int i=0;i<=2;i++)
		  {
		  GRID[21][i]=0;
	       GRID[20][i]=0;
	       GRID[19][i]=0;
		  }
	   
	   
	   for (int i=49;i<60;i++)
		  {
		   GRID[21][i]=0;
	       GRID[20][i]=0;
	       GRID[19][i]=0;
		  }
	   
	   
	   for (int i=13;i>=4;i--)
	   {
		   for (int j=4;j<31;j++)
		   {
			 GRID[i][j]=0;
			 
		   }
		   
	   }
	
	    GRID[12][15]=1;
	    GRID[13][16]=1;
	    
	   for (int i=51;i<x_size;i++)
		  {
		   for (int j=0; j<y_size;j++)
		   {
	     GRID[i][j]=0;
		  }
		  }
	
	  for (int i=0; i<x_size;i++)
	   {
		for (int j=0; j<y_size;j++)
		  {
			if (GRID[i][j]==0)
			  { G_cost[i][j]=10000;}
			    // H_cost[i][j]=10000;}
			else {
				G_cost[i][j]=0;
				 H_cost[i][j]= Math.sqrt(Math.pow((i-dest.x),2)+Math.pow((j-dest.y),2));
				 }
			}
	     }
	  
	        for (int i=0; i<x_size;i++)
	          {
		       for (int j=0; j<y_size;j++)
		        {
		        F_cost[i][j]=G_cost[i][j]+H_cost[i][j];
		        }
	           }
	      //assign lists
	        list x=new list (source.x,source.y,0,H_cost[source.x][source.y],F_cost[source.x][source.y]);
	        list y=new list(0,0,0,0,0);
	        
	       
	   	     
	          neighbour.x[0]=x;
	          
	          for (int i=1;i<8;i++ )
	          {
	        	  neighbour.x[i]=y;
	          }
	   	 
	 
		  
	      int l=0;
	      list NULL=new list (0,0,0,0,0);
	      list taken=NULL;
	      
	      taken=new list (source.x,source.y,0,H_cost[source.x][source.y],F_cost[source.x][source.y]);
	    boolean path_not_found=true;
	    
	while (path_not_found)
	  {
	
		
		    
		   if (l>0)
		    {
			   min=neighbour.x[0].f;
			
		     for (int d=1; d<neighbour_counter;d++)
		      {
			    if (neighbour.x[d].f<min)
			     {
			      min=neighbour.x[d].f;
		           taken=neighbour.x[d];
		           
		       
			     }
		      }
		    }
		
		   try
		   {
         		 closed.x[index]=taken;
		   }
		   catch(ArrayIndexOutOfBoundsException e)
		   {
			   System.out.println("CANNOT FIND PATH FOR THE GIVEN POINTS");
  			   System.exit(0);
		   }
		
		   
		   GRID[closed.x[index].x][closed.x[index].y]=9;
		   index=index+1;
	     if (taken.x==dest.x&& taken.y==dest.y)
	     {
	    	 System.out.print("path_found");
	    	 path_not_found=false;
	    
	     }
	     //flush the neighbour list everytime
	     neighbour_counter=0;
	     for (int s=0;s<8;s++)
	     {
	    	 neighbour.x[s]=NULL;
	     }
	     
	    down:
	     for(int i = taken.x-1;i<=taken.x+1;i++)
	     {
	    	 for(int j = taken.y-1;j<=taken.y+1;j++)

	    	  {
	    		 if (i==taken.x&&j==taken.y)
	    		 {
	               
	    			 continue;
	    		}
	    		 
	    		
	    		 
	    		 try {
	    		 //if it passes all the above test, add it to the open list
	    		 G_cost[i][j]=G_cost[i][j]+Math.sqrt(Math.pow((i-taken.x),2)+Math.pow((j-taken.y),2));
	            
	             
	             F_cost[i][j]=G_cost[i][j]+H_cost[i][j];
	    		 }
	    		 catch(ArrayIndexOutOfBoundsException e)
	    		 {
	    			 System.out.println("CANNOT FIND PATH FOR THE GIVEN POINTS");
	    			 System.exit(0);
	    			
	    		 }
	    		 
	    		 Path templist=new Path();
	             list temp=new list(i,j,G_cost[i][j],H_cost[i][j],F_cost[i][j]);
	             
	              templist.x[0]=temp;
	             
	            for (int k=1;k<index;k++)
	             {
	               if (closed.x[k]==templist.x[0])
	                 break down;
	                 
	             }
	             
	                     
	             neighbour.x[neighbour_counter]=temp;
	             neighbour_counter=neighbour_counter+1;
	            
	            	 
	            	 
	            
	    	   }
	      }

     l++;
	    
	 }//while(1) loop ends here
	 
	 
	 
	 
	
     for (int i=x_size-1;i>=0;i--)
	    {
		  for (int j=0;j<y_size;j++)
		  {
			System.out.print(GRID[i][j]);
			System.out.print(" ");
		  }
		  System.out.print("\n");
	    }
	return closed;
	 
	

	}
	
	
	
}
	
	

