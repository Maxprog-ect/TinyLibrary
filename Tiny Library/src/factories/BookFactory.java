package factories;

import products.*;

/**
 * A factory for creating book objects.
 * @author Mackenzie
 * @version 1
 */
public class BookFactory implements LoanableFactory {
    private final String dueDate;

    /**
     *
     * @param dueDate sets the due date of the objects being created
     */
    public BookFactory(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @param objData a string array containing the data of book being created
     * @return returns a new book object
     */
    @Override
    public LoanableItem createLoanable(String[] objData) {
        String title = objData[0];
        String author = objData[1];
        String isbn = objData[2];

        Book book = new Book(title, author, isbn, dueDate);

        return book;
    }
}
