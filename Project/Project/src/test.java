import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThemeParkADT park =  new ThemeParkADT();
		
		park.readFileAndAnalyse("C:\\Users\\Sultan\\Desktop\\Project\\Project\\src\\data.txt");
		
		//park.searchVisitor("AlAli");
		
		int x = 0;
		
		Scanner s = new Scanner(System.in);
		
		
		while(x != -1) {
			System.out.println("\n \n \n******************************************************");
			System.out.println("Press 1 to search visitors by last name");
			System.out.println("Press 2 to print number of regions");
			System.out.println("Press 3 to print regions and number of visitors for each");
			System.out.println("Press 4 to print total of VIPs based on specific region");
			System.out.println("Press 5 to to print VIPs current location");
			System.out.println("Press 6 to check and print two VIPs if they have same region based on Phone number ");
			System.out.println("Press 7 to check and print two regular whether if they have same order of kingdom based on Phone number");
			System.out.println("**If you want to exit please enter -1**");
			System.out.println("******************************************************\n \n \n");
			
			x = s.nextInt();
			
			String value;
			String value2;
			switch(x) {
			
			case -1: return;
			case 1: System.out.println("Please enter the last name of visitors");
			value = s.next();
			park.searchVisitor(value);
			break;
			case 2:
				park.rgnCount();
				break;
			case 3:
				park.popularRgn();
				break;
			case 4:
				System.out.println("Please enter the region ");
				x = s.nextInt();
				park.vipRgn(x);
				break;
			case 5:
				park.vipLocation();
				break;
			case 6:
				System.out.println("Please enter the phone number of VIP 1");
				value = s.next();
				System.out.println("Please enter the phone number of VIP 2");
				value2 = s.next();
				
				if(park.checkVipLoc(value, value2)) {
					System.out.println("They have same current location");
				}
				break;
			case 7:
				System.out.println("Please enter the phone number of regular visitor 1");
				value = s.next();
				System.out.println("Please enter the phone number of regular visitor 2");
				value2 = s.next();
				if(park.checkRegLoc(value, value2)) {
					System.out.println("They have same order");
				}
				break;
				
			 default:
				 System.out.println("Invalid value!");
				 break;
				
				
			}
			
			
	
			
		}

	}

}
