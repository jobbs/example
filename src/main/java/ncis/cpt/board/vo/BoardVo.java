/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BoardVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.board.vo;

import java.util.ArrayList;
import java.util.List;

import ncis.cmn.entity.CmBoard;
import ncis.cmn.util.ObjectUtils;

import org.springframework.web.multipart.MultipartFile;

public class BoardVo extends CmBoard {

	/**
	 * 답변 개수
	 */
    private int answerCnt;

    /**
     * 업로드 파일
     */
	private MultipartFile[] uploadFile;

	/**
	 * 게시판 파일 정보
	 */
	private List<BoardFileVo> boardFiles;

	/**
	 * 삭제 파일 정보
	 */
	private List<Long> deleteFile;

	/**
	 * 답변 정보
	 */
	private BoardVo answer;

	public MultipartFile[] getUploadFile() {

	    if( null != this.uploadFile ) {
	        return this.uploadFile.clone();
	    }
	    return null;
	}

	public void setUploadFile(MultipartFile[] uploadFile) {
		this.uploadFile = uploadFile.clone();
	}

	public List<BoardFileVo> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFileVo> boardFiles) {
		this.boardFiles = boardFiles;
	}

	public void addBoardFiles(List<BoardFileVo> uploadFiles) {
		if( ObjectUtils.isEmpty(uploadFiles)){
			return;
		}

		if( this.boardFiles == null){
			this.boardFiles = new ArrayList<BoardFileVo>();
		}
		this.boardFiles.addAll(uploadFiles);
	}

	/**
	 * @return the deleteFile
	 */
	public List<Long> getDeleteFile() {
		return deleteFile;
	}

	/**
	 * @param deleteFile the deleteFile to set
	 */
	public void setDeleteFile(List<Long> deleteFile) {
		this.deleteFile = deleteFile;
	}

	/**
	 * @return the answer
	 */
	public BoardVo getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(BoardVo answer) {
		this.answer = answer;
	}

    /**
     * @return the answerCnt
     */
    public int getAnswerCnt() {
        return answerCnt;
    }

    /**
     * @param answerCnt the answerCnt to set
     */
    public void setAnswerCnt(int answerCnt) {
        this.answerCnt = answerCnt;
    }
}
