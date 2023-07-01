package in.ineuron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.StockInfo;
import in.ineuron.service.StockInfoServiceImpl;

@Controller
@RequestMapping("/api/stock")
public class StockController {

	@Autowired
	private StockInfoServiceImpl service;

	@GetMapping("/insert")
	public String showStockInsertPage() {
		return "stockInsertForm";
	}

	@GetMapping("/search")
	public String showStockSearchPage() {
		return "stockInfoSearchForm";
	}

	@GetMapping("/customerSearch")
	public String showStockSearchPageForCustomer() {
		return "stockInfoSearchForm-Customer";
	}

	@GetMapping("/calculate")
	public String showStockCalculate() {
		return "stockCalculateForm";
	}

	@GetMapping("/update")
	public String showStockUpdatePage(HttpServletRequest request, Model model) {

		searchStockInfo(request, model);

		String target = null;
		if (model.getAttribute("info") == null) {
			model.addAttribute("erroMessage", "Some issue has occured please try after some time");
			target = "error";
		} else {
			target = "stockUpdateForm";
		}

		return target;
	}

	@PostMapping("/saveStockInfo")
	public String saveStockInfo(HttpServletRequest request, Model model) {

		String companyName = request.getParameter("companyName");
		String chairMan = request.getParameter("chairMan");
		String stockPrice = request.getParameter("stockPrice");
		String companyNetWorth = request.getParameter("companyNetWorth");

		String status = null;
		String target = null;

		if (companyName != null && chairMan != null && stockPrice != null && companyNetWorth != null) {

			StockInfo info = new StockInfo();
			info.setCompanyName(companyName);
			info.setChairMan(chairMan);
			info.setCompanyNetWorth(Double.parseDouble(companyNetWorth));
			info.setStockPrice(Double.parseDouble(stockPrice));

			status = service.saveStockInfo(info);
			model.addAttribute("stockSaveInfo", status);
			target = "saveStatus";

		} else {
			model.addAttribute("errorMessage", "Please enter the details");
			target = "stockInsertForm";
		}

		return target;
	}

	@PostMapping("/updateStockInfo")
	public String updateStockInfo(HttpServletRequest request, Model model) {

		String companyName = request.getParameter("companyName");
		String chairMan = request.getParameter("chairMan");
		String stockPrice = request.getParameter("stockPrice");
		String companyNetWorth = request.getParameter("companyNetWorth");

		String target = null;

		if (companyName != null && chairMan != null && stockPrice != null && companyNetWorth != null) {

			StockInfo info = new StockInfo();
			info.setCompanyName(companyName);
			info.setChairMan(chairMan);
			info.setStockPrice(Double.parseDouble(stockPrice));
			info.setCompanyNetWorth(Double.parseDouble(companyNetWorth));

			String status = service.updateStockInfo(info);
			model.addAttribute("stockSaveInfo", status);
			target = "saveStatus";
		} else {
			target = "error";
			model.addAttribute("erroMessage", "Please try updation in a proper manner");
		}

		return target;
	}

	@GetMapping("/searchStockInfo")
	public String searchStockInfo(HttpServletRequest request, Model model) {
		String target = null;
		String companyName = null;

		try {
			companyName = request.getParameter("companyName");

			if (companyName != null) {
				StockInfo info = service.getStockInfoByCompanyName(companyName);
				model.addAttribute("info", info);
				target = "displayInfo";
			} else {

				model.addAttribute("errorMessage", "Please enter the Details");
				target = "stockSearchForm";
			}
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				target = "stockInfoSearchForm";
				model.addAttribute("errorMessage", "No information to display Please try with another one");
			} else {
				target = "stockInfoSearchForm";
				model.addAttribute("errorMessage", "Internal Server Error Please try after some time");
			}
		}
		return target;
	}

	@GetMapping("/searchStockInfoCustomer")
	public String searchStockInfoCustomer(HttpServletRequest request, Model model) {
		String target = null;
		String companyName = null;

		try {
			companyName = request.getParameter("companyName");

			if (companyName != null) {
				StockInfo info = service.getStockInfoByCompanyName(companyName);
				model.addAttribute("info", info);
				target = "displayInfoCustomer";
			} else {

				model.addAttribute("errorMessage", "Please enter the Details");
				target = "stockInfoSearchForm-Customer";
			}
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				target = "stockInfoSearchForm-Customer";
				model.addAttribute("errorMessage", "No information to display Please try with another one");
			} else {
				target = "stockInfoSearchForm-Customer";
				model.addAttribute("errorMessage", "Internal Server Error Please try after some time");
			}
		}
		return target;
	}

	@PostMapping("/stockTotalPriceCalculate")
	public String getTotalStockAmount(HttpServletRequest request, Model model) {

		String target = null;
		String companyName = request.getParameter("companyName");
		String quantity = request.getParameter("quantity");

		try {
			if (companyName != null && quantity != null) {
				StockInfo info = service.getTotalPriceForStock(companyName, Integer.parseInt(quantity));
				model.addAttribute("info", info);
				model.addAttribute("quantity", quantity);
				target="displayTotalStockInfo";
			} else {
				target = "stockCalculateForm";
				model.addAttribute("errorMessage", "Enter the detials to get the Service");
			}
		} catch (Exception e) {
			if (e.getMessage().contains("404 Not Found")) {
				target = "stockCalculateForm";
				model.addAttribute("errorMessage", "No information to display Please try with another one");
			} else {
				target = "stockCalculateForm";
				model.addAttribute("errorMessage", "Internal Server Error Please try after some time");
			}
		}
		return target;
	}
}
