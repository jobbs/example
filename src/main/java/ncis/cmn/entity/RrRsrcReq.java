package ncis.cmn.entity;

import javax.validation.constraints.Size;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.validation.InsertReqValidation;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 자원요청 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RrRsrcReq {

    /**
     * 자원요청번호
     */
    private String rsrcReqNo;

    /**
     * 자원요청자ID
     */
    private String rsrcReqUserId;

    /**
     * 자원요청일시
     */
    private String rsrcReqDttm;

    /**
     * 자원요청진행상태코드
     */
    private String rsrcReqPrcssStatCd;

    /**
     * 요청기관ID
     */
    private String reqInstitutionId;

    /**
     * 제목
     */
    @NotEmpty(message = "제목을 입력해주세요.", groups = { InsertReqValidation.class })
    @Size(message = "제목은 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.SBJCT_MAX_LENGTH, groups = { InsertReqValidation.class })
    private String sbjct;

    /**
     * 티켓번호
     */
    @NotEmpty(message = "티켓번호를 입력해주세요.", groups = { InsertReqValidation.class })
    @Size(message = "티켓번호는 {max}자 이내로 입력해주세요.", min = 0, max = ComConstant.TICKT_NO_MAX_LENGTH, groups = { InsertReqValidation.class })
    private String ticktNo;

    /**
     * 센터ID
     */
    @NotEmpty(message = "센터를 선택해주세요.", groups = { InsertReqValidation.class })
    private String regionId;

    /**
     * 테스트여부
     */
    @NotEmpty(message = "테스트여부를 선택해주세요.", groups = { InsertReqValidation.class })
    private String testYn;

    /**
     * 연계여부
     */
    private String linkYn;

    /**
     * 완료일시
     */
    private String comptDttm;

    /**
     * HA 여부
     */
    private String haCompYn;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일자
     */
    private String regDttm;

    /**
     * 자원요청유형코드
     */
    private String rsrcReqTyCd;

    /**
     * 표시여부
     */
    private String displayYn;


    /**
     * 실행자 ID
     */
    private String exeUserId;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * 삭제자 ID
     */
    private String delUserId;
    
    
    /**
     * 자원요청구분코드
     */
    private String rsrcReqClCd;
    
    /**
     * 요청자 ID
     */
    private String reqUserId;
    
    /**
     * 요청내용
     */
    private String reqCn;
    
    /**
     * 저장첨부파일명
     */
    private String savAtchFileNm;
    
    /**
     * 원본첨부파일명
     */
    private String oriAtchFileNm;
    
    /**
     * 첨부파일경로
     */
    private String atchFilePath;
    
    /**
     * 첨부파일크기
     */
    private Integer atchFileSize;


    public String getRsrcReqNo() {
        return rsrcReqNo;
    }

    public void setRsrcReqNo(String rsrcReqNo) {
        this.rsrcReqNo = rsrcReqNo;
    }

    public String getRsrcReqUserId() {
        return rsrcReqUserId;
    }

    public void setRsrcReqUserId(String rsrcReqUserId) {
        this.rsrcReqUserId = rsrcReqUserId;
    }

    public String getRsrcReqDttm() {
        return rsrcReqDttm;
    }

    public void setRsrcReqDttm(String rsrcReqDttm) {
        this.rsrcReqDttm = rsrcReqDttm;
    }

    public String getRsrcReqPrcssStatCd() {
        return rsrcReqPrcssStatCd;
    }

    public void setRsrcReqPrcssStatCd(String rsrcReqPrcssStatCd) {
        this.rsrcReqPrcssStatCd = rsrcReqPrcssStatCd;
    }

    public String getSbjct() {
        return sbjct;
    }

    public void setSbjct(String sbjct) {
        this.sbjct = sbjct;
    }

    public String getTicktNo() {
        return ticktNo;
    }

    public void setTicktNo(String ticktNo) {
        this.ticktNo = ticktNo;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTestYn() {
        return testYn;
    }

    public void setTestYn(String testYn) {
        this.testYn = testYn;
    }

    public String getLinkYn() {
        return linkYn;
    }

    public void setLinkYn(String linkYn) {
        this.linkYn = linkYn;
    }

    public String getComptDttm() {
        return comptDttm;
    }

    public void setComptDttm(String comptDttm) {
        this.comptDttm = comptDttm;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getRsrcReqTyCd() {
        return rsrcReqTyCd;
    }

    public void setRsrcReqTyCd(String rsrcReqTyCd) {
        this.rsrcReqTyCd = rsrcReqTyCd;
    }

    public String getExeUserId() {
        return exeUserId;
    }

    public void setExeUserId(String exeUserId) {
        this.exeUserId = exeUserId;
    }

    public String getReqInstitutionId() {
        return reqInstitutionId;
    }

    public void setReqInstitutionId(String reqInstitutionId) {
        this.reqInstitutionId = reqInstitutionId;
    }


	public String getDisplayYn() {
		return displayYn;
	}

	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
	}

	/**
	 * @return the haCompYn
	 */
	public String getHaCompYn() {
		return haCompYn;
	}

	/**
	 * @param haCompYn the haCompYn to set
	 */
	public void setHaCompYn(String haCompYn) {
		this.haCompYn = haCompYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}

	public String getRsrcReqClCd() {
		return rsrcReqClCd;
	}

	public void setRsrcReqClCd(String rsrcReqClCd) {
		this.rsrcReqClCd = rsrcReqClCd;
	}

	public String getReqUserId() {
		return reqUserId;
	}

	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}

	public String getReqCn() {
		return reqCn;
	}

	public void setReqCn(String reqCn) {
		this.reqCn = reqCn;
	}

	public String getSavAtchFileNm() {
		return savAtchFileNm;
	}

	public void setSavAtchFileNm(String savAtchFileNm) {
		this.savAtchFileNm = savAtchFileNm;
	}

	public String getOriAtchFileNm() {
		return oriAtchFileNm;
	}

	public void setOriAtchFileNm(String oriAtchFileNm) {
		this.oriAtchFileNm = oriAtchFileNm;
	}

	public String getAtchFilePath() {
		return atchFilePath;
	}

	public void setAtchFilePath(String atchFilePath) {
		this.atchFilePath = atchFilePath;
	}

	public Integer getAtchFileSize() {
		return atchFileSize;
	}

	public void setAtchFileSize(Integer atchFileSize) {
		this.atchFileSize = atchFileSize;
	}
	

}
