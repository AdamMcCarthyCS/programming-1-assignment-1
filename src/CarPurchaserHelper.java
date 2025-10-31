/**
 * This is a class which contains utility methods to perform program calculations.
 *
 * <p>All mathematical calculations used in the program are contained in this class. The
 * methods are called through the user interface in the driver class.</p>
 *
 * @author Adam McCarthy
 * @version 1.0
 */
public class CarPurchaserHelper {

    /**
     * Calculates the monthly payment for a hire-purchase agreement.
     *
     * <p>This method takes car price, initial deposit, annual interest rate, and repayment term in
     * years and computes the monthly repayment for a purchased vehicle.</p>
     * <br>
     * <p>The monthly interest rate is calculated using:</p>
     * <pre>monthly interest rate = annual interest / 12 months</pre>
     * <p>The general formula for the hire-purchase value is:</p>
     * <pre>hire-purchase principle = monthly payment * (1+r)^n</pre>
     * <p>The (1+r)^n term is for calculating the interest that compounds over n months which we
     * call the {@code factor} here. This formula is rearranged to make the monthly payment the
     * subject of the formula. This gives the final expression:</p>
     *
     * <pre>monthly payment = hire-purchase principle * monthly interest rate * factor / (factor - 1)</pre>
     *
     * @param carPrice          The price of the car in euros and cents
     * @param deposit           The initial deposit paid when purchasing the vehicle
     * @param annualInterest    The percentage interest written as an integer
     * @param termYears         The number of years the payment will take place over
     *
     * @return                  The monthly repayment value for the hire-purchase agreement in euros
     *                          and cents
     */
    public double calculateHP(double carPrice, double deposit, double annualInterest, int termYears) {
        double amountToFinance = carPrice - deposit;
        double monthlyInterestRate = (annualInterest / 100) / 12;
        int totalMonths = termYears * 12;

        if (monthlyInterestRate == 0) {
            return amountToFinance / totalMonths;
        } else {
            // Calculate (1 + r)^n using a loop
            double factor = 1;
            for (int i = 0; i < totalMonths; i++) {
                factor *= (1 + monthlyInterestRate);
            }

            double monthlyPayment = amountToFinance * monthlyInterestRate * factor / (factor - 1);
            return monthlyPayment;
        }
    }

    /**
     * Calculates the monthly payment for a personal contract plan.
     *
     * <p>This method takes car price, initial deposit, annual interest rate, repayment term in
     * years, and guaranteed minimum future value at the end of the term and computes the monthly
     * repayment for a purchased vehicle.</p>
     * <br>
     * <p>The guaranteed minimum future value of the vehicle is calculated using</p>
     * <pre>car guaranteed minimum future value = car price * (GMFV percentage / 100)</pre>
     * <p>The monthly interest rate is calculated using:</p>
     * <pre>monthly interest rate = annual interest / 12 months</pre>
     * <p>The general formula for the loan is:</p>
     * <pre>loan principle = monthly payment * (1+r)^n</pre>
     * <p>The (1+r)^n term is for calculating the interest that compounds over n months which we
     * call the {@code factor} here. This formula is rearranged to make the monthly payment the
     * subject of the formula. This gives the final expression:</p>
     *
     * <pre>monthly payment = amountToFinance * monthly interest rate * factor / (factor - 1)</pre>
     *
     * @param carPrice          The price of the car in euros and cents
     * @param deposit           The initial deposit paid when purchasing the vehicle
     * @param annualInterest    The percentage interest written as an integer
     * @param termYears         The number of years the payment will take place over
     * @param gmfvPercent       The guaranteed minimum future value in euros and cents
     *
     * @return                  The monthly repayment value for the personal contract plan in euros
     *                          and cents
     */
    public double pcpResultMonth(double carPrice, double deposit, double annualInterest, int termYears, double gmfvPercent) {
        double gmfv = carPrice * (gmfvPercent / 100);
        double amountToFinance = carPrice - deposit - gmfv;

        double monthlyInterestRate = (annualInterest / 100) / 12;
        int totalMonths = termYears * 12;

        double monthlyPayment;

        if (monthlyInterestRate == 0) {
            monthlyPayment = amountToFinance / totalMonths;
        } else {
            // Calculate (1 + r)^n using a loop
            double factor = 1;
            for (int i = 0; i < totalMonths; i++) {
                factor *= (1 + monthlyInterestRate);
            }

            monthlyPayment = amountToFinance * monthlyInterestRate * factor / (factor - 1);
        }

        return  monthlyPayment;
    }

