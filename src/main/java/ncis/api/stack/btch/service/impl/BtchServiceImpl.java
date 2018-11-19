/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchServiceImpl.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * ----------------------------------------------------------------
 * 		Date         author         ver            Description
 * ----------------------------------------------------------------
 * 2016. 10. 28.      정승용         	v1.0                     최초생성
 * 2016. 12. 19.      정승용         	v1.0            배치 정보 삭제주기 추가개발
 *
 */
package ncis.api.stack.btch.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ncis.api.stack.btch.service.BtchService;
import ncis.api.stack.btch.vo.BtchVo;
import ncis.cmn.couch.CouchDBRestTemplate;
import ncis.cmn.entity.couch.DocumentResponseVo;
import ncis.cmn.entity.couch.QueryParamVo;
import ncis.cmn.entity.couch.ViewResponseRowVo;
import ncis.cmn.entity.couch.ViewResponseVo;
import ncis.cmn.util.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

/**
 * @author 정승용
 *
 */
@Service("btchService")
public class BtchServiceImpl implements BtchService {

	private final ParameterizedTypeReference<DocumentResponseVo> TYPE_DOCUMENT = new ParameterizedTypeReference<DocumentResponseVo>() {};
	private final ParameterizedTypeReference<ViewResponseVo<BtchVo>> TYPE_VIEW_MANAGER = new ParameterizedTypeReference<ViewResponseVo<BtchVo>>() {};

	@SuppressWarnings("unused")
	private final ParameterizedTypeReference<List<DocumentResponseVo>> TYPE_BULK_RESULT = new ParameterizedTypeReference<List<DocumentResponseVo>>() {};

	@Autowired
	private CouchDBRestTemplate template;

	/**
	 * 배치관리 수집주기 조회
	 * @param BtchVo 배치관리 내용
	 */
	@Override
	public List<BtchVo> selectBtch() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, IOException {
		List<BtchVo> resultList = new ArrayList<BtchVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.batchSchedule.url");
		String url = dbUrl+"/_design/all/_view/batchSchedule";

		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);

