public class Main {
    public static void main(String[] args) {


        PersonManager personManager = new PersonManager(new KpsServiceAdapter());
        personManager.add(new Person("999", "Berkan"));

        //yeni eklenen servislerde manager bağımlı olmamlıdır.

    }

//-------------------------------------------------------------------
    class KpsService { //Bu koda dokunmuyoruz. Adaptasyona ihtiyacımız var.
        public boolean checkPerson(long tcNo, String firstName) {
            System.out.println("other service");
            return true;
        }
    }


    class KpsServiceAdapter implements PersonService {

        @Override
        public boolean checkPerson(Person person) {
            KpsService kpsService = new KpsService();
            kpsService.checkPerson(person.getTcNo(), person.getFirstName());
            return true;
        }
    }

    //-------------------------------------------------------
    interface PersonService {
        boolean checkPerson(Person person);
    }


    class PersonManager {
        PersonService personService;

        public PersonManager(PersonService personService) {
            this.personService = personService;
        }

        public void add(Person person) {
            System.out.println("İşlem yapıldı");
            personService.checkPerson(person);
        }
    }
}