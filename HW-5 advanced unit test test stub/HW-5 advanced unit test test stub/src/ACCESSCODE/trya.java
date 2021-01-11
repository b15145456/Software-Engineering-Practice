package ACCESSCODE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

public class trya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Date dt = new Date( );
		cal.set(2020, 5, 6, 7, 8, 9);
		Date customTime = cal.getTime();
//		dt.setTime(customTime);
//		assertEquals("",clock.getLocalCurrentTimeStamp());
		System.out.print(dt);
	}

}