		// 목록 조회 요청
		ViewResponseVo<BtchVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);

		// 전체목록 수
		int totCnt = response.getRows().size();

		// 조회 결과
		List<BtchVo> result = new ArrayList<>();

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<BtchVo> row : response.getRows()) {
				result.add(row.getDoc());
			}

			for (int i = 0; i < totCnt; i++) {
				BtchVo btchVo = new BtchVo();
				btchVo.set_id(result.get(i).get_id());
				btchVo.set_rev(result.get(i).get_rev());
				btchVo.setSeq(result.get(i).getSeq());
				btchVo.setBatchName(result.get(i).getBatchName());
				btchVo.setCronExpression(result.get(i).getCronExpression());
				String[] cronPart = result.get(i).getCronExpression().split(" ");

				String month = cronPart[4];
				String day = cronPart[3];
				String hour = cronPart[2];
				String minute = cronPart[1];

				// 조건에 따라 입력값 설정
				if(month.contains("/")){
					month = month.substring(month.indexOf("/")+1);
					day="*";
					hour="*";
					minute="*";
				}else if(day.contains("/")){
					day = day.substring(day.indexOf("/")+1);
					hour="*";
					minute="*";
				}else if(hour.contains("/")){
					hour = hour.substring(hour.indexOf("/")+1);
					minute="*";
				}else if(minute.contains("/")){
					minute = minute.substring(minute.indexOf("/")+1);
				}

				btchVo.setExeTimeMonth(month);
				btchVo.setExeTimeDay(day);
				btchVo.setExeTimeHour(hour);
				btchVo.setExeTimeMinute(minute);

				resultList.add(btchVo);
			}
		}

		return resultList;
	}

	/**
	 * 배치정보 삭제주기 조회
	 * @param BtchVo 배치삭제주기 내용
	 */
	@Override
	public List<BtchVo> selectBtchInfoDel() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, IOException {
		List<BtchVo> resultList = new ArrayList<BtchVo>();

		String dbUrl = PropertiesUtil.getProperty("gateway.batchSchedule.url");
		String url = dbUrl+"/_design/all/_view/delInfoSchedule";

		QueryParamVo queryParam = new QueryParamVo();
		queryParam.setInclude_docs(true);

		// 목록 조회 요청
		ViewResponseVo<BtchVo> response = template.get(url, queryParam, TYPE_VIEW_MANAGER);

		// 전체목록 수
		int totCnt = response.getRows().size();

		// 조회 결과
		List<BtchVo> result = new ArrayList<>();

		// 조회된 문서를 List로 담는다.
		if (response.getRows() != null && response.getRows().size() > 0) {
			for (ViewResponseRowVo<BtchVo> row : response.getRows()) {
				result.add(row.getDoc());
			}

			for (int i = 0; i < totCnt; i++) {
				BtchVo btchVo = new BtchVo();
				btchVo.set_id(result.get(i).get_id());
				btchVo.set_rev(result.get(i).get_rev());
				btchVo.setDelSeq(result.get(i).getDelSeq());
				//System.out.println("[==========DelSeq==========] : " + btchVo.getDelSeq());
				btchVo.setBatchName(result.get(i).getBatchName());
				btchVo.setCronExpression(result.get(i).getCronExpression());
				String[] cronPart = result.get(i).getCronExpression().split(" ");

				String month = cronPart[4];
				String day = cronPart[3];
				String hour = cronPart[2];
				String minute = cronPart[1];

				// 조건에 따라 입력값 설정
				if(month.contains("/")){
					month = month.substring(month.indexOf("/")+1);
					day="*";
					hour="*";
					minute="*";
				}else if(day.contains("/")){
					day = day.substring(day.indexOf("/")+1);
					hour="*";
					minute="*";
				}else if(hour.contains("/")){
					hour = hour.substring(hour.indexOf("/")+1);
					minute="*";
				}else if(minute.contains("/")){
					minute = minute.substring(minute.indexOf("/")+1);
				}

				btchVo.setExeTimeMonth(month);
				btchVo.setExeTimeDay(day);
				btchVo.setExeTimeHour(hour);
				btchVo.setExeTimeMinute(minute);

				resultList.add(btchVo);
			}
		}

		return resultList;
	}

	/**
	 * 배치관리 내용 수정
	 *  @param BtchVo 배치관리 내용
	 */
	@Override
	public void updateBtch(BtchVo btchVo) throws Exception {
		String cronEprss = "";
		String dbUrl = PropertiesUtil.getProperty("gateway.batchSchedule.url"), url = "";

		Map<String, Object> document = new HashMap<String, Object>();
		System.out.println("[==========BatchId==========] : " + btchVo.getBatchId());

		for (int i = 0; i < btchVo.getBatchId().length; i++) {
			url = dbUrl + "/" + btchVo.getBatchId()[i];

			String month = btchVo.getTimeMonth()[i];
			String day = btchVo.getTimeDay()[i];
			String hour = btchVo.getTimeHour()[i];
			String minute = btchVo.getTimeMinute()[i];

			// 조건에 따라 입력값 설정
			if (!month.equals("*")) {
				month = "*/" + month;
				day = "1";
				hour = "0";
				minute = "0";
			} else if (!day.equals("*")) {
				day = "*/" + day;
				hour = "0";
				minute = "0";
			} else if (!hour.equals("*")) {
				hour = "*/" + hour;
				minute = "0";
			} else if (!minute.equals("*")) {
				minute = "*/" + minute;
			}

			cronEprss = "0 " + minute + " " + hour + " " + day + " " + month + " ?";

			document.put("_rev", btchVo.getRev()[i].toString());
			document.put("seq", btchVo.getSeqArr()[i]);
			document.put("batchName", btchVo.getBatchId()[i]);
			document.put("cronExpression", cronEprss);

			template.put(url, null, document, TYPE_DOCUMENT); // 수정 요청
		}
	}

	/**
	 * 배치정보 삭제주기 수정
	 *  @param BtchVo 배치정보 삭제주기 내용
	 */
	@Override
	public void updateBtchInfoDel(BtchVo btchVo) throws Exception {
		String cronEprss = "";
		String dbUrl = PropertiesUtil.getProperty("gateway.batchSchedule.url"), url = "";

		Map<String, Object> document = new HashMap<String, Object>();

		for (int i = 0; i < btchVo.getBatchId().length; i++) {
			url = dbUrl + "/" + btchVo.getBatchId()[i];

			String month = btchVo.getDelTimeMonth()[i];
			String day = btchVo.getDelTimeDay()[i];
			String hour = btchVo.getDelTimeHour()[i];
			String minute = btchVo.getDelTimeMinute()[i];

			// 조건에 따라 입력값 설정
			if (!month.equals("*")) {
				month = "*/" + month;
				day = "1";
				hour = "0";
				minute = "0";
			} else if (!day.equals("*")) {
				day = "*/" + day;
				hour = "0";
				minute = "0";
			} else if (!hour.equals("*")) {
				hour = "*/" + hour;
				minute = "0";
			} else if (!minute.equals("*")) {
				minute = "*/" + minute;
			}

			cronEprss = "0 " + minute + " " + hour + " " + day + " " + month + " ?";

			document.put("_rev", btchVo.getRev()[i].toString());
			document.put("delSeq", btchVo.getSeqArr()[i]);
			document.put("batchName", btchVo.getBatchId()[i]);
			document.put("cronExpression", cronEprss);

			template.put(url, null, document, TYPE_DOCUMENT); // 수정 요청
		}
	}
}
