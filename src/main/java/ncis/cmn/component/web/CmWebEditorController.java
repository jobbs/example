/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmWebEditorController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 11. 4.
 * @lastmodified 2016. 11. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.component.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.NotAllowedFileExtException;
import ncis.cmn.util.FileManageUtil;
import ncis.cmn.vo.CommonFileVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author 최진호
 *
 */
@Controller
public class CmWebEditorController {

    private final String FILE_PATH = "editor";

    /**
     *
     * @param request
     * @param response
     * @param filePath
     * @param fileName
     * @param contentType
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "/cmn/component/imageSrc.do")
    public void imageSrc(HttpServletRequest request, HttpServletResponse response ) throws FileNotFoundException {

        String filePath = request.getParameter("filePath");
        String fileName = request.getParameter("fileName");
        String contentType = request.getParameter("contentType");
        FileManageUtil.imageFileView(response, filePath, fileName, contentType);
    }

    /**
     *
     * @param request
     * @param fileData
     * @param callback
     * @param callback_func
     * @return
     */
    @RequestMapping(value = "/resources/seditor/fileUploader.do", method = RequestMethod.POST)
    public String insertEditorImage(
                                    HttpServletRequest request,
                                    @RequestParam CommonsMultipartFile fileData,
                                    @RequestParam String callback,
                                    @RequestParam String callback_func) {

        StringBuffer retUrl = new StringBuffer()
        .append(callback).append("?callback_func=").append(callback_func);

        try {

            CommonFileVo fileVo =  FileManageUtil.uploadFile(fileData, FILE_PATH, CommonFileVo.class, FileManageUtil.FileType.DEFAULT);

            StringBuffer url = new StringBuffer()
                                    .append( request.getContextPath() )
                                    .append("/cmn/component/imageSrc.do?")
                                    .append("filePath=" + fileVo.getFilePath())
                                    .append("&fileName=" + fileVo.getSaveFileName())
                                    .append("&contentType=" + fileVo.getContentType());

            retUrl.append("&bNewLine=true").append("&sFileName=").append(fileVo.getFilePath());
            retUrl.append("&sFileURL=").append(URLEncoder.encode(url.toString(), "UTF-8"));


        } catch (NotAllowedFileExtException | InstantiationException | IllegalAccessException | IOException e) {
            retUrl.append("&errstr=error");
        }

        return "redirect:" + retUrl.toString();
    }
}
