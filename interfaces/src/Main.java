public class Main {

    public static void main(String[] args){

        Logger[] loggers = {new SmsLogger(), new EmailLogger(), new FileLogger()};



        CustomerManager customerManager = new CustomerManager(loggers);
        Customer berkan = new Customer(1, "Berkan", "Arslan");
        customerManager.add(berkan);

    }
}
