package com.arnis.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.arnis.roman.RomanNumberConvertor;

public class RomanNumberConvertorShould {
	
	@ParameterizedTest
	@CsvSource({
		"1, I",
		"2, II",
		"5, V",
		"4, IV",
		"9, IX",
		"999, CMXCIX",
		"444, CDXLIV",
		"3568, MMMDLXVIII",
		"517, DXVII"
		})
	public void convertDecimalToNumeral(int decimal, String expected) {
		RomanNumberConvertor convertor = new RomanNumberConvertor();
		
		String result = convertor.convert(decimal);
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void convert444ToCDXLIV() {
		
		RomanNumberConvertor convertor = new RomanNumberConvertor();
		
		String result = convertor.convert(444);
		
		assertEquals("CDXLIV", result);
	}

}
