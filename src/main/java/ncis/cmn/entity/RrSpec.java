package ncis.cmn.entity;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 스펙 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrSpec {

    /**
     * 스펙ID
     */
    @NotEmpty(message = "스펙SEQ는(은) 필수입력 항목입니다.")
    private Integer specSeq;

    /**
     * 스펙명
     */
    @NotEmpty(message = "스펙명는(은) 필수입력 항목입니다.")
    private String specNm;

    /**
     * 생성일자
     */
    @NotEmpty(message = "생성일자는(은) 필수입력 항목입니다.")
    private Date creDt;

    /**
     * CPU(vCore)
     */
    private Integer cpuVcore;

    /**
     * 엔타이틀먼트
     */
    private BigDecimal ent;

    /**
     * 메모리(MB)
     */
    private Integer mem;

    /**
     * 생성자ID
     */
    private String creUserId;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일자
     */
    private Date updtDt;

    /**
     * 설명
     */
    private String dc;

    /**
     * 스펙구분코드
     */
    @NotEmpty(message = "스펙구분코드는(은) 필수입력 항목입니다.")
    private String specClCd;

    /**
     * 스토리지(기본값)
     */
    private Integer strgDfltVl;

    /**
     * uncapped weight
     */
    private String uncappWeight;

    /**
     * 엔타이틀먼트_최대값
     */
    private BigDecimal entMaxVl;

    /**
     * 엔타이틀먼트_기본값
     */
    private BigDecimal entDfltVl;

    /**
     * 엔타이틀먼트_최소값
     */
    private BigDecimal entMinVl;

    /**
     * 메모리_최대값
     */
    private Integer memMaxVl;

    /**
     * 메모리_최소값
     */
    private Integer memMinVl;

    /**
     * 메모리_기본값
     */
    private Integer memDfltVl;

    /**
     * vCore_최대값
     */
    private Integer vcoreMaxVl;

    /**
     * vCore_최소값
     */
    private Integer vcoreMinVl;

    /**
     * vCore_기본값
     */
    private Integer vcoreDfltVl;
    
    /**
     * 구분코드
     */
    private String clCd;
    
    
    /**
     * 최대 POD 수 
     */
    private Integer maxPodQty;
    


	/**
	 * @return the specSeq
	 */
	public Integer getSpecSeq() {
		return specSeq;
	}

	/**
	 * @param specSeq the specSeq to set
	 */
	public void setSpecSeq(Integer specSeq) {
		this.specSeq = specSeq;
	}

	/**
	 * @return the specNm
	 */
	public String getSpecNm() {
		return specNm;
	}

	/**
	 * @param specNm the specNm to set
	 */
	public void setSpecNm(String specNm) {
		this.specNm = specNm;
	}

	/**
	 * @return the creDt
	 */
	public Date getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(Date creDt) {
		this.creDt = creDt;
	}

	/**
	 * @return the cpuVcore
	 */
	public Integer getCpuVcore() {
		return cpuVcore;
	}

	/**
	 * @param cpuVcore the cpuVcore to set
	 */
	public void setCpuVcore(Integer cpuVcore) {
		this.cpuVcore = cpuVcore;
	}

	/**
	 * @return the ent
	 */
	public BigDecimal getEnt() {
		return ent;
	}

	/**
	 * @param ent the ent to set
	 */
	public void setEnt(BigDecimal ent) {
		this.ent = ent;
	}

	/**
	 * @return the mem
	 */
	public Integer getMem() {
		return mem;
	}

	/**
	 * @param mem the mem to set
	 */
	public void setMem(Integer mem) {
		this.mem = mem;
	}

	/**
	 * @return the creUserId
	 */
	public String getCreUserId() {
		return creUserId;
	}

	/**
	 * @param creUserId the creUserId to set
	 */
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}

	/**
	 * @return the updtUserId
	 */
	public String getUpdtUserId() {
		return updtUserId;
	}

	/**
	 * @param updtUserId the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}

	/**
	 * @return the updtDt
	 */
	public Date getUpdtDt() {
		return updtDt;
	}

	/**
	 * @param updtDt the updtDt to set
	 */
	public void setUpdtDt(Date updtDt) {
		this.updtDt = updtDt;
	}

	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

	/**
	 * @return the specClCd
	 */
	public String getSpecClCd() {
		return specClCd;
	}

	/**
	 * @param specClCd the specClCd to set
	 */
	public void setSpecClCd(String specClCd) {
		this.specClCd = specClCd;
	}

	/**
	 * @return the strgDfltVl
	 */
	public Integer getStrgDfltVl() {
		return strgDfltVl;
	}

	/**
	 * @param strgDfltVl the strgDfltVl to set
	 */
	public void setStrgDfltVl(Integer strgDfltVl) {
		this.strgDfltVl = strgDfltVl;
	}

	/**
	 * @return the uncappWeight
	 */
	public String getUncappWeight() {
		return uncappWeight;
	}

	/**
	 * @param uncappWeight the uncappWeight to set
	 */
	public void setUncappWeight(String uncappWeight) {
		this.uncappWeight = uncappWeight;
	}

	/**
	 * @return the entMaxVl
	 */
	public BigDecimal getEntMaxVl() {
		return entMaxVl;
	}

	/**
	 * @param entMaxVl the entMaxVl to set
	 */
	public void setEntMaxVl(BigDecimal entMaxVl) {
		this.entMaxVl = entMaxVl;
	}

	/**
	 * @return the entDfltVl
	 */
	public BigDecimal getEntDfltVl() {
		return entDfltVl;
	}

	/**
	 * @param entDfltVl the entDfltVl to set
	 */
	public void setEntDfltVl(BigDecimal entDfltVl) {
		this.entDfltVl = entDfltVl;
	}

	/**
	 * @return the entMinVl
	 */
	public BigDecimal getEntMinVl() {
		return entMinVl;
	}

	/**
	 * @param entMinVl the entMinVl to set
	 */
	public void setEntMinVl(BigDecimal entMinVl) {
		this.entMinVl = entMinVl;
	}

	/**
	 * @return the memMaxVl
	 */
	public Integer getMemMaxVl() {
		return memMaxVl;
	}

	/**
	 * @param memMaxVl the memMaxVl to set
	 */
	public void setMemMaxVl(Integer memMaxVl) {
		this.memMaxVl = memMaxVl;
	}

	/**
	 * @return the memMinVl
	 */
	public Integer getMemMinVl() {
		return memMinVl;
	}

	/**
	 * @param memMinVl the memMinVl to set
	 */
	public void setMemMinVl(Integer memMinVl) {
		this.memMinVl = memMinVl;
	}

	/**
	 * @return the memDfltVl
	 */
	public Integer getMemDfltVl() {
		return memDfltVl;
	}

	/**
	 * @param memDfltVl the memDfltVl to set
	 */
	public void setMemDfltVl(Integer memDfltVl) {
		this.memDfltVl = memDfltVl;
	}

	/**
	 * @return the vcoreMaxVl
	 */
	public Integer getVcoreMaxVl() {
		return vcoreMaxVl;
	}

	/**
	 * @param vcoreMaxVl the vcoreMaxVl to set
	 */
	public void setVcoreMaxVl(Integer vcoreMaxVl) {
		this.vcoreMaxVl = vcoreMaxVl;
	}

	/**
	 * @return the vcoreMinVl
	 */
	public Integer getVcoreMinVl() {
		return vcoreMinVl;
	}

	/**
	 * @param vcoreMinVl the vcoreMinVl to set
	 */
	public void setVcoreMinVl(Integer vcoreMinVl) {
		this.vcoreMinVl = vcoreMinVl;
	}

	/**
	 * @return the vcoreDfltVl
	 */
	public Integer getVcoreDfltVl() {
		return vcoreDfltVl;
	}

	/**
	 * @param vcoreDfltVl the vcoreDfltVl to set
	 */
	public void setVcoreDfltVl(Integer vcoreDfltVl) {
		this.vcoreDfltVl = vcoreDfltVl;
	}

	/**
	 * @return the clCd
	 */
	public String getClCd() {
		return clCd;
	}

	/**
	 * @param clCd the clCd to set
	 */
	public void setClCd(String clCd) {
		this.clCd = clCd;
	}

	/**
	 * @return the maxPodQty
	 */
	public Integer getMaxPodQty() {
		return maxPodQty;
	}

	/**
	 * @param maxPodQty the maxPodQty to set
	 */
	public void setMaxPodQty(Integer maxPodQty) {
		this.maxPodQty = maxPodQty;
	}
	
}
