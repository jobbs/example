package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ncis.cmn.validation.constrains.NullPattern;
import ncis.cmn.validation.groups.InsertProc;

import org.hibernate.validator.constraints.NotEmpty;

public class CmMenu {

    /**
     * 메뉴ID
     */
    private Long menuSeq;

    /**
     * 부모ID
     */
    private Long parentSeq;

    /**
     * 메뉴명
     */
    @NotEmpty(message="메뉴명은 필수 항목입니다.")
    @Size(max = 100, message="메뉴명은 100byte 이하로 입력하여 주시기 바랍니다.")
    private String menuNm;

    /**
     * 메뉴패턴
     */
    @NotEmpty(message="메뉴 패턴을 입력하여 주시기 바랍니다." )
    @Pattern(regexp="^[/](\\w|/)*[/]$", message="메뉴 패턴은 반드시 '/'로 시작을 하여 '/'로 끝나도록 하여 주시기 바랍니다.")
    private String menuPattern;

    /**
     * 시작파일명
     */
    @NullPattern(regexp=".*\\w([.]do)$", message="실행파일은 .do로 끝나도록 입력하시기 바랍니다.")
    private String menuFile;

    /**
     * 메뉴설명
     */
    private String menuDesc;

    /**
     * 메뉴레밸
     */
    private Integer menuLevel;

    /**
     * 팝업창여부
     */
    @NotEmpty(groups = { InsertProc.class })
    private String popupYn;

    /**
     * 사용여부
     */
    @NotEmpty(groups = { InsertProc.class })
    private String useYn;

    /**
     * 메뉴순번
     */
    private Integer menuOrder;

    /**
     * 등록일시
     */
    private Date regDttm;

    /**
     * 등록자아이디
     */
    private String regUserId;

    /**
     * 수정일시
     */
    private Date updtDttm;

    /**
     * 수정자아이디
     */
    private String updtUserId;

    /**
     * @return the menuSeq
     */
    public Long getMenuSeq() {
        return menuSeq;
    }

    /**
     * @param menuSeq the menuSeq to set
     */
    public void setMenuSeq(Long menuSeq) {
        this.menuSeq = menuSeq;
    }

    /**
     * @return the parentSeq
     */
    public Long getParentSeq() {
        return parentSeq;
    }

    /**
     * @param parentSeq the parentSeq to set
     */
    public void setParentSeq(Long parentSeq) {
        this.parentSeq = parentSeq;
    }

    /**
     * @return the menuNm
     */
    public String getMenuNm() {
        return menuNm;
    }

    /**
     * @param menuNm the menuNm to set
     */
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    /**
     * @return the menuPattern
     */
    public String getMenuPattern() {
        return menuPattern;
    }

    /**
     * @param menuPattern the menuPattern to set
     */
    public void setMenuPattern(String menuPattern) {
        this.menuPattern = menuPattern;
    }

    /**
     * @return the menuFile
     */
    public String getMenuFile() {
        return menuFile;
    }

    /**
     * @param menuFile the menuFile to set
     */
    public void setMenuFile(String menuFile) {
        this.menuFile = menuFile;
    }

    /**
     * @return the menuDesc
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * @param menuDesc the menuDesc to set
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * @return the menuLevel
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * @param menuLevel the menuLevel to set
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * @return the popupYn
     */
    public String getPopupYn() {
        return popupYn;
    }

    /**
     * @param popupYn the popupYn to set
     */
    public void setPopupYn(String popupYn) {
        this.popupYn = popupYn;
    }

    /**
     * @return the useYn
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * @param useYn the useYn to set
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * @return the menuOrder
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * @param menuOrder the menuOrder to set
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * @return the regDttm
     */
    public Date getRegDttm() {
        return regDttm;
    }

    /**
     * @param regDttm the regDttm to set
     */
    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    /**
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * @param regUserId the regUserId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /**
     * @return the updtDttm
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }

    /**
     * @param updtDttm the updtDttm to set
     */
    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
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

}
