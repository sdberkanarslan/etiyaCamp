

public class Main {

    public static void main(String[] args) {       //birbirlerinin alternatifi olan kodlar için if kullanılmaz.

        //LogManager logManager = new LogManager();
        //logManager.log(1);

        CustomerManager customerManager = new CustomerManager();
        customerManager.add(new EmailLogger());



    }
}
