package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 첨부파일 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class OaAtchFile {

	 /**
     * 첨부파일SEQ
     */
    @NotEmpty(message = "첨부파일SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal atchFileSeq;

    /**
     * 첨부파일명
     */
    @NotEmpty(message = "첨부파일명는(은) 필수입력 항목입니다.")
    private String atchFileNm;

    /**
     * 첨부파일유형코드
     */
    private String atchFileTyCd;

    /**
     * 경로
     */
    private String path;

    /**
     * 파일크기
     */
    private BigDecimal fileSize;

    /**
     * 첨부파일내용
     */
    private String atchFileCn;

    /**
     * 배포SEQ
     */
    @NotEmpty(message = "배포	SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal distrbSeq;



    public String getAtchFileNm() {
        return atchFileNm;
    }

    public void setAtchFileNm(String atchFileNm) {
        this.atchFileNm = atchFileNm;
    }

    public String getAtchFileTyCd() {
        return atchFileTyCd;
    }

    public void setAtchFileTyCd(String atchFileTyCd) {
        this.atchFileTyCd = atchFileTyCd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getAtchFileCn() {
        return atchFileCn;
    }

    public void setAtchFileCn(String atchFileCn) {
        this.atchFileCn = atchFileCn;
    }

	public BigDecimal getAtchFileSeq() {
		return atchFileSeq;
	}

	public void setAtchFileSeq(BigDecimal atchFileSeq) {
		this.atchFileSeq = atchFileSeq;
	}

	public BigDecimal getDistrbSeq() {
		return distrbSeq;
	}

	public void setDistrbSeq(BigDecimal distrbSeq) {
		this.distrbSeq = distrbSeq;
	}

}
