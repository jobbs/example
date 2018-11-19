/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonException.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.exception;


/**
 * @author 최진호
 *
 */
@SuppressWarnings("serial")
public class CommonException extends RuntimeException {

    public CommonException( String message ) {
        super(message);
    }
}
