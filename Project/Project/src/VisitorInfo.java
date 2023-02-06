public class VisitorInfo {
	String fName, lName, phone;
	int region, type;
	ArrayStack<Integer> order;

	public VisitorInfo(String fName, String lName, String phone, int region,
			int type) {
		if(phone.length() != 10)
			this.phone = "xxxxxxxxxx"; 
		else
		
			this.phone = phone;
		this.fName = fName;
		this.lName = lName;
		
		
		
		
		this.region = region;
		this.type = type;
		this.order = new ArrayStack<Integer>();
	}

	public String toString() {
		String str = "";

		str += "Name: " + fName + " " + lName + "\n";
		str += "Region: " + region + "\n";
		str += "VIP Pass holder: " + ((type == 0) ? "No" : "Yes") + "\n";
		str += "Phone number: " + phone + "\n";
		str += "Order of visiting the kingdoms: " + order + "\n";

		return str;
	}

}
