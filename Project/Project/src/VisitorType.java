public class VisitorType {
	int type;
	int num_visitors;
	LinkedList<VisitorInfo> visitList;

	public VisitorType(int type) {
		this.type = type;
		this.num_visitors = 0;
		this.visitList = new LinkedList<VisitorInfo>();
	}
}
