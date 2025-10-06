package factories;

import products.*;

/**
 * A factory for creating products.CD objects.
 * @author Mackenzie
 * @version 1
 */
public class CDFactory implements LoanableFactory {
    private String dueDate;

    /**
     *
     * @param dueDate sets the due date for the objects being created
     */
    public CDFactory(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @param objData a string array of data for the products.CD being created
     * @return a new products.CD object
     */
    @Override
    public LoanableItem createLoanable(String[] objData) {
        String albumName = objData[0];
        String artist = objData[1];

        CD cd = new CD(albumName, artist, dueDate);
        return cd;
    }

}
