import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        new Driver();
    }
    Driver(){
        Scanner input = new Scanner(System.in);
        /*
        Create an instance of the CarPurchaseHelper class.
        */
        CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

        //To-do :call welcome message

        // print the welcome message by passing the string returned from the function to print
        // method
        System.out.println(carPurchaserHelper.printWelcomeMessage());

        // use sentinel value to start while loop
        int choice = -1;
        while (choice != 0) {
            System.out.println("--- Car Finance Calculator ---");
            System.out.println("1. Calculate HP");
            System.out.println("2. Calculate PCP");
            System.out.println("3. Calculate Fuel Cost");
            System.out.println("4. Calculate Monthly Cost");
            System.out.println("5. Recommend Car Type");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            // Add an empty line before the next lines printed out to the user
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





            //ToDo :Add in remaining choices for the methods you have written
            //in the CarPurchaseHelper class





            //ToDo : don't forget to update choice (LCV)
            }
        //ToDo :print goodbye message
        }

    }


