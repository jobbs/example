/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestTestController.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.test.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/inrest")
public class RestTestController {

	Logger logger = LoggerFactory.getLogger(RestTestController.class);

	@Resource(name="userService") UserService userService;

	@RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
	public ResponseEntity<UserVo> selectUser(HttpServletRequest request, @PathVariable String userId, Model model) {

		 Enumeration<String> headerNames = request.getHeaderNames();
		 while(headerNames.hasMoreElements()) {

			 String header = headerNames.nextElement();

			 System.out.println( header +  " : " + request.getHeader(header));
		 }




		logger.debug("GET User ======================================================================================");
		logger.debug("Request User ID : " + userId);

		UserVo user = userService.selectUser(userId);

		logger.debug("GET User ======================================================================================");
		return new ResponseEntity<UserVo>(user, HttpStatus.OK);
	}


	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<ProcResultVo> insertUser(HttpServletRequest request, @RequestBody UserVo user) throws IOException {

		ProcResultVo result = new ProcResultVo();

		logger.debug("ADD User ======================================================================================");

		logger.debug("User ID : " + user.getUserId());
		logger.debug("User Name : " + user.getUserNm());

		result.setData(user);

		logger.debug("ADD User ======================================================================================");

		return new ResponseEntity<ProcResultVo>(result, HttpStatus.OK);
	}

	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public ResponseEntity<ProcResultVo> updateUser(@RequestBody UserVo user) {

		ProcResultVo result = new ProcResultVo();

		logger.debug("UPDATE User ======================================================================================");

		logger.debug("User ID : " + user.getUserId());
		logger.debug("User Name : " + user.getUserNm());

		logger.debug("UPDATE User ======================================================================================");

		return new ResponseEntity<ProcResultVo>(result, HttpStatus.OK);
	}

	@RequestMapping(value="/user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<ProcResultVo> deleteUser(@PathVariable String userId) {

		ProcResultVo result = new ProcResultVo();

		logger.debug("DELETE User ======================================================================================");

		logger.debug("User ID : " + userId);

		logger.debug("DELETE User ======================================================================================");

		return new ResponseEntity<ProcResultVo>(result, HttpStatus.OK);
	}

}

