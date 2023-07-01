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

import in.ineuron.entity.StockInfo;
import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/api/stock")
public class StockPriceController {

	@Autowired
	private IStockPriceService service;

	@GetMapping("/find/{companyName}")
	public ResponseEntity<?> getStockInfo(@PathVariable String companyName) {

		StockInfo stockInfo = service.findStockPriceByCompanyName(companyName);

		System.out.println("Stock  " + stockInfo);
		return new ResponseEntity<StockInfo>(stockInfo, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveStockInformation(@RequestBody StockInfo info) {

		String status = service.saveStockInfo(info);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateStockInfo(@RequestBody StockInfo info) {
		String status = service.updateStockinfo(info);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{companyName}")
	public ResponseEntity<?> deleteStockInfo(@PathVariable String companyName) {
		String status = service.deleteStockInfo(companyName);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
