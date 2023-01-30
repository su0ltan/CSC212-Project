package projectPhase2;

import java.io.File;
import java.util.Scanner;

public class ThemeParkADT<T> {

	private Node<T> T;
	private rgnInfo rgnSortedArray[];

	private rgnInfo regionArray[];
	int maxK;
	private LinkedList<visitorInfo> vips;

	private LinkedList<visitorInfo> visitorsObj;

	public ThemeParkADT(String path) {

		// declaring the file path and call the function

		readFileAndAnalyse(path);
		

	}

	public ThemeParkADT() {

		this("C:\\Users\\Sultan\\data.txt");

	}

	public void rgnCount() {
		System.out.println("The total number of regions are " + maxK);
	}

	public void searchVisitor(String lName) {

		visitorsObj.current = visitorsObj.head;
		while (visitorsObj.current != null) {

			if (visitorsObj.current.data.Lname.equals(lName)) {

				visitorsObj.current.data.print();
			}
			visitorsObj.current = visitorsObj.current.next;

		}
	}

	public void popularRgn() {

	}

	public void vipRgn(int i) {

	}

	public void vipLocation() {

	}

	public boolean checkVipLoc(String n1, String n2, Boolean flag) {

		return flag;
	}

	public boolean checkRegLoc(int r, String n1, String n2, Boolean flag) {
		return flag;
	}

	private void readFileAndAnalyse(String f) {

		File file = new File(f);

		if (file.exists()) {
			try {

				int maxK = 0;
				// to store visitors info
				visitorsObj = new LinkedList<>();
				vips = new LinkedList<>();

				// to read the file
				Scanner sc = new Scanner(file);

				// visitorInfo tmpVistors = null ;
				String[] arrOfStr = null;
				;

				while (sc.hasNextLine()) {
					arrOfStr = sc.nextLine().split(",");
					readVisitor(arrOfStr);

				}

				regionArray = new rgnInfo[maxK + 1];
				visitorsObj.findfirst();
				while (visitorsObj.getCurrent() != null) {
					visitorInfo tmp;
					tmp = visitorsObj.current.getData();
					int rgntmP = tmp.region;

					if (tmp.type == 1)
						regionArray[rgntmP + 1].vtype[1].visitList.insert(tmp);

					else
						regionArray[rgntmP + 1].vtype[0].visitList.insert(tmp);

					visitorsObj.findnext();

				}
				for(int i = 1; i < maxK; i++) {
					regionArray[i].vtype[0].countVisitors();
				}
				
				// vips.PrintElement();
				// visitorsObj.PrintElement();

				// searchVisitor("Jarbo");

			} catch (Exception x) {
				System.out.println(x.getMessage());
			}
		}
	}

	private void readVisitor(String[] arrOfStr) {

		visitorInfo tmpVistors = new visitorInfo();
		/*
		 * split function divides the string line according to comma and store the words
		 * in the array
		 */

		// declaring new object and store the info into it
		tmpVistors = new visitorInfo();
		tmpVistors.fname = arrOfStr[0];
		tmpVistors.Lname = arrOfStr[1];
		tmpVistors.region = Integer.parseInt(arrOfStr[2]);
		tmpVistors.type = Integer.parseInt(arrOfStr[3]);
		tmpVistors.phoneNum = arrOfStr[4];

		if (maxK < tmpVistors.region)
			maxK = tmpVistors.region;

		ArrayStack<Integer> kOrder = new ArrayStack<>();
		for (int i = 5; i < arrOfStr.length; i++)
			kOrder.push(Integer.parseInt(arrOfStr[i]));

		tmpVistors.setOrder(kOrder);

		addVIPvisitors(tmpVistors, vips);

		visitorsObj.insert(tmpVistors);

	}

	private void addVIPvisitors(visitorInfo tmp, LinkedList<visitorInfo> vips) {
		if (tmp.type == 1)
			vips.insert(tmp);
	}

}
