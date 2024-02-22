package lab_4_2;

public class Tax {
    // Filing statuses
    private final int SINGLE_FILER = 0,
            MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1,
            MARRIED_SEPARATELY = 2,
            HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus = SINGLE_FILER; // Set to default filing status

    private int[][] brackets;

    // Tax rates in percentages
    private double[] rates;

    private double taxableIncome = 0; // Set default taxable income to 0

    Tax() {} // No-arg constructor

    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) { // Constructor with all args
        this.filingStatus = filingStatus;
        this.brackets = brackets.clone();
        this.rates = rates.clone();
        this.taxableIncome = taxableIncome;
    }

    // --- Getters ---
    public int getFilingStatus() {
        return this.filingStatus;
    }

    public int[][] getBrackets() {
        return brackets.clone();
    }

    public double[] getRates() {
        return rates.clone();
    }

    public double getTaxableIncome() {
        return this.taxableIncome;
    }

    // --- Setters ---
    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets.clone();
    }

    public void setRates(double[] rates) {
        this.rates = rates.clone();
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        // Returns amount that should be taxed based on filing status and income
        return taxableIncome * (rates[getTaxBracket(filingStatus, taxableIncome)] / 100);
    }

    public double getTaxRate() {
        // Return tax rate in percent based on filing status and income
        return rates[getTaxBracket(filingStatus, taxableIncome)];
    }

    private int getTaxBracket(int filingStatus, double taxableIncome) {
        int bracket = 0;
        for (; bracket < brackets[filingStatus].length - 1; bracket++) { // loop through all brackets
            // If taxableIncome is less than max of a bracket and bracket has a max, return
            // bracket
            if (taxableIncome <= brackets[filingStatus][bracket] && bracket != (brackets[filingStatus].length - 1)) {
                return bracket;
            }
        }
        return bracket; // This should return the maximum bracket (one with no limit)
    }

    public String[] getFilingStatusesAsStrings() {
        // return filing statuses as array of strings for printing purposes
        return new String[] { "single filer", "married jointly or qualifying widow", "married separately",
                "head of household" };
    }
}
