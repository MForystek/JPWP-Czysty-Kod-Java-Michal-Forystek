package zadania.MortgageCalculator;

public class MortgageCalculator {
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    //Calculate mortgage payment knowing number of total payments, monthly interest and principal
    public double calculateMortgage() {
        return principal
                * (annualInterest/1200) * Math.pow(1 + annualInterest/1200, years*12)
                / (Math.pow(1 + annualInterest/1200, years*12) - 1);
    }

    //Calculates actual balance knowing number of payments that was made, monthly interest, total number of payments and principal
    public double calculateBalance(short numberOfPaymentsMade) {
        return principal
                * (Math.pow(1 + annualInterest/1200, years*12) - Math.pow(1 + annualInterest/1200, numberOfPaymentsMade))
                / (Math.pow(1 + annualInterest/1200, years*12) - 1);
    }

    //Calculates remaining balances knowing number of total payments
    public double[] getRemainingBalances() {
        var balances = new double [years*12];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }
}
