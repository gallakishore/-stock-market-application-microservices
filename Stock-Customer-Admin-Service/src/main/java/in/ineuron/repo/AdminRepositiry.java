package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.model.Admin;

public interface AdminRepositiry extends JpaRepository<Admin, Integer> {

	@Query(value = "select count(*) from Admin where amail=:mail", nativeQuery = true)
	public Integer checkEmailIsAvailableOrNot(String mail);

	public Admin findByAmail(String amail);

}
