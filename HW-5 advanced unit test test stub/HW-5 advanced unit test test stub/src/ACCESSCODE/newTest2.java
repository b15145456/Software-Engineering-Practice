package ACCESSCODE;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class newTest2 {
  
  private String _expected; // 箇戳挡狦
  private int _year;        // 把计1
  private int _month;        // 把计1
  private int _day;        // 把计1
  private int _hour;        // 把计1
  private int _minte;// 把计1
  private int _second;        // 把计1


  OoooSmartClock clock = new OoooSmartClock();
  Calendar cal = Calendar.getInstance();


  @Parameters
  public static  Collection<Object[]> getTestParameters() {
    return Arrays.asList(new Object[][] 
	    {
	      {"2020-10-10 DOUBLE-TEN NOON",2020,9,10,12,0,5},
	      {"2020-10-10 DOUBLE-TEN NOON",2020,9,10,12,1,0},
	      {"2020-10-10 DOUBLE-TEN MIDNIGHT",2020,9,10,0,0,5},
	      {"2020-10-10 DOUBLE-TEN MIDNIGHT",2020,9,10,0,1,0},
	      {"2020-10-10 DOUBLE-TEN 05:06:07",2020,9,10,5,6,7},
	      
	      {"2020-08-08 FATHER'S DAY NOON",2020,7,8,12,0,5},
	      {"2020-08-08 FATHER'S DAY NOON",2020,7,8,12,1,0},
	      {"2020-08-08 FATHER'S DAY MIDNIGHT",2020,7,8,0,0,5},
	      {"2020-08-08 FATHER'S DAY MIDNIGHT",2020,7,8,0,1,0},
	      {"2020-08-08 FATHER'S DAY 05:06:07",2020,7,8,5,6,7},
	      
	      {"2020-12-25 X'MAS NOON",2020,11,25,12,0,5},
	      {"2020-12-25 X'MAS NOON",2020,11,25,12,1,0},
	      {"2020-02-25 X'MAS MIDNIGHT",2020,11,25,0,0,5},
	      {"2020-02-25 X'MAS MIDNIGHT",2020,11,25,0,1,0},
	      {"2020-12-25 X'MAS 05:06:07",2020,11,25,5,6,7},
	      
	      {"2020-03-25 NOON",2020,2,25,12,0,5},
	      {"2020-03-25 NOON",2020,2,25,12,1,0},
	      {"2020-03-25 MIDNIGHT",2020,2,25,0,0,5},
	      {"2020-03-25 MIDNIGHT",2020,2,25,0,1,0},
	      {"2020-03-25 05:06:07",2020,2,25,5,6,7}
	    }
    );
  }
  
//2020-9-10 12:0:5	 	 2020-9-10 12:1:0		 2020-9-10 0:0:5		 2020-9-10 0:1:0	2020-9-10  5:6:7
//2020-7-8 12:0:5	 	 2020-7-8 12:1:0		 2020-7-8 0:0:5			 2020-7-8 0:1:0		2020-7-8  5:6:7
//2020-1-25  12:0:5	 	 2020-1-25 12:1:0		 2020-9-10 0:0:5		 2020-9-10 0:1:0	2020-9-10  5:6:7
//2020-2-25 12:0:5		// 2020-2-25 12:1:0
//2020-2-25 0:0:5		// 2020-2-25 0:1:0  
//2020-2-25 5:6:7
  
  // ParameterizedTest篶Α
  public newTest2(String exptected, int year, int month, int day, int hour, int minte, int second) {
    this._expected = exptected;
    this._year = year;
    this._month = month;
    this._day = day;
    this._hour = hour;
    this._minte = minte;
    this._second = second;
  }
  
  @Test
  public void testGetLocalCurrentTimeStamp() {
	  	cal.set(this._year, this._month, this._day, this._hour, this._minte, this._second);					//	void set(int year, int month, int date, int hour, int minute, int second) 
		Date customTime = cal.getTime();
		clock.setCurrentTime(customTime);
		assertEquals(this._expected,clock.getLocalCurrentTimeStamp());
  }

}