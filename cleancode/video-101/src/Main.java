public class Main {

    public static void main(String[] args) {

        //check: kullanıcı doğrulama..gerçek kişimi değilmi.

        //add..service reference..addmernis..
        //Manager da mernisi cağıramazsın.
        //comment blokları kaldırmak daha okunur yapar kodu.

        public class KpsService //Bu koda dokunamıyoruz..
        {
            public boolean CheckPerson(long tcNo, String adi, String soyadi, int yil) {

                return true;

            }
        }
    }
}

//------------------------------------------

public class CustomerManager
{
    ICustomerDal customerDal;
    public CostumerManager(ICustomerDal){
        customerDal = customerDal;
        public void add(Customer costomer)
        KpsService kpsService =new KpsService();
        CheckCustomerExists(customer);

    }
}
