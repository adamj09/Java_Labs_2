package lab_4_2;

public class Tax {
    private final int SINGLE_FILER = 0, MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1, MARRIED_SEPARATELY = 2, HEAD_OF_HOUSEHOLD = 3;
    private int filingStatus = SINGLE_FILER;

    private int[][] brackets;
    private double[] rates;
    private double taxableIncome = 0;

    Tax(){}
    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome){

    }

    public int getFilingStatus() {
        return this.filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets.clone();
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates.clone();
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return this.taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax(){
        return 0.0;
    }
}
