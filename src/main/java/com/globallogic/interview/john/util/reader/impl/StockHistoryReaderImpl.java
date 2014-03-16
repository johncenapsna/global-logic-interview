package com.globallogic.interview.john.util.reader.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.globallogic.interview.john.util.reader.StockHistoryReader;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Implementation of StockHistoryReader API
 * @author John Solomon
 *
 */
public class StockHistoryReaderImpl implements StockHistoryReader {

	/**
	 * API implementation for method to read csv stock record file
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public List<String[]> readStockHistory(String path) throws IOException {
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<String[]> stockRecordList = null;
		try {
			fileReader = new FileReader(path);
			csvReader = new CSVReader(fileReader);
			stockRecordList = csvReader.readAll();
		} finally {
			if (csvReader!=null) { 
				csvReader.close();
			}
			if (fileReader!=null) { 
				fileReader.close();
			}
		}
		return stockRecordList;
	}

}
