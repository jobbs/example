/* ###################################################################################################### 
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC COMMON DAO
 * ### @DESCRIPT : 	
 * ###################################################################################################### */
package com.netive.service.common.dao;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional("TxDataManager")
public class CommonDAO {

	@Autowired
	@Resource(name="CrawlDataSession")		//다중 데이터베이스 사용시, 접근할 데이터베이스 지정. 데이터베이스 설정은 *-context.xml 참고
	private SqlSession db;					//MYBATIS SQL SESSION 연결. 
		
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 한개의 ROW를 SELECT 하는 매서드 (GET ID) 
	 * */		
	public Object selectForObject(String id) {
		
		return db.selectOne(id);
	}

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 한개의 ROW를 SELECT 하는 매서드 (GET ID, GET PARM) 
	 * */			
	public Object selectForObject(String id, Object parm) {
		
		return db.selectOne(id, parm);
	}
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 다수개의 ROW를 SELECT 하는 매서드 (GET ID) 
	 * */				
	public List<?> selectForList(String id) {
		
		return db.selectList(id);
	}
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 다수개의 ROW를 SELECT 하는 매서드 (GET ID, GET PARM) 
	 * */					
	public List<?> selectForList(String id, Object parm) {
		
		return db.selectList(id, parm);
	}	
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : INSERT 하는 매서드 (GET ID) 
	 * */		
	public int insertForObject(String id) {
		
		return db.insert(id);
	}	

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : INSERT 하는 매서드 (GET ID, GET PARM) 
	 * */			
	public int insertForObject(String id, Object parm) {
		
		return db.insert(id, parm);
	}	

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : UPDATE 하는 매서드 (GET ID) 
	 * */		
	public int updateForObject(String id) {
		
		return db.update(id);
	}	

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : UPDATE 하는 매서드 (GET ID, GET PARM) 
	 * */			
	public int updateForObject(String id, Object parm) {
		
		return db.update(id, parm);
	}	
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DELETE 하는 매서드 (GET ID) 
	 * */		
	public int deleteForObject(String id) {
		
		return db.delete(id);
	}	

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DELETE 하는 매서드 (GET ID, GET PARM) 
	 * */			
	public int deleteForObject(String id, Object parm) {
		
		return db.delete(id, parm);
	}		

}
