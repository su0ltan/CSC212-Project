package projectPhase2;

import java.io.Serializable;

public class visitorInfo implements Serializable  {

	public String fname;
	public String Lname;
	public String phoneNum;
	public int region;
	public int type;
	public ArrayStack<Integer> order;
	
	
	public ArrayStack<Integer> getOrder() {
		return order;
	}
	public void setOrder(ArrayStack<Integer> order) {
		this.order = order;
	}
	
	
	
	public visitorInfo(visitorInfo v ) {
		fname=v.fname;
		Lname = v.Lname;
		phoneNum = v.phoneNum;
		region= v.region;
		type = v.type;
		
		
	}
	


	public visitorInfo(String fname, String lname, String phoneNum, int region, int type, ArrayStack<Integer> order) {
	
		this.fname = fname;
		Lname = lname;
		this.phoneNum = phoneNum;
		this.region = region;
		this.type = type;
		this.order = order;
	}
	public visitorInfo () {
		order = new ArrayStack<>();
	}
	public void print() {
		String s;
		
		if(type == 0) s = "regular";else s = "VIP";
		System.out.print("First name:"+fname +" Last name: " + Lname+" Region: "+ region+" Visitor Type: "+s+ " Phone number: " + phoneNum + " "+"Kingdoms visited: ");
		ArrayStack<Integer> tmp=null;
		while(!order.empty()) {
			int x=order.pop();
			System.out.print(x);
			tmp.push(x);
		}while(!tmp.empty())order.push(tmp.pop());
		
		System.out.println();
	}
	
}