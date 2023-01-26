package projectPhase2;

import java.io.Serializable;

public class visitorInfo implements Serializable  {

	public String fname;
	public String Lname;
	public String phoneNum;
	public int region;
	public int type;
	public ArrayStack<Integer> order;
	
	
	
	public visitorInfo(visitorInfo v) {
		fname=v.fname;
		Lname = v.Lname;
		phoneNum = v.phoneNum;
		region= v.region;
		type = v.type;
		
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
	public visitorInfo () {}
	
}