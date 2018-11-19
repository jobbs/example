package ncis.cmn.dao;

import ncis.cmn.entity.RsPStrgNas;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리스토리지_NAS DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsPStrgNasDao")
public class CRsPStrgNasDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리스토리지_NAS 등록
	 * @param rsPStrgNas
	 */
	public void insertRsPStrgNas(RsPStrgNas rsPStrgNas) {
		sqlSession.insert("ncis.sql.cmn.rsPStrgNas.insertRsPStrgNas", rsPStrgNas);
	}

	/**
	 * 물리스토리지_NAS 수정
	 * @param rsPStrgNas
	 */
	public void updateRsPStrgNas(RsPStrgNas rsPStrgNas) {
		sqlSession.update("ncis.sql.cmn.rsPStrgNas.updateRsPStrgNas", rsPStrgNas);
	}

	/**
	 * 물리스토리지_NAS 삭제
	 * @param rsPStrgNas
	 */
	public void deleteRsPStrgNas(RsPStrgNas rsPStrgNas) {
		sqlSession.update("ncis.sql.cmn.rsPStrgNas.deleteRsPStrgNas", rsPStrgNas);
	}

}
