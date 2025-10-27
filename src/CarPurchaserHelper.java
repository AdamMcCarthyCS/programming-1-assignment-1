public class CarPurchaserHelper {
//This will be given to students,
// ToDO: explain it in the reflection
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
    //This will be given to students,
// ToDO: explain it in the reflection
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
     * Return a welcome message to the user
     */
    public String printWelcomeMessage() {
        // return a string literal with welcome message
        return "Welcome to the Car Purchase Helper!";
    }

    /**
     * Return a goodbye message to the user
     */
    public String printGoodbyeMessage() {
        // return a string literal with a goodbye message
        return "Thanks for using the Car Purchase Helper!";
    }

    /**
     *
     * @param carPrice          a double amount in euros and cents which represents the car price
     * @param numberOfMonths    an integer number of months over which the repayments are made
     *
     * @return                  the amount the user will have to rou
     */
    public double calculateMonthlyCost(double carPrice, int numberOfMonths) {
        /*
        Divide the car cost by the number of months. Since carPrice is a double the result will
        cast to a double despite months being an int.
        TODO: see if the precision matters later. Maybe you can format it if you print the value?
        */
        double monthlyCost = carPrice / numberOfMonths;

        return monthlyCost;
    }


    public double fuelCostEstimator(double kilometersPerWeek, double costOfFuel) {
        // calculate the number of liters used per week
        double litersPerWeek = kilometersPerWeek / 100 * 6;

        // calculate total cost per week by multiplying the cost of fuel per liter by the number of
        // liters used weekly
        double weeklyFuelCost = costOfFuel * litersPerWeek;

        return weeklyFuelCost;
    }

    public String recommendCarType(String userLifestyle) {
        double carPrice;
        //TODO add 30% deposit for PCP and 35% for HP as on VW Example page
        double deposit;
        double kilometersPerWeek;
        double gmfvPercent = 50.0d; // The car retains half its value
        double costOfFuel = 1.76; // The cost of petrol at the time of writing
        double annualInterestHP = 5.9d; // Taken from VW Website
        double annualInterestPCP = 0.9d; // Taken from VW Website
        int numberOfRepaymentMonths = 48; // Taken from VW Website (See references)
        int termYears = numberOfRepaymentMonths / 12;

        // Calculate the following to return to user in recommendation
        double hpMonthlyPayment;
        double pcpMonthlyPayment;
        double ordinaryFinanceMonthlyCost;
        double weeklyFuelCost;
        String carName;
        if (userLifestyle.equals("family")) {
            // Store the name of the car and calcualte the deposit
            carName = "Volkswagen T-Roc R-Line";
            carPrice = 40460.00d;
            deposit = carPrice * 0.3d; // 30% of value
            kilometersPerWeek = 300;
        } else if (userLifestyle.equals("luxury")) {
            carName = "BMW BWM i4 eDrive35 M Sport";
            carPrice = 74501.40d;
            deposit = carPrice * 0.3d; // 30% of value
            kilometersPerWeek = 300;
        } else if (userLifestyle.equals("adventure")) {
            carName = "Land Rover Defender";
            carPrice = 72825d;
            deposit = carPrice * 0.3d; // 30% of value
            kilometersPerWeek = 1000;
        } else {
            return "Invalid lifestyle option!";
        }
        // calculate the HP monthly payment
        hpMonthlyPayment = calculateHP(carPrice, deposit, annualInterestHP, termYears);
        // calculate the PCP monthly Payment
        pcpMonthlyPayment = pcpResultMonth(carPrice, deposit, annualInterestPCP, termYears,
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
            annualInterestHP, deposit);
        // format all double values to 2dp
        String pcpLine = String.format("2) PCP Agreement: €%.2f for %d months at %.2f%% APR, " +
            "with initial deposit of €%.2f and GMFV of %.2f%%\n", pcpMonthlyPayment,
            numberOfRepaymentMonths, annualInterestPCP, deposit, gmfvPercent);
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

