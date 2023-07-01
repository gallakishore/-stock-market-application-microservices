package in.ineuron.service;

import in.ineuron.model.StockInfo;

public interface StockInfoService {

	public String saveStockInfo(StockInfo info);

	public StockInfo getStockInfoByCompanyName(String companyName);

	public String updateStockInfo(StockInfo info);

	public String deleteStockInfo(String companyName);
	
	public StockInfo getTotalPriceForStock(String companyName,Integer quantity);
}
