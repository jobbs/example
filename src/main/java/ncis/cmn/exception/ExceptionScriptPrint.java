/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ExceptionScriptPrint.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 12. 13.
 * @lastmodified 2016. 12. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 13.     selim         v1.0             최초생성
 *
 */
package ncis.cmn.exception;

/**
 * @author 최진호
 *
 */
@SuppressWarnings("serial")
public class ExceptionScriptPrint extends RuntimeException {

	public enum ActionType {
		/**
		 * 원래 페이지로 이동
		 */
		DEFAULT,
		/**
		 * 창 닫기
		 */
		CLOSE,
		/**
		 * 부모창 새로고침
		 */
		OPENERRELOAD,
		/**
		 * 자신은 닫고 부모창은 새로 고침
		 */
		OPENERRELOADCLOSE
	}

	private ActionType actionType;

    public ExceptionScriptPrint( String message ) {
        super(message);
        this.actionType = ActionType.DEFAULT;
    }

    public ExceptionScriptPrint( String message, ActionType actionType) {
    	super(message);
    	this.actionType = actionType;
    }

    /**
	 * @return the actionType
	 */
	public ActionType getActionType() {
		return actionType;
	}
}
