public class CorporateCustomer extends Customer{
    private String title;
    private long taxNumber;



    public CorporateCustomer(int id, String customerNumber, Canal canal, String title, long taxNumber) {
        super(id, customerNumber, canal);
        this.title = title;
        this.taxNumber = taxNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(long taxNumber) {
        this.taxNumber = taxNumber;
    }
}
