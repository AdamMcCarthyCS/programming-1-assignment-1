    import java.util.Scanner;

    public class Driver {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Create an instance of the CarPurchaseHelper class.
            CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

            // print the welcome message by passing the string returned from the function to print
            // method
            String welcomeMessage = carPurchaserHelper.printWelcomeMessage();
            System.out.println(welcomeMessage);

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


                // --- HP Calculation ---
                //ToDo :if user chooses HP
                if (choice == 1) {

                    // Read in the values needed for the calculateHP method
                    // Store the values in variables which will be passed to the calculateHP method
                    // as arguments when it is called

                    System.out.print("Enter car price: ");
                    double hpPrice = input.nextDouble();
                    System.out.print("Enter deposit: ");
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

                    // --- PCP Calculation ---
                if (choice == 2) {
                    // read in all the values needed for calling the pcpResultMonth method
                    // store these values in variables which will be passed as arguments to the method
                    System.out.print("Enter car price: ");
                    double pcpPrice = input.nextDouble();
                    System.out.print("Enter the deposit: ");
                    double deposit = input.nextDouble();
                    System.out.print("Enter the annual interest rate (%): ");
                    double annualInterest = input.nextDouble();
                    System.out.print("Enter the term in years: ");
                    int termInYears = input.nextInt();
                    System.out.print("Enter the GMFV percent: ");
                    int gmfvPercent = input.nextInt();

                    // pass the values as arguments to the pcpResultMonth method and store t
                    // the return value for printing to the user
                    double monthlyPayment = carPurchaserHelper.pcpResultMonth(pcpPrice, deposit,
                        annualInterest, termInYears, gmfvPercent);
                    // format the monthlyPayment to print to 2dp
                    String monthlyPaymentOutput = String.format("The monthly payment is €%.2f",monthlyPayment);
                    // print the monthly payment
                    System.out.println(monthlyPaymentOutput);

                }

                    // --- Fuel Cost Calculation ---
                if (choice == 3) {
                    // read in the kilometers travelled per week and fuel cost from the user
                    // this will be used to estimate the fuel cost per week
                    System.out.print("Enter estimated kilometers traveled per week: ");
                    double kilometersPerWeek = input.nextDouble();
                    System.out.print("Enter the cost of fuel per liter: ");
                    double costOfFuel = input.nextDouble();

                    // print out the fuel cost per week
                    double fuelCostPerWeek = carPurchaserHelper.fuelCostEstimator(kilometersPerWeek,
                            costOfFuel);
                    // format the fuelCostPerWeek to print to  2dp
                    String fuelCostOutput  = String.format("The estimated fuel cost per week is "
                        + "€%.2f", fuelCostPerWeek);
                    System.out.println(fuelCostOutput);
                }

                    // --- Monthly Cost Calculator ---
                if (choice == 4) {
                    // read in the car price and number of months from the user and store
                    // these values will be passed as arguments to the fuelCostEstimator method
                    System.out.print("Enter the car price: ");
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

            if (choice == 5) {
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





                //ToDo :Add in remaining choices for the methods you have written
                //in the CarPurchaseHelper class





                // If the user chooses to exit the program set the sentinel value to 0
                // this causes the loop to end
                if (choice == 6) {
                    choice = 0;
                }
                }
            // print the goodbye message returned by the method in the CarPurchaseHelper class
            String goodbyeMessage = carPurchaserHelper.printGoodbyeMessage();
            System.out.println(goodbyeMessage);
            }

        public void start(Scanner input, CarPurchaserHelper carPurchaserHelper) {
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
                if (choice == -1) {
                    System.out.println("That is not a valid menu choice");
                }
            }
        }

        public int chooseMenuItem(int userChoice, Scanner input,
              CarPurchaserHelper carPurchaserHelper) {
            if (userChoice == 1) {
                calculateHP(input, carPurchaserHelper);
                return 1;
            } else if (userChoice == 2) {
                calculatePCP(input, carPurchaserHelper);
                return 2;
            } else if (userChoice == 6) {
                return 0;
            } else {
                return -1;
            }
        }

        public void calculateHP(Scanner input, CarPurchaserHelper carPurchaserHelper) {
            // Read in the values needed for the calculateHP method
            // Store the values in variables which will be passed to the calculateHP method
            // as arguments when it is called

            System.out.print("Enter car price: ");
            double hpPrice = input.nextDouble();
            System.out.print("Enter deposit: ");
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

        public void calculatePCP(Scanner input, CarPurchaserHelper carPurchaserHelper) {
            // read in all the values needed for calling the pcpResultMonth method
            // store these values in variables which will be passed as arguments to the method
            System.out.print("Enter car price: ");
            double pcpPrice = input.nextDouble();
            System.out.print("Enter the deposit: ");
            double deposit = input.nextDouble();
            System.out.print("Enter the annual interest rate (%): ");
            double annualInterest = input.nextDouble();
            System.out.print("Enter the term in years: ");
            int termInYears = input.nextInt();
            System.out.print("Enter the GMFV percent: ");
            int gmfvPercent = input.nextInt();

            // pass the values as arguments to the pcpResultMonth method and store t
            // the return value for printing to the user
            double monthlyPayment = carPurchaserHelper.pcpResultMonth(pcpPrice, deposit,
                    annualInterest, termInYears, gmfvPercent);
            // format the monthlyPayment to print to 2dp
            String monthlyPaymentOutput = String.format("The monthly payment is €%.2f",monthlyPayment);
            // print the monthly payment
            System.out.println(monthlyPaymentOutput);
        }

        public void calculateFuelCost(Scanner input, CarPurchaserHelper carPurchaserHelper) {
            // read in the kilometers travelled per week and fuel cost from the user
            // this will be used to estimate the fuel cost per week
            System.out.print("Enter estimated kilometers traveled per week: ");
            double kilometersPerWeek = input.nextDouble();
            System.out.print("Enter the cost of fuel per liter: ");
            double costOfFuel = input.nextDouble();

            // print out the fuel cost per week
            double fuelCostPerWeek = carPurchaserHelper.fuelCostEstimator(kilometersPerWeek,
                    costOfFuel);
            // format the fuelCostPerWeek to print to  2dp
            String fuelCostOutput  = String.format("The estimated fuel cost per week is "
                    + "€%.2f", fuelCostPerWeek);
            System.out.println(fuelCostOutput);
        }
        }


