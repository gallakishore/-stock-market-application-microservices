package in.ineuron.service;

import in.ineuron.model.Customer;

public interface ICustomerService {

	public String saveCustomerData(Customer customer);

	public Customer findCustomerById(Integer id);

	public Customer findCustomerByMail(String mail);

	public String updateCustomerData(Customer admin);

	public String deleteCustomerDataByID(Integer aid);

}
