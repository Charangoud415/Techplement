package PasswordManager.com;

import java.util.Scanner;

public class Main {
    private static final String AES_KEY = "1234567890123456"; // 16-byte key (change it)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPassword Manager");
            System.out.println("1. Store Password");
            System.out.println("2. Retrieve Password");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 1) {
                System.out.print("Enter website: ");
                String website = scanner.nextLine();
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                PasswordStorage.storePassword(website, username, password, AES_KEY);
            } else if (choice == 2) {
                System.out.print("Enter website to retrieve password: ");
                String website = scanner.nextLine();
                PasswordRetrieval.retrievePassword(website, AES_KEY);
            } else {
                System.out.println("Exiting...");
                break;
            }
        }
        
        scanner.close();
    }
}
