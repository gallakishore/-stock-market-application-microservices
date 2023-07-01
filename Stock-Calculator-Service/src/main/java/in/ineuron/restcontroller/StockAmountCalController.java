package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IStockPriceClient;
import in.ineuron.model.StockInfo;

@RestController
@RequestMapping("/api/stockservice")
public class StockAmountCalController {

	@Autowired
	private IStockPriceClient client;

	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculateTotalAmount(@PathVariable String companyName, @PathVariable Integer quantity) {

		ResponseEntity<StockInfo> response = null;
		ResponseEntity<?> responseEntity = null;
		try {


			response = client.getStockInfo(companyName);

			StockInfo info = response.getBody();

			Double price = info.getStockPrice();
			info.setTotalAmount(price * quantity);

			responseEntity = new ResponseEntity<StockInfo>(info, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			if (e.getMessage()
					.contains("[Load balancer does not contain an instance for the service STOCK-PRICE-SERVICE]")) {
				responseEntity = new ResponseEntity<String>("No servers available for service",
						HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				responseEntity = new ResponseEntity<String>("Company Data Not Found ", HttpStatus.NOT_FOUND);
			}
		}
		return responseEntity;
	}

}
