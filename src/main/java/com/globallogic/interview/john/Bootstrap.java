package com.globallogic.interview.john;

import java.util.List;

import org.apache.log4j.Logger;

import com.globallogic.interview.john.computation.StockComputation;
import com.globallogic.interview.john.computation.impl.StockComputationImpl;
import com.globallogic.interview.john.util.reader.StockHistoryReader;
import com.globallogic.interview.john.util.reader.impl.StockHistoryReaderImpl;
import com.globallogic.interview.john.vo.CompanyStockRecord;

/**
 * Boostraps & invoke computation
 * @author John Solomon
 *
 */
public class Bootstrap {
	
	private static StockHistoryReader reader = new StockHistoryReaderImpl();
	
	private static StockComputation stockcomputer = new StockComputationImpl();
	
	private static Logger log = Logger.getLogger(Bootstrap.class);
	
	/**
	 * Main method of utility
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args == null || args.length < 1
				|| args[0].trim().length() < 1) {
			throw new Exception("Invalid Input: Stock Record File Path "
					+ "should be passed as first argument");
		}
		List<CompanyStockRecord> records = stockcomputer.findPeakValue(reader.readStockHistory(args[0]));
		for (CompanyStockRecord record : records) {
			log.info("Company: " + record.getCompanyName() + ";Peak Period: "
					+ record.getPeakMonth() + ", " + record.getPeakYear()
					+ ";Peak Stock Value: " + record.getPeakStockValue());
		}
	}
	
}
