/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.service;

import java.util.List;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.alrm.vo.AlrmVo;

/**
 * @author 최진호
 *
 */
public interface AlrmService {

    /**
     * 알림 목록 수
     * @param searchVo
     * @return
     */
    public int selectAlrmTotCnt(AlrmSearchVo searchVo);

    /**
     * 알림 목록
     * @param searchVo
     * @return
     */
    public List<AlrmVo> selectAlrmList(AlrmSearchVo searchVo);

    /**
     * 알림 상세
     * @param alrmSeq
     * @return
     */
    public AlrmVo selectAlrm(Long alrmSeq);

    /**
     * 알림 수정
     */
    public void updateAlrm(AlrmVo alrmVo);

	/**
	 * 알림 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<AlrmVo> selectAlrmListXlsDwnl(AlrmSearchVo searchVo);

}
