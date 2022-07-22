

public class CustomerManager {
    public void add(Logger logger) {                     //logger 3ününde referansını tutabilir.


        //müşteri ekleme kodları
        System.out.println("Müşteri eklendi");


        //iş yapan sınıflar: filelogger databaselogger emaıllogger bunlar somut sınıflardır
        //DatabaseLogger logger = new DatabaseLogger();

        logger.log();                                               // bunlar asla newlenemez
    }
}
