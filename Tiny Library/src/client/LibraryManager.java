package client;

/**
 * handles the main logic loop of the program and controls the library system.
 * @Author Mackenzie
 * @Version 1
 */

import products.LoanableItem;

import java.util.Scanner;

public class LibraryManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //create a new scanner for the program
        LibrarySystem librarySystem = new LibrarySystem(); //create the library
        int running = 1; //set running to 1
        String email; //string for the patron's email
        String id; //string for the item id
        LoanableItem item; // a variable to hold the item

        System.out.println("Welcome to the library!"); //first time welcome message
        while (running == 1) {
            displayMenu(); //display the options

            int choice = Integer.parseInt(scanner.nextLine()); //get choice from user

            switch (choice) {

                case 1: //case 1 is object is being rented
                    System.out.println("What is your email?");
                    email = scanner.nextLine(); //prompt for patron email and store
                    System.out.println("Enter the id of the item you would like to rent:");
                    id = scanner.nextLine(); //prompt for item id and store
                    item = librarySystem.findItem(id); // make sure the item exists and is available
                    if (item == null) {System.out.println("Item doesn't exist.\n"); break;}
                    if (!item.isAvailable()) {System.out.println("Item is not available\n"); break;}
                    else {
                        librarySystem.withdrawItem(email, id);//use the library system to withdraw item
                    }
                    break;

                case 2: //case 2 object is being returned
                    System.out.println("What is your email?");
                    email = scanner.nextLine(); //prompt for patron email and store
                    System.out.println("Enter the id of the item you would like to return:");
                    id = scanner.nextLine(); //prompt for item id and store
                    item = librarySystem.findItem(id); //check item exists and is checked out
                    if (item == null) {System.out.println("Item doesn't exist.\n"); break;}
                    if (item.isAvailable()) {System.out.println("Item is already turned in\n"); break;}
                    else {
                        librarySystem.returnItem(email, id);//return the item
                    }
                    break;

                case 3: //case 3 display library items
                    librarySystem.displayItems(); //use library system to display all library items
                    break;

                case 4: //case 4 show currently checked out items
                    librarySystem.displayBorrowedItems(); //use library system method to display
                    break;

                case 5:
                    System.out.println("Which item would you like to add?");
                    System.out.println("1. Add book");
                    System.out.println("2. Add cd");
                    System.out.println("3. add magazine"); //prompt for item type and store choice

                    int itemType;
                    try {
                        itemType = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Enter a valid number.\n");
                        break;
                    }

                    librarySystem.addItem(itemType); //add item using library system
                    break;

                case 6: //case 7 add a new patron to library
                    System.out.println("What is the patron's name?");
                    String patronName = scanner.nextLine();
                    System.out.println("What is the patron's email?");
                    String patronEmail = scanner.nextLine();
                    librarySystem.addPatron(patronName, patronEmail);
                    System.out.println("Patron added successfully.");
                    break;

                case 7: //quit program
                    running = 0;
                    break;
            }
        }
    }

    /**
     * a method used to display the menu
     */
    public static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Rent an item");
        System.out.println("2. Return an item");
        System.out.println("3. Show all items");
        System.out.println("4. Show all items currently checked out");
        System.out.println("5. Add Item");
        System.out.println("6. Add Patron");
        System.out.println("7. Exit");
    }
}
