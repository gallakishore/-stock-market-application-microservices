package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.model.Admin;
import in.ineuron.model.Customer;

@Service
public class RegisterLoginServiceImpl implements RegisterLoginService {

	@Override
	public String registerAdminData(Admin admin) {

		String status = null;
		WebClient client = null;
		String end_point = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:9999/api/admin/save";

			status = client.post().uri(end_point).accept(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(admin)).retrieve().bodyToMono(String.class).block();
		} catch (Exception e) {

			status = "Admin Data Insertion Failed Please Try After Some Time";

		}
		return status;
	}

	@Override
	public String registerCustomerData(Customer customer) {

		String status = null;
		WebClient client = null;
		String end_point = null;
		try {

			client = WebClient.create();
			end_point = "http://localhost:9999/api/customer/save";
			status = client.post().uri(end_point).accept(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(customer)).retrieve().bodyToMono(String.class).block();
		} catch (Exception e) {
			status = "Customer Data Insertion Failed Please Try After Some Time";
		}
		return status;
	}

	@Override
	public String fetchAndCompareAdminDetails(String mail, String password) {

		WebClient client = null;
		String end_point = null;
		String status = null;
		Admin admin = null;
		String pass = null;

		try {
			client = WebClient.create();
			end_point = "http://localhost:9999/api/admin/findbyMail/{mail}";
			admin = client.get().uri(end_point, mail).retrieve().bodyToMono(Admin.class).block();

			pass = admin.getPassword();

			System.out.println(admin);
			if (pass.equals(password)) {
				status = "success";
			} else
				status = "failure";

		} catch (Exception e) {
			System.out.println(e.getMessage());

			if (e.getMessage().contains("404 Not Found"))
				status = "wrongEmail";
			else
				status = "errorpage";
		}

		return status;
	}

	@Override
	public String fetchAndCompareCustomerDetails(String mail, String password) {

		WebClient client = null;
		String end_point = null;
		String status = null;
		Customer customer = null;
		String pass = null;

		try {
			client = WebClient.create();
			end_point = "http://localhost:9999/api/customer/findbyMail/{mail}";
			customer = client.get().uri(end_point, mail).retrieve().bodyToMono(Customer.class).block();

			pass = customer.getPassword();

			System.out.println(customer);

			if (pass.equals(password))
				status = "success";
			else
				status = "failure";

		} catch (Exception e) {
			System.out.println(e.getMessage());

			if (e.getMessage().contains("404 Not Found"))
				status = "wrongEmail";
			else
				status = "errorpage";
		}

		return status;
	}

	@Override
	public Admin fetchAdminDetails(String mail) {

		WebClient client = null;
		String end_point = null;
		Admin admin = null;

		client = WebClient.create();
		end_point = "http://localhost:9999/api/admin/findbyMail/{mail}";
		admin = client.get().uri(end_point, mail).retrieve().bodyToMono(Admin.class).block();

		System.out.println(admin);

		return admin;
	}

	@Override
	public Customer fetchCustomerDetails(String mail) {

		WebClient client = null;
		String end_point = null;
		Customer customer = null;

		client = WebClient.create();
		end_point = "http://localhost:9999/api/customer/findbyMail/{mail}";
		customer = client.get().uri(end_point, mail).retrieve().bodyToMono(Customer.class).block();

		System.out.println(customer);

		return customer;
	}

	@Override
	public String updateAdminData(Admin admin) {

		String status = null;
		WebClient client = null;
		String end_point = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:9999/api/admin/update";

			status = client.put().uri(end_point).accept(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(admin))
					.retrieve().bodyToMono(String.class).block();
		} catch (Exception e) {

			status = "Admin Data Updation Failed Please Try After Some Time";

		}
		return status;
	}

	@Override
	public String updateCustomerData(Customer customer) {

		String status = null;
		WebClient client = null;
		String end_point = null;
		try {

			client = WebClient.create();
			end_point = "http://localhost:9999/api/customer/update";
			status = client.put().uri(end_point).accept(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(customer)).retrieve().bodyToMono(String.class).block();
		} catch (Exception e) {
			status = "Customer Data Updation Failed Please Try After Some Time";
		}
		return status;
	}

}
