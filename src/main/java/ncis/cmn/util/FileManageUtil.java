/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename FileManageUtil.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.DownFileNotFoundException;
import ncis.cmn.exception.NotAllowedFileExtException;
import ncis.cmn.exception.UploadFileSizeExceededException;
import ncis.cmn.vo.FileVo;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * <pre></pre>
 *
 * @author kamsi76
 *
 */
public class FileManageUtil {

	public static enum FileType{
		/**
		 * 일반 파일업로드
		 */
		DEFAULT("UPLOAD_FILE_PATH","UPLOAD_FILE_ALLOWED_FILEEXT"),
		/**
		 * 이미지 파일 업로드
		 */
		IMAGE("UPLOAD_IMAGE_PATH", "UPLOAD_IMAGE_ALLOWED_FILEEXT");

		private final String path;
		private final String ext;
		private FileType(String path, String ext) {
			this.path = path;
			this.ext = ext;
		}
	}

	public static final int BUFF_SIZE = 1024;

	private static final Logger logger = LoggerFactory.getLogger(FileManageUtil.class);


	/**
	 * <pre>
	 * 여러개의 파일을 업로드 한다.(경로지정 없음)
	 * 용량을 체크하여 등록되는 모든 파일의 용량이 클 지정한 용량보다 클경우 업로드를 제한한다.
	 * </pre>
	 * @param files
	 * @param newType
	 * @param fileType
	 * @param limitSize
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <E extends FileVo> List<E> uploadFiles(MultipartFile[] files, Class<? extends E> newType, FileType fileType, Long limitSize) throws InstantiationException, IllegalAccessException, IOException {

		if (!ObjectUtils.isEmpty(files)) {

			Long fileTotalSize = new Long(0);
			for(int i=0; i<files.length; i++){
				MultipartFile file = files[i];
				fileTotalSize += file.getSize();
			}

			if( limitSize < fileTotalSize ) {
				throw new UploadFileSizeExceededException(limitSize);
			}

			return uploadFiles(files, null, newType, fileType);
		} else {
			return null;
		}
	}

	/**
	 * <pre>
	 * 여러개의 파일을 업로드 한다.
	 * 용량을 체크하여 등록되는 모든 파일의 용량이 클 지정한 용량보다 클경우 업로드를 제한한다.
	 * </pre>
	 * @param files
	 * @param path
	 * @param newType
	 * @param fileType
	 * @param limitSize
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <E extends FileVo> List<E> uploadFiles(MultipartFile[] files, String path, Class<? extends E> newType, FileType fileType, Long limitSize) throws InstantiationException, IllegalAccessException, IOException {

		if (!ObjectUtils.isEmpty(files)) {

			Long fileTotalSize = new Long(0);
			for(int i=0; i<files.length; i++){
				MultipartFile file = files[i];
				fileTotalSize += file.getSize();
			}

			if( limitSize < fileTotalSize ) {
				throw new UploadFileSizeExceededException(limitSize);
			}

			return uploadFiles(files, path, newType, fileType);
		} else {
			return null;
		}



	}


	/** <pre>
	 * 여러개의 첨부파일을 업로드한다.(경로지정없음)
	 * </pre>
	 *
	 * @param <E>
	 * @param files
	 * @param newType CommFileVO 를 상속받은 vo class
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <E extends FileVo> List<E> uploadFiles(MultipartFile[] files, Class<? extends E> newType, FileType fileType) throws InstantiationException, IllegalAccessException, IOException {

		return uploadFiles(files, null, newType, fileType);

	}

	/** <pre>
	 * 여러개의 첨부파일을 업로드한다.
	 * </pre>
	 *
	 * @param <E>
	 * @param files
	 * @param path
	 * @param newType
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <E extends FileVo> List<E> uploadFiles(MultipartFile[] files, String path, Class<? extends E> newType, FileType fileType) throws InstantiationException, IllegalAccessException, IOException {
		List<E> list = null;
		if (!ObjectUtils.isEmpty(files)) {
			list = new ArrayList<E>();
			for(int i=0; i<files.length; i++){
				MultipartFile file = files[i];
				E fileVO = uploadFile(file, path, newType, fileType, i);
				if(fileVO != null){
					list.add(fileVO);
				}
			}
		}
		return list;
	}

	/**
	 * <pre>
	 * 첨부 파일을 업로드 한다.(경로지정 없음)
	 * 용량을 체크하여 등록되는 모든 파일의 용량이 클 지정한 용량보다 클경우 업로드를 제한한다.
	 * </pre>
	 * @param file
	 * @param newType
	 * @param fileType
	 * @param limitSize
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <T extends FileVo> T uploadFile(MultipartFile file,Class<? extends T> newType, FileType fileType, Long limitSize) throws InstantiationException, IllegalAccessException, IOException {
		if( file.getSize() > limitSize ) {
			throw new UploadFileSizeExceededException(limitSize);
		}

		return uploadFile(file, null, newType, fileType, 0);
	}

	/**
	 * <pre>
	 * 첨부 파일을 업로드 한다.
	 * 용량을 체크하여 등록되는 모든 파일의 용량이 클 지정한 용량보다 클경우 업로드를 제한한다.
	 * </pre>
	 * @param file
	 * @param newType
	 * @param fileType
	 * @param limitSize
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <T extends FileVo> T uploadFile(MultipartFile file, String path, Class<? extends T> newType, FileType fileType, Long limitSize) throws InstantiationException, IllegalAccessException, IOException {
		if( file.getSize() > limitSize ) {
			throw new UploadFileSizeExceededException(limitSize);
		}
		return uploadFile(file, path, newType, fileType, 0);
	}

	/** <pre>
	 * 첨부파일을 업로드한다.(경로지정 없음)
	 * </pre>
	 *
	 * @param <T>
	 * @param file
	 * @param newType
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T extends FileVo> T uploadFile(MultipartFile file,Class<? extends T> newType, FileType fileType) throws InstantiationException, IllegalAccessException, IOException {
		return uploadFile(file, null, newType, fileType, 0);
	}

	/** <pre>
	 * 첨부파일을 업로드한다.
	 * </pre>
	 * @param file
	 * @param path
	 * @param newType
	 * @param fileType
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <T extends FileVo> T uploadFile(MultipartFile file, String path, Class<? extends T> newType, FileType fileType) throws InstantiationException, IllegalAccessException, IOException {
		return uploadFile(file, path, newType, fileType, 0);
	}


	/** <pre>
	 * 첨부파일을 업로드한다.
	 * </pre>
	 *
	 * @param <T>
	 * @param file
	 * @param path
	 * @param newType
	 * @return
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private static <T extends FileVo> T uploadFile(MultipartFile file, String path, Class<? extends T> newType, FileType fileType, int idx) throws IOException, InstantiationException, IllegalAccessException {

		if(file.isEmpty()){
			return null;
		}

		T fileVO = newType.newInstance();
		String originFileName = file.getOriginalFilename();
		int index = originFileName.lastIndexOf(".");
		String fileExt = originFileName.substring(index + 1);
		long size = file.getSize();
		String saveFileName = getTimeStamp(idx);

		String fullSaveFileName = new StringBuffer(saveFileName).append(".").append(fileExt).toString();

		if(!isAllowedFileExt(fileExt, fileType)){
			throw new NotAllowedFileExtException(PropertiesUtil.getProperty(fileType.ext));
		}

		String filePath = PropertiesUtil.getProperty(fileType.path);
		if(path != null && !path.isEmpty()){
			filePath += File.separator+path;
		}

		writeFile(file, fullSaveFileName, filePath);

		fileVO.setContentType(file.getContentType());
		fileVO.setFilePath(filePath);
		fileVO.setOriginFileName(originFileName);
		fileVO.setSaveFileName(fullSaveFileName);
		fileVO.setFileExt(fileExt);
		fileVO.setFileSize(size);
		return fileVO;
	}

	/** <pre>
	 * 파일 확장자를 체크한다.
	 * </pre>
	 *
	 * @param fileExt
	 * @return
	 */
	private static boolean isAllowedFileExt(String fileExt, FileType fileType){
		if(StringUtils.isEmpty(fileExt)){
			return false;
		}
		String allowedFileExt = PropertiesUtil.getProperty(fileType.ext);
		if(!StringUtils.isEmpty(allowedFileExt)){
			return fileExt.toLowerCase().matches(allowedFileExt);
		}
		return true;
	}

