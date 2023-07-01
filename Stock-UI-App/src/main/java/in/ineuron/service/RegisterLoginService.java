package in.ineuron.service;

import in.ineuron.model.Admin;
import in.ineuron.model.Customer;

public interface RegisterLoginService {

	public String registerAdminData(Admin admin);
	public String updateAdminData(Admin admin);

	public String registerCustomerData(Customer customer);
	public String updateCustomerData(Customer customer);
	
	public String fetchAndCompareAdminDetails(String mail,String password);
	
	public Admin fetchAdminDetails(String mail);
	
	public Customer fetchCustomerDetails(String mail);
	
	public String fetchAndCompareCustomerDetails(String mail,String password);

}
