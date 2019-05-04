//********************************************************************
//  Temperature.java       Author: Em Powers
//
//  Represents the current Temperature in degrees 
//  Fahrenheit (represented as the char F) or 
//  degrees Celsius (represented as the char C). 
//********************************************************************

import java.util.Scanner;
public class Temperature {

	private double degrees;  // degrees in Fahrenheit or Celsius
	private double currentdegrees; // current value of degrees
	private double otherdegrees; // a new degree value
	private char currenttype; // current value of type
	private char type; // whether the temperature is F (Fahrenheit) or C (Celsius)
	
	 // Constructor to specify both parameters (degrees, type)
	
	 public Temperature(double otherdegrees, char currenttype)
	    {
		 	degrees = otherdegrees;
		 	type = currenttype;
	    }
	 
	 // Constructor to specify just the degrees (defaults to type Celsius)
	 
	 public Temperature(double otherdegrees)
	    {
	    		degrees = otherdegrees; 
	    		type = 'C';
	    }	 
	 
	 // Constructor to specify just the type (defaults to 0.0 for the degrees value)
	 
	 public Temperature(char currenttype)
	    {
		 	degrees = 0;
		 	type = currenttype; 
	    }
	 
	 // Default constructor that specifies neither (defaults to 0 degrees Celsius)
	 
	 public Temperature()
	    {
		 	degrees = 0;
		 	type = 'C';
	    }
	 
	 /** Method that asks for a temperature from the user
	  *  formatted in degrees, then either "F" (for Fahrenheit)
	  *  or "C" (for Celsius)
	  */
	 
	 public void readInput()
		 {
			 Scanner scn = new Scanner(System.in); 
			 
			 System.out.println();
			 System.out.println("Please enter a temperature formatted as degrees: ");
			 degrees = scn.nextFloat();
			 System.out.println();
			 System.out.println("Please enter either F (Fahrenheit) or C (Celsius): ");
			 type = scn.next().charAt(0);
			 System.out.println();
		 }
	 
	 // Method that writes the output of the current degrees and the current letter.
		 
	 public void writeOutput()
		 {
			 System.out.println(Math.round(degrees*10)/10.0 + " " + type);
		 }
	 
	 // Method that displays the temperature in degrees C (even if value is Fahrenheit)
	 
	 public void writeC()
		 {
		 	switch(type)
		  			{
		  			 case 'F': 
		  			 case 'f': 
						 currentdegrees = (double) ((degrees - 32)*5.0/9.0);
						 System.out.println(Math.round(currentdegrees*10)/10.0);
						 break;
						 
		  			 case 'C': 
		  			 case 'c':
		  				 System.out.println(Math.round(degrees*10)/10.0);
		  				 break;
					 
		  			 default: 
		  				 System.out.println("Please enter only F for Fahrenheit or C for Celsius.");
				 	}
		 	}
	
	 // Method that displays the temperature in degrees F (even if value is Celsius)
	 
	 public void writeF()
		 {
			switch(type)
  			{
				 case 'F': 
				 case 'f': 
					 System.out.println(Math.round(degrees*10)/10.0);
					 break;
					 
					 case 'C': 
					 case 'c':
						 currentdegrees = (double) ((degrees)* 9/5 + 32);
						 System.out.println(Math.round(currentdegrees*10)/10.0);
						 break;
				 
					 default: 
						 System.out.println("Please enter only F for Fahrenheit or C for Celsius.");
			 }
		 }
	 
	 // Method that accesses the current value in degrees C (even if current value is in Fahrenheit)
	 
	 public double getC()
	    {
	        switch(type)
	        {
	        case 'F':
	        case 'f':
	            currentdegrees = (double) ((degrees - 32)*5.0/9.0);
	            return Math.round(currentdegrees*10)/10.0;
	        case 'C':
	        case 'c':
	            return Math.round(degrees*10)/10.0;

	        default:
	            return Math.round(degrees*10)/10.0;
	        }
	    }
	  
		// Method that accesses the current value in degrees F (even if current value is in Celsius)
	    
	    public double getF()
	    {
	    	switch(type)
		  	{
		  	case 'F':
		  	case 'f': 
		  		return Math.round(degrees*10)/10.0;
			
		  	case 'C' :
		  	case 'c' : 
		  		currentdegrees = (double) ((degrees) * 9/5 + 32);
				return Math.round(currentdegrees*10)/10.0;
			default: 
				return Math.round(degrees*10)/10.0;
		  	}		

	    }
	    
		 // Mutator method that sets (updates) the degrees value
	    
	    public void set(double otherdegrees)
	    {
	    		degrees = otherdegrees; 
	    }
	    
		 // Mutator method that sets (updates) the type value
	    
	    public void set(char currenttype)
	    {
	    		type = currenttype; 
	    }
	    
		 // Mutator method that sets (updates) both the degrees and type values
	
	    public void set(double otherdegrees, char currenttype)
	    {
	    		degrees = otherdegrees;
	    		type = currenttype;
	    }
	    
	    // Mutator method that compares two temperatures. 
	    
	    public boolean equals(Temperature more)
	    {
	    		
	    		return (Math.round(this.getC() * 10) ==
	    				Math.round(more.getC() * 10)); 
	    }
	    
	    // toString method for the Temperature class.  
	    
	    public String toString()
	    {
	    		return "Temperature{" + "temperature=" + degrees + "type=" + type + '}';
	    }
}
