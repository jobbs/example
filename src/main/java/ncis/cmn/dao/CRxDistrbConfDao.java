package ncis.cmn.dao;

import ncis.cmn.entity.RxDistrbConf;
import ncis.cmn.entity.RxDistrbEnvConf;
import ncis.cmn.entity.RxMnulScl;
import ncis.cmn.entity.RxPvc;
import ncis.cmn.entity.RxRsrvSclng;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배포설정 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxDistrbConfDao")
public class CRxDistrbConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배포설정 등록
	 * @param rxDistrbConf
	 */
	public void insertRxDistrbConf(RxDistrbConf rxDistrbConf) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertRxDistrbConf", rxDistrbConf);
	}

	/**
	 * 배포설정 수정
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbConf(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbConf", rxDistrbConf);
	}

	/**
	 * 배포설정 삭제
	 * @param rxDistrbConf
	 */
	public void deleteRxDistrbConf(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.deleteRxDistrbConf", rxDistrbConf);
	}

	/**pvc 추가
	 * @param rxPvc
	 * @return
	 */
	public void insertPvcStrgAdd(RxPvc rxPvc) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertPvcStrgAdd", rxPvc);
	}

	/**배포설정 pvc 할당
	 * @param rxPvc
	 */
	public void insertDistrbAsgn(RxPvc rxPvc) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbAsgn", rxPvc);
	}

	/**
	 * @param rxMnulScl
	 */
	public void insertReplicasAdd(RxMnulScl rxMnulScl) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertReplicasAdd", rxMnulScl);
	}

	/**
	 * @param disConf
	 */
	public void updateRsrcLt(RxDistrbConf disConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRsrcLt", disConf);
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRsrcLtHstry", disConf);
	}

	/**
	 * 배포설정 버전 수정
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbConfVer(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbConfVer", rxDistrbConf);
	}

	/**
	 * 배포 상태 수정
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbConfStat(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbConfStat", rxDistrbConf);
	}


	/**배포 환경변수 삭제
	 * @param rxDistrbConf
	 */
	public void deleteDistrbConf(RxDistrbEnvConf rxEnvConf) {
		sqlSession.delete("ncis.sql.cmn.rxDistrbConf.deleteDistrbConf", rxEnvConf);
	}

	/**배포 환경변수 추가
	 * @param rxEnvConf
	 */
	public void insertDistrbConf(RxDistrbEnvConf rxEnvConf) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbConf", rxEnvConf);
	}

	/**
	 * @param rxRsrvSclng
	 */
	public void insertDistrbAutoConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbAutoConf", rxRsrvSclng);
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbAutoThresConf", rxRsrvSclng);
	}

	/** 오토스케일링 설정
	 * @param rxRsrvSclng
	 */
	public void insertDistrbMultiSclConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbAutoConf", rxRsrvSclng);
	}

	/** 다차원 스케일링 설정
	 * @param rxRsrvSclng
	 */
	public void insertDistrbMultiSclThresConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbAutoThresConf", rxRsrvSclng);
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertDistrbMultiSclGrpConf", rxRsrvSclng);
	}

	/** 배포 설정
	 * @param rxDistrbConf
	 */
	public void insertRxDistrbHstry(RxDistrbConf rxDistrbConf) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbConf.insertRxDistrbHstry", rxDistrbConf);
	}

	/**
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbHstry(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbHstry", rxDistrbConf);

	}

	/**
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbConfSave(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbConfSave", rxDistrbConf);

	}

	/**
	 * @param rxRsrvSclng
	 */
	public void updateDistrbAutoConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.updateDistrbAutoConf", rxRsrvSclng);
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.updateDistrbAutoThresConf", rxRsrvSclng);

	}

	/**
	 * @param rxRsrvSclng
	 */
	public void updateDistrbMultiSclConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.updateDistrbMultiSclConf", rxRsrvSclng);

	}

	/**
	 * @param rxRsrvSclng
	 */
	public void updateDistrbMultiSclThresConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.updateDistrbMultiSclThresConf", rxRsrvSclng);
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.updateDistrbMultiSclGrpConf", rxRsrvSclng);

	}

	/**
	 * @param rxRsrvSclng
	 */
	public void deleteDistrbAutoSclConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbAutoSclConf", rxRsrvSclng);
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbAutoSclThresConf", rxRsrvSclng);
	}

	/**
	 * @param rxRsrvSclng
	 */
	public void deleteDistrbMultiSclConf(RxRsrvSclng rxRsrvSclng) {
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbAutoSclThresConf", rxRsrvSclng);
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbAutoSclGrpConf", rxRsrvSclng);

	}
	/**자원제한 초기화
	 * @param disConf
	 */
	public void updateInitRsrcLt(RxDistrbConf disConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateInitRsrcLt", disConf);
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateInitRsrcLtHstry", disConf);
	}

	/**
	 * @param rxPvc
	 */
	public void deleteDistrbAsgn(RxPvc rxPvc) {
		sqlSession.delete("ncis.sql.cmn.rxDistrbConf.deleteDistrbAsgn", rxPvc);

	}

	/**
	 * @param rxPvc
	 */
	public void deletePvcStrgAdd(RxPvc rxPvc) {
		sqlSession.delete("ncis.sql.cmn.rxDistrbConf.deletePvcStrgAdd", rxPvc);

	}

	/**
	 * @param rxRsrvSclng
	 */
	public void deleteDistrbMultiScl(RxRsrvSclng rxRsrvSclng) {
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbAutoSclConf", rxRsrvSclng);
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbMultiSclThresConf", rxRsrvSclng);
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteDistrbMultiSclGrpConf", rxRsrvSclng);
	}

	/**
	 * @param rxDistrbConf
	 */
	public void updateRxDistrbSync(RxDistrbConf rxDistrbConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbConf.updateRxDistrbSync", rxDistrbConf);

	}


}
