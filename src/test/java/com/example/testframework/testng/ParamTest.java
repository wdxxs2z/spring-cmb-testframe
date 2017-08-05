package com.example.testframework.testng;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamTest {
	
	private SimpleDateFormat sdf;
	
	@DataProvider(name="testParam")
	public static Object[][] getParamters() {
		String[][] params = {
				{"2017-07-02 00:15:35", "yyyyMMdd", "20170702"},
				{"2017-07-02 00:15:35", "yyyy年MM月dd日", "2017年07月02日"},
				{"2017-07-02 00:15:35", "yyyy年MM月dd日 HH时mm分ss秒", "2017年07月02日 00时15分35秒"}
		};
		return params;
	}
	
	@Test(dataProvider="testParam")
	public void testSimpleDateFormat(String date,String dateformat,String expectedDate) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = df.parse(date);
		sdf = new SimpleDateFormat(dateformat);
		String result = sdf.format(d);
		assertEquals(result, expectedDate);
	}

}
