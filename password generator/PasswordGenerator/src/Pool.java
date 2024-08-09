
public class Pool {
	public static final String UPPERCASE= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE= "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	private boolean upper=false;
	private boolean lower=false;
	private boolean num=false;
	private boolean sym=false;
	private String customPool="";
	
	public Pool(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
		// TODO Auto-generated constructor stub
		upper= includeUpper;
		lower= includeLower;
		num =includeNum;
		sym=includeSym;
		
	}
	public void customizePool() {
		if(upper==true)
			customPool=customPool+UPPERCASE+" ";
		if(lower==true) 
			customPool=customPool+LOWERCASE+" ";
		if(num==true)
			customPool=customPool+NUMBERS+" ";
		if(sym==true) 
			customPool=customPool+SYMBOLS;
		System.out.println("string is len: " + customPool);
	}
	public String getPool() {
		customizePool();
		return customPool;
	}

}
