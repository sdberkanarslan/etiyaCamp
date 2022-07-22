
////***
public class Category {
    private int id;                 //FIELD BLOGU
    private String name;            //dışarıdan erişim yasak demek private


    public Category() {
        //CONSR BLOGU PARAMETRESİZ
    }

    public Category(int id, String name) {      //CONSTR BLOGU PARAMETRELİ
        this.id = id;                           //This();  basedekini çaılştırır parameteresiz olan ama kullanılmayadabilir.
        this.name = name;
    }



                                        //OPREASYON FONSKİYON BLOGU

    public int getId() {         //ınt burada veri verdiğimde okuduğunda sayı vericem demek, metot çalıştığında oluşacak verinin türünü belirtir...
        return id;        //döndür demek veriyi

    }

    //***private int id() {                       //????????????
     //   return this.id();
   // }

    public void setId(int id) {              //void emirdir bunun değeri budur dediğinizde return edilmiyor id 1 dediğinde 1 yazar void ile
        this.id = id;                             //id olmasının sebebi parantez içiersinde id oalrak tanımladık en yakın olanı referans alırız.

    }

    public String getName() {               //parametre yok okumalarda yani getname in parantez içinde parametre yok...
        return this.name + "!";                         //okuyacağım veri String olacak diyorsan aldığın veri mutalaka strin aynı sekilde hangi tür dersen onu alacak aksi halde hata verir.
                                                  //tip güvenli bir programlama dilidir.
    }                                         //ünlem eklemek istedik sadece buradan düzenleyerek ekleenen heryerdeki ürünler istediğimiz gibi oluyor.

    public void setName(String name) {
        this.name =name;
    }

}
