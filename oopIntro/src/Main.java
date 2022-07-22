
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1,"Lenovo V14", 15000, "16 GB RAM", 10);    //13500 bunu siliyoruz çünkü get ile alınan veri



        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Lenovo v15");                 //eşittir ile değilde parametre ile veriyoruz.
        product2.setDetail("16 GB RAM");
        product2.setDiscount(10);
        product2.setUnitPrice(16000);

        System.out.println(product2.getUnitPriceAfterDiscount());



        Category category1 = new Category();
        //category1.id = 1;
        //category1.name = "İçecek";
        category1.setId(1);
        category1.setName("Icecek");



        Category category2 = new Category();
        //category2.id = 2;
        //category2.name = "Yiyecek";
        category2.setId(2);
        category2.setName("Yiyecek");


        //System.out.println(category1.name+"!");
        //System.out.println(category2.name+"!");
        System.out.println(category1.getName());
        System.out.println(category2.getName());






        Product product3 = new Product();









        //Product[] products = {product1, product2, product3};

        //for (Product product : products) {
        //    System.out.println(product.name);
        //}

        //System.out.println(products.length);



        //Product product2 = new Product();
        //product2.id =2;
        //product2.name = "Lenovo V15";
        //product2.unitPrice = 16000;
        //product2.detail = "32 GB RAM";
        //product2.discount = 10;
        //product2.unitPriceAfterDiscount = 14400;

        //Product product3 = new Product();
        //product3.id = 3;
        //product3.name = "HP 5";
        //product3.unitPrice = 10000;
        //product3.detail = "8 GB RAM";


    //Category category1 = new Category();
    //category1.id =1;
    //category1.name ="Bilgisayar";

    //Category category = new Category();
    //category2.id =2;
    //category2.name ="Ev/Bahçe";

    //ProductManager productManager = new ProductManager();
    //productManager.addToCart(product1);
    //productManager.addToCart(product2);
    //productManager.addToCart(product3);

}

}