    /**
     * Calculates the balloon payment due at end of PCP payment term
     *
     * <p>This method calculates the balloon payment due at the end of the personal contract
     * plan if the user wishes to keep the car. The calculation is as follows:</p>
     * <pre>balloon payment = car value * (guaranteed minimum future value percentage / 100)</pre>
     *
     * @param carValue      the purchase price of the vehicle
     * @param gmfv          the guaranteed minimum future value as a percentage
     *
     * @return              the amount the user will need to pay at the end of the contract to
     *                      keep the vehicle
     */
    public double calculateBalloonPayment(double carValue, double gmfv){
        return carValue * gmfv / 100;
    }

    /**
     * Returns a welcome message to be printed out to the user
     *
     * @return          A welcome message for the user
     */
    public String printWelcomeMessage() {
        // return a string literal with welcome message
        return "Welcome to the Car Purchase Helper!";
    }

    /**
     * Returns a goodbye message to be printed out to the user
     *
     * @return          A goodbye message for the user
     */
    public String printGoodbyeMessage() {
        // return a string literal with a goodbye message
        return "Thanks for using the Car Purchase Helper!";
    }

    /**
     * Calculates the monthly payment for a 0% finance purchase of a car over a fixed term.
     *
     * <p>This method reads in the car value and duration of the loan in months and returns the
     * monthly repayment the user will need to make on the purchase. The repayment is calculated
     * using:</p>
     * <pre>monthly repayment = total car value / term of agreement in months</pre>
     *
     * @param carPrice          a double amount in euros and cents which represents the car price
     * @param numberOfMonths    an integer number of months over which the repayments are made
     *
     * @return                  the personal contract plan monthly payment
     */
    public double calculateMonthlyCost(double carPrice, int numberOfMonths) {
            /*
            Divide the car cost by the number of months. Since carPrice is a double the result will
            cast to a double despite months being an int.
            */
        double monthlyCost = carPrice / numberOfMonths;

        return monthlyCost;
    }

    /**
     * Estimates the cost of fuel based on the number of kilometers driven per week
     *
     * <p>This method takes kilometers per week and fuel price as inputs and calculates the users
     * estimated weekly fuel use using:</p>
     * <pre>liters of fuel used per week = kilometers per week / 100 * 6</pre>
     * <p>The cost of this fuel use is then calculated using:</p>
     * <pre>weekly fuel cost = cost of fuel * litres of fuel used per week</pre>
     *
     * @param kilometersPerWeek     the number of kilometers the user will travel weekly
     * @param costOfFuel            the cost of fuel in euros and cents
     *
     * @return                      a weekly estimated fuel cost in euros and cents
     */
    public double fuelCostEstimator(double kilometersPerWeek, double costOfFuel) {
        // calculate the number of liters used per week
        double litersPerWeek = kilometersPerWeek / 100 * 6;

        // calculate total cost per week by multiplying the cost of fuel per liter by the number of
        // liters used weekly
        double weeklyFuelCost = costOfFuel * litersPerWeek;

        return weeklyFuelCost;
    }

