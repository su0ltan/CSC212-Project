import java.io.File;
import java.util.Scanner;

public class ThemeParkADT {
	static int k, r;
	static RgnInfo regionArray[], rgnSortedArray[];
	static LinkedList<VisitorInfo> visitors, vips;

	private static void init() {
		k = 4;//we assume that initial value for k is 4 (and it will be change in region var)
		r = 0;

		regionArray = new RgnInfo[k + 1];
		visitors = new LinkedList<VisitorInfo>();
		vips = new LinkedList<VisitorInfo>();
	}
	
	public ThemeParkADT() {}//cons

	// Bubble Sort
	private static void sortRgnSortedArray() {
		int len = rgnSortedArray.length;
		int i = 0, j = 0;
		while (i < len - 1) {
			j = 0;
			while (j < len - i - 1) {
				if (rgnSortedArray[j].total_visitors <= rgnSortedArray[j + 1].total_visitors) {
					RgnInfo temp = rgnSortedArray[j];
					rgnSortedArray[j] = rgnSortedArray[j + 1];
					rgnSortedArray[j + 1] = temp;
				}
				j++;
			}
			i++;
		}
	}

	private static VisitorInfo getVistiorInfo(String line)  {
		String info[] = line.split(",");
		for (int i = 0; i < info.length; i++)
			info[i] = info[i].trim();
	
		String fName = info[0];
		String lName = info[1];
		int region = Integer.parseInt(info[2]);
		int type = Integer.parseInt(info[3]);
		String phone = info[4];
		
		VisitorInfo visitorInfo = new VisitorInfo(fName, lName, phone, region, type);
		for (int i = 5; i < info.length; i++)
			visitorInfo.order.push(Integer.parseInt(info[i]));
	
		return visitorInfo;
	}

