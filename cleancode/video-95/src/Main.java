public class Main {
    CustomerManager customerManager = new CustomerManager();
    customerManager.add("berkan","asdasda","asdfsa");
    customerManager.add("berkan","asdasda","asdaas",1); // Başka bir özellik eklenmesi istendiğinde,sistemde birden fazla yere ekleme yapamayız. Bu yanlıştır.
    customerManager.add("berkan","aassdaa","asdasd");
    customerManager.add("berkan","aaddasd","adfasd");

}

    public class CustomerManager {
        public void add(String firstName, String lastName, String identityNumber){
            System.out.println("EKLENDİ");
        }
    }
