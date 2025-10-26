    import java.util.Scanner;

    public class Driver {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Create an instance of the CarPurchaseHelper class.
            CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

            // print the welcome message by passing the string returned from the function to print
            // method
            String welcomeMessage = carPurchaserHelper.printWelcomeMessage();
            System.out.println();

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
                    // print the monthly HP payment which was calculated using the method for the user
                    System.out.println("Monthly HP payment: €" + hpMonthly);
                }

                    // --- PCP Calculation ---
                if (choice == 2) {
                    // read in all the values needed for calling the pcpResultMonth method
                    // store these values in variables which will be passed as arguments to the method
                    System.out.print("Enter car price: ");
                    double pcpPrice = input.nextDouble();
                    System.out.print("Enter the deposit: ");
                    double deposit = input.nextDouble();
                    System.out.print("Enter the annualInterest: ");
                    double annualInterest = input.nextDouble();
                    System.out.print("Enter the term in years: ");
                    int termInYears = input.nextInt();
                    System.out.print("Enter the gmfv percent: ");
                    int gmfvPercent = input.nextInt();

                    // pass the values as arguments to the pcpResultMonth method and store t
                    // the return value for printing to the user
                    double monthlyPayment = carPurchaserHelper.pcpResultMonth(pcpPrice, deposit,
                        annualInterest, termInYears, gmfvPercent);

                    // print the monthly payment
                    System.out.println("The monthly payment is €" + monthlyPayment);

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
                    System.out.println("The estimated fuel cost per week is €" + fuelCostPerWeek);
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

                    // print out the monthly repayments for the user
                    System.out.println("The monthly repayments are €" + monthlyCost);
                }

            if (choice == 5) {
                // prompt the user of the car recommendation categories
                System.out.println("Please enter a lifestyle choice to get your car reccomendation!");
                System.out.print("Enter an option from: 'family', 'luxury', 'adventure': ");
                // read in user choice
                String lifestyleChoice = input.nextLine();
                // get recommendation based on choice
                String recommendation = carPurchaserHelper.recommendCarType(lifestyleChoice);
                // print reccomendation
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

        }


