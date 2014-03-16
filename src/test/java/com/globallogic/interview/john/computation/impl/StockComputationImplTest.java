package com.globallogic.interview.john.computation.impl;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.globallogic.interview.john.computation.StockComputation;
import com.globallogic.interview.john.enumconst.ConfigEnum;
import com.globallogic.interview.john.util.reader.StockHistoryReader;
import com.globallogic.interview.john.util.reader.impl.StockHistoryReaderImpl;
import com.globallogic.interview.john.vo.CompanyStockRecord;

/**
 * Test cases to validate Peak Stock Value computation 
 * @author John Solomon
 *
 */
public class StockComputationImplTest {
	
	private StockComputation tetObj = new StockComputationImpl();
	
	private static List<String[]> stockRecordList = null;
	
	@BeforeClass
	public static void prepareTestData() throws IOException {
		StockHistoryReader reader = new StockHistoryReaderImpl();
		stockRecordList = reader.readStockHistory(ConfigEnum.RECORD_FILE.getValue());
	}
	
	@Test
	public void testFindPeakValue() throws Exception {
		List<CompanyStockRecord> records = tetObj.findPeakValue(stockRecordList);
		for (CompanyStockRecord record : records) {
			System.out.println("Company: " + record.getCompanyName() + ";Peak Period: "
					+ record.getPeakMonth() + ", " + record.getPeakYear()
					+ ";Peak Stock Value: " + record.getPeakStockValue());
		}
		Assert.assertTrue("Not yet implemented", true);
	}

}
