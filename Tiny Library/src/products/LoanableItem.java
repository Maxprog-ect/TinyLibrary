package products;

/**
 * abstract product loanable item
 */
public interface LoanableItem {
    /**
     *
     * @return the availability of the item
     */
    public boolean isAvailable();

    /**
     *
     * @param borrowed new availability of object
     */
    public void setBorrowed(boolean borrowed);

    /**
     *
     * @return the due date of the object
     */
    public String getDueDate();

    /**
     * displays the info of the object
     */
    public void displayInfo();
}
