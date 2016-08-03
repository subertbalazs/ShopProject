import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class MainTest {

	@Test
	public void lastCharTestFor_getDateTimeNow() {
		Main junit = new Main();
		int result = junit.getDateTimeNow().substring(9).lastIndexOf(9);
		int date = LocalDateTime.now().toString().substring(9).lastIndexOf(9);
		assertEquals(result, date);
		;
	}

}
