package projectPhase2;
public class visitorInfo {

	public String fname;
	public String Lname;
	public String phoneNum;
	public int region;
	public int type;
	public ArrayStack<Integer> order;
	
	
	
	public visitorInfo() {
		
	}



	public visitorInfo(String fname, String lname, String phoneNum, int region, int type, ArrayStack<Integer> order) {
		super();
		this.fname = fname;
		Lname = lname;
		this.phoneNum = phoneNum;
		this.region = region;
		this.type = type;
		this.order = order;
	}
	
	
}