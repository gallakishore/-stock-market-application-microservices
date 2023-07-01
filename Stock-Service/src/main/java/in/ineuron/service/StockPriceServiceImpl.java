package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.StockInfo;
import in.ineuron.exception.StockInfoInsertionException;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.repository.IStockRepository;

@Service
public class StockPriceServiceImpl implements IStockPriceService {

	@Autowired
	private IStockRepository repo;

	@Override
	public String saveStockInfo(StockInfo info) {

		StockInfo res = repo.save(info);
		if (res != null)
			return "Stock Info is saved with ID " + res.getStockId();
		else
			throw new StockInfoInsertionException("Failed to insert the info");
	}

	@Override
	public StockInfo findStockPriceByCompanyName(String companyName) {

		StockInfo stockInfo = repo.findByCompanyName(companyName);

		if (stockInfo == null) {
			throw new StockNotFoundException("Company Info Not available");
		}

		return stockInfo;
	}

	@Override
	public String updateStockinfo(StockInfo info) {

		StockInfo stockInfo = repo.findByCompanyName(info.getCompanyName());

		if (stockInfo != null) {

			if (info.getChairMan() != null)
				stockInfo.setChairMan(info.getChairMan());
			if (info.getCompanyName() != null)
				stockInfo.setCompanyName(info.getCompanyName());
			if (info.getCompanyNetWorth() != null)
				stockInfo.setCompanyNetWorth(info.getCompanyNetWorth());
			if (info.getStockPrice() != null)
				stockInfo.setStockPrice(info.getStockPrice());

			StockInfo res = repo.save(stockInfo);

			return "Company Stock Info is updated successfully for " + res.getCompanyName();

		} else {
			throw new StockNotFoundException("Company Info Not available for updation");
		}
	}

	@Override
	public String deleteStockInfo(String companyName) {
		StockInfo stockInfo = repo.findByCompanyName(companyName);

		if (stockInfo != null) {

			repo.delete(stockInfo);

			return "StockInfo is deleted successfully for " + companyName;
		} else {
			throw new StockNotFoundException("Company Info Not available for deletion ");
		}

	}

}
