/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchAsgnServiceImpl.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service.impl;

import javax.annotation.Resource;
import ncis.cmn.dao.CRnVrSwtchAsgnDao;
import ncis.cpt.opr.ip.dao.RnVrSwtchAsgnDao;
import ncis.cpt.opr.ip.service.VrSwtchAsgnService;
import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */

@Service("vrSwtchAsgnService")
public class VrSwtchAsgnServiceImpl implements VrSwtchAsgnService {
    @Resource(name = "cRnVrSwtchAsgnDao")
    private CRnVrSwtchAsgnDao cRnVrSwtchAsgnDao;

    @Resource(name = "rnVrSwtchAsgnDao")
    private RnVrSwtchAsgnDao rnVrSwtchAsgnDao;

    // /**
    // * 가상스위치(LAN) 할당 정보 조회
    // */
    // @Override
    // public List<VrSwtchAsgnVo> selectVrSwtchAsgnList(VrSwtchAsgnSearchVo searchVo) {
    // return rnVrSwtchAsgnDao.selectVrSwtchAsgnList(searchVo);
    // }
    //
    // /**
    // * 가상스위치(LAN) 정보 수정
    // */
    // @Override
    // public void updateVrSwtchAsgnList(VrSwtchAsgnSearchVo searchVo, List<VrSwtchAsgnVo> vrSwtchAsgnVoList) {
    // List<VrSwtchAsgnVo> vrSwtchAsgnVoListForDelete = rnVrSwtchAsgnDao.selectVrSwtchAsgnList(searchVo);
    //
    // for (VrSwtchAsgnVo vrSwtchAsgnListForInsert : vrSwtchAsgnVoList) {
    // boolean contains = false;
    // for (VrSwtchAsgnVo vrSwtchAsgnVoForDelete : vrSwtchAsgnVoListForDelete) {
    // if (vrSwtchAsgnVoForDelete.getVrSwtchSeq().equals(vrSwtchAsgnListForInsert.getVrSwtchSeq())) {
    // contains = true;
    // vrSwtchAsgnVoListForDelete.remove(vrSwtchAsgnVoForDelete);
    // break;
    // }
    // }
    // if (!contains) {
    // cRnVrSwtchAsgnDao.insertRnVrSwtchAsgn(vrSwtchAsgnListForInsert);
    // }
    // }
    //
    // for (VrSwtchAsgnVo vrSwtchAsgnVoForDelete : vrSwtchAsgnVoListForDelete) {
    // cRnVrSwtchAsgnDao.deleteRnVrSwtchAsgn(vrSwtchAsgnVoForDelete);
    // }
    //
    // }
    //
    // /**
    // * 가상스위치 할당 정보 추가
    // */
    // @Override
    // public void insertVrSwtchAsgnList(List<VrSwtchAsgnVo> vrSwtchAsgnVoList) {
    // for (VrSwtchAsgnVo vrSwtchAsgnListForInsert : vrSwtchAsgnVoList) {
    // cRnVrSwtchAsgnDao.insertRnVrSwtchAsgn(vrSwtchAsgnListForInsert);
    // }
    // }

}
