import java.util.Scanner;

public class DaysofaMonth {
	
	public static boolean checkYear(int nam) {
		return (nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0;
	}

	public static void main(String[] args) {
      
        int year;
        int days = 0;
        boolean validMonth = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Input month: ");
		String month = input.nextLine();
		System.out.println("Input year: ");
		year = input.nextInt();
		
		switch (month) {
		case "Jan":
		case "Jan.":
		case "January":
		case "1":
		case "March":
		case "Mar.":
		case "Mar":
		case "3":
		case "May":
		case "5":
		case "July":
		case "Jul":
		case "7":
		case "August":
		case "Aug.":
		case "Aug":
		case "8":
		case "October":
		case "Oct.":
		case "Oct":
		case "10":
		case "December":
		case "Dec.":
		case "Dec":
		case "12":
			days = 31;
			break;
		case "April":
		case "Apr.":
		case "Apr":
		case "4":
		case "June":
		case "Jun":
		case "6":
		case "September":
		case "Sept.":
		case "Sep":
		case "9":
		case "November":
		case "Nov.":
		case "Nov":
		case "11":
			days = 30;
			break;
		case "February":
		case "Feb.":
		case "Feb":
		case "2":
			if(checkYear(year)) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		default:
			System.out.print("Invalid month.");
			validMonth = false;
		}
		if (validMonth) {
			System.out.printf("The number of days in %s of %d is: %d", month, year, days);
		}
		
		input.close();
		
        
    }

}
