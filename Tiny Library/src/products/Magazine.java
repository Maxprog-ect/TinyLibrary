package products;

/**
 * A concrete product magazine that implements the loanable interface
 * @author Mackenzie
 * @version 1
 */
public class Magazine implements LoanableItem {
    private String dueDate; //due date of the magazine
    private String title; //title of the magazine
    private String publisher; //publisher of the magazine
    private int volumeNum; //volume number of the magazine
    private boolean borrowed;

    /**
     *
     * @param title title of the magazine being added
     * @param publisher publisher of the magazine being added
     * @param volumeNum volume number of magazine being added
     * @param dueDate due date of the magazine being added
     */
    public Magazine(String title, String publisher, int volumeNum, String dueDate) {
        this.title = title;
        this.publisher = publisher;
        this.volumeNum = volumeNum;
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
     * displays the info of the magazine object
     */
    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Volume: " + volumeNum);
        System.out.println("Due Date: " + dueDate);
        if (borrowed) {System.out.println("Borrowed" + '\n');}
        else {System.out.println("Available" + '\n');}
    }

    /**
     *
     * @return the availability of the magazine object
     */
    @Override
    public boolean isAvailable() { return !borrowed; }

    /**
     *
     * @param borrowed new availability of object
     */
    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
