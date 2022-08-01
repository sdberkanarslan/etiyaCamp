public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setFirstName("");
        CustomerManager customerManager = new CustomerManager();
        customerManager.add(customer);
    }
}

//--------------------------------------------------------------------------------------------------

class CustomerDal {
    public void add(Customer customer) {
        System.out.println("EKLENDİ");
    }
}

//--------------------------------------------------------------------------------------------------

//TECHNİCALDEBT
//Ürününü geliştirdiğimiz müşterilerin yenilenen ve değişen ihtiyaçlarını kodsal anlamda düzenlemek ve karşılamaktır.
//Hızlı yapayım düzelteyim mantığıdır. Teknik borçlanma olarak geçer. Borçlanmaya girilecekse code-refactor olabilmelidir.

class Customer {
    public String firstName;
    public String lastName;
    public String identityNumber;
    public int cityId;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String identityNumber, int cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.cityId = cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

//--------------------------------------------------------------------------------------------------
class CustomerManager {
    public void add(Customer customer) {    //ENCAPSULATION
        validate(customer);              //add operasyonunu temel bir validate operasyonu ile kontrol altına aldık.
    }


    CustomerDal customerDal = new CustomerDal;
    customerDal.add(customer);


    public void addByOtherBusiness() {                   //Minimum karakter isteniyor firstName için.
        CustomerDal customerDal = new CustomerDal;
        customerDal.add(customer);

    }
}




    //CODE SMELL(Kötü Kokan Kod)
    public void validate(Customer customer) {
        if (
                String.valueOf(customer.firstName).length() != 0 &&    //3 Logic aynı metodun içine koyduk. farklı metodlarda cagıracagız.
                String.valueOf(customer.lastName).length() != 0 &&
                String.valueOf(customer.cityId).length() != 0 &&
                String.valueOf(customer.identityNumber).length() != 0
        ) {
            //Bir Validasyon ile iş kodunu beraber yazdık(aynı metodun içinde), bu bir teknik borçlanmadır.


            public void validateFirstNameIfEmpty(Customer customer) {
                if (String.valueOf(customer.firstName).length() != 0)}
            {
                throw new Exception("Validasyon Hatası")
            }


        public void validateLastNameIfEmpty(Customer customer) {
            if (String.valueOf(customer.lastName).length() != 0)}
            {
                throw new Exception("Validasyon Hatası")
            }

        public void validateIdentityNumberIfEmpty() {
            if (String.valueOf(customer.identityNumber).length() != 0)}
            {
                throw new Exception("Validasyon Hatası")
            }


                if (
                        String.valueOf(customer.firstName).length() != 0 &&    //3 Logic aynı metodun içine koyduk. farklı metodlarda cagıracagız.
                                String.valueOf(customer.lastName).length() != 0 &&
                                String.valueOf(customer.cityId).length() != 0 &&
                                String.valueOf(customer.identityNumber).length() != 0
            ) {

            System.out.println("EKLENDİ");
            System.out.println("EKLENDİ");   //Validasyon bloğu ile iş kodu bloğu birbirine temas etmemeli bu yüzden refaktör etmeliyiz.
            System.out.println("EKLENDİ");
            System.out.println("EKLENDİ");
            System.out.println("EKLENDİ");
            System.out.println("EKLENDİ");

            //Yazdır komutlarını koruyoruz if bloğuyla..şartlarla.
            //Eğer yukarıdaki if için, değişkenler boş değilse == yazdır.. EKLENDİ.

        }
        System.out.println("DEĞERLER BOŞ OLDUĞU İÇİN EKLENEMEDİ");
    }
}
