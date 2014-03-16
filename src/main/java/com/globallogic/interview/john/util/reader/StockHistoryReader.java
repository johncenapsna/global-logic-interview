package com.globallogic.interview.john.util.reader;

import java.io.IOException;
import java.util.List;

/**
 * Utility API to read csv stock record file
 * @author John Solomon
 *
 */
public interface StockHistoryReader {

	/**
	 * Method to read csv stock record file
	 * @param path
	 * @return
	 * @throws IOException
	 */
	List<String[]> readStockHistory(String path) throws IOException;
	
}
