import javax.security.auth.login.LoginException;

public class CustomerManager {

    //private Logger logger;

    //public CustomerManager(Logger logger) {
    //   this.logger = logger;
    //}

    private Logger[] loggers;
    public CustomerManager(Logger[] loggers) {
        this.loggers = loggers;
    }




    //loosly - tightly coupled
    public void add(Customer customer){
        System.out.println("Müşteri eklendi " +  customer.getFirstName());


        //Utils utils = new Utils();
        Utils.runLoggers(loggers, customer.getFirstName());






       /* for(Logger logger: loggers){
            logger.log(customer.getFirstName());
        }*/



        //this.logger.log(customer.getFirstName());


        //DatabaseLogger logger = new DatabaseLogger();
        //logger.log(customer.getFirstName() + "veri tabanına loglandı ");

    }

    public void delete(Customer customer){
        System.out.println("Müsteri silindi" + customer.getFirstName() );



        Utils.runLoggers(loggers, customer.getLastName());


/*

        for(Logger logger: loggers){
            logger.log(customer.getFirstName());
        }
*/




        //DatabaseLogger logger = new DatabaseLogger();
        //logger.log(customer.getFirstName() + "veri tabanından silindi ");
        //this.logger.log(customer.getFirstName());

    }



}
