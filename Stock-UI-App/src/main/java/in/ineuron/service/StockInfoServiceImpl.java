package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.model.StockInfo;

@Service
public class StockInfoServiceImpl implements StockInfoService {

	@Override
	public String saveStockInfo(StockInfo info) {

		WebClient client = null;
		String status = null;
		String end_point = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:2222/api/stock/save";
			status = client.post().uri(end_point).accept(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(info))
					.retrieve().bodyToMono(String.class).block();

		} catch (Exception e) {
			status = "Stock Data Insertion Failed Please Try After Some Time";
		}
		return status;
	}

	@Override
	public StockInfo getStockInfoByCompanyName(String companyName) {
		WebClient client = null;
		String end_point = null;
		StockInfo status = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:2222/api/stock/find/{companyName}";
			status = client.get().uri(end_point, companyName).retrieve().bodyToMono(StockInfo.class).block();

		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public String updateStockInfo(StockInfo info) {
		WebClient client = null;
		String status = null;
		String end_point = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:2222/api/stock/update";
			status = client.put().uri(end_point).accept(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(info))
					.retrieve().bodyToMono(String.class).block();

		} catch (Exception e) {
			status = "Stock Data Updation Failed Please Try After Some Time";
		}
		return status;
	}

	@Override
	public String deleteStockInfo(String companyName) {
		WebClient client = null;
		String status = null;
		String end_point = null;
		try {
			client = WebClient.create();
			end_point = "http://localhost:2222/api/stock/delete/{companyName}";
			status = client.delete().uri(end_point, companyName).retrieve().bodyToMono(String.class).block();

		} catch (Exception e) {
			status = "Stock Data Updation Failed Please Try After Some Time";
		}
		return status;
	}

	@Override
	public StockInfo getTotalPriceForStock(String companyName, Integer quantity) {

		String REST_END_POINT = "http://localhost:5555/api/stockservice/calculate/{companyName}/{quantity}";

		StockInfo info = null;
		WebClient webclient = WebClient.create();

		info = webclient.get().uri(REST_END_POINT, companyName, quantity).retrieve().bodyToMono(StockInfo.class)
				.block();
		return info;
	}

}
