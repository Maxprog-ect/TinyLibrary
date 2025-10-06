package client;

/**
 * handles the data structures used for the library
 */

import factories.BookFactory;
import factories.CDFactory;
import factories.LoanableFactory;
import factories.MagazineFactory;
import products.LoanableItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
    private Map<String, LoanableItem> library; //variable for item storage
    private Map<String, Patron> patrons; //variable for patron data storage
    private int counter = 1; //counter for key
    private LoanableFactory bookFactory; //factory for creating new books
    private LoanableFactory cdFactory; //factory for creating new cds
    private LoanableFactory magazineFactory; //factory for creating new magazines
    private Scanner scanner; //scanner for user inputs

    /**
     * creates a new library system and initializes variables and factories
     */
    public LibrarySystem() {
        library = new LinkedHashMap<>();
        patrons = new HashMap<>();
        bookFactory = new BookFactory( "2 weeks");
        cdFactory = new CDFactory("1 week");
        magazineFactory = new MagazineFactory("3 days");
        scanner = new Scanner(System.in);
    }

    /**
     *
     * @param type of item to be added
     */
    public void addItem(int type) {
        String[] objData = new String[3]; //create a string array to hold object data
        switch (type) {
            case 1: //book added
                System.out.println("Enter book title: ");
                objData[0] = scanner.nextLine();
                System.out.println("Enter author: ");
                objData[1] = scanner.nextLine();
                System.out.println("Enter ISBN: ");
                objData[2] = scanner.nextLine(); //prompt and store info

                library.put("item" + counter++, bookFactory.createLoanable(objData)); //create book with factory
                System.out.println("Item has been added to the library.\n");
                break;

            case 2: //cd added
                System.out.println("Enter album title: ");
                objData[0] = scanner.nextLine();
                System.out.println("Enter artist name: ");
                objData[1] = scanner.nextLine(); //prompt for cd data and store

                library.put("item" + counter++, cdFactory.createLoanable(objData)); //create cd with factory
                System.out.println("Item has been added to the library.\n");
                break;

            case 3: //magazine created
                System.out.println("Enter magazine title: ");
                objData[0] = scanner.nextLine();
                System.out.println("Enter publisher name: ");
                objData[1] = scanner.nextLine();
                System.out.println("Enter volume number: ");
                objData[2] = scanner.nextLine(); //prompt for and store object data

                try {
                    int i = Integer.parseInt(objData[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer. Item hasn't been added to the library.\n");
                    break;
                }
                library.put("item" + counter++, magazineFactory.createLoanable(objData)); //create magazine with factory
                System.out.println("Item has been added to the library.\n");
                break;

        }
    }

    /**
     *
     * @param id key of item to be found
     * @return return the loanableitem object
     */
    public LoanableItem findItem(String id) {
        if (library.containsKey(id)) { //check if library contains item and return item
            return library.get(id);
        } else {
            return null; //return null if item isn't in the library
        }
    }

    /**
     * display all items in the library
     */
    public void displayItems() {
        for (Map.Entry<String, LoanableItem> entry : library.entrySet()) { //iterate through each entry
            System.out.println("Item ID: " + entry.getKey()); //print item id
            entry.getValue().displayInfo(); //print item info
        }
    }

    /**
     * display all the borrowed items
     */
    public void displayBorrowedItems() {
        for (Patron patron : patrons.values()) { //iterate through each patron
            System.out.println(patron.getName() +": "); //print patron name
            patron.displayBorrowedItems(); //print borrowed items
        }
    }

    /**
     *
     * @param patronName name of patron to be added
     * @param patronEmail email of patron to be added
     */
    public void addPatron(String patronName, String patronEmail) {
        patrons.put(patronEmail, new Patron(patronName, patronEmail)); //add new patron
    }

    /**
     *
     * @param patronEmail email of patron withdrawing
     * @param id id of item to be withdrawn
     */
    public void withdrawItem(String patronEmail, String id) {
        Patron patron = patrons.get(patronEmail); //get patron
        if (patron == null) {System.out.println("Patron doesn't exist.");}//check if patron exists
        else {
            LoanableItem loanableItem = library.get(id); //get the item to be loaned
            patron.withdrawItem(loanableItem); //withdraw the item using patron method
            loanableItem.setBorrowed(true); //set the item as borrowed
            System.out.println("You have successfully rented " + id + ".");
        }
    }

    /**
     *
     * @param patronEmail email of patron returning item
     * @param id //item to be returned
     */
    public void returnItem(String patronEmail, String id) {
        Patron patron = patrons.get(patronEmail); //get the patron
        if (patron == null) {System.out.println("Patron doesn't exist.");} //check if the patron exists
        else {
            LoanableItem loanableItem = library.get(id); //get the item
            patron.returnItem(loanableItem); //return the item
            loanableItem.setBorrowed(false); //set the item as available
            System.out.println("You have successfully returned " + id + ".");
        }
    }

}
