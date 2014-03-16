package com.globallogic.interview.john.computation;

import java.util.List;

import com.globallogic.interview.john.vo.CompanyStockRecord;

/**
 * API for Stock related computations 
 * @author John Solomon
 *
 */
public interface StockComputation {

	/**
	 * Method which compute peak stock value internally and returns entire company records
	 * @param stockRecordlist
	 * @return
	 * @throws Exception
	 */
	List<CompanyStockRecord> findPeakValue(List<String[]> stockRecordlist) throws Exception;
}
