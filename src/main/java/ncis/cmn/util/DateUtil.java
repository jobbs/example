/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DateUtil.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {

	public static Date getDateOfTimestamp(long time) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);

		return c.getTime();
	}

	/** <pre>현재 년도</pre>
	 *
	 * @return
	 */
	public static int getCurrentYear(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.get(Calendar.YEAR);
	}

	/**
	 * <pre>현재 월</pre>
	 *
	 * @return
	 */
	public static int getCurrentMonth(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * <pre>현재 요일</pre>
	 *
	 * @return
	 */
	public static int getCurrentWeek(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * <pre>해당 날짜의 요일</pre>
	 *
	 * @param reqDate : 'yyyy-MM-dd'형식의 String
	 * @return
	 */
	public static int getWeek(String reqDate) {
		Calendar c = Calendar.getInstance();
		String date[] = reqDate.split("-"); // 선택한 날짜를 년-월-일로 구분
		c.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2])); // 월-1 (0부터 시작)
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * <pre>오늘 날짜</pre>
	 *
	 * @param format Date 포멧
	 * @return
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}

	public static String getCurrentDate(String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}

	/**
	 * 해당월의 마지막 일자
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getLastDayOfMonth(int year, int month){
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		int endDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return endDate;
	}

	/**
	 * 해당월의 마지막 일자
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayStrOfMonth(int year, int month , String format){
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		int endDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		c.set(year, month-1, endDate);

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(c.getTime());
	}

	/**
	 * 해당월의 첫날
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayStrOfMonth(int year, int month , String format){
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(c.getTime());
	}

	public static Boolean isNewDate(Date date, int amount){
		if(DateUtils.addHours(new Date(), -(amount*24)).compareTo(date) == -1){
			return true;
		}
		return false;
	}

	/**
	 * <pre>시작일자와 종료일자의 차이 일수를 반환<</pre>
	 *
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long diffOfDate(String start, String end) throws ParseException {
		return diffOfDate(start, end, "yyyyMMdd");
	}

	/**
	 * <pre>시작일자와 종료일자의 차이 일수를 반환</pre>
	 *
	 * @param start
	 * @param end
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static long diffOfDate(String start, String end, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		Date beginDate = formatter.parse(start);
		Date endDate = formatter.parse(end);

		return diffOfDate(beginDate, endDate);
	}

	/**
	 * <pre>시작일자와 종료일자의 차이 일수를 반환</pre>
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long diffOfDate(Date beginDate, Date endDate) {

		long diff = endDate.getTime() - beginDate.getTime();
		long diffDays = diff/(24*60*60*1000);

		return diffDays;
	}


	/**
	 * <pre>해당일자에 날짜를 더하여 반환</pre>
	 *
	 * @param source
	 * @param plus
	 * @return
	 * @throws ParseException
	 */
	public static Date plusDate(String source, int plus) throws ParseException {
		return plusDate(source, plus, "yyyy-MM-dd");
	}

	/**
	 * <pre>해당일자에 날짜를 더하여 반환</pre>
	 *
	 * @param source
	 * @param plus
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date plusDate(String source, int plus, String format) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = dateFormat.parse(source);

		return plusDate(date, plus);
	}

	/**
	 * <pre>해당일자에 날짜를 더하여 반환</pre>
	 *
	 * @param source
	 * @param plus
	 * @return
	 * @throws Exception
	 */
	public static Date plusDate(Date source, int plus) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.add(Calendar.DATE, plus);

		return cal.getTime();
	}

	/**
	 * <pre>해당일자에 날짜를 더하여 반환</pre>
	 *
	 * @param source
	 * @param plus
	 * @return
	 * @throws Exception
	 */
	public static String dateToString(Date source, String format) {

		if( null == source )
			return "";

		SimpleDateFormat sdfCurrent = new SimpleDateFormat(format, Locale.KOREA);
		return sdfCurrent.format(source);

	}

	public static String getTimeStamp() {
		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";

			SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
			Timestamp ts = new Timestamp(System.currentTimeMillis());

			rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}

	public static String getCurrentTimeString() {
		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyy-MM-dd hh:mm:ss";

			SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
			Timestamp ts = new Timestamp(System.currentTimeMillis());

			rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}


	/**
	 * <pre>
	 * string을 date로 변환
	 * </pre>
	 *
	 * @param sDate
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String sDate, String format) throws ParseException {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        cal.setTime(sdf.parse(sDate));

        return cal.getTime();
    }


	/**
	 * <pre>
	 * year, month, day중에 원하는 값을 넣어서 날짜를 계산함 String형태로 반환
	 * </pre>
	 *
	 * @param sDate
	 * @param format
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String addYearMonthDay(String sDate, String format, int year, int month, int day) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format( addYearMonthDayFromString(sDate, format, year, month, day) );
    }

	/**
	 * <pre>
	 * year, month, day중에 원하는 값을 넣어서 날짜를 계산함 date형태로 반환
	 * </pre>
	 *
	 * @param sDate
	 * @param format
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static Date addYearMonthDayFromString(String sDate, String format, int year, int month, int day) throws ParseException {
		return addYearMonthDay(stringToDate(sDate, format), year, month, day);
	}


	public static Date addYearMonthDay(Date sDate, int year, int month, int day) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);

        if (year != 0)
            cal.add(Calendar.YEAR, year);
        if (month != 0)
            cal.add(Calendar.MONTH, month);
        if (day != 0)
            cal.add(Calendar.DATE, day);

        return cal.getTime();
    }

	public static String addMonth(int month) throws ParseException{
		String date = getCurrentDate("yyyy-MM-dd");
		return addYearMonthDay(date,"yyyy-MM-dd",0,month,0);
	}


	public static String addMinute(String format, int minute) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		return sdf.format(addMinute(minute));
	}

	/**
	 * 분단위 를 추가 하여 날짜를 구한다.
	 * @param minute
	 * @return
	 * @throws ParseException
	 */
	public static Date addMinute(int minute) throws ParseException {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
	}

	public static String stringValueOf(Object object) throws ParseException{

		return object == null ? "":String.valueOf(object);
	}
}
