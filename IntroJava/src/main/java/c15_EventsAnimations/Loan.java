package c15_EventsAnimations;

public class Loan {
        private double annualInterestRate;
        private int numberOfYears;
        private double loanAmount;
        private final java.util.Date loanDate;
    
        /** Default constructor */
        public Loan() {
            this(2.5, 1, 1000);
        }
    
        /** Construct a loan with specified annual interest rate, 
            number of years, and loan amount
         */
        public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
            setAnnualInterestRate(annualInterestRate);
            setNumberOfYears(numberOfYears);
            setLoanAmount(loanAmount);
            loanDate = new java.util.Date();
        }
    
        /** Return annualInterestRate */
        public double getAnnualInterestRate() {
            return annualInterestRate;
        }
    
        /** Set an new annualInterestRate */
        public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException{
            if (annualInterestRate <= 0) throw new IllegalArgumentException("Interest rates cannot be less or equal to zero.");
            this.annualInterestRate = annualInterestRate;
        }
    
        /** Return numberOfYears */
        public int getNumberOfYears() {
            return numberOfYears;
        }
    
        /** Set a new numberOfYears */
        public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
            if (numberOfYears <= 0) throw new IllegalArgumentException("Number of years cannot be less or equal to zero.");
            this.numberOfYears = numberOfYears;
        }
    
        /** Return loanAmount */
        public double getLoanAmount() {
            return loanAmount;
        }
    
        /** Set a new loanAmount */
        public void setLoanAmount(double loanAmount) throws IllegalArgumentException{
            if (loanAmount <= 0) throw new IllegalArgumentException("Loan amount cannot be less or equal to zero.");
            this.loanAmount = loanAmount;
        } 
    
        /** Find monthly payment */
        public double getMonthlyPayment() {
            double monthlyInterestRate = annualInterestRate / 1200;
            return loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        }
    
        /** Find total payment */
        public double getTotalPayment() {
            return getMonthlyPayment() * numberOfYears * 12;
        }
        
        /** Return loan date */
        public java.util.Date getLoanDate() {
            return loanDate;
        }
}
