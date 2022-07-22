

public class LogManager {

    //1 DATABASE
    //2 FİLE
    //3 E MAIL

    public void log(int logType) {
        if(logType == 1) {
            System.out.println("Veritabanına loglandı.");
        }
        else if(logType == 2) {
            System.out.println("Dosyaya loglandı.");
        }
        else {
            System.out.println("Email gönderildi.");
        }


    }

}
