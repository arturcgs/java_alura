import java.util.Scanner;

public class BankingAccount {
    public static void main(String[] args) {
        // start variables
        double balance = 2500.00;
        int operation = 6;
        String NAME = "Artur Caminero Gomes Soares";
        String ACCOUNT_TYPE = "Savings";
        Scanner scanner = new Scanner(System.in);

        // print initial information
        String initialMessage = """
                ******************************************
                Initial Information
                
                Name: %s
                Account type: %s
                Initial Balance: $%.2f
                *****************************************
                """.formatted(NAME, ACCOUNT_TYPE, balance);
        System.out.println(initialMessage);

        while (operation != 4) {
            // check for operation
            String operationsOption = """
                \nOperations:
                1 - Check Balance
                2 - Receive Value
                3 - Transfer Value
                4 - Exit
                """;
            System.out.println(operationsOption);
            operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println(String.format("\nCurrent Balance: $%.2f", balance));
                    break;
                case 2:
                    System.out.println("\nHow much would you like to deposit? ");
                    double deposit = scanner.nextDouble();
                    balance += deposit;
                    System.out.println(String.format("\nCurrent Balance: $%.2f", balance));
                    break;
                case 3:
                    System.out.println("\nHow much would you like to transfer? ");
                    double transfer = scanner.nextDouble();
                    balance -= transfer;
                    System.out.println(String.format("\nCurrent Balance: $%.2f", balance));
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("\nInvalid Operation. Try again.\n");
            }
        }
    }
}
