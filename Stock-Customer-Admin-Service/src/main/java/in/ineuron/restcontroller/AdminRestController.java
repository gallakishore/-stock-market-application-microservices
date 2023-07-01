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

import in.ineuron.model.Admin;
import in.ineuron.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	private AdminServiceImpl adminService;

	@PostMapping("/save")
	public ResponseEntity<?> saveAdminInfo(@RequestBody Admin admin) {
		String message = adminService.saveAdminData(admin);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/findbyId/{id}")
	public ResponseEntity<?> findAdminInfoById(@PathVariable Integer id) {
		Admin admin = adminService.findAdminById(id);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@GetMapping("/findbyMail/{mail}")
	public ResponseEntity<?> findAdminInfoByMail(@PathVariable String mail) {
		Admin admin = adminService.findAdminByMail(mail);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAdminInfo(@RequestBody Admin admin) {
		String status = adminService.updateAdminData(admin);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteAdminInfo(@RequestBody Admin admin) {
		String status = adminService.deleteAdminDataByID(admin.getAid());
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
