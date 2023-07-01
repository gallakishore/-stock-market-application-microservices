package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockPriceService {

	public String getTotalCost(String companyName, Integer quantity) {

		String response = null;
		String REST_END_POINT = "http://localhost:4444/api/cal/calculate/{companyName}/{quantity}";

		try {

			WebClient webclient = WebClient.create();

			response = webclient.get().uri(REST_END_POINT, companyName, quantity).retrieve().bodyToMono(String.class)
					.block();

		} catch (Exception e) {

			response = "Company Not Found";
		}

		return response;
	}
}
