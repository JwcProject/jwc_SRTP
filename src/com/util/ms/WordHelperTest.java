package com.util.ms;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class WordHelperTest {

	@Test
	public void test() {
		WordHelper word = new WordHelper("C:\\Users\\pan\\Desktop\\test3.doc");
		word.open();
		Map<String, String> contentMap;
		contentMap = word.getDeclaContent();
		for(int i = 0;i < WordHelper.content.length; ++i){
			System.out.println(WordHelper.content[i]+":\n"+contentMap.get(WordHelper.content[i]));
		}
	}

}
