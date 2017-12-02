package com.arnis.roman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanNumberConvertor {

	public String convert(int decimalNumber) {
		String result = "";
		int remainingValue = decimalNumber;
		
		Map<Integer, String> mappingTable = new LinkedHashMap<Integer, String>();
		mappingTable.put(1000, "M");
		mappingTable.put(900, "CM");
		mappingTable.put(500, "D");
		mappingTable.put(400, "CD");
		mappingTable.put(100, "C");
		mappingTable.put(90, "XC");
		mappingTable.put(50, "L");
		mappingTable.put(40, "XL");
		mappingTable.put(10, "X");
		mappingTable.put(9, "IX");
		mappingTable.put(5, "V");
		mappingTable.put(4, "IV");
		mappingTable.put(1, "I");
		
		
		for (Entry<Integer,String> mappingEntry : mappingTable.entrySet()) {
			while (remainingValue >= mappingEntry.getKey()) {
				result += mappingEntry.getValue();
				remainingValue -= mappingEntry.getKey();
			}
		}
		
		return result;
	}

}
