import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Canal canal = new Canal(1,"Internet");

        Customer customer1 = new IndividualCustomer(1,"1122",canal,"Berkan","Arslan","12345678901");
        Address addresses = new Address(1,customer1,"Istanbul","Turkiye","Beşiktaş","Kabataş");
        System.out.println(customer1.getId());
        System.out.println(customer1.getCustomerNumber());
        System.out.println(customer1.getCanal().getName());

    }
}