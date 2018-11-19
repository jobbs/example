package ncis.cmn.dao;

import ncis.cmn.entity.StTrgtSrvrThresConf;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cStTrgtSrvrThresConfDao")
public class CStTrgtSrvrThresConfDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 대상서버 임계치 설정 등록
	 * @param roleUserVo
	 */
	public void insertStTrgtSrvrThresConf(StTrgtSrvrThresConf vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConf",vo);
	}
	/**
	 * 물리서버 임계치 설정  등록 직접 입력
	 * */
	public void insertStTrgtSrvrThresConfPm(PmThrdConfVo vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConfPm",vo);
	}
	/**
	 * 가상서버 임계치 설정  등록 직접 입력
	 * */
	public void insertStTrgtSrvrThresConfVm(PmThrdConfVo vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConfVm",vo);
	}

	/**
	 * 자동확장 임계치 설정  등록 직접 입력
	 * */
	public void insertStTrgtSrvrThresConfAx(PmThrdConfVo vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConfAx",vo);
	}

	/**
	 * 프로파일 선택 등록
	 * @param roleUserVo
	 */
	public void insertStTrgtSrvrThresConfPmProf(PmThrdConfVo vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConfPmProf",vo);
	}
	public void insertStTrgtSrvrThresConfVmProf(PmThrdConfVo vo) {
		sqlSession.insert("ncis.sql.cmn.stTrgtSrvrThresConf.insertStTrgtSrvrThresConfVmProf",vo);
	}

	/**
	 * 대상서버 임계치 설정 수정
	 * @param dicary
	 */
	public void updateStTrgtSrvrThresConf(StTrgtSrvrThresConf vo) {
		sqlSession.update("ncis.sql.cmn.stTrgtSrvrThresConf.updateStTrgtSrvrThresConf",vo);
	}

	/**
	 * 대상서버 임계치 설정 삭제
	 * @param roleUser
	 */
	public void deleteStTrgtSrvrThresConf(StTrgtSrvrThresConf vo) {
		sqlSession.delete("ncis.sql.cmn.stTrgtSrvrThresConf.deleteStTrgtSrvrThresConf", vo);
	}
	/**
	 * 물리서버서버 임계치 설정 삭제
	 * @param roleUser
	 */
	public int deleteStTrgtSrvrThresConfPm(PmThrdConfVo vo) {
		return sqlSession.delete("ncis.sql.cmn.stTrgtSrvrThresConf.deleteStTrgtSrvrThresConfPm", vo);
	}
	/**
	 * 물리서버서버 임계치 설정 삭제
	 * @param roleUser
	 */
	public int deleteStTrgtSrvrThresConfVm(PmThrdConfVo vo) {
		return sqlSession.delete("ncis.sql.cmn.stTrgtSrvrThresConf.deleteStTrgtSrvrThresConfVm", vo);
	}

	/**
	 * 자동확장 임계치 설정 삭제
	 * @param roleUser
	 */
	public int deleteStTrgtSrvrThresConfAx(PmThrdConfVo vo) {
		return sqlSession.delete("ncis.sql.cmn.stTrgtSrvrThresConf.deleteStTrgtSrvrThresConfAx", vo);
	}
}