	/**
	 * <pre>
	 * 첨부파일을 실제 저장한다.
	 * </pre>
	 *
	 * @param file
	 * @param saveFileName
	 * @param path
	 * @throws IOException
	 */
	private static void writeFile(MultipartFile file, String saveFileName,
			String path) throws IOException {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = file.getInputStream();

			File realUploadDir = new File(path);

			if (!realUploadDir.exists()){
				boolean bResult = realUploadDir.mkdir();
				if(!bResult){
					throw new IOException("디렉토리가 존재하지 않습니다.");
				}
			}

			os = new FileOutputStream( new File(path, FilenameUtils.getName(saveFileName)) );

			int bytesRead = 0;
			byte[] buffer = new byte[BUFF_SIZE];

			while ((bytesRead = is.read(buffer, 0, BUFF_SIZE)) != -1) {
				os.write(buffer, 0, bytesRead);
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new IOException("해당 파일이 존재하지 않습니다. 파일명 : " + saveFileName );
		} finally{
			if(os != null){
				os.close();
			}
		}

	}

//	/** <pre>
//	 * 썸네일 생성
//	 * </pre>
//	 *
//	 * @param orgFileName 원본파일명
//	 * @param path 저장경로
//	 * @param saveFileName 저장파일명
//	 * @param fileExt 파일확장자
//	 * @throws IOException
//	 */
//	private static void createThumbnail(String orgFileName, String path, String saveFileName, String fileExt) throws IOException{
//		String thumbFileName = path + File.separator + saveFileName +"_thumb."+fileExt;
//		Thumbnails.of(orgFileName).size(120, 120).toFile(new File(thumbFileName));
//	}

