/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TestDao.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 2. 7.
 * @lastmodified 2017. 2. 7.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 2. 7.     selim         v1.0             최초생성
 *
 */
package ncis.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author selim
 *
 */
@Repository("testDao")
public class TestDao {
	@Autowired
    SqlSessionTemplate sqlSession;

	/**
	 * @param i
	 */
	public void insertSequenceTest(int i) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("testNm", "테스트순번 : " + i);

		sqlSession.insert("ncis.sql.cpt.test.insertSequenceTest", params);
	}
}
