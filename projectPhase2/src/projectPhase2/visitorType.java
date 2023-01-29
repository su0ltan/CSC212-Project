package projectPhase2;

public class visitorType {

	public int type;
	private int NumVistor;
	public LinkedList<visitorInfo> visitList;
	public visitorType(int type, visitorInfo visitor) {
		super();
		this.type = type;
		visitList.insert(visitor);
		NumVistor = 0;
		countVisitors();
	}
	public void countVisitors(){
		while(visitList.current !=null)
			NumVistor++;
		
	}


}