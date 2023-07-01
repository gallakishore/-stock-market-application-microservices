package in.ineuron.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "STOCK_INFO")
public class StockInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;

	private String companyName;

	private String chairMan;

	private Double companyNetWorth;
	
	private Double stockPrice;

	@CreationTimestamp
	private LocalDate creationDate;

	@UpdateTimestamp
	private LocalDate updationDate;

}
