package client; /**
 * class for creating patrons
 * @author Mackenzie
 * @version 1
 */

import products.LoanableItem;

import java.util.ArrayList;

public class Patron {
    private final String patronName; //variable for patron name
    private final String patronEmail; //variable for patron email
    private ArrayList<LoanableItem> borrowedItems; //list of borrowed items

    /**
     *
     * @param patronName name of patron being created
     * @param patronEmail email of patron being created
     */
    public Patron(String patronName, String patronEmail) {
        this.patronName = patronName;
        this.patronEmail = patronEmail;
        borrowedItems = new ArrayList<>();
    }

    /**
     *
     * @return name of the patron
     */
    public String getName() {
        return patronName;
    }

    /**
     *
     * @return email of the patron
     */
    public String getEmail() {
        return patronEmail;
    }

    /**
     *
     * @param item loanable item to be borrowed
     * @return whether item was successfully withdrawn
     */
    public boolean withdrawItem(LoanableItem item) {
       return borrowedItems.add(item);
    }

    /**
     *
     * @param item loanable item to be returned
     * @return whether item was successfully returned
     */
    public boolean returnItem(LoanableItem item) {
        return borrowedItems.remove(item);
    }

    /**
     * display the patrons borrowed items
     */
    public void displayBorrowedItems() {
        for (LoanableItem item : borrowedItems) { //iterate through borrowed items
            item.displayInfo(); //display the item info
        }
    }
}
