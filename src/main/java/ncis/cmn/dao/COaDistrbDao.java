package ncis.cmn.dao;

import ncis.cmn.entity.OaDistrb;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배포 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaDistrbDao")
public class COaDistrbDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배포 등록
	 * @param oaDistrb
	 */
	public void insertOaDistrb(OaDistrb oaDistrb) {
		sqlSession.insert("ncis.sql.cmn.oaDistrb.insertOaDistrb", oaDistrb);
	}

	/**
	 * 배포 수정
	 * @param oaDistrb
	 */
	public void updateOaDistrb(OaDistrb oaDistrb) {
		sqlSession.update("ncis.sql.cmn.oaDistrb.updateOaDistrb", oaDistrb);
	}

	/**
	 * 배포 삭제
	 * @param oaDistrb
	 */
	public void deleteOaDistrb(OaDistrb oaDistrb) {
		sqlSession.update("ncis.sql.cmn.oaDistrb.deleteOaDistrb", oaDistrb);
	}

}