	public static void readFileAndAnalyse(String fileName) {
		try {
			init();
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				VisitorInfo visitor = getVistiorInfo(line);

				visitors.insert(visitor);

				if (visitor.type == 1) {
					vips.insert(visitor);
				}

				int region = visitor.region;
				int type = visitor.type;

				/* we assumed that k is the max region which is 4. if region greater than k 
				that means there's a new region
				where we need to expand the array by creating another array
				by creating temp array called arr and make regionArray reference into it*/
				if (region > k) { 
					
					RgnInfo arr[] = new RgnInfo[region + 1];

					for (int i = 0; i < regionArray.length; i++)
						arr[i] = regionArray[i];

					regionArray = arr;
					k = region;
				}

				if (regionArray[region] == null) {
					regionArray[region] = new RgnInfo(region);
					r++;
				}

				regionArray[region].total_visitors++;
				regionArray[region].vType[type].num_visitors++;
				regionArray[region].vType[type].visitList.insert(visitor);
			}

			rgnSortedArray = new RgnInfo[r];
			int i = 0;
			for (RgnInfo rgn : regionArray) {
				if (rgn != null) {
					rgnSortedArray[i++] = rgn;
				}
			}

			sortRgnSortedArray();

			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// The method will print all visitors’ information having last name lName
	public static void searchVisitor(String lName) {
		LinkedList<VisitorInfo> list = visitors;
		if (!list.empty()) {
			list.findFirst();
			int count = 0;
			while (!list.last()) {
				VisitorInfo visitor = list.retrieve();
				if (lName.equalsIgnoreCase(visitor.lName)) {
					System.out.println("Visitor " + (++count) + ":");
					System.out.println(visitor);
				}
				list.findNext();
			}
			VisitorInfo visitor = list.retrieve();
			if (lName.equalsIgnoreCase(visitor.lName)) {
				System.out.println("Visitor " + (++count) + ":");
				System.out.println(visitor);
			}
		}
	}

	//The method will print the total number of regions that the visitors come from.
	public static void rgnCount() {
		System.out.println("The total number of regions are " + r);
	}
	

	//The method will print the regions and their number of visitors sorted by the total
	public static void popularRgn() {

		//display the regions along with their number of visitors sorted by the 
		//total number of visitors from this region
		for (RgnInfo rgn : rgnSortedArray) {
			System.out.println("Region " + rgn.region + ": "
					+ rgn.total_visitors);
		}
	}
	
	

	//The method will print the total number of VIP pass holders from region i
	public static void vipRgn(int i) {
		if (i > k || regionArray[i] == null) {
			System.out.println("Region does not exists.");
		} else {
			System.out.println("The total number of VIP pass holders coming "
					+ "from Region " + i + " is "
					+ regionArray[i].vType[1].num_visitors);
		}
	}

	//The method will print the current location of all VIP pass holders
	public static void vipLocation() {
		LinkedList<VisitorInfo> list = vips;
		if (!list.empty()) {
			list.findFirst();
			while (!list.last()) {
				VisitorInfo visitor = list.retrieve();
				System.out.println(visitor.fName + " " + visitor.lName
						+ " in kingdom " + visitor.order.topElem());
				list.findNext();
			}
			VisitorInfo visitor = list.retrieve();
			System.out.println(visitor.fName + " " + visitor.lName
					+ " in kingdom " + visitor.order.topElem());
			//topElem is function that return the last value in stack (same pop but doesnot remove from stack)
		}
	}

	//The method will return true if the two VIP visitors with phone numbers n1 and n2 are 
	//in the same Kingdom. Otherwise, a message will be printed indicating the reason the method is 
	//returning false.
	public static boolean checkVipLoc(String n1, String n2) {
		VisitorInfo v1 = null, v2 = null;
		LinkedList<VisitorInfo> list = vips;
		if (!list.empty()) {
			list.findFirst();
			while (!list.last()) {
				VisitorInfo visitor = list.retrieve();
				//check if null because of duplicate numbers
				if (v1 == null && visitor.phone.equals(n1))
					v1 = visitor;
				else if (v2 == null && visitor.phone.equals(n2))
					v2 = visitor;
				list.findNext();
			}
			VisitorInfo visitor = list.retrieve();
			if (v1 == null && visitor.phone.equals(n1))
				v1 = visitor;
			else if (v2 == null && visitor.phone.equals(n2))
				v2 = visitor;
		}

		if (v1 == null || v2 == null) {
			System.out.println("One of visitors is not found in VIP pass holders list.");
			return false;
		} else if (v1.region != v2.region) {
			System.out.println("Visitors are not from the same region.");
			return false;
		} else if (v1.order.topElem() != v2.order.topElem()) {
			System.out.println("Visitors are not in the same Kingdom.");
			return false;
		}

		return true;
	}

	//The method will return true if the two regular visitors with phone numbers n1 and n2 
	//coming from region r visited the kingdoms in the same order. Otherwise, a message will be 
	//printed indicating the reason the method is returning false.
	public static boolean checkRegLoc(String n1, String n2) {
		VisitorInfo v1 = null, v2 = null;
		LinkedList<VisitorInfo> list = visitors;
		if (!list.empty()) {
			list.findFirst();
			while (!list.last()) {
				VisitorInfo visitor = list.retrieve();
				if (v1 == null && visitor.phone.equals(n1))
					v1 = visitor;
				else if (v2 == null && visitor.phone.equals(n2))
					v2 = visitor;
				list.findNext();
			}
			VisitorInfo visitor = list.retrieve();
			if (v1 == null && visitor.phone.equals(n1))
				v1 = visitor;
			else if (v2 == null && visitor.phone.equals(n2))
				v2 = visitor;
		}

		if (v1 == null || v2 == null) {
			System.out.println("One of visitors is not found in regular pass holders list.");
			return false;
		} else if (v1.type != 0 || v2.type != 0) {
			System.out.println("One of visitors are not a regular pass holders.");
			return false;
		} else if (v1.region != v2.region) {
			System.out.println("Visitors are not from the same region.");
			return false;
		} else if (v1.order.size() != v2.order.size()
				|| !v1.order.toString().equals(v2.order.toString())) {
			System.out.println("Visitors are not visited the kingdoms in the same order.");
			return false;
		}

		
		
		return true;
	}

	

}
