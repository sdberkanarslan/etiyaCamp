

public class Main {
    public static void main(String[] args) {

        //Customer customer = new Customer();
        //customer.id =1;
        //customer.firstName ="Berkan";               //herseyi içeren classlar ....müşretileri ayırmak lazım..
        //customer.lastName ="Arslan";
        //customer.customerNumber ="1323";
        //customer.naionalIdentity ="10000000";

        IndividualCustomer berkan = new IndividualCustomer() ;
        berkan.customerNumber = "12345";

        CorporoteCustomer hepsiBurada = new CorporoteCustomer();
        hepsiBurada.customerNumber = "78910";


        SendikaCustomer abc = new SendikaCustomer();
        abc.customerNumber ="99999";


        CustomerManager customerManager = new CustomerManager();
        //customerManager.add(hepsiBurada);
        //customerManager.add(berkan);
        //customerManager.add(abc);

        Customer[] customers = {berkan, abc, hepsiBurada};


        customerManager.addMultiple(customers);






    }


}
