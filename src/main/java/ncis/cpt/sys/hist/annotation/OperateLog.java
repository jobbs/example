/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OperateLog.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {

	public enum ActionType {
		READ, INSERT, UPDATE, DELETE, ACTION
	}

	/**
	 * 행위명
	 * @return
	 */
	String action() default "";

	/**
	 * 행위설명
	 * @return
	 */
	String desc() default "";

	/**
	 * 실행타입
	 */
	ActionType actionType() default ActionType.READ;

	/**
	 * 저장하고자 하는 파라메터
	 * @return
	 */
	String[] params() default "";

}
