package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;
import in.ineuron.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerServiceImpl customerService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCustomerInfo(@RequestBody Customer customer) {
		String message = customerService.saveCustomerData(customer);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/findbyId/{id}")
	public ResponseEntity<?> findCustomerInfoById(@PathVariable Integer id) {
		Customer customer = customerService.findCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("/findbyMail/{mail}")
	public ResponseEntity<?> findCustomerInfoByMail(@PathVariable String mail) {
		Customer customer = customerService.findCustomerByMail(mail);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCustomerInfo(@RequestBody Customer customer) {
		String status = customerService.updateCustomerData(customer);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCustomerInfo(@RequestBody Customer customer) {
		String status = customerService.deleteCustomerDataByID(customer.getCid());
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
