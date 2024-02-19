package lab_4_2;

public class Tax {
    private final int SINGLE_FILER = 0, MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1, MARRIED_SEPARATELY = 2, HEAD_OF_HOUSEHOLD = 3;
    private int filingStatus = SINGLE_FILER;

    private int[][] brackets = {
        {
            25050,
            65550,
            136750,
            297350
        },
        {
            45200,
            109250,
            166500,
            297350
        },
        {
            22600,
            54625,
            83250,
            148675
        },
        {
            36250,
            93650,
            151650,
            297350
        },
    };
    private double[] rates = new double[5]; // Tax rates in percentages
    private double taxableIncome = 0;

    Tax(){}

    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome){
        this.filingStatus = filingStatus;
        this.brackets = brackets.clone();
        this.rates = rates.clone();
        this.taxableIncome = taxableIncome;
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
        return taxableIncome * (rates[getTaxBracket(filingStatus, taxableIncome)] / 100);
    }

    private int getTaxBracket(int filingStatus, double taxableIncome){
        for(int bracket = 0; bracket < brackets[filingStatus].length; bracket++){
            if(taxableIncome < brackets[filingStatus][bracket]){
                return bracket;
            }
        }
        return 0; // Shouldn't be reachable
    }
}
