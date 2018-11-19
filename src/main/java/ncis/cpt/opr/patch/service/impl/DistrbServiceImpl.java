/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DistrbServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.COaAtchFileDao;
import ncis.cmn.dao.COaDistrbDao;
import ncis.cmn.dao.COaVmDistrbDtlDao;
import ncis.cmn.entity.OaAtchFile;
import ncis.cmn.entity.OaVmDistrbDtl;
import ncis.cmn.exception.JsonException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.opr.patch.dao.DistrbDao;
import ncis.cpt.opr.patch.service.DistrbService;
import ncis.cpt.opr.patch.vo.DistrbFileVo;
import ncis.cpt.opr.patch.vo.DistrbSearchVo;
import ncis.cpt.opr.patch.vo.DistrbVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;
import ncis.intfc.seoa.service.SeoaService;
import ncis.intfc.seoa.vo.DeployConfigVO;
import ncis.intfc.seoa.vo.DeployResultVO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("distrbService")
public class DistrbServiceImpl implements DistrbService{

	@Resource(name="distrbDao")
	private DistrbDao distrbDao;

	@Resource(name="cOaDistrbDao")
	private COaDistrbDao cOaDistrbDao;

	@Resource(name="cOaAtchFileDao")
	private COaAtchFileDao cOaAtchFileDao;

	@Resource(name="cOaVmDistrbDtlDao")
	private COaVmDistrbDtlDao cOaVmDistrbDtlDao;

	@Resource(name = "seoaService")
	SeoaService seoaService;

	@Resource(name = "commonService")
	CommonService commonService;

	/**
	 * 배포 목록 조회
	 * @return
	 */
	@Override
	public List<DistrbVo> selectDistrbList(DistrbSearchVo searchVo) {

		List<DistrbVo> list = null;

		int totalCount = distrbDao.selectDistrbListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = distrbDao.selectDistrbList(searchVo);
		}
		return list;
	}

	/**
	 * 배포 목록 엑셀다운로드
	 * @return
	 */
	@Override
	public List<DistrbVo> selectDistrbExcelList(DistrbSearchVo searchVo) {

		List<DistrbVo> list = null;

		list = distrbDao.selectDistrbExcelList(searchVo);
		return list;
	}



	/**
	 * 배포 정보 등록
	 * @param distrbVo 배포 정보 내용
	 */

	public void insertDisrb(DistrbVo distrbVo) throws JsonException {

		try {
			//배포 등록
			if("".equals(distrbVo.getDistrbPath()) || null == distrbVo.getDistrbPath()){
				distrbVo.setDistrbPath(OprConstant.DISTRB_FILE_DEFAUlT_PATH);
			}
			cOaDistrbDao.insertOaDistrb(distrbVo);


			OaAtchFile oaAtchFile = new OaAtchFile();
			//첨부파일 등록
			DistrbFileVo distrbFileVo = distrbVo.getDistrbFile();
			oaAtchFile.setDistrbSeq(distrbVo.getDistrbSeq());//배포SEQ
			oaAtchFile.setAtchFileNm(distrbFileVo.getOriginFileName());
			oaAtchFile.setPath(distrbFileVo.getFilePath());
			oaAtchFile.setFileSize(new BigDecimal(distrbFileVo.getFileSize()));
			cOaAtchFileDao.insertOaAtchFile(oaAtchFile);

			OaVmDistrbDtl oaVmDistrbDtl = null;
			RestHeaders restHeaders = null;
			InputStream fis = null;
			BufferedInputStream reader = null;

			DeployResultVO result = null;
			for (VmPatchVo vmPatchVo : distrbVo.getDistrVmList()) {

				oaVmDistrbDtl = new OaVmDistrbDtl();
				oaVmDistrbDtl.setDistrbSeq(distrbVo.getDistrbSeq());
				oaVmDistrbDtl.setVmSeq(vmPatchVo.getVmSeq());
				oaVmDistrbDtl.setVmCompId(vmPatchVo.getVmCompId());
				cOaVmDistrbDtlDao.insertOaVmDistrbDtl(oaVmDistrbDtl);

				String rsrcPoolId = distrbDao.selectRsrcPoolId(vmPatchVo);

				restHeaders = new RestHeaders();
				restHeaders.setSeq(commonService.selectSeqNum("GW_IF_JOB", "GwJob"));
				restHeaders.setAreaId(vmPatchVo.getRegionId());
				restHeaders.setZoneId(vmPatchVo.getZoneId());
		        restHeaders.setNetworkId(vmPatchVo.getNetClCd());
		        restHeaders.setManagerId(rsrcPoolId);

		        DeployConfigVO deployConfigVO = new DeployConfigVO();


		        //테스트용
		       /* deployConfigVO.setMachineIp("10.182.239.38");
		        deployConfigVO.setLoginId("root");
		        deployConfigVO.setLoginPassWord("root");
		        deployConfigVO.setFileName(distrbVo.getDistrbFile().getOriginFileName());
		       if("".equals(distrbVo.getDistrbPath()) || null == distrbVo.getDistrbPath()){
		        	deployConfigVO.setDestinationPath(OprConstant.DISTRB_FILE_DEFAUlT_PATH);
				} else {
					deployConfigVO.setDestinationPath(distrbVo.getDistrbPath());
				}
		        deployConfigVO.setFileContent("77u/W2dyb3VwXQ0KMTAuMC40LjIxOSBhbnNpYmxlX3VzZXI9Y2xvdWQtdXNlciBjaGVja2luZ19o b3N0X2tleT1GYWxzZQ0KMTAuMC40LjIxNSBhbnNpYmxlX3VzZXI9Y2xvdWQtdXNlciBjaGVja2lu Z19ob3N0X2tleT1GYWxzZQ==");

*/
		        //실제 데이터
		        deployConfigVO.setMachineIp(vmPatchVo.getRprsntIpAddr());
		        deployConfigVO.setLoginId("root");
		        deployConfigVO.setLoginPassWord(vmPatchVo.getPassWd());
		        deployConfigVO.setFileName(distrbVo.getDistrbFile().getOriginFileName());
		        if("".equals(distrbVo.getDistrbPath()) || null == distrbVo.getDistrbPath()){
		        	deployConfigVO.setDestinationPath(OprConstant.DISTRB_FILE_DEFAUlT_PATH);
				} else {
					deployConfigVO.setDestinationPath(distrbVo.getDistrbPath());
				}

		        try {
		        	int length = distrbVo.getUploadFile().getBytes().length;
					fis = distrbVo.getUploadFile().getInputStream();
					reader = new BufferedInputStream(fis);
					byte[] bytes = new byte[length];
					reader.read(bytes, 0, length);

					deployConfigVO.setFileContent(
							StringUtils.newStringUtf8(Base64.encodeBase64(bytes))
						);

		        } catch(IOException e) {
		        	throw e;
		        } finally {
		        	if( null != fis ) fis.close();
		        	if( null != reader ) reader.close();
		        }

		        result = seoaService.deployVmConfigFile(restHeaders, deployConfigVO);

				if("file exists".equals(result.getStatus())) {
					throw new Exception("배포경로에 동일한 파일이 존재합니다.");
				}
			}
		} catch (Exception e) {
			throw new JsonException(e.getMessage());
		}
	}

}
