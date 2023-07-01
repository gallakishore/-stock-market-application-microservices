package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select count(*) from Customer where cmail=:mail", nativeQuery = true)
	public Integer checkEmailIsAvailableOrNot(String mail);

	public Customer findByCmail(String mail);

}
