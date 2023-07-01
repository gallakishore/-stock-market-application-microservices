package in.ineuron.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Admin;
import in.ineuron.model.Customer;
import in.ineuron.service.RegisterLoginService;

@Controller
@RequestMapping("/api/register")
public class CustomerAdminController {

	@Autowired
	private RegisterLoginService service;

	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}

	@GetMapping("/adminInfo")
	public String showAdminAboutPage() {
		return "displayAdminInfo";
	}

	@GetMapping("/customerLogin")
	public String showCustomerLoginPage() {
		return "customerLogin";
	}

	@GetMapping("/adminLogin")
	public String showAdminLoginPage() {
		return "adminLogin";
	}

	@GetMapping("/adminRegister")
	public String showAdminRegisterPage() {
		return "adminRegister";
	}

	@GetMapping("/customerRegister")
	public String showCustomerRegisterPage() {
		return "customerRegister";
	}

	@PostMapping("/adminDataRegister")
	public String saveAdminData(HttpServletRequest request, Model model) {

		String password = request.getParameter("adimPassword");
		String confPassword = request.getParameter("adimConfirmPassword");

		if (!password.equals(confPassword)) {
			model.addAttribute("message", "Password and Confirm Password are not Same");
			return "adminRegister";
		} else {
			String name = request.getParameter("adimName");
			String email = request.getParameter("adimEmail");
			String gender = request.getParameter("adminGender");

			Admin admin = new Admin();
			admin.setAmail(email);
			admin.setAname(name);
			admin.setGender(gender);
			admin.setPassword(password);

			String msg = service.registerAdminData(admin);
			model.addAttribute("message", msg);

			return "status";
		}

	}

	@PostMapping("/customerDataRegister")
	public String saveCustomerData(HttpServletRequest request, Model model) {

		String password = request.getParameter("customerPassword");
		String confPassword = request.getParameter("customerConfirmPassword");

		if (!password.equals(confPassword)) {
			model.addAttribute("message", "Password and Confirm Password are not Same");
			return "customerRegister";
		} else {
			String customerName = request.getParameter("customerName");
			String customerEmail = request.getParameter("customerEmail");
			String customerGender = request.getParameter("customerGender");

			Customer customer = new Customer();
			customer.setCmail(customerEmail);
			customer.setCname(customerName);
			customer.setGender(customerGender);
			customer.setPassword(password);

			String msg = service.registerCustomerData(customer);
			model.addAttribute("message", msg);
			return "status";
		}
	}

	@PostMapping("/adminLoginPortal")
	public String displayAdminHomePage(HttpServletRequest request, Model model) {

		String targetPage = null;
		String adminMail = request.getParameter("adminMail");
		String adminPassword = request.getParameter("adminPassword");

		if (adminMail == null || adminPassword == null) {
			model.addAttribute("errorMessage", "Please enter the details");
			return "adminLogin";
		}

		String status = service.fetchAndCompareAdminDetails(adminMail, adminPassword);

		if (status.equalsIgnoreCase("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("adminMail", adminMail);
			targetPage = "adminHomePage";
		} else if (status.equalsIgnoreCase("failure")) {
			model.addAttribute("errorMessage", "Please enter the password correctly");
			targetPage = "adminLogin";
		} else if (status.equalsIgnoreCase("wrongEmail")) {
			model.addAttribute("errorMessage", "Please enter the email id correctly");
			targetPage = "adminLogin";
		} else if (status.equalsIgnoreCase("errorpage")) {
			model.addAttribute("errorMessage", "Internal Server Error Please Try After Some Time");
			targetPage = "adminLogin";
		}
		return targetPage;
	}

	@PostMapping("/customerLoginPortal")
	public String displayCustomerHomePage(HttpServletRequest request, Model model) {

		String targetPage = null;
		String customerMail = request.getParameter("customerMail");
		String customerPassword = request.getParameter("customerPassword");

		if (customerMail == null || customerPassword == null) {
			model.addAttribute("errorMessage", "Please enter the details");
			return "customerLogin";
		}

		String status = service.fetchAndCompareCustomerDetails(customerMail, customerPassword);

		if (status.equalsIgnoreCase("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("customerMail", customerMail);
			targetPage = "customerHomePage";
		} else if (status.equalsIgnoreCase("failure")) {
			model.addAttribute("errorMessage", "Please enter the password correctly");
			targetPage = "customerLogin";

		} else if (status.equalsIgnoreCase("wrongEmail")) {
			model.addAttribute("errorMessage", "Please enter the email id correctly");
			targetPage = "customerLogin";
		} else if (status.equalsIgnoreCase("errorpage")) {
			model.addAttribute("errorMessage", "Internal Server Error Please Try After Some Time");
			targetPage = "customerLogin";
		}

		return targetPage;

	}

	@GetMapping("/adminDetails")
	public String displayAdminInfoPage(HttpServletRequest request, Model model) {
		String target = null;
		String mail = null;
		Admin admin = null;

		try {
			mail = request.getParameter("adminMail");
			admin = service.fetchAdminDetails(mail);
			model.addAttribute("adminInfo", admin);

			target = "displayAdminInfo";
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				target = "error";
				model.addAttribute("errorMessage", "No information to display Please try with another one");
			} else {
				target = "error";
				model.addAttribute("errorMessage", "Internal Server Error Please try after some time");
			}
		}
		return target;
	}

	@GetMapping("/adminUpdateForm")
	public String showAdminUpdateForm(HttpServletRequest request, Model model) {

		String target = null;
		displayAdminInfoPage(request, model);
		if (model.getAttribute("adminInfo") == null) {

			target = "error";
			model.addAttribute("erroMessage", "Some issue has occured please try after some time");
		} else {
			target = "adminUpdateForm";
		}
		return target;
	}

	@PostMapping("/updateAdminDataInfo")
	public String updateAdminInformation(HttpServletRequest request, Model model) {

		String aid = request.getParameter("aid");
		String adimEmail = request.getParameter("adimEmail");
		String adminGender = request.getParameter("adminGender");
		String adimPassword = request.getParameter("adimPassword");
		String adimName = request.getParameter("adimName");

		Admin admin = new Admin();
		admin.setAid(Integer.parseInt(aid));
		admin.setAmail(adimEmail);
		admin.setAname(adimName);
		admin.setPassword(adimPassword);
		admin.setGender(adminGender);

		String status = service.updateAdminData(admin);
		model.addAttribute("adminUpdateInfo", status);

		return "saveStatus";
	}

	@GetMapping("/customerDetails")
	public String displayCustomerInfoPage(HttpServletRequest request, Model model) {
		String target = null;
		String mail = null;
		Customer customer = null;

		try {
			mail = request.getParameter("customerMail");
			customer = service.fetchCustomerDetails(mail);
			model.addAttribute("customerInfo", customer);

			target = "displayCustomerInfo";
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				target = "error";
				model.addAttribute("errorMessage", "No information to display Please try with another one");
			} else {
				target = "error";
				model.addAttribute("errorMessage", "Internal Server Error Please try after some time");
			}
		}
		return target;
	}

	@GetMapping("/customerUpdateForm")
	public String showCustomerUpdateForm(HttpServletRequest request, Model model) {

		String target = null;
		displayCustomerInfoPage(request, model);
		if (model.getAttribute("customerInfo") == null) {

			target = "error";
			model.addAttribute("erroMessage", "Some issue has occured please try after some time");
		} else {
			target = "customerUpdateForm";
		}
		return target;
	}

	@PostMapping("/updateCustomerDataInfo")
	public String updateCustomerInformation(HttpServletRequest request, Model model) {

		String cid = request.getParameter("cid");
		String customerName = request.getParameter("customerName");
		String customerEmail = request.getParameter("customerEmail");
		String customerGender = request.getParameter("customerGender");
		String customerPassword = request.getParameter("customerPassword");

		Customer customer = new Customer();
		customer.setCid(Integer.parseInt(cid));
		customer.setCmail(customerEmail);
		customer.setGender(customerGender);
		customer.setPassword(customerPassword);
		customer.setCname(customerName);

		String status = service.updateCustomerData(customer);
		model.addAttribute("customerUpdateInfo", status);

		return "saveStatus";
	}
}
