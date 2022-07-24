public class SmsLogger implements Logger{        //logger ı smslogger a uyarla
    @Override                                     //ınheritance da base kodun üzeerine istersek yazıyoruz override yapıyoruz burada operasyonu -metodu yazmalıyız.
    public void log(String message) {
        System.out.println("Sms gönderildi" + message);
    }
}
