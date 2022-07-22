

public class DatabaseLogger extends Logger {
        @Override   //eziyorum basedeki kodu
        public void log() {                                               //emaillogger diyorki logger sende log var ama benim farklı özelilkelrimde var kendi kodum var diyor metot override
            System.out.println("Database loglandı");
        }

    }
