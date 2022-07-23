public class Main {


    public static void main(String[] args) {

        String mesaj = "Bugün hava çok güzel.";
        System.out.println(mesaj);

        /*System.out.println("Eleman sayısı : " + mesaj.length());
        System.out.println("5. eleman : " + mesaj.charAt(4));        //Bir stringde karakter çağırmak için kullanılır.
        //System.out.println(mesaj.concat(" Yaşasın!"));

        String mesaj2 = mesaj.concat("YAŞASIN");                 //concat: Ekleme yapmak için kullanılır.
        System.out.println(mesaj2);

        System.out.println(mesaj.startsWith("B"));                   //startsWith: Boolean olarak neyle başladığını sorgular.
        System.out.println(mesaj.endsWith("."));                     //endsWith: Boolean olarak neyle bittiğini sorgular.
                                                                     //sensesensitive..büyük küçük duyarlıdır.

        char[] karakterler = new char[25];
        mesaj.getChars(0,4,karakterler,0);
        System.out.println(karakterler);
        System.out.println(mesaj.indexOf("av"));               //indexOf: bastan kaçıncı sırada şeklinde bulmamız için kullanılır.
        System.out.println(mesaj.lastIndexOf("a"));         //lastIndexOf: sondan kacıncı sırada şeklinde.
*/
        String yeniMesaj = mesaj.replace(' ', '-');
        System.out.println(yeniMesaj);
        System.out.println(mesaj.substring(2, 4));               //replace: boşluk gördüğün yerlere - koymak .


        for (String kelime : mesaj.split(" ")) {           //split: boşluk olan kısımlara kelime olarak tanımlayıp alta geçirdik.
            System.out.println(kelime);
        }

        System.out.println(mesaj.toLowerCase());                //harfleri küçük harf yap.
        System.out.println(mesaj.toUpperCase());                //harfleri büyük harf yap.

        System.out.println(mesaj.trim());
        

    }
}
