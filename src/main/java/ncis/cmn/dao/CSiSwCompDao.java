package ncis.cmn.dao;

import ncis.cmn.entity.SiSwComp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 소프트웨어구성정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiSwCompDao")
public class CSiSwCompDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 소프트웨어구성정보 등록
	 * @param siSwComp
	 */
	public void insertSiSwComp(SiSwComp siSwComp) {
		sqlSession.insert("ncis.sql.cmn.siSwComp.insertSiSwComp", siSwComp);
	}

	/**
	 * 소프트웨어구성정보 수정
	 * @param siSwComp
	 */
	public void updateSiSwComp(SiSwComp siSwComp) {
		sqlSession.update("ncis.sql.cmn.siSwComp.updateSiSwComp", siSwComp);
	}

	/**
	 * 소프트웨어구성정보 삭제
	 * @param siSwComp
	 */
	public void deleteSiSwComp(SiSwComp siSwComp) {
		sqlSession.update("ncis.sql.cmn.siSwComp.deleteSiSwComp", siSwComp);
	}

}
