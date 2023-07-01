package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.entity.StockInfo;

public interface IStockRepository extends JpaRepository<StockInfo, Integer> {

	public StockInfo findByCompanyName(String companyName);
}
