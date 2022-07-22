public class Product {

    //ALANLARIMIZ (ÖNCE FİELD SONRA CONSTR. SONRA OPERASYO. OLACAK ŞEKL. SIRALANIR.)

    //encapsulation
    private int id;
    private String name;                                 //private: sadece bu class ın içerisinde demek. dışarıdan erişime kapatıyoruz.
    private double unitPrice;                             //içerden okuyan ve yazan getter ve setter lar operasyonlar yazıyoruz.
    private String detail;
    private double discount;
    //private double unitPriceAfterDiscount;  buna gere yok artık cünkü formülüzasyon yaptık o blokta

    public Product() {
    }

//public Product() {   //PARAMETRESİZ KISIM EKLEMELİYİZ

   // }


    //İNT ID YE SAG TIK YAPIP CONSTR EKLEYEREK YAPIYORUZ BURAYI, ELLE CONSTR YAZMAYA GEREK YOK
    public Product(int id, String name, double unitPrice, String detail, double discount) {    //buradan da siliyoruz çünkü sadece okuyoruz double ...unitPriceAfterDiscount
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;            // THIS DEMEK CLASS DEMEK, CLASS DA TANIMLANANLARI ATIYOR
        this.detail = detail;
        this.discount = discount;
        //this.unitPriceAfterDiscount = unitPriceAfterDiscount;              buna gere yok artık cünkü formülüzasyon yaptık o blokta
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getUnitPriceAfterDiscount() {
        return this.unitPrice-(this.unitPrice * this.discount / 100);  //UnitPriceAfterDiscount yazan yere formul ü hazırlıyayıp yazıyoruz.
    }

}



