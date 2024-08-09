import java.util.*;
public class Generator {

	public static Scanner keyboard;
	Pool pool;
	public Generator(Scanner scan) {
		keyboard=scan;
	}
	//public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
         //pool = new Pool(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
   // }
	public void menu() {
	  System.out.println("Enter 1 - Password Generator");
	  System.out.println("Enter 2 - Password Strength Check");
	  System.out.println("Enter 3 - Quit");
	  System.out.print("Choice:");
	  String choice="-1";
	  while(choice != "3"){
		  choice = keyboard.next();
		  switch(choice) {
		  	case "1" : 
		  		request();
		  		break;
			case "2" :
				passCheck(); 
				break;
			case "3" :
				System.out.print("Thank You! The Program has closed."); 
				System.exit(0);
				break;
			default : {
				System.out.println("Enter 1 - Password Generator");
				System.out.println("Enter 2 - Password Strength Check");
				System.out.println("Enter 3 - Quit");
				System.out.print("Choice:");
				break;
			}
                    
		  }
		
	  }
    }
	boolean valid=false;
	public void request() {
		        boolean IncludeUpper = false;
		        boolean IncludeLower = false;
		        boolean IncludeNum = false;
		        boolean IncludeSym = false;
		        boolean correctParams = false;
		        
		        System.out.println("Hello, welcome to the Password Generator :) answer"
		                + " the following questions by Yes or No \n");
		        keyboard.nextLine();
		        
		        do {
		        	String input="";
		        	correctParams = false;
		        	System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
		            input = keyboard.nextLine();
		            if( isInclude(input))
			            IncludeLower = true;
		        	while(!valid) 
		        	{
			            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
			            input = keyboard.nextLine();
			           if( isInclude(input))
			            IncludeLower = true;
		        	}

			        System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
			        input = keyboard.nextLine();
			        if (isInclude(input)) 
			            IncludeUpper = true;
		        	while(!valid)
		        	{
			            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
			            input = keyboard.nextLine();
			            if (isInclude(input)) 
				            IncludeUpper = true;
			            
		        	}
		        	
		        	System.out.println("Do you want Numbers \"1234...\" to be used? ");
		            input = keyboard.nextLine();
		            if (isInclude(input)) 
					       IncludeNum = true;
		            
		        	while(!valid)
		        	{
			            
			            System.out.println("Do you want Numbers \"1234...\" to be used? ");
			            input = keyboard.nextLine();
			            if (isInclude(input)) 
				       IncludeNum = true;
		        	}
		        	
		        	
		        	 System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
			         input = keyboard.nextLine();
			         if (isInclude(input)) 
				            IncludeSym = true;
		        	while(!valid) {
			            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
			            input = keyboard.nextLine();
			            if (isInclude(input)) 
			            IncludeSym = true;
		        	}
		    
		            //No Pool Selected
		            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
		                System.out.println("You have selected no characters to generate your " +
		                        "password at least one of your answers should be Yes");
		                correctParams = true;
		            }
		            
		        } while (correctParams);

		        System.out.println("Great! Now enter the length of the password");
		        int length = keyboard.nextInt();
		        pool = new Pool(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
		        String codes =pool.getPool();
		        createPass(length,codes);
		       	
	}
    private boolean isInclude(String Input) {
    	boolean included=false;
		  if (Input.equalsIgnoreCase("yes")) {
		         included=true;
		  		isvalid(true);
		  }
		  else if(Input.equalsIgnoreCase("no"))
		  {
			  included=false;
			  isvalid(true);
		  }
		  else {
	          System.out.println("Invalid Input Error...Please Try Again");
	          isvalid(false);
		  }
	              
	            
		  
		  return included;
    }
    private void isvalid(boolean is)  
    {
    	valid=is;
    	
    }
 

	public void createPass(int leng, String codes) {
		
		Random rnd=new Random();
		String[] arr =codes.split(" ");
		int size=arr.length;
		int hold;
		int count=0;
		int b;
		String str="";
		//pick randomly out of the list until array is filled
		for(int i=0; i<leng;i++)
		{   
			if(count>size-1) 
			count=0;
			
			hold=arr[count].length();
			b=rnd.nextInt(hold);
			str=str+arr[count].charAt(b);
			count++;
			
			
		}
		System.out.print("Password Generated: "+str);
		
	}
	public void passCheck() {
		
	}

}
