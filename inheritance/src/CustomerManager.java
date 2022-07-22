

public class CustomerManager {
    public void add(Customer customer) {   //birşey geri döndürmesin denileni yapsın. veri kaynağına gitsin eklesin.
        //customer.***********
        System.out.println(customer.customerNumber + " kaydedildi");
    }

    //bulk insert
    public void addMultiple(Customer[] customers) {                   //addMultiple çoklu ekleme demek.
        for(Customer customer : customers) {             //gönderdiğimiz her müsteriyi array-diziye ekleyecek.
            add(customer);                               //polimorphizm sağlayan yapı?
        }
    }




    //public void add(CorporoteCustomer customer) {                                  //2 ayrı metot yaptık.
       // System.out.println(customer.customerNumber + " kaydedildi");

   // }


    //SOLID- OPEN CLOSED PRİNCİPLE ... sisteme yei özellik eklendiğinde mevcut kodu değiştiremezsiniz. yeni kod ekleyebilirsin.

}
