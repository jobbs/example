/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Test.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 11. 9.
 * @lastmodified 2016. 11. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 9.     최진호         v1.0             최초생성
 *
 */
package nciaProject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 최진호
 *
 */
public class Test {

	public static void main(String[] args) throws IOException, ParseException {

		System.out.println( System.getProperty("file.encoding") );

		String name = new String("[GPKI_CERT_VerifyByIVS] ?좏슚湲곌컙??留뚮즺???몄쬆???낅땲??");
		byte[] strs = name.getBytes();
		System.out.println("Length : " + strs.length);
		System.out.println("Hex " + BinToHex(strs));
		System.out.println("Value : " + new String(strs));
	}

	public static Date plusDate(Date source, int plus) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		cal.add(Calendar.DATE, plus);

		return cal.getTime();
	}

	public static String BinToHex(byte[] buf) {
		String res = "";
		String token = "";

		for(int ix = 0; ix < buf.length; ix++ ) {
			token = Integer.toHexString(buf[ix]);

			if( token.length() >= 2 ) {
				token = token.substring(token.length()-2);
			} else {
				for( int jx = 0; jx < 2-token.length(); jx++) {
					token = "0" + token;
				}
			}

			res += " " + token;
		}

		return res.toUpperCase();
	}
}
