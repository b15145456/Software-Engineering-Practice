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
	//����Dialog �@�����\
	void setUpDialog() throws Exception {				
		Dialog dlg = new OoooSetTimeZoneDialog();	
		clock.setUpDialog(dlg);
		clock.setTimeZone();
		assertEquals(1,clock.getTimeZone());
	}
	
	@Test
	//����Dialog==null�ɡA���۹�����exception message
	void testSetTimeZoneExceptionMessage() {
		Exception exception = assertThrows(Exception.class, () -> clock.setTimeZone());	
		assertEquals("NODATA_CHOOSED", exception.getMessage());
	}
	
	@Test
	//����Dialog!=null�ɡA�i�H���T����setTimeZone
	void testSetTimeZone() throws Exception {								
		Dialog dlg = new OoooSetTimeZoneDialog() ;
		clock.setUpDialog(dlg);
		clock.setTimeZone();
		assertEquals(1,clock.getTimeZone());
	}
	
	@Test
	//���զ��@�ӰѼƪ�setTimeZone
	void testSetTimeZone1Arg() {
	    clock.setTimeZone(5);
		assertEquals(5,clock.getTimeZone());
	}
	
	@Test
	//���եi�H���o���T���ɰ�
	void testGetTimeZone() {
		Dialog dlg = new OoooSetTimeZoneDialog();
		clock.setUpDialog(dlg);
		assertEquals(-1,clock.getTimeZone());
	}
	
	@Test
	//���եi�H���o���T���{�b�ɶ�
	void testGetCurrentTimeStamp() {				
		
	    ft.format(dt);
		clock.setCurrentTime(dt);
		assertEquals(ft.format(dt),clock.getCurrentTimeStamp());
	}
	
}