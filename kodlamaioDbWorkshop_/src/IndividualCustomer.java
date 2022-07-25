import java.util.List;

public class IndividualCustomer extends Customer {
    private String firstName;
    private String lastName;
    private String nationalityIdentity;

    public IndividualCustomer() {
    }

    public IndividualCustomer(int id, String customerNumber, Canal canal, String firstName, String lastName, String nationalityIdentity) {
        super(id, customerNumber, canal);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalityIdentity = nationalityIdentity;
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

    public String getNationalityIdentity() {
        return nationalityIdentity;
    }

    public void setNationalityIdentity(String nationalityIdentity) {
        this.nationalityIdentity = nationalityIdentity;
    }
}
