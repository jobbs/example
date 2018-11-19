/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 11.
 * @lastmodified 2017. 1. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 11.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.entity.RrSw;
import ncis.cpt.opr.catalg.vo.SwSearchVo;
import ncis.cpt.opr.catalg.vo.SwVo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * @author 이화영
 *
 */
public interface SwService {

	/**
	 * 소프트웨어 목록조회
	 * @param svo
	 * @return
	 */
	public List<SwVo> selectSwMngList(SwSearchVo svo);

	/**
	 * 소프트웨어 Excel 목록 조회
	 * @param svo
	 * @return
	 */
	List<SwVo> selectSwExcelList(SwSearchVo svo);

	/**
	 * 소프트웨어 상세 조회
	 * @param swSeq
	 * @return
	 */
	SwVo selectSw(BigDecimal swSeq);

	/**
	 * 소프트웨어 등록
	 * @param rrSw
	 */
	void insertSw(RrSw rrSw);

	/**
	 *sw정보 중복 체크
	 * @param swVo
	 */
	boolean selectSwInfoCheck(String swNm, String swVer, BigDecimal swSeq);

	/**
	 *sw사용여부 체크
	 * @param swSeq
	 */
	boolean selectSwUseYn(BigDecimal swSeq);

	/**
	 * 소프트웨어 수정
	 * @param rrSw
	 */
	void updateSw(RrSw rrSw);

	/**
	 * 소프트웨어 삭제
	 * @param svo
	 */
	public void deleteListSw(SwVo swVo);
	/**
	 * 소프트웨어 삭제
	 * @param rrSw
	 */
	void deleteSw(BigDecimal swSeq);

	/**
	 * SW업로드 예시파일 다운로드
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	public void exampleFileDwnLoad(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

	/**
	 * SW 업로드
	 * @param newFile
	 * @param userId
	 */
	public boolean fileUpLoadForm(File newFile, String userId);

	/**
	 * 업로드 파일 read
	 * @param newFile
	 * @param userId
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InvalidFormatException
	 */
	public List<RrSw> readExcelFile(File newFile, String userId) throws IOException, FileNotFoundException, InvalidFormatException;
}
