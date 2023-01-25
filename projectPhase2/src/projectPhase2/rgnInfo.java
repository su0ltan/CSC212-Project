package projectPhase2;
public class rgnInfo {
	public int region;
	public int total_visitors;
	public visitorType[] vtype;
	public rgnInfo(int region, int total_visitors ) {
		super();
		this.region = region;
		this.total_visitors = total_visitors;
		vtype = new visitorType[2];
	}

	

}