    /**
     * Makes a car recommendation based on the user's lifestyle.
     *
     *<p>The method reads in a user lifestyle of 'family', 'luxury', or 'adventure' and generates a
     * car recommendation string which is printed to the user.</p>
     *
     * <p>Monthly payments on a personal contract plan are calculated using {@code pcpResultMonth},
     * and also on a hire-purchase agreement using {@code calculateHP}. The method also
     * provides an estimate of a 0% interest repayment plan calculation using
     * {@code fuelCostEstimator} and an estimate of weekly fuel costs using
     * {@code calculateMonthly cost}. All values are returned to 2dp using the {@code format} method
     * of the {@code String} class</p>
     *
     * @param userLifestyle     A choice of lifestyle which informs the car suggested to the user
     * @return                  A string detailing options of hire-purchase, personal contract plan,
     *                          and fuel costs based on the users lifestyle
     */
    public String recommendCarType(String userLifestyle) {
        double carPrice;
        //TODO add 30% deposit for PCP and 35% for HP as on VW Example page
        double depositHP; // variable used as an argument in the calculations below
        double depositPCP;
        double kilometersPerWeek;
        double gmfvPercent = 50.0d; // the car retains half its value
        double costOfFuel = 1.76; // the cost of petrol at the time of writing
        double annualInterestHP = 5.9d; // taken from VW Website
        double annualInterestPCP = 0.9d; // taken from VW Website
        double depositHPpercentage = 0.35; // taken from VW Website
        double depositPCPPercentage = 0.31; // taken from VW Website
        int numberOfRepaymentMonths = 48; // taken from VW Website (See references)
        int termYears = numberOfRepaymentMonths / 12;

        // Calculate the following to return to user in recommendation
        double hpMonthlyPayment;
        double pcpMonthlyPayment;
        double ordinaryFinanceMonthlyCost;
        double weeklyFuelCost;
        String carName;
        if (userLifestyle.equals("family")) {
            // Store the name of the car and calculate the deposit
            carName = "Volkswagen T-Roc R-Line";
            carPrice = 40460.00d;
            depositHP = depositHPpercentage * carPrice;
            depositPCP = depositPCPPercentage * carPrice;
            kilometersPerWeek = 400d;
        } else if (userLifestyle.equals("luxury")) {
            carName = "BMW i4 eDrive35 M Sport";
            carPrice = 74501.40d;
            depositHP = depositHPpercentage * carPrice;
            depositPCP = depositPCPPercentage * carPrice;
            kilometersPerWeek = 300d;
        } else if (userLifestyle.equals("adventure")) {
            carName = "Land Rover Defender";
            carPrice = 72825d;
            depositHP = depositHPpercentage * carPrice;
            depositPCP = depositPCPPercentage * carPrice;
            kilometersPerWeek = 1000d;
        } else {
            // warn user if they have not entered a valid lifestyle option
            return "Invalid lifestyle option!";
        }
        // calculate the HP monthly payment using the HP deposit and annual interest
        hpMonthlyPayment = calculateHP(carPrice, depositHP, annualInterestHP, termYears);
        // calculate the PCP monthly payment using the PCP deposit and annual interest
        pcpMonthlyPayment = pcpResultMonth(carPrice, depositPCP, annualInterestPCP, termYears,
                gmfvPercent);
        // calculate ordinary finance monthly payment
        ordinaryFinanceMonthlyCost = calculateMonthlyCost(carPrice, numberOfRepaymentMonths);
        // calculate weekly fuel cost
        weeklyFuelCost = fuelCostEstimator(kilometersPerWeek, costOfFuel);

        // Store the message to be returned to the user

        // format carPrice to print to 2dp.
        String recommendationLine = String.format("The car we recommend for you is: " + carName + "\n"
                + "Car price: €%.2f\n", carPrice)
                + "Options:\n";
        // format hpMonthlyPayment and deposit to print to 2dp
        // format numberOfRepaymentMonths and annualInterestPCP to print as integers
        String hpLine = String.format("1) HP Agreement: €%.2f for %d months at %.2f%% APR, " +
                        "with initial deposit of €%.2f\n", hpMonthlyPayment, numberOfRepaymentMonths,
                annualInterestHP, depositHP);
        // format all double values to 2dp
        String pcpLine = String.format("2) PCP Agreement: €%.2f for %d months at %.2f%% APR, " +
                        "with initial deposit of €%.2f and GMFV of %.2f%%\n", pcpMonthlyPayment,
                numberOfRepaymentMonths, annualInterestPCP, depositPCP, gmfvPercent);
        // format ordinaryFinanceMonthlyCost to 2dp
        // format numberOfRepaymentMonths as an integer
        String ordinaryFinancingLine = String.format("3) Ordinary financing: €%.2f for "
                + "%d months\n", ordinaryFinanceMonthlyCost, numberOfRepaymentMonths);
        // format all doubles to 2dp
        String fuelCostLine = String.format("Estimated weekly fuel cost based on "
                + "%.2f kilometers/pw at current fuel price of €%.2f "
                + "per liter is €%.2f", kilometersPerWeek, costOfFuel, weeklyFuelCost);

        // concatenate the above strings to create the message to be returned
        String message = recommendationLine + hpLine + pcpLine + ordinaryFinancingLine
                + fuelCostLine;

        return message;
    }

}

