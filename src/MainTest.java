import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

public class MainTest {

	@Test
	public void checkTodaysDateFor_getDateTimeNow() {
		Main junit = new Main();
		String result = junit.getDateTimeNow();
		String now = LocalDateTime.now().toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate;
		try {
			nowDate = sdf.parse(now);
			Date getFromNowFunction = sdf.parse(result);
			assertEquals(nowDate, getFromNowFunction);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void lastCharTestFor_getDateTimeNow() {
		Main junit = new Main();
		int result = junit.getDateTimeNow().substring(9).lastIndexOf(9);
		int date = LocalDateTime.now().toString().substring(9).lastIndexOf(9);
		assertEquals(result, date);
		;
	}

}
