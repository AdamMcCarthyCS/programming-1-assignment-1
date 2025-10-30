import java.util.Scanner;

/**
 * This class is the entry point to the program.
 *
 * <p>The program starts in the {@code main} method. Using the {@code start} method the UI
 * begins a continuous loop delegating option choices to helper methods until the user exits
 * the program manually.</p>
 *
 * @author Adam McCarthy
 * @version 1.0
 */
public class Driver {

    /**
     * This is the entry point for the program.
     *
     * <p>The main method initialises an instance of the {@code Scanner} class and also the
     * {@code CarPurchaserHelper} class. It begins the user interface by greeting the user and
     * calling the {@code start} method. When the user chooses to exit the program a
     * goodbye message is printed.</p>
     *
     * @param args  optional command line arguments passed as an array of strings (unused)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an instance of the CarPurchaseHelper class.
        CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

        // print the welcome message by passing the string returned from the function to print
        // method
        String welcomeMessage = carPurchaserHelper.printWelcomeMessage();
        System.out.println(welcomeMessage);

        // Start the UI interaction
        start(input, carPurchaserHelper);

        // print the goodbye message returned by the method in the CarPurchaseHelper class
        String goodbyeMessage = carPurchaserHelper.printGoodbyeMessage();
        System.out.println(goodbyeMessage);
    }

    /**
     * Main menu loop of the program.
     *
     * <p>Each time the user selects an option the program passes control to one of the helper
     * methods through the {@code chooseMenuItem} method. The program continuously returns
     * to this method until the user manually chooses to exit.</p>
     *
     * @param input                 an instance of the Scanner class used to read user input
     * @param carPurchaserHelper    an instance of the CarPurchaserHelper class to be passed to
     *                              the utility methods through the {@code chooseMenuItem} method
     */
    public static void start(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // use sentinel value to start while loop
        int choice = -1;
        while (choice != 0) {
            // Add an empty line before menu is reprinted each time
            System.out.println();

            System.out.println("--- Car Finance Calculator ---");
            System.out.println("1. Calculate HP");
            System.out.println("2. Calculate PCP");
            System.out.println("3. Calculate Fuel Cost");
            System.out.println("4. Calculate Monthly Cost");
            System.out.println("5. Recommend Car Type");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            // Add newline after user choice for UI visual improvement
            System.out.println();


            choice = chooseMenuItem(choice, input, carPurchaserHelper);
            // Notify the user of an invalid choice
            if (choice == -1) {
                System.out.println("That is not a valid menu choice");
            }
        }
    }

    /**
     * Delegates user menu choice to the appropriate helper function of the class.
     *
     * <p>Using conditional logic the method passes control of the program to the appropriate
     * helper method. If the user has chosen 6, the method immediately returns 0 which exits
     * the program. If the user has not entered a valid integer the method retuns -1 which
     * signals that an incorrect choice has been made.</p>
     *
     * @param userChoice            an integer value representing the users menu choice
     * @param input                 an instance of the {@code Scanner} class which is passed to
     *                              the relevant helper function
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class which
     *                              is passed to the relevant helper function
     *
     * @return                      an integer value which determines if the program loop
     *                              continues, exits, or prints a warning
     */
    public static int chooseMenuItem(int userChoice, Scanner input,
                                     CarPurchaserHelper carPurchaserHelper) {
        if (userChoice == 1) {
            calculateHP(input, carPurchaserHelper);
            return 1;
        } else if (userChoice == 2) {
            calculatePCP(input, carPurchaserHelper);
            return 2;
        } else if (userChoice == 3) {
            calculateFuelCost(input, carPurchaserHelper);
            return 3;
        } else if (userChoice == 4) {
            calculateMonthlyCost(input, carPurchaserHelper);
            return 4;
        } else if (userChoice == 5) {
            recommendCarChoice(input, carPurchaserHelper);
            return 5;
        } else if (userChoice == 6) {
            return 0;
        }

        // if no valid choice was made return -1
        return -1;
    }

    /**
     * Collects user information for calculation and printing of monthly hire-purchase payment.
     *
     * <p>The method prompts the user to enter the data needed to calculate the value of a
     * hire-purchase agreement monthly payment. Once it has all the relevant arguments
     * the method calls the {@code calculateHP} method of the {@code CarPurchaserHelper}
     * class. The result is then formated into the standard convention for financial numerical
     * amounts using the {@code format} method from the built in {@code String} class</p>
     *
     * @param input                 an instance of the {@code Scanner} class used to read user
     *                              input
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class used to
     *                              call a utility method that computes the monthly cost
     */
    public static void calculateHP(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // Read in the values needed for the calculateHP method
        // Store the values in variables which will be passed to the calculateHP method
        // as arguments when it is called

        System.out.print("Enter car price (€): ");
        double hpPrice = input.nextDouble();
        System.out.print("Enter deposit) (€: ");
        double hpDeposit = input.nextDouble();
        System.out.print("Enter annual interest rate (%): ");
        double hpInterest = input.nextDouble();
        System.out.print("Enter term in years: ");
        int hpTerm = input.nextInt();

        // call the calculateHP method using the stored values above as arguments to the
        // method
        double hpMonthly = carPurchaserHelper.calculateHP(hpPrice, hpDeposit, hpInterest, hpTerm);
        // format the hpMonthly string to print to 2dp
        String hpMonthlyOutput = String.format("Monthly HP payment: €%.2f" ,hpMonthly);
        // print the monthly HP payment which was calculated using the method for the user
        System.out.println(hpMonthlyOutput);
    }

