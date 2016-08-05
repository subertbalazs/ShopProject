import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

public class TestGetDataFromConsole {

	@Test
	public void checkTodaysDateFor_getDateTimeNow() {

		String result = GetDataFromConsole.getDateTimeNow();
		String now = LocalDateTime.now().toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate;
		try {
			nowDate = sdf.parse(now);
			Date getFromNowFunction = sdf.parse(result);
			assertEquals(nowDate, getFromNowFunction);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void lastCharTestFor_getDateTimeNow() {
		int result = GetDataFromConsole.getDateTimeNow().substring(9).lastIndexOf(9);
		int date = LocalDateTime.now().toString().substring(9).lastIndexOf(9);
		assertEquals(result, date);
	}
	@Test
	public void checkReturnTypeFor_checkWarranty_withLess_returnTrue() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date warranty;
		try {
			warranty = sdf.parse("2012-11-13");
			Date now = sdf.parse("2012-11-11");
			boolean result = GetDataFromConsole.checkWarranty(warranty, now);
			assertEquals(result, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void checkReturnTypeFor_checkWarranty_withEqual_returnTrue() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date warranty;
		try {
			warranty = sdf.parse("2012-11-11");
			Date now = sdf.parse("2012-11-11");
			boolean result = GetDataFromConsole.checkWarranty(warranty, now);
			assertEquals(result, true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void checkReturnTypeFor_checkWarranty_withMore_returnFalse() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date warranty;
		try {
			warranty = sdf.parse("2012-11-11");
			Date now = sdf.parse("2012-11-13");
			boolean result = GetDataFromConsole.checkWarranty(warranty, now);
			assertEquals(result, false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

