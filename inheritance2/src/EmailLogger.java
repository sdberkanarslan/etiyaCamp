

public class EmailLogger extends Logger {                             //polımorphizm örneğin : logger email loggerin özelliklerini kullanabilir.
    @Override   //eziyorum basedeki kodu
    public void log() {                                               //emaillogger diyorki logger sende log var ama benim farklı özelilkelrimde var kendi kodum var diyor metot override
        System.out.println("Email loglandı");
    }


}
