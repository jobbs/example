package ncis.cmn.dao;

import ncis.cmn.entity.RsPStrgDfs;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리스토리지_DFS DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsPStrgDfsDao")
public class CRsPStrgDfsDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리스토리지_DFS 등록
	 * @param rsPStrgDfs
	 */
	public void insertRsPStrgDfs(RsPStrgDfs rsPStrgDfs) {
		sqlSession.insert("ncis.sql.cmn.rsPStrgDfs.insertRsPStrgDfs", rsPStrgDfs);
	}

	/**
	 * 물리스토리지_DFS 수정
	 * @param rsPStrgDfs
	 */
	public void updateRsPStrgDfs(RsPStrgDfs rsPStrgDfs) {
		sqlSession.update("ncis.sql.cmn.rsPStrgDfs.updateRsPStrgDfs", rsPStrgDfs);
	}

	/**
	 * 물리스토리지_DFS 삭제
	 * @param rsPStrgDfs
	 */
	public void deleteRsPStrgDfs(RsPStrgDfs rsPStrgDfs) {
		sqlSession.update("ncis.sql.cmn.rsPStrgDfs.deleteRsPStrgDfs", rsPStrgDfs);
	}

}
