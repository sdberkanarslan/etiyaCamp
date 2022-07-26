public class CustomerManager {

    private Logger logger;

    public CustomerManager(Logger logger) {
        this.logger = logger;
    }

    public void add(Customer customer) {
        System.out.println("Customer added");
        this.logger.log(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getNationalIdentity() );

    }

    public void update(Customer customer) {
        System.out.println("Customer updated");
        this.logger.log(customer.getFirstName());
    }

}