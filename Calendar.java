/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
		int inputYear = Integer.parseInt(args[0]);
	 	while (year < inputYear) {
	 		advance();
        }
		while (year == inputYear) {
			if (dayOfWeek != 1) { 
	 			System.out.println(dayOfMonth + "/" + month + "/" + year);
	 		} else {
				System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
			}
			advance();
		}
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if (dayOfWeek < 7) {
			dayOfWeek++;
		} else {
			dayOfWeek = 1;
		}
		if (dayOfMonth < nDaysInMonth) {
			dayOfMonth++;
		} else {
			if (month < 12) {
				month++;
			} else {
				month = 1;
				year++;
			}
			nDaysInMonth = nDaysInMonth(month, year);
			dayOfMonth = 1;
		}
		} 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean firstCond = year % 400 == 0;
	    boolean secondCond = year % 4 == 0 && year % 100 != 0;
		boolean checkIfLeapYear = firstCond || secondCond;
		return checkIfLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
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