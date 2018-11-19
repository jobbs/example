/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmRcLogger.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 11. 4.
 * @lastmodified 2016. 11. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 4.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.logger;

import java.io.IOException;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 심원보
 *
 */
public class VmRcLogger {

//    private static Hashtable<BigDecimal, Logger> loggers = new Hashtable<BigDecimal, Logger>();
//    private static String prefixFileName = PropertiesUtil.getProperty("VM_RC_LOG_PATH");

    public static synchronized Logger getLogger(BigDecimal vmSeq) throws IOException {

    	return LoggerFactory.getLogger("vmRcLog");
//        Logger logger = loggers.get(vmSeq);
//        if (null == logger) {
//            logger = Logger.getLogger(String.format("%s/%s", prefixFileName, vmSeq.toString()));
//            loggers.put(vmSeq, logger);
//            String fileName = String.format("%s/%s.log", prefixFileName, vmSeq.toString());
//            String pattern = "[%d{yyyy-MM-dd HH:mm:ss}] %m%n";
//            PatternLayout layout = new PatternLayout(pattern);
//            String datePattern = ".yyyy-MM-dd";
//            DailyRollingFileAppender dailyRollingFileAppender = new DailyRollingFileAppender(layout, fileName, datePattern);
//            logger.addAppender(dailyRollingFileAppender);
//        }
//        return logger;

    }

}
