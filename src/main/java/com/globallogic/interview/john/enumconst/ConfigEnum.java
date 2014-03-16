package com.globallogic.interview.john.enumconst;

/**
 * Enum which hold all config related constants
 * @author John Solomon
 *
 */
public enum ConfigEnum {
	
	RECORD_FILE("target\\test-classes\\stock-stats.csv"),
	SEPERATOR("*");
	
	private String value;
	
	ConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public String getRegex() {
		return "\\" + value;
	}
	
}