    /**
     * Collects user information for the calculation and printing of a personal contract plan
     * monthly amount.
     *
     * <p>The method prompts the user to enter the data needed to calculate the value of a
     * personal contract plan agreement monthly payment. Once it has all the relevant arguments
     * the method calls the {@code pcpResultMonth} method of the {@code CarPurchaserHelper}
     * class. The result is then formated into the standard convention for financial numerical
     * amounts using the {@code format} method from the built in {@code String} class</p>
     *
     * @param input                 an instance of the {@code Scanner} class used to read user
     *                              input
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class used to
     *                              call a utility method that computes the monthly cost
     */
    public static void calculatePCP(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // read in all the values needed for calling the pcpResultMonth method
        // store these values in variables which will be passed as arguments to the method
        System.out.print("Enter car price (€): ");
        double pcpPrice = input.nextDouble();
        System.out.print("Enter the deposit (€): ");
        double deposit = input.nextDouble();
        System.out.print("Enter the annual interest rate (%): ");
        double annualInterest = input.nextDouble();
        System.out.print("Enter the term in years: ");
        int termInYears = input.nextInt();
        System.out.print("Enter the GMFV percentage as an integer: ");
        int gmfvPercent = input.nextInt();

        // pass the values as arguments to the pcpResultMonth method and store t
        // the return value for printing to the user
        double monthlyPayment = carPurchaserHelper.pcpResultMonth(pcpPrice, deposit,
                annualInterest, termInYears, gmfvPercent);
        // calculate banana payment amount
        double bananaPaymentAmount = carPurchaserHelper.calculateBananaPayment(pcpPrice, gmfvPercent);
        // format the monthlyPayment to print to 2dp
        String monthlyPaymentOutput = String.format("The monthly payment is €%.2f",monthlyPayment);
        // calculate banana payment and format output to 2dp
        String bananaPaymentOutput = String.format("A payment of €%.2f is required to own the car at " +
                "the end of the contract term.", bananaPaymentAmount);
        // print the monthly payment
        System.out.println(monthlyPaymentOutput);
        // print the banana payment
        System.out.println(bananaPaymentOutput);
    }

    /**
     * Collects information from the user to calculate and print an estimated weekly fuel cost.
     *
     * <p>The method prompts the user to enter distance and fuel cost values and passes these
     * to the {@code fuelCostEstimator} method of the {@code CarPurchaserHelper} class. It then
     * prints the estimated weekly cost to 2dp in the expected format for financial amounts.</p>
     *
     * @param input                 an instance of the {@code Scanner} class used to read user
     *                              input
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class used to
     *                              call a utility method that computes the weekly cost
     */
    public static void calculateFuelCost(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // read in the kilometers travelled per week and fuel cost from the user
        // this will be used to estimate the fuel cost per week
        System.out.print("Enter estimated kilometers traveled per week: ");
        double kilometersPerWeek = input.nextDouble();
        System.out.print("Enter the cost of fuel per liter in euros and cents: ");
        double costOfFuel = input.nextDouble();

        // print out the fuel cost per week
        double fuelCostPerWeek = carPurchaserHelper.fuelCostEstimator(kilometersPerWeek,
                costOfFuel);
        // format the fuelCostPerWeek to print to  2dp
        String fuelCostOutput  = String.format("The estimated fuel cost per week is "
                + "€%.2f", fuelCostPerWeek);
        System.out.println(fuelCostOutput);
    }

    /**
     * Collects information from the user to calculate the monthly repayments on a 0% interest
     * car loan.
     *
     * <p>The method reads the car cost and term of repayment in months and uses the
     * {@code calculateMonthlyCost} method of the {@code CarPurchaserHelper} to calculate the
     * monthly repayments. The value is then formatted to 2dp using the {@code format} method
     * of the {@code String} class and printed out to the user.</p>
     *
     * @param input                 an instance of the {@code Scanner} class used to read user
     *                              input
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class used to
     *                              call a utility method that computes the monthly cost
     */
    public static void calculateMonthlyCost(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // read in the car price and number of months from the user and store
        // these values will be passed as arguments to the fuelCostEstimator method
        System.out.print("Enter the car price (€): ");
        double carPrice = input.nextDouble();
        System.out.print("Enter the term of the repayments in months: ");
        int numberOfMonths = input.nextInt();

        // calculate the monthly repayment by passing the variables above as arguments
        // to the calcualteMonthlyCost method and store the returned value
        double monthlyCost = carPurchaserHelper.calculateMonthlyCost(carPrice,
                numberOfMonths);
        // format the monthly cost to print to 2dp
        String monthlyCostOutput = String.format("The monthly repayments are €%.2f",
                monthlyCost);
        // print out the monthly repayments for the user
        System.out.println(monthlyCostOutput);
    }

    /**
     * Collects information from the user to recommend a car purchase that compliments their
     * lifestyle
     *
     *<p>The method offers the user a choice between family, luxury, and adventure lifestyle
     * choices. It then reads in the users choice and calls the {@code recommendCarType}
     * method from the {@code CarPurchaserHelper} class and prints a summarised
     * recommendation including hire-purchase, personal contract plan, finance plan, and
     * estimated weekly fuel costs.</p>
     *
     * @param input                 an instance of the {@code Scanner} class used to read user
     *                              input
     * @param carPurchaserHelper    an instance of the {@code CarPurchaserHelper} class used to
     *                              call a utility method that makes a purchase recommendation
     */
    public static void recommendCarChoice(Scanner input, CarPurchaserHelper carPurchaserHelper) {
        // prompt the user of the car recommendation categories
        System.out.println("Please enter a lifestyle choice to get your car recommendation!");
        System.out.print("Enter an option from: 'family', 'luxury', 'adventure': ");
        // read in user choice
        String lifestyleChoice = input.nextLine();
        // get recommendation based on choice
        String recommendation = carPurchaserHelper.recommendCarType(lifestyleChoice);
        // print recommendation
        System.out.println(recommendation);
    }

}


