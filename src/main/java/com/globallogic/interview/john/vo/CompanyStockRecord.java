package com.globallogic.interview.john.vo;

import java.util.HashMap;

import com.globallogic.interview.john.enumconst.ConfigEnum;

/**
 * Bean which is basically a wrapper of HashMap.
 * An object of which is used to hold a company's record
 * @author John Solomon
 *
 */
public class CompanyStockRecord extends HashMap<String, Float> {

	private static final long serialVersionUID = 1L;
	
	public CompanyStockRecord(String companyName) {
		this.companyName = companyName;
	}
	
	private String companyName;
	
	private Float peakStockValue = new Float(0);
	
	private String peakMonth;
	
	private int peakYear;

	public String getCompanyName() {
		return companyName;
	}

	public Float getPeakStockValue() {
		return peakStockValue;
	}

	public void setPeakStockValue(Float peakStockValue) {
		this.peakStockValue = peakStockValue;
	}

	public String getPeakMonth() {
		return peakMonth;
	}

	public void setPeakMonth(String peakMonth) {
		this.peakMonth = peakMonth;
	}

	public int getPeakYear() {
		return peakYear;
	}

	public void setPeakYear(int peakYear) {
		this.peakYear = peakYear;
	}

	public Float put(String key, Float stockValue) {
		if (stockValue > getPeakStockValue()) {
			setPeakStockValue(stockValue);
			String[] period = key.split(ConfigEnum.SEPERATOR.getRegex());
			setPeakYear(Integer.parseInt(period[0]));
			setPeakMonth(period[1]);
		}
		return super.put(key, stockValue);
	}
	
}
