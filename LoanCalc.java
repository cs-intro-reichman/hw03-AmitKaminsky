/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double g = loan / n;
		double finalBalance = endBalance(loan, rate, n, g);
		boolean ifZero = (finalBalance <= 0);
		iterationCounter = 0;
		while (ifZero == false && g <= loan) {
			g += epsilon;
			finalBalance = endBalance(loan, rate, n, g);
			ifZero = (finalBalance <= 0);
			iterationCounter++;
		}
    	return g;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double L = loan / n;
		double H = loan;
		double M = (L + H) / 2;
		while (H - L > epsilon) {
			// Checks if the product is negative or positive
			// If positive - it means that the payment is too low so the low bound should be higher
			if (endBalance(loan, rate, n, M) * endBalance(loan, rate, n, L) > 0) {
				L = M;
			} else { // If negative - it means that the payment is too high than the high bound should be lower
				H = M;
			}
			M = (L + H) / 2;
			iterationCounter++;
		}
    	return M;
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		double updatedPayLeft = loan;
		for (int period = 0; period < n; period++){
			 updatedPayLeft = (updatedPayLeft - payment) * (1 + rate / 100); 
		}
    	return updatedPayLeft;
	}
}