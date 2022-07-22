

public class FileLogger extends Logger {
        @Override   //eziyorum basedeki kodu....üzerine yazacağım demek
        public void log() {                                               //emaillogger diyorki logger sende log var ama benim farklı özelilkelrimde var kendi kodum var diyor metot override
            System.out.println("File loglandı");
        }

    }
