package c10_ObjectOrientedThinking;

public class Tax {
    // DATA fields
    private int filingStatus;
    private final int SINGLE_FILER = 0;
    private final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    private final int MARRIED_SEPARATELY = 2;
    private final int HEAD_OF_HOUSEHOLD = 3;
    private int[][] brackets = {
            {8350, 33950, 82250, 171550, 372950}, // Single filer
            {16700, 67900, 137050, 20885, 372950}, // Married jointly  −or qualifying widow(er)
            {8350, 33950, 68525, 104425, 186475}, // Married separately
            {11950, 45500, 117450, 190200, 372950} // Head of household
    };
    private double[] rates = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};
    private double taxableIncome;

    //Constructor
    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        setFilingStatus(filingStatus);
        setBrackets(brackets);
        setRates(rates);
        setIncome(taxableIncome);
    }

    public Tax() {
    }

    //Methods
    public int getFilingStatus(){
        return filingStatus;
    }

    public double[] getRates(){
        return rates;
    }

    public int[][] getBrackets(){
        return brackets;
    }
    public double getIncome(){
        return taxableIncome;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public void setIncome(double taxableIncome){
        this.taxableIncome = taxableIncome;
    }

    public void setBrackets(int[][] brackets){
        this.brackets = brackets;
    }

    public void setRates(double[] rates){
        this.rates = rates;
    }

    public double getTax() {
        double tax = 0;
        double incomeTaxed;
        for (int i = brackets[0].length - 1; i >= 0; i--) {
            if (taxableIncome > brackets[filingStatus][i]) {
                incomeTaxed = taxableIncome - brackets[filingStatus][i];
                tax += incomeTaxed * rates[i+1];
            }
        }
        tax += brackets[filingStatus][0] * rates[0];
        return tax;
    }

}
