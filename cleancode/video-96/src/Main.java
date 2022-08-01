public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        customerManager.add(new Customer("Berkan", "Arslan", "9999999", 1));
    }
}

class CustomerManager {
    public void add(Customer customer) {
        System.out.println("EKLENDİ");
    }
}

class Customer {
    public String firstName;
    public String lastName;
    public String identityNumber;
    public int cityId;

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

