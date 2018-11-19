package ncis.cmn.dao;

import ncis.cmn.entity.OaAtchFile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 첨부파일 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaAtchFileDao")
public class COaAtchFileDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 첨부파일 등록
	 * @param oaAtchFile
	 */
	public void insertOaAtchFile(OaAtchFile oaAtchFile) {
		sqlSession.insert("ncis.sql.cmn.oaAtchFile.insertOaAtchFile", oaAtchFile);
	}

	/**
	 * 첨부파일 수정
	 * @param oaAtchFile
	 */
	public void updateOaAtchFile(OaAtchFile oaAtchFile) {
		sqlSession.update("ncis.sql.cmn.oaAtchFile.updateOaAtchFile", oaAtchFile);
	}

	/**
	 * 첨부파일 삭제
	 * @param oaAtchFile
	 */
	public void deleteOaAtchFile(OaAtchFile oaAtchFile) {
		sqlSession.update("ncis.sql.cmn.oaAtchFile.deleteOaAtchFile", oaAtchFile);
	}

}
