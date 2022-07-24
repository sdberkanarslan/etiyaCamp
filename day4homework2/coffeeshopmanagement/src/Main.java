
public class Main {
    public static void main(String[] args){
        BaseCustomerManager customerManager = new BaseCustomerManager() {};
        customerManager.save(new Customer(1,"Berkan","Arslan","1996.01.01","12345678910"));
    }
}
