package products;

/**
 * A concrete product book that implements the loanable interface
 * @author Mackenzie
 * @version 1
 */
public class Book implements LoanableItem {
    private String dueDate; //holds the due date of the book
    private final String title; //holds the title of the book
    private final String author; //variable for author
    private final String isbn; //variable for isbn
    private boolean borrowed; //boolean for availability, initially set to false

    /**
     *
     * @param title title of the book
     * @param author name of the book's author
     * @param isbn isbn of the book
     * @param dueDate due date of the book
     */
    public Book(String title, String author, String isbn, String dueDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.dueDate = dueDate;
        borrowed = false;
    }

    /**
     *
     * @return the due date
     */
    @Override
    public String getDueDate() { return dueDate;}

    /**
     * A method for displaying the info of the book object
     */
    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Due Date: " + dueDate);
        if (borrowed) {System.out.println("Borrowed" + '\n');}
        else {System.out.println("Available" + '\n');}
    }

    /**
     *
     * @return the status of the book availability
     */
    @Override
    public boolean isAvailable() {
        return !borrowed;
    }

    /**
     *
     * @param borrowed a boolean providing the new state of the availability
     */
    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setDueDate(String dueDate) { this.dueDate = dueDate;}
}
