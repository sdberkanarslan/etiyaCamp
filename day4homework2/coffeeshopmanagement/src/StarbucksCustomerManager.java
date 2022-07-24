public class StarbucksCustomerManager extends BaseCustomerManager{

    private ICostumerCheckService iCustomerCheckService;

    public StarbucksCustomerManager(ICostumerCheckService iCostumerCheckService){
        this.iCustomerCheckService = iCostumerCheckService;
    }


    @Override

    public void Save(Customer customer) throws Exception  {
        if(ICostumerCheckService.checkIfRealPerson(customer))
        {
            super.Save(customer);
        }
        else
        {
            throw new Exception("Not a valid person");
        }
    }
}
