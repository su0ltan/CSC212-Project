public class RgnInfo {
	int region;;
	int total_visitors;
	VisitorType vType[];

	public RgnInfo(int region) {
		this.region = region;
		this.total_visitors = 0;
		vType = new VisitorType[2];
		vType[0] = new VisitorType(0);
		vType[1] = new VisitorType(1);
	}
}
