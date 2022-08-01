public class Main {
    public static void main(String[] args) {

        System.out.println("Class: (Sınıf) lar için PascalCase kullanılır.");
        System.out.println("Method: (Method) lar için lower camelCase kullanılır.");
        System.out.println("Variable: (Değişken) ler için lower camelCase kullanılır. ");
        System.out.println("Sabitler: Sabitler için screaming snake case kullanılır.");

        int id;

        final int MAX_AGE = 35;
        class Person {

            public Person(){

            }

        }
        interface Person1 {
            public void getAllByCategoryId(int categoryId);
        }

    }
}