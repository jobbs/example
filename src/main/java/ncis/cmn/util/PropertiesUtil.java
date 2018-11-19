/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PropertiesUtil.java
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
 * 2017. 06.23      gnsl                      jboss에서 WAR 타입 시에, `properties not found error` 수정.
 *
 */
package ncis.cmn.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {

	// 프로퍼티값 로드시 에러발생하면 반환되는 에러문자열
	public static final String ERR_CODE = " EXCEPTION OCCURRED";
	public static final String ERR_CODE_FNFE = " EXCEPTION(FNFE) OCCURRED";
	public static final String ERR_CODE_IOE = " EXCEPTION(IOE) OCCURRED";

	// 파일구분자
	static final char FILE_SEPARATOR = File.separatorChar;

	public static final String RELATIVE_PATH_PREFIX = PropertiesUtil.class
			.getResource("")
			.getPath()
			.substring(1,PropertiesUtil.class.getResource("").getPath().lastIndexOf("ncis"));

	public static final String GLOBALS_PROPERTIES_FILE = System.getProperty("file.separator") + RELATIVE_PATH_PREFIX
			+ "properties" + System.getProperty("file.separator")
			+ "globals.properties";

	private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);

	public static String getProperty(String keyName) {
		String value = "";
		FileInputStream fis = null;
		InputStream bis = null;
		try {

		    Properties props = new Properties();
		    /**
		     * 2017.06.23  jboss에서 WAR 타입 시에, `properties not found error` 수정.
		     */
//			fis = new FileInputStream(GLOBALS_PROPERTIES_FILE);
//			bis = new BufferedInputStream(fis);
		    bis = PropertiesUtil.class
					.getClassLoader() 
					.getResourceAsStream("properties" + System.getProperty("file.separator") + "globals.properties");
			props.load(bis);
			value = props.getProperty(keyName).trim();
		} catch (FileNotFoundException fne) {
			LOG.error(fne.getMessage());
		} catch (IOException ioe) {
			LOG.error(ioe.getMessage());
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}

		}
		return value;
	}

	public static String getPathProperty(String fileName, String key) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			java.util.Properties props = new java.util.Properties();
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			props.load(bis);

			String value = props.getProperty(key);
			value = "properties" + System.getProperty("file.separator") + value;
			return value;
		} catch (java.io.FileNotFoundException fne) {
			return ERR_CODE_FNFE;
		} catch (java.io.IOException ioe) {
			return ERR_CODE_IOE;
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}
		}
	}

	public static String getProperty(String fileName, String key) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			java.util.Properties props = new java.util.Properties();
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			props.load(bis);
			fis.close();

			String value = props.getProperty(key);
			return value;
		} catch (java.io.FileNotFoundException fne) {
			return ERR_CODE_FNFE;
		} catch (java.io.IOException ioe) {
			return ERR_CODE_IOE;
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				LOG.debug(ex.getMessage());
			}
		}
	}

}
