public abstract class BaseCustomerManager implements ICostumerService{

    static void save(Customer customer){
        System.out.println("Saved to db" + customer.firstName);
    }

    public abstract void Save(Customer customer) throws Exception;
}
