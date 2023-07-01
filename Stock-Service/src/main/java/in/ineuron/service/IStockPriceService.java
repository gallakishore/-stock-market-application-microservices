package in.ineuron.service;

import in.ineuron.entity.StockInfo;

public interface IStockPriceService {


	public String saveStockInfo(StockInfo info);

	public StockInfo findStockPriceByCompanyName(String companyName);

	public String updateStockinfo(StockInfo info);

	public String deleteStockInfo(String companyName);
}
