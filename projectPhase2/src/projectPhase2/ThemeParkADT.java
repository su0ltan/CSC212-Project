package projectPhase2;

public class ThemeParkADT<T> {
	
	
	private rgnInfo regionArray[]; 
	int maxK;
	public int getMaxK() {
		return maxK;
	}


	public void setMaxK(int maxK) {
		this.maxK = maxK;
	}


	private LinkedList<visitorInfo> n;
	private Node<T> T;
	private rgnInfo rgnSortedArray[];
	
	
	
	LinkedList<visitorInfo> visitors;
	
	
	 public LinkedList<visitorInfo> getVisitors() {
		return visitors;
	}


	public void setVisitors(LinkedList<visitorInfo> visitors) {
		n = visitors;
	}


	public void  rgnCount() {
		 System.out.println("The total number of regions are " + maxK); 
	 }


	public void  searchVisitor(String lName) {
		
		n.current=n.head;
		while(n.current!=null) {
			
			if(n.current.data.Lname.equals(lName)) {
				
				n.current.data.print();}
			n.current=n.current.next;
		
		}
	}
	
		
	public void  popularRgn() {
		
	}
	
	
	public void vipRgn(int i) {
		
	}
	
	
	public void vipLocation() {
		
	}
	
	
	public boolean checkVipLoc(String n1, String n2, Boolean flag) {
		
		return flag;
	}
	
	
	public boolean  checkRegLoc(int r, String n1, String n2, Boolean flag) {
		return flag;
	}	

}
