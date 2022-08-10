package CoffeeShopDemo2;

import CoffeeShopDemo2.business.abstracts.CustomerCheckService;
import CoffeeShopDemo2.business.abstracts.CustomerService;
import CoffeeShopDemo2.business.concretes.NeroCustomerManager;
import CoffeeShopDemo2.business.concretes.StarbucksCustomerManager;
import CoffeeShopDemo2.core.adapters.MernisServiceAdapter;
import CoffeeShopDemo2.dataAccess.abstracts.BaseRepository;
import CoffeeShopDemo2.dataAccess.concretes.hibernateImpls.HibernateCustomerRepository;
import CoffeeShopDemo2.entities.concretes.Customer;

public class Main {


	public static void main(String[] args) {
		
		CustomerService customerService=new NeroCustomerManager(new HibernateCustomerRepository());
		
		Customer customer1=new Customer(1,"Berkan","Arslan","11111111111",1996);
		Customer customer2=new Customer(2,"Semih","Arslan","22222222222",1997);
		
		CustomerService customerService1= new StarbucksCustomerManager( new HibernateCustomerRepository(),new MernisServiceAdapter());
		Customer customer3=new Customer(2,"Berkan","Arslan","11111111111",1996);
		
		
		customerService1.add(customer1);
		customerService1.add(customer2);
		customerService1.add(customer3);

	}

}
