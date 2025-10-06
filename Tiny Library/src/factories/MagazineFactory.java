package factories;

/**
 * A factory for creating magazine objects.
 * @author Mackenzie
 * @version 1
 */

import products.*;

public class MagazineFactory implements LoanableFactory {
    private final String dueDate; //due date of magazine items

    /**
     *
     * @param dueDate sets the due date of the factory
     */
    public MagazineFactory(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @param objData data of object to be created
     * @return the new magazine object
     */
    @Override
    public LoanableItem createLoanable(String[] objData) {
        String title = objData[0];
        String publisher = objData[1];
        int volumeNum = Integer.parseInt(objData[2]);

        Magazine newMagazine = new Magazine(title, publisher, volumeNum, dueDate);
        return newMagazine;


    }

}
