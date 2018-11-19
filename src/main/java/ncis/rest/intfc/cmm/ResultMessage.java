/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ResultMessage.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */

package ncis.rest.intfc.cmm;

import java.util.List;

import ncis.cmn.util.DateUtil;
import ncis.rest.intfc.cmm.vo.ResultVO;
import ncis.rest.intfc.conf.vo.ApplInfoVO;
import ncis.rest.intfc.conf.vo.CategoryCodeVO;
import ncis.rest.intfc.conf.vo.CfImgVO;
import ncis.rest.intfc.conf.vo.CfServcNsVO;
import ncis.rest.intfc.conf.vo.CfServcVO;
import ncis.rest.intfc.conf.vo.CfBldConfVO;
import ncis.rest.intfc.conf.vo.CfDistrbConfVO;
import ncis.rest.intfc.conf.vo.CfServcSclngVO;
import ncis.rest.intfc.conf.vo.ClusterVO;
import ncis.rest.intfc.conf.vo.PmVO;
import ncis.rest.intfc.conf.vo.SoftwareVO;
import ncis.rest.intfc.conf.vo.SpecInfoVO;
import ncis.rest.intfc.conf.vo.TemplateSwVO;
import ncis.rest.intfc.conf.vo.TemplateVO;
import ncis.rest.intfc.conf.vo.VmVO;
import ncis.rest.intfc.conf.vo.ZoneVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * API 서비스 결과 코드에 따른 메세지 정의 Class
 *
 * @author ShinKeeBong
 *
 */
public class ResultMessage {


