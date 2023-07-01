package in.ineuron.model;

import lombok.Data;

@Data
public class StockInfo {

	private Integer stockId;

	private String companyName;

	private String chairMan;

	private Double companyNetWorth;

	private Double stockPrice;

	private Double totalAmount;

}
