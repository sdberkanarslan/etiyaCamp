package CoffeeShopDemo2.business.concretes;

import java.util.List;

import CoffeeShopDemo2.business.abstracts.CustomerCheckService;
import CoffeeShopDemo2.business.abstracts.CustomerService;
import CoffeeShopDemo2.dataAccess.abstracts.BaseRepository;
import CoffeeShopDemo2.entities.concretes.Customer;

public class StarbucksCustomerManager implements CustomerService  {

	CustomerCheckService customerCheckService;
	
	BaseRepository baseRepository;
	
	public StarbucksCustomerManager(BaseRepository baseRepository,CustomerCheckService customerCheckService) {
		
		this.customerCheckService = customerCheckService;
		this.baseRepository=baseRepository;
	}

	@Override
	public void add(Customer customer) {
		if(customerCheckService.checkIfRealPerson(customer)) {
			baseRepository.add(customer);
			System.out.println("Musteri basarılı sekilde eklendi "+ customer.getFirstName());
		}
		
		else {
			System.out.println("Müşteri eklenemedi "+customer.getFirstName()+" "+customer.getLastName());
		}
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAll() {
		
		return baseRepository.getAll();
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
