/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PoolVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.netwkstack.vo;


/**
 * @author ShinKeeBong
 *
 */
public class PoolVO {

    private String lbAlgorithm;                             //부하분산 알고리즘
    private SessionPersistenceVO sessionPersistence;  //세션유지 방법

	public String getLbAlgorithm() {
		return lbAlgorithm;
	}
	public void setLbAlgorithm(String lbAlgorithm) {
		this.lbAlgorithm = lbAlgorithm;
	}
	public SessionPersistenceVO getSessionPersistence() {
		return sessionPersistence;
	}
	public void setSessionPersistence(SessionPersistenceVO sessionPersistence) {
		this.sessionPersistence = sessionPersistence;
	}
}
