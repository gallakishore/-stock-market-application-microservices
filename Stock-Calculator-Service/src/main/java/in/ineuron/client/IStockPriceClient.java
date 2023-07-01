package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ineuron.model.StockInfo;

@FeignClient(name = "STOCK-PRICE-SERVICE")
public interface IStockPriceClient {

	@GetMapping("/api/stock/find/{companyName}")
	public ResponseEntity<StockInfo> getStockInfo(@PathVariable String companyName);
}
