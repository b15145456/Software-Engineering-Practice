package ACCESSCODE;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class newTest {
	
	Date dt = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	OoooSmartClock clock = new OoooSmartClock();
	
	@Test
	//測試Dialog 作假成功
	void setUpDialog() throws Exception {				
		Dialog dlg = new OoooSetTimeZoneDialog();	
		clock.setUpDialog(dlg);
		clock.setTimeZone();
		assertEquals(1,clock.getTimeZone());
	}
	
	@Test
	//測試Dialog==null時，有相對應的exception message
	void testSetTimeZoneExceptionMessage() {
		Exception exception = assertThrows(Exception.class, () -> clock.setTimeZone());	
		assertEquals("NODATA_CHOOSED", exception.getMessage());
	}
	
	@Test
	//測試Dialog!=null時，可以正確執行setTimeZone
	void testSetTimeZone() throws Exception {								
		Dialog dlg = new OoooSetTimeZoneDialog() ;
		clock.setUpDialog(dlg);
		clock.setTimeZone();
		assertEquals(1,clock.getTimeZone());
	}
	
	@Test
	//測試有一個參數的setTimeZone
	void testSetTimeZone1Arg() {
	    clock.setTimeZone(5);
		assertEquals(5,clock.getTimeZone());
	}
	
	@Test
	//測試可以取得正確的時區
	void testGetTimeZone() {
		Dialog dlg = new OoooSetTimeZoneDialog();
		clock.setUpDialog(dlg);
		assertEquals(-1,clock.getTimeZone());
	}
	
	@Test
	//測試可以取得正確的現在時間
	void testGetCurrentTimeStamp() {				
		
	    ft.format(dt);
		clock.setCurrentTime(dt);
		assertEquals(ft.format(dt),clock.getCurrentTimeStamp());
	}
	
}