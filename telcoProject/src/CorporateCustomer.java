import java.util.List;

public class CorporateCustomer extends Customer{
    private int companyName;
    private String taxNumber;

    public CorporateCustomer() {
    }

    public CorporateCustomer(int id, String customerNumber, List<Subscription> subscriptions, int companyName, String taxNumber) {
        super(id, customerNumber, subscriptions);
        this.companyName = companyName;
        this.taxNumber = taxNumber;
    }

    public int getCompanyName() {
        return companyName;
    }

    public void setCompanyName(int companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
