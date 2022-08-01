public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setFirstName("Berkan");

        CustomerDal customerDal = new CustomerDal;
        if (customerDal.customerExists(customer)) {
            customerDal.add(customer);
        }
    }

//-----------------------------------------------------------------------
    public class CustomerDal {
        public void add(Customer customer) {
            System.out.println("VERİTABANI EKLENDİ");
        }

        public boolean CustomerExists(Customer customer) {
            //Veritabanında varmı yokmu, bize döndürsün varmı yokmu şeklinde.
            return true;
        }


    }

    //-----------------------------------------------------------------------

    public class Customer {
        private String firstName;
        private String lastName;
        private String identityNumber;
        private int cityId;

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


}