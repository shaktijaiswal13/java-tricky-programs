package com.test.overlodingoverriding;

public class OverloadingOverridingTest {

	public static void main(String[] args) {

		Loan loan = Loan.createLoan("HSBC");
		System.err.println(loan.toString());

		Loan ploan = Loan.createLoan("Citibank", 12);
		System.err.println(ploan.toString());

		// Example of method overriding in Java
		Loan personalLoan = new PersonalLoan();
		System.err.println(personalLoan.toString());
	}

}

class Loan {
	private double interestRate;
	private String customer;
	private String lender;

	public static Loan createLoan(String lender) {
		Loan loan = new Loan();
		loan.lender = lender;
		return loan;
	}

	public static Loan createLoan(String lender, double interestRate) {
		Loan loan = new Loan();
		loan.lender = lender;
		loan.interestRate = interestRate;
		return loan;
	}

	@Override
	public String toString() {
		return "This is Loan by Citibank " + interestRate + " " + lender + " "
				+ customer;
	}

}

class PersonalLoan extends Loan {

	@Override
	public String toString() {
		return "This is Personal Loan by Citibank";
	}
}

// Read more:
// http://javarevisited.blogspot.com/2011/12/method-overloading-vs-method-overriding.html#ixzz3DO33G1uZ
