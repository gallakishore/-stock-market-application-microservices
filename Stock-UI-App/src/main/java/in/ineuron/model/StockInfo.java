package in.ineuron.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StockInfo {

	private Integer stockId;

	private String companyName;

	private String chairMan;

	private Double companyNetWorth;

	private Double stockPrice;
	
	private Double totalAmount;

	private LocalDate creationDate;

	private LocalDate updationDate;

}
