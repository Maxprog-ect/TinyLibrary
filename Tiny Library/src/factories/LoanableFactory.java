package factories;
import products.LoanableItem;

/**
 * abstract factory for creating loanable objects
 */
public interface LoanableFactory {
    /**
     *
     * @param objData data of object to be created
     * @return a new loanable object
     */
    LoanableItem createLoanable(String[] objData);
}
