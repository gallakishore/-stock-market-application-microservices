package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.exception.CustomerDataInsertionException;
import in.ineuron.exception.CustomerDataNotFoundException;
import in.ineuron.model.Customer;
import in.ineuron.repo.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private  CustomerRepository customerRepo;

	@Override
	public String saveCustomerData(Customer customer) {
		Integer mailstatus = customerRepo.checkEmailIsAvailableOrNot(customer.getCmail());

		Integer id = null;
		System.out.println("Status :: "+mailstatus);

		if (mailstatus == 0)
			id = customerRepo.save(customer).getCid();
		else
			return "Mail Id Has Choosen By Another User";

		if (id != null)
			return "Customer Info is saved with id:: " + id;
		else
			throw new CustomerDataInsertionException("Customer Info Insertion Failed");
	}

	@Override
	public Customer findCustomerById(Integer id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isPresent())
			return customer.get();
		else
			throw new CustomerDataNotFoundException("Customer Info is not available for this id:: " + id);
	}

	@Override
	public String updateCustomerData(Customer customer) {

		Optional<Customer> customerInfo = customerRepo.findById(customer.getCid());
		if (customerInfo.isPresent()) {

			Customer customerPreviousInfo = customerInfo.get();
			if (customer.getCname() != null)
				customerPreviousInfo.setCname(customer.getCname());
			if (customer.getGender() != null)
				customerPreviousInfo.setGender(customer.getGender());
			if (customer.getPassword() != null)
				customerPreviousInfo.setPassword(customer.getPassword());

			Integer id = customerRepo.save(customerPreviousInfo).getCid();
			return "Cutomer info is updated for the id " + id;
		} else
			throw new CustomerDataNotFoundException(
					"Customer Info is not available for this id:: " + customer.getCid());
	}

	@Override
	public String deleteCustomerDataByID(Integer cid) {
		Optional<Customer> customerInfo = customerRepo.findById(cid);
		if (customerInfo.isPresent()) {
			customerRepo.deleteById(cid);
			return "Cutomer info is Deleted for the id " + cid;
		} else
			throw new CustomerDataNotFoundException("Customer Info is not available for this id:: " + cid);
	}

	@Override
	public Customer findCustomerByMail(String mail) {
		Customer customer = customerRepo.findByCmail(mail);
		if (customer != null)
			return customer;
		else
			throw new CustomerDataNotFoundException("Customer Info is not available for this mail:: " + mail);
	}

}