	/**
	 * <pre>
	 * timestamp 를 구한다.
	 * </pre>
	 *
	 * @return
	 */
	public static String getTimeStamp(int idx) {
		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		rtnStr = sdfCurrent.format(ts.getTime());
		return rtnStr + String.valueOf(idx);
	}

	/** <pre>
	 * 파일 다운로드
	 * </pre>
	 *
	 * @param request
	 * @param response
	 * @param downFileName
	 * @param orgFileName
	 * @throws IOException
	 */
	public static void downFile(HttpServletRequest request,
			HttpServletResponse response, String downFileName,
			String orgFileName) throws IOException {

		File file = new File(downFileName);

		if (!file.exists()) {
			throw new DownFileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new DownFileNotFoundException(downFileName);
		}


		response.setContentType("application/download; utf-8");
		response.setContentLength((int) file.length());

		String userAgent = request.getHeader("user-Agent");
		if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1) { // Over IE 6.0
			response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(orgFileName, "utf-8") + "\";");
		} else { // Other browser like mozilla
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(orgFileName.getBytes("UTF-8"), "ISO-8859-1") + "\";");
		}
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				    logger.error(e.getMessage());
				}
		}

		out.flush();
		out.close();
	}

	public static void imageFileView(HttpServletResponse response, String path, String fileName, String mimeTypeParams) throws FileNotFoundException {

	    String mimeType = mimeTypeParams;
	    String downFileName = path + File.separator + fileName;

	    File file = new File(downFileName );

	    if( !file.exists() ) {
	        throw new FileNotFoundException(downFileName);
	    }

	    if( !file.isFile() ) {
	        throw new FileNotFoundException(downFileName);
	    }

	    byte[] b = new byte[BUFF_SIZE];

	    if( null == mimeType ) {
	        mimeType = "application/octet-stream";
	    }

	    response.setContentType(mimeType);
	    response.setHeader("Content-Disposition", "filename=image;");

	    BufferedInputStream fin = null;
	    BufferedOutputStream outs = null;


	    try {
	        fin = new BufferedInputStream(new FileInputStream(file));
            outs = new BufferedOutputStream(response.getOutputStream());

            int read = 0;
            while((read = fin.read(b)) != -1 ) {
                outs.write(b, 0, read);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if( outs != null ) {
                try {
                    outs.close();
                } catch (IOException e){
                    logger.error(e.getMessage());
                }

                if( fin != null ) {
                    try {
                        fin.close();
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        }



	}

	/**
	 * <pre>
	 * 파일 다운로드 (BLOB로 DB안에 파일내용이 저장된 경우)
	 * </pre>
	 *
	 * @param request
	 * @param response
	 * @param fileName
	 * @param fileCont
	 * @throws IOException

	 * @author you2198
	 * @created 2014. 4. 30.
	 */
	public static void downFile(HttpServletRequest request,
			HttpServletResponse response, String fileName,
			byte[] fileCont) throws IOException {

		if(fileCont.length > 0) {
			response.setContentType("application/download; utf-8");
			response.setContentLength(fileCont.length);

			String userAgent = request.getHeader("user-Agent");
			if (userAgent.indexOf("MSIE 5.5") > -1) { // Under IE 5.5
				response.setHeader("Content-Disposition", "filename=\""+ URLEncoder.encode(fileName, "utf-8") +"\";");
			} else if (userAgent.indexOf("MSIE") > -1) { // Over IE 6.0
				response.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(fileName, "utf-8") +"\";");
			} else { // Other browser like mozilla
				response.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(fileName, "utf-8") +"\";");
			}

			response.setHeader("Content-Transfer-Encoding", "binary");

			OutputStream out = response.getOutputStream();
			for(int i=0; i<fileCont.length; i++) out.write(fileCont[i]);

			out.flush();
			out.close();
		}
	}
}