/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwServiceImpl.java
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
package ncis.cpt.opr.catalg.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.dao.CRrSwDao;
import ncis.cmn.entity.RrSw;
import ncis.cpt.opr.catalg.dao.SwDao;
import ncis.cpt.opr.catalg.service.SwService;
import ncis.cpt.opr.catalg.vo.SwSearchVo;
import ncis.cpt.opr.catalg.vo.SwVo;

import org.apache.poi.POIXMLException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

/**
 * @author 이화영
 *
 */
@Service("swService")
public class SwServiceImpl implements SwService {

	private static final Logger logger = LoggerFactory.getLogger(SwServiceImpl.class);

	@Resource(name="swDao") private SwDao swDao;
	@Resource(name="cRrSwDao") private CRrSwDao cRrSwDao;

	/**
	 * 소프트웨어 목록조회
	 * @param vo
	 * @return
	 */
	@Override
	public List<SwVo> selectSwMngList(SwSearchVo svo){

		List<SwVo> resultList = null;

		int totCnt = swDao.selectSwMngListTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);	// 페이지 처리위한 count
			resultList = swDao.selectSwMngList(svo);
		}
		return resultList;
	}

	/**
	 * 소프트웨어 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	@Override
	public List<SwVo> selectSwExcelList(SwSearchVo svo) {

		List<SwVo> list = null;

		list = swDao.selectSwExcelList(svo);

		return list;
	}

	/**
	 * 소프트웨어 상세 조회
	 * @param swSeq
	 * @return
	 */
	@Override
	public SwVo selectSw(BigDecimal swSeq) {
		return swDao.selectSw(swSeq);
	}

	/**
	 * 소프트웨어 등록
	 * @param rrSw
	 */
	@Override
	public void insertSw(RrSw rrSw) {
		cRrSwDao.insertRrSw(rrSw);
	}

	/**
	 *sw정보 중복 체크
	 * @param swVo
	 */
	public boolean selectSwInfoCheck(String swNm, String swVer, BigDecimal swSeq){
		return swDao.selectSwInfoCheck(swNm, swVer, swSeq) >= 1 ? true : false;
	}

	/**
	 *sw사용여부 체크
	 * @param swSeq
	 */
	public boolean selectSwUseYn(BigDecimal swSeq) {
		return swDao.selectSwUseYn(swSeq) >= 1 ? true : false;
	}

	/**
	 * 소프트웨어 수정
	 * @param rrSw
	 */
	@Override
	public void updateSw(RrSw rrSw) {
		cRrSwDao.updateRrSw(rrSw);
	}

	/**
	 * 소프트웨어 삭제
	 * @param svo
	 */
	@Override
	public void deleteListSw(SwVo swVo) {

		 for (int i = 0; i < swVo.getUpdtCheck().size(); i++) {
			 int useCnt =  swDao.selectSwUseYn(new BigDecimal(swVo.getUpdtCheck().get(i)));

			 if(useCnt == 0){
				 cRrSwDao.deleteSw(new BigDecimal(swVo.getUpdtCheck().get(i)));
			 }
	     }
	}

	/**
	 * 소프트웨어 삭제
	 * @param rrSw
	 */
	@Override
	public void deleteSw(BigDecimal swSeq){
		cRrSwDao.deleteSw(swSeq);
	}

	/**
	 * SW업로드 예시파일 다운로드
	 * @return
	 */
	@Override
	public void exampleFileDwnLoad(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException  {


		String dftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/cpt/opr/catalg/tmplat/");
		File file = new File(dftpath+"/SWUpLoadSample.x");
		String fileNm = "SW업로드샘플";
		response.reset();

		response.setContentType("application/vnd.ms-excel");
		response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".xlsx\"");
        response.setHeader("Content-Transfer-Encoding", "binary");

        FileInputStream fis = null;
		OutputStream out = null;

		try{
			fis = new FileInputStream(file);
			out = response.getOutputStream();

			byte b[] = new byte[1024];
			int data = 0;

			while((data=(fis.read(b, 0, b.length))) != -1){
				out.write(b, 0, data);
			}
			FileCopyUtils.copy(fis, out);

			out.flush();
			out.close();
			fis.close();
		}catch(FileNotFoundException fe){
			logger.error("FileNotFoundException", fe);
		}catch(IOException ie){
			logger.error("IOException", ie);
		}catch(Exception e){
			logger.error("Exception", e);
		}
	}

	/**
	 * SW 업로드
	 */
	@Override
	public boolean fileUpLoadForm(File newFile, String userId){

		boolean bool = true;

		if(newFile != null && !newFile.equals("")){
			try{
				List<RrSw> list = null;
				list = readExcelFile(newFile, userId);

				// 업로드된 엑셀파일의 중복 데이터 제거
				for(int i=0; i<list.size(); i++){

					RrSw vo = new RrSw();
					vo = list.get(i);
					for(int j=0; j<list.size(); j++){
						RrSw compVo = new RrSw();
						compVo = list.get(j);

						if(i != j){
							if(vo.getSwNm().equals(compVo.getSwNm()) || vo.getSwNm() == compVo.getSwNm()){
								if(vo.getSwVer().equals(compVo.getSwVer()) || vo.getSwVer() == compVo.getSwVer()){
									list.remove(j);
								}
							}
						}
					}
				}

				// 업로드된 정상 데이터  insert
				for(int k=0; k<list.size(); k++){
					cRrSwDao.insertRrSw(list.get(k));
				}

			}catch(FileNotFoundException fe){
				logger.error("FileNotFoundException", fe);
				bool = false;
			}catch(IOException ie){
				logger.error("IOException", ie);
				bool = false;
			}catch(POIXMLException pe){
				logger.error("POIXMLException", pe);
				bool = false;
			}catch(Exception e){
				logger.error("Exception", e);
				bool = false;
			}
		}else{
			bool = false;
		}
		return bool;
	}

	/**
	 * 업로드 파일 read
	 * @throws InvalidFormatException
	 */
	@Override
	public List<RrSw> readExcelFile(File newFile, String userId) throws IOException, FileNotFoundException, InvalidFormatException {

		List<SwVo> swAllList = swDao.selectSwMngList(null);

		List<RrSw> list = new ArrayList<RrSw>();

		FileInputStream fis=new FileInputStream(newFile);
//		POIFSFileSystem pfs= new POIFSFileSystem(fis);
//		Workbook workbook = new HSSFWorkbook(fis);

		Workbook workbook = null;
		if(newFile.toString().endsWith(".xls")){
			workbook = new HSSFWorkbook(fis);
		}else{
			workbook = new XSSFWorkbook(fis);
		}

//		workbook = WorkbookFactory.create(fis);

		int sheetCnt = workbook.getNumberOfSheets();

		for(int i=0; i<sheetCnt; i++){

			//HSSFSheet sheet = workbook.getSheetAt(i);
			Sheet sheet = workbook.getSheetAt(i);

			int rowCnt = sheet.getPhysicalNumberOfRows();

			for(int j=0; j<rowCnt; j++){

				if(j!=0){
					RrSw vo = new RrSw();


					//HSSFRow r1 = sheet.getRow(r);
					Row r1 = sheet.getRow(j);

//					HSSFCell c1 = r1.getCell(0);
//					HSSFCell c2 = r1.getCell(1);
//					HSSFCell c3 = r1.getCell(2);
//					HSSFCell c4 = r1.getCell(3);
//					HSSFCell c5 = r1.getCell(4);

					Cell c1 = r1.getCell(0);
					Cell c2 = r1.getCell(1);
					Cell c3 = r1.getCell(2);
					Cell c4 = r1.getCell(3);
					Cell c5 = r1.getCell(4);

					vo.setSwNm(c1.getStringCellValue());
					vo.setSwVer(c2.getStringCellValue());
					if(!("").equals(c3) && null != c3){
						vo.setSwMnfctCo(c3.getStringCellValue());
					}
					if(!("").equals(c4) && null != c4){
						vo.setRmk(c4.getStringCellValue());
					}
					if(!("").equals(c5) && null != c5){
						vo.setCompId(c5.getStringCellValue());
					}
					vo.setCreUserId(userId);
					//vo.setUpdtUserId(userId);

					boolean bool = true;

					// 기존 SW와 중복데이터 비교
					for(int k=0; k<swAllList.size(); k++){
						if(swAllList.get(k).getSwNm().equals(c1.getStringCellValue()) || swAllList.get(k).getSwNm() == c1.getStringCellValue()){
							if(swAllList.get(k).getSwVer().equals(c2.getStringCellValue()) || swAllList.get(k).getSwVer() == c2.getStringCellValue()){
								bool = false;
							}
						}
					}

					if(bool){
						list.add(vo);
					}
				}
			}
		}

		return list;
	}

}