	/**
	 * 오류코드 출력용
	 * @param resultCode
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseEntity<ResultVO> ErrorResultVO(String resultCode)
	{
		ResultVO errorVO = new ResultVO();

		errorVO.setResultCode(resultCode);
		errorVO.setResultCnt(0);
		errorVO.setMessage(Message(resultCode));

		return new ResponseEntity<ResultVO>(errorVO, HttpStatus.OK);
	}

	/**
	 * 정상적으로 조회된 데이터 List 출력용
	 * @param <T>
	 * @param resultCode
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> ResponseEntity<ResultVO> SuccessResultVO(String resultCode, List<T> data)
	{
		ResultVO<T> resultVO = new ResultVO<T>();
		String gatherDate = null;
		Object obj= null;
		//VO에 셋팅된 gatherDate를 resultVO에 셋팅하고 VO에는 null처리함.
		if(data != null && data.size()>0){
			resultVO.setResultCode(resultCode);
			resultVO.setResultCnt(data.size());
			resultVO.setMessage(Message(resultCode));
			gatherDate= DateUtil.getCurrentTimeString();
			for(int i=0; i < data.size(); i++){
				obj=data.get(i);
				if(obj instanceof ZoneVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setZoneInfos(data);
					}
				}else if(obj instanceof ClusterVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setClusterInfos(data);
					}
				}else if(obj instanceof  PmVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setPmInfos(data);
					}
				}else if(obj instanceof VmVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setVmInfos(data);
					}
				}else if(obj instanceof CategoryCodeVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setCodeInfos(data);
					}
				}else if(obj instanceof ApplInfoVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setApplInfos(data);
					}
				}else if(obj instanceof TemplateVO){
					if(i==data.size()-1){
						resultVO.setTemplateInfos(data);
					}
				}else if(obj instanceof SoftwareVO){
					if(i==data.size()-1){
						resultVO.setSwInfos(data);
					}
				}else if(obj instanceof TemplateSwVO){
					if(i==data.size()-1){
						resultVO.setSwTemplateInfos(data);
					}
				}else if(obj instanceof SpecInfoVO){
					if(i==data.size()-1){
						resultVO.setSpecInfos(data);
					}
				}else if(obj instanceof CfServcNsVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setServcNsInfos(data);
					}
				}else if(obj instanceof CfServcVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setServcInfos(data);
					}
				}else if(obj instanceof CfBldConfVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setBldConfInfos(data);
					}
				}else if(obj instanceof CfDistrbConfVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setDistrbConfInfos(data);
					}
				}else if(obj instanceof CfServcSclngVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setSclngThresConfInfos(data);
					}
				}else if(obj instanceof  CfImgVO){
					resultVO.setGatherDate(gatherDate);
					if(i==data.size()-1){
						resultVO.setBaseImgInfos(data);
					}
				}




			}
		}

		return new ResponseEntity<ResultVO>(resultVO, HttpStatus.OK);
	}


	/**
	 * API 서비스 결과 코드에 따른 메세지
	 * @param resultCode
	 * @return
	 */
	public static String Message(String resultCode)
	{

		/*
		IFM0000	성공하였습니다	처리가 성공했을시 발생
		IFM0001	시스템 오류	서비스 수행 중 시스템 장애 발생
		IFM0002	서비스 타임아웃	서비스 요청 후 응답이 없는 경우 발생
		IFM0003	등록에 성공하였습니다	등록에 성공하였을 때 발생
		IFM0004	수정(update)에 성공하였습니다.	수정에 성공하였을 때 발생
		IFM1001	유효하지 않은 API 서비스	서비스 중지된 API 서비스 또는 존재하지 않는 서비스를 호출시 발생
		IFM1002	유효하지 않은 인증키	인증키 값이 잘 못 기재되었거나, 사용중지 또는 권한이 없는 경우 발생
		IFM1003	사용자 인증 실패	계정이 없는 사용자의 인증 실패시 발생
		IFM1004	서비스 권한 오류	서비스에 대한 호출 권한이 없는 경우 발생
		IFM1005	데이터 장합성 오류	요청 데이터 파싱시 오류 발생
		IFM1006	필수 파라미터 누락 :	조회 시 필수 파라미터 누락시 발생
		IFM1007	조회 된 정보 없음	조회된 정보가 없을 경우 발생
		IFM1013	수정(update) 필수 파라미터 누락 :	수정에 필요한 필수 파라미터를 누락했을 때 발생
		IFM1014	수정(update) 할 데이터가 없습니다.	수정할 데이터가 없을 경우 발생
		IFM1015	조회기관 권한 오류	서비스를 조회 할 수 있는 기관의 권한이 없을 경우 발생
		IFM1016	유효하지 않은 IP주소	유효하지 않는 IP 주소 일 경우 발생
		IFM9999	기타 오류	정의되지 않은 기타 오류 발생
		*/

		String msg = "";
		if(     "IFM0000".equals(resultCode)) msg = "성공하였습니다";                    //처리가 성공했을시 발생
		else if("IFM0001".equals(resultCode)) msg = "시스템 오류";                       //서비스 수행 중 시스템 장애 발생
		else if("IFM0002".equals(resultCode)) msg = "서비스 타임아웃";                   //서비스 요청 후 응답이 없는 경우 발생
		else if("IFM0003".equals(resultCode)) msg = "등록에 성공하였습니다";             //등록에 성공하였을 때 발생
		else if("IFM0004".equals(resultCode)) msg = "수정(update)에 성공하였습니다";     //수정에 성공하였을 때 발생
		else if("IFM1001".equals(resultCode)) msg = "유효하지 않은 API 서비스";          //서비스 중지된 API 서비스 또는 존재하지 않는 서비스를 호출시 발생
		else if("IFM1002".equals(resultCode)) msg = "유효하지 않은 인증키";              //인증키 값이 잘 못 기재되었거나, 사용중지 또는 권한이 없는 경우 발생
		else if("IFM1003".equals(resultCode)) msg = "사용자 인증 실패";                  //계정이 없는 사용자의 인증 실패시 발생
		else if("IFM1004".equals(resultCode)) msg = "서비스 권한 오류";                  //서비스에 대한 호출 권한이 없는 경우 발생
		else if("IFM1005".equals(resultCode)) msg = "데이터 장합성 오류";                //요청 데이터 파싱시 오류 발생
		else if("IFM1006".equals(resultCode)) msg = "필수 파라미터 누락";                //조회 시 필수 파라미터 누락시 발생
		else if("IFM1007".equals(resultCode)) msg = "조회 된 정보 없음";                 //조회된 정보가 없을 경우 발생
		else if("IFM1013".equals(resultCode)) msg = "수정(update) 필수 파라미터 누락";   //수정에 필요한 필수 파라미터를 누락했을 때 발생
		else if("IFM1014".equals(resultCode)) msg = "수정(update) 할 데이터가 없습니다"; //수정할 데이터가 없을 경우 발생
		else if("IFM1015".equals(resultCode)) msg = "조회기관 권한 오류";                //서비스를 조회 할 수 있는 기관의 권한이 없을 경우 발생
		else if("IFM1016".equals(resultCode)) msg = "유효하지 않은 IP주소";              //유효하지 않는 IP 주소 일 경우 발생
		else if("IFM9999".equals(resultCode)) msg = "기타 오류";                         //정의되지 않은 기타 오류 발생
		else msg = "정의되지 않은 오류코드입니다";

		return msg;

	}


}
