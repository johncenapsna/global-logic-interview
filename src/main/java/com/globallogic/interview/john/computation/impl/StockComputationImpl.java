package com.globallogic.interview.john.computation.impl;

import java.util.ArrayList;
import java.util.List;

import com.globallogic.interview.john.computation.StockComputation;
import com.globallogic.interview.john.enumconst.ConfigEnum;
import com.globallogic.interview.john.vo.CompanyStockRecord;

/**
 * Implementation of StockComputation API
 * @author John Solomon
 *
 */
public class StockComputationImpl implements StockComputation {
	
	/**
	 * API implementation for method which compute peak stock value internally and returns entire company records
	 * @param stockRecordlist
	 * @return
	 * @throws Exception
	 */
	public List<CompanyStockRecord> findPeakValue(List<String[]> stockRecordlist) throws Exception {
		if (stockRecordlist == null || stockRecordlist.size() < 2) {
			throw new Exception("No Records Available");
		}
		List<CompanyStockRecord> companiesRecord = new ArrayList<CompanyStockRecord>();
		boolean isHeader = true;
		for (String[] record : stockRecordlist) {
			CompanyStockRecord companyRecord = null;
			for (int col = 2; col < record.length; col++) {
				String recordEntry = record[col].trim();
				if (isHeader) {
					// Initialize company record
					companyRecord = new CompanyStockRecord(recordEntry);
					companiesRecord.add(companyRecord);
				} else {
					// Adding stock values of various period to company record
					String period = new StringBuffer(record[0].trim()).append(ConfigEnum.SEPERATOR.getValue())
							.append(record[1].trim()).toString();
					Float stockValue = Float.parseFloat(recordEntry);
					companiesRecord.get(col - 2).put(period, stockValue);
				}
			}
			isHeader = false;
		}
		return companiesRecord;
	}

}
