/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	// Tests the isLeapYear function.
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int year) {
		for (int i = 1; i <= 12; i++) {
			System.out.println("Month " + i + " has " + nDaysInMonth(i, year) + " days");;
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
	    boolean firstCond = year % 400 == 0;
	    boolean secondCond = year % 4 == 0 && year % 100 != 0;
		boolean checkIfLeapYear = firstCond || secondCond;
		return checkIfLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {
		int monthDays = 0;
		switch (month) {
			case 1:
				monthDays = 31;
				break;
			case 2:
				monthDays = isLeapYear(year) ? 29 : 28;
				break;
			case 3:
				monthDays = 31;
				break;
			case 4:
				monthDays = 30;
				break;
			case 5:
				monthDays = 31;
				break;
			case 6:
				monthDays = 30;
				break;
			case 7:
				monthDays = 31;
				break;
			case 8:
				monthDays = 31;
				break;
			case 9:
				monthDays = 30;
				break;
			case 10:
				monthDays = 31;
				break;
			case 11:
				monthDays = 30;
				break;
			case 12:
				monthDays = 31;
				break;
		}
		return monthDays;
	}
}