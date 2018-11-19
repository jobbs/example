/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecServiceImpl.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRrSpecDao;
import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.opr.catalg.dao.SpecDao;
import ncis.cpt.opr.catalg.service.SpecService;
import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;
import ncis.intfc.ntops.vo.ProcessConstant;

import org.springframework.stereotype.Service;
/**
 * @author 송승규
 *
 */
@Service("specService")
public class SpecServiceImpl implements SpecService {

	@Resource(name="specDao") private SpecDao specDao;
	@Resource(name="cRrSpecDao") private CRrSpecDao cSpecDao;

	/**
	 * 스펙 목록조회
	 * @param svo
	 * @return SpecSvo
	 */
	@Override
	public List<SpecVo> selectSpecList(SpecSvo svo) {

		List<SpecVo> resultList = null;

		int totCnt = specDao.selectSpecTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);	// 페이지 처리위한 count
			resultList = specDao.selectSpecList(svo);
		}
		return resultList;
	}

	/**
	 * 스펙 상세조회
	 * @param svo
	 * @return SpecVo
	 */
	@Override
	public SpecVo selectSpecDetail(SpecVo vo){

		SpecVo resultVo = new SpecVo();
		resultVo = specDao.selectSpecDetail(vo.getSpecSeq());

		return resultVo;
	}
	
	/**
	 * 스펙 중복 체크
	 * @param SpecVo
	 * @param SpecVo
	 * @return int
	 */
	private int checkSpecDuplication(SpecVo vo, SpecVo compVo){
		int cnt=0;
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>clcd"+vo.getSpecClCd());
		if((ProcessConstant.getOsTyCd02()).equals(vo.getSpecClCd())){
			if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0 &&
				vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0 && 
				vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0 &&
				vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0 && 
				vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0 &&
				vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0 &&
				vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>HP<<<<<<<<<<<<<<<<<<<<");
					cnt++;
			}
		} else if ((ProcessConstant.getOsTyCd03()).equals(vo.getSpecClCd())){ 
			if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0 &&
				vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0 &&
				vo.getEntMinVl().compareTo(compVo.getEntMinVl())==0 &&
				vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0 &&
				vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0 &&
				vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0 &&
				vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0 &&
				vo.getMemDfltVl().compareTo(compVo.getMemDfltVl())==0 &&
				vo.getMemMinVl().compareTo(compVo.getMemMinVl())==0 &&
				vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
					if((null==vo.getUncappWeight() && null==compVo.getUncappWeight()) || 
							(null!=vo.getUncappWeight() && null!=compVo.getUncappWeight() && 
							Float.parseFloat(vo.getUncappWeight())==Float.parseFloat(compVo.getUncappWeight()))){
						cnt++;
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>AIX<<<<<<<<<<<<<<<<<<<<");
					}
			}
		}else if((ProcessConstant.getOsTyCd09()).equals(vo.getSpecClCd())){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>SO<<<<<<<<<<<<<<<<<<<<");
			System.out.println(compVo.getVcoreMaxVl());
			System.out.println(compVo.getVcoreDfltVl());
			System.out.println(compVo.getMemMaxVl());
			System.out.println(compVo.getMemDfltVl());
			System.out.println(compVo.getStrgDfltVl());
			System.out.println("---------------------------------------------");
			if(vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0 &&
				vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0 &&
				vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0 &&
				vo.getMemDfltVl().compareTo(compVo.getMemDfltVl())==0 &&
				vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
					cnt++;
			}
		}else{
			if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0 &&
				vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0 &&
				vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
					cnt++;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>OTHER<<<<<<<<<<<<<<<<<<<<");
			}
		}
		return cnt;
	}

	/**
	 * 스펙 저장
	 * @param svo
	 * @return ProcResultVo
	 */
	@Override
	public ProcResultVo updateSpecDetail(SpecVo vo) throws Exception{

		ProcResultVo resultVo = new ProcResultVo();

		if("01".equals(vo.getClCd())) {
			SpecSvo svo = new SpecSvo();
			int updateCnt = 0;

			List<SpecVo> list = specDao.selectSpecList(svo);

			for(int i=0; i<list.size(); i++){
				SpecVo compVo = list.get(i);

				// 동일 스펙 존재여부 확인
				if(!vo.getSpecSeq().equals(compVo.getSpecSeq())){
					if(vo.getSpecClCd().equals(compVo.getSpecClCd())){
						//18.09.11 이제율 수정
						//중첩 if -> && , 매소드화

						updateCnt += checkSpecDuplication(vo, compVo);
						
						/*
						if(("HP-UX").equals(vo.getSpecClCdNm())){  					// HP 인경우
							if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0){
								if(vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0){
									if(vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0){
										if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0){
											if(vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0){
												if(vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0){
													if(vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
														updateCnt++;
													}
												}
											}
										}
									}
								}
							}
						}else if(("AIX").equals(vo.getSpecClCdNm())){ // AIX 인 경우
							if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0){
								if(vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0){
									if(vo.getEntMinVl().compareTo(compVo.getEntMinVl())==0){
										if(vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0){
											if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0){
												if(vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0){
													if((null==vo.getUncappWeight() && null==compVo.getUncappWeight()) || (null!=vo.getUncappWeight() && null!=compVo.getUncappWeight() && Float.parseFloat(vo.getUncappWeight())==Float.parseFloat(compVo.getUncappWeight()))){
														if(vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0){
															if(vo.getMemDfltVl().compareTo(compVo.getMemDfltVl())==0){
																if(vo.getMemMinVl().compareTo(compVo.getMemMinVl())==0){
																	if(vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
																		updateCnt++;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
						*/
					}
				}
			}

			if(0 == updateCnt){
				SpecVo result = specDao.selectSpecDetail(vo.getSpecSeq());

				vo.setCreUserId(result.getCreUserId());
				vo.setCreDt(result.getCreDt());
				vo.setSpecClCd(result.getSpecClCd());
				//vo.setUpdtDt(new Date());
				vo.setCpuVcore(vo.getVcoreDfltVl());
				vo.setEnt(vo.getEntDfltVl());
				vo.setMem(vo.getMemMaxVl());

				cSpecDao.updateRrSpec(vo);

				resultVo.setProcType("update");
				resultVo.setSuccess(true);
			}else{
				resultVo.setSuccess(false);
				resultVo.addMessage("동일한 스펙이 존재하여, 해당 스펙을 수정할 수 없습니다.");
			}

		}else {
			cSpecDao.updateRrSpec(vo);
			resultVo.setProcType("update");
			resultVo.setSuccess(true);
		}

		return resultVo;
	}

	/**
	 * 스펙 생성
	 * @param svo
	 * @return ProcResultVo
	 */
	@Override
	public ProcResultVo insertSpec(SpecVo vo) throws Exception{

		ProcResultVo resultVo = new ProcResultVo();

		if("01".equals(vo.getClCd())) {
			SpecSvo svo = new SpecSvo();
			int insertCnt = 0;

			List<SpecVo> list = specDao.selectSpecList(svo);

			for(int i=0; i<list.size(); i++){
				SpecVo compVo = list.get(i);

				// 동일 스펙 존재여부 확인				
				if(vo.getSpecClCd().equals(compVo.getSpecClCd())){
					//18.09.11 이제율 수정
					//중첩 if -> && , 매소드화
					insertCnt += checkSpecDuplication(vo, compVo);	
				
					/*
					if(("HP-UX").equals(vo.getSpecClCdNm())){
						if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0){
							if(vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0){
								if(vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0){
									if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0){
										if(vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0){
											if(vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0){
												if(vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
													insertCnt++;
												}
											}
										}
									}
								}
							}
						}
					}else if(("AIX").equals(vo.getSpecClCdNm())){ // AIX 인경우
						if(vo.getEntMaxVl().compareTo(compVo.getEntMaxVl())==0){
							if(vo.getEntDfltVl().compareTo(compVo.getEntDfltVl())==0){
								if(vo.getEntMinVl().compareTo(compVo.getEntMinVl())==0){
									if(vo.getVcoreMaxVl().compareTo(compVo.getVcoreMaxVl())==0){
										if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0){
											if(vo.getVcoreMinVl().compareTo(compVo.getVcoreMinVl())==0){
												if((null==vo.getUncappWeight() && null==compVo.getUncappWeight()) || (null!=vo.getUncappWeight() && null!=compVo.getUncappWeight() && Float.parseFloat(vo.getUncappWeight())==Float.parseFloat(compVo.getUncappWeight()))){
													if(vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0){
														if(vo.getMemDfltVl().compareTo(compVo.getMemDfltVl())==0){
															if(vo.getMemMinVl().compareTo(compVo.getMemMinVl())==0){
																if(vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
																	insertCnt++;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}else{
						if(vo.getVcoreDfltVl().compareTo(compVo.getVcoreDfltVl())==0){
							if(vo.getMemMaxVl().compareTo(compVo.getMemMaxVl())==0){
								if(vo.getStrgDfltVl().compareTo(compVo.getStrgDfltVl())==0){
									insertCnt++;
								}
							}
						}
					}
					 */
				}
			}
			
			if(0 == insertCnt){
				//vo.setCreDt(new Date());
				// 2016.12.14 수정일자는 수정시에만 입력.
				//vo.setUpdtDt(new Date());
				vo.setCpuVcore(vo.getVcoreDfltVl());
				vo.setEnt(vo.getEntDfltVl());
				vo.setMem(vo.getMemMaxVl());

				cSpecDao.insertRrSpec(vo);

				resultVo.setProcType("insert");
				resultVo.setSuccess(true);
			}else{
				resultVo.setSuccess(false);
				resultVo.addMessage("동일한 스펙이 존재하여, 스팩생성을 할 수 없습니다.");
			}
		}else {
			cSpecDao.insertRrSpec(vo);
			resultVo.setProcType("insert");
			resultVo.setSuccess(true);
		}

		return resultVo;
	}

	/**
	 * 스펙 삭제 (
	 * @param svo
	 * @return
	 */
	@Override
	public void deleteSpec(SpecSvo svo) throws Exception{

		cSpecDao.deleteRrSpec(svo);
	}
}
