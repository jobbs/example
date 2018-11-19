/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.validation.groups.InsertProc;
import ncis.cmn.vo.CommonFileVo;
import ncis.cmn.vo.ProcResultVo;
import ncis.cmn.web.BaseController;
import ncis.cpt.sys.errrpt.service.ErrRptService;
import ncis.cpt.sys.errrpt.vo.ErrRptFileVo;
import ncis.cpt.sys.errrpt.vo.ErrRptProcssVo;
import ncis.cpt.sys.errrpt.vo.ErrRptSearchVo;
import ncis.cpt.sys.errrpt.vo.ErrRptVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 최진호
 *
 */
@Controller
@RequestMapping(value = "/cpt/errrpt")
public class ErrRptController extends BaseController {

    private final String FILE_PATH = "errrpt";

    @Resource(name="errRptService")
    private ErrRptService errRptService;


    /**
     * 게시판 목록 조회
     *
     * @param boardId
     * @param request
     * @param model
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectErrRptList.do")
    public String selectBoardList(HttpServletRequest request, Model model, ErrRptSearchVo searchVo) {

        List<ErrRptVo> list = errRptService.selectErrRptList(searchVo); // 게시글list 가져오기

        model.addAttribute("list", list);
        model.addAttribute("searchVo", searchVo);
        return portalTilesView(request);
    }

    /**
     * 게시판 상세 조회
     *
     * @param boardId
     * @param request
     * @param model
     * @param boardSeq
     * @param searchVo
     * @return
     */
    @RequestMapping(value = "/selectErrRpt.do")
    public String selectBoard(HttpServletRequest request, Model model, @RequestParam("errRptSeq") Long errRptSeq, ErrRptSearchVo searchVo) {

        ErrRptVo vo = errRptService.selectErrRpt(errRptSeq);
        if( ObjectUtils.isEmpty(vo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

        model.addAttribute("vo", vo);
        model.addAttribute("searchVo", searchVo);

        return portalTilesView(request);
    }

    /**
     * 게시판 등록 화면
     *
     * @param boardId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/insertErrRpt.do", method = RequestMethod.GET)
    public String insertBoardView(HttpServletRequest request, Model model) {
        ErrRptVo vo =  new ErrRptVo();
        vo.setProcssStatCd("REG");

        model.addAttribute("vo", vo);
        return portalTilesView(request, "formErrRpt");
    }

    /**
     * 게시판 등록 프로세스
     *
     * @param boardId
     * @param boardVo
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @RequestMapping(value = "/insertErrRpt.do", method = RequestMethod.POST)
    @ResponseBody
    public ProcResultVo insertErrRpt(@ModelAttribute("vo") ErrRptVo errRptVo, BindingResult bindResult) {

        ProcResultVo result = getBindingResult(errRptVo, bindResult, InsertProc.class);

        try {

            if (result.isSuccess()) {
                if (!ObjectUtils.isEmpty(errRptVo.getUploadFile())) {
                    errRptVo.setErrRptFiles(FileManageUtil.uploadFiles(errRptVo.getUploadFile(), FILE_PATH, ErrRptFileVo.class, FileManageUtil.FileType.DEFAULT));
                }

                errRptVo.setRegUsrId(getUserId());
                errRptVo.setUpdtUsrId(getUserId());

                errRptService.insertErrRpt(errRptVo);
                result.setProcType("insert");
            }

        } catch (InstantiationException | IllegalAccessException | IOException e) {
            result.addMessage("게시판 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }


        return result;

    }



    /**
     * 게시판 업데이트 화면
     *
     * @param boardId
     * @param request
     * @param model
     * @param boardSeq
     * @return
     */
    @RequestMapping(value = "/updateErrRpt.do", method = RequestMethod.GET)
    public String updateBoardView(HttpServletRequest request, Model model, @RequestParam("errRptSeq") Long errRptSeq) {

        ErrRptVo vo = errRptService.selectErrRpt(errRptSeq);
        if( ObjectUtils.isEmpty(vo) ) {
            throw new DataNotFoundException(messageUtil.getMessage("message.error.dataNotFound"));
        }

        model.addAttribute("vo", vo);
        return portalTilesView(request, "formErrRpt");
    }


    /**
     *
     * @param boardCd
     * @param boardVo
     * @return
     */
    @RequestMapping(value = "/updateErrRpt.do", method = RequestMethod.POST)
    @ResponseBody
    public ProcResultVo updateBoard(@ModelAttribute("vo") ErrRptVo errRptVo) {

        ProcResultVo result = new ProcResultVo();

        try {
            if (!ObjectUtils.isEmpty(errRptVo.getUploadFile())) {
                errRptVo.setErrRptFiles(FileManageUtil.uploadFiles(errRptVo.getUploadFile(), FILE_PATH, ErrRptFileVo.class, FileManageUtil.FileType.DEFAULT));
            }

            errRptVo.setRegUsrId(getUserId());
            errRptVo.setUpdtUsrId(getUserId());

            errRptService.updateErrRpt(errRptVo);

            result.setProcType("update");
            result.setSuccess(true);

        } catch (InstantiationException | IllegalAccessException | IOException e) {
            result.addMessage("에러보고 저장 시 오류가 발생하였습니다.");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 게시판 삭제
     *
     * @param boardId
     * @param boardVo
     * @return
     */
    @RequestMapping(value = "//deleteErrRpt.do", method = RequestMethod.POST)
    @ResponseBody
    public ProcResultVo deleteErrRpt(@RequestParam("errRptSeq") Long errRptSeq) {
        errRptService.deleteErrRpt(errRptSeq);
        return getSuccessProcResult();
    }

    /**
     *
     * @param request
     * @param response
     * @param seq
     * @throws IOException
     */
    @RequestMapping(value = "/downfile.do")
    public void downFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("seq") Long seq) throws IOException {

        CommonFileVo file = errRptService.selectErrRptFile(seq);
        FileManageUtil.downFile(request, response, file.getDownFileName(), file.getOriginFileName());
    }

    /**
     *
     * @param errRptProcss
     * @param bindResult
     * @return
     */
   @RequestMapping(value = "/insertErrRptProcss.do", method = RequestMethod.POST)
   @ResponseBody
   public ProcResultVo insertErrRptProcss(@Valid ErrRptProcssVo errRptProcss, BindingResult bindResult) {

       ProcResultVo result = getBindingResult(bindResult);

       if( result.isSuccess() ) {
           errRptProcss.setRegUsrId(getUserId());
           errRptProcss.setUpdtUsrId(getUserId());

           errRptService.insertErrRptProcss(errRptProcss);

           result.setProcType("insert");
       }

       return result;
   }

   /**
    *
    * @param request
    * @param model
    * @param errRptSeq
    * @return
    */
   @RequestMapping(value = "/selectErrRptProcss.do", method = RequestMethod.GET)
   @ResponseBody
   public ProcResultVo selectErrRptProcss(@RequestParam("errRptProcssSeq") Long errRptProcssSeq) {

       ProcResultVo result = new ProcResultVo();

       ErrRptProcssVo vo = errRptService.selectErrRptProcss(errRptProcssSeq);
       if( ObjectUtils.isEmpty(vo) ) {
           return getFailProcResult(messageUtil.getMessage("message.error.dataNotFound"));
       }

       result.setData(vo);

       return result;
   }

   /**
   *
   * @param boardCd
   * @param boardVo
   * @return
   */
  @RequestMapping(value = "/updateErrRptProcss.do", method = RequestMethod.POST)
  @ResponseBody
  public ProcResultVo updateErrRptProcss(@Valid ErrRptProcssVo errRptProcss, BindingResult bindResult) {

      ProcResultVo result = getBindingResult(bindResult);

      if( result.isSuccess() ) {

          errRptProcss.setUpdtUsrId(getUserId());
          errRptService.updateErrRptProcss(errRptProcss);

          result.setProcType("update");
      }

      return result;
  }

  @RequestMapping(value = "/deleteErrRptProcss.do", method = RequestMethod.POST)
  @ResponseBody
  public ProcResultVo deleteErrRptProcss( @RequestParam("errRptProcssSeq") Long errRptProcssSeq) {

      errRptService.deleteErrRptProcss(errRptProcssSeq);
      return getSuccessProcResult();
  }
}
