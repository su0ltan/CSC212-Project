package projectPhase2;

public class visitorType {

	public int type;
	public int NumVistor;
	public LinkedList<visitorInfo> visitList;
	public visitorType(int type, int numVistor, visitorInfo visitor) {
		super();
		this.type = type;
		NumVistor = numVistor;
		visitList.insert(visitor);
	}
	


}