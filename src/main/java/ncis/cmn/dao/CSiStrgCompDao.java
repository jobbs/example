package ncis.cmn.dao;

import ncis.cmn.entity.SiStrgComp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 스토리지구성정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSiStrgCompDao")
public class CSiStrgCompDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 스토리지구성정보 등록
	 * @param siStrgComp
	 */
	public void insertSiStrgComp(SiStrgComp siStrgComp) {
		sqlSession.insert("ncis.sql.cmn.siStrgComp.insertSiStrgComp", siStrgComp);
	}

	/**
	 * 스토리지구성정보 수정
	 * @param siStrgComp
	 */
	public void updateSiStrgComp(SiStrgComp siStrgComp) {
		sqlSession.update("ncis.sql.cmn.siStrgComp.updateSiStrgComp", siStrgComp);
	}

	/**
	 * 스토리지구성정보 삭제
	 * @param siStrgComp
	 */
	public void deleteSiStrgComp(SiStrgComp siStrgComp) {
		sqlSession.update("ncis.sql.cmn.siStrgComp.deleteSiStrgComp", siStrgComp);
	}

}
