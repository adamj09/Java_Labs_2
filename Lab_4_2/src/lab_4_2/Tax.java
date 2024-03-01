package lab_4_2;

public class Tax {
    private static final int SINGLE_FILER = 0,
            MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1,
            MARRIED_SEPARATELY = 2,
            HEAD_OF_HOUSEHOLD = 3;
    private int filingStatus = SINGLE_FILER;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome = 0;

    Tax() {
    } // No-arg constructor

    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
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
        double tax = 0;
        double income = taxableIncome;
        int[] bracket = brackets[filingStatus];
        for (int i = 0; i < bracket.length - 1; i++) {
            if (income <= bracket[i]) {
                tax += income * rates[i] / 100;
                return tax;
            } else {
                tax += (bracket[i] - (i > 0 ? bracket[i - 1] : 0)) * rates[i] / 100;
                income -= (bracket[i] - (i > 0 ? bracket[i - 1] : 0));
            }
        }
        // Tax the remaining income using the last bracket's rate
        tax += income * rates[bracket.length - 1] / 100;
        return tax;
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
