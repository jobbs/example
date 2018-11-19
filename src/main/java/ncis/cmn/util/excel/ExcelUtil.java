/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ExcelUtil.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    /**
     * 엑셀 파일 다운 로드
     * @param response                  HttpServletResponse
     * @param fileName                  다운로드 파일명
     * @param cSheets                   Excel 생성 Data 정보
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    public static void downloadExcel(HttpServletResponse response, String fileName, List<CustomSheet> cSheets) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        Workbook workBook = createExcel( cSheets );

        OutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileName).getBytes("KSC5601"),"8859_1") + ".xlsx\"");

        workBook.write(out);
        out.flush();
        out.close();
    }

    /**
     * 엑셀 파일 파일 저장
     * @param path                      저장 경로
     * @param fileName                  다운로드 파일명
     * @param cSheets                   Excel 생성 Data 정보
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IOException
     */
    public static void saveExcel(String path, String fileName, List<CustomSheet> cSheets ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        Workbook workBook = createExcel( cSheets );

        String fullPath = path + File.separator + fileName + ".xlsx";

        FileOutputStream out = new FileOutputStream(fullPath);
        workBook.write(out);
        out.flush();
        out.close();

    }

    /**
     * WorkBook 생성
     * @param cSheets                   Excel 생성 Data 정보
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static Workbook createExcel( List<CustomSheet> cSheets)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Workbook workBook = new XSSFWorkbook();

        for (CustomSheet cSheet : cSheets) {

            Map<String, String> headers = cSheet.getHreader();
            List<?> datas = cSheet.getDatas();

            Sheet sheet = workBook.createSheet(cSheet.getSheetName());

            Row row = null;
            Cell cell = null;

            //Header 생성
            //Header 색상 지정
            CellStyle headerStyle = workBook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.index);
            headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            headerStyle.setAlignment(CellStyle.ALIGN_CENTER);

            Font font = workBook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            headerStyle.setFont(font);

            row = sheet.createRow(0);
            int h = 0;
            for( Entry<String, String> entry : headers.entrySet()) {
                cell = row.createCell(h++);
                cell.setCellValue( entry.getValue() );
                cell.setCellStyle(headerStyle);
            }

            int i = 0;
            for (Object data : datas) {

                data = datas.get(i);
                Class<? extends Object> dataCls = data.getClass();
                Method[] meths = dataCls.getMethods();

                row = sheet.createRow(++i);

                int c = 0;
                for( Entry<String, String> entry : headers.entrySet()) {

                    String methodName = "get" + StringUtils.capitalize(entry.getKey());
                    for (Method method : meths) {
                        if ( method.getName().toLowerCase().equals(methodName.toLowerCase())) {

                            cell = row.createCell(c++);
                            if( null == method.invoke(data) ) {
                            	cell.setCellValue( "" );
                            } else {
                            	cell.setCellValue( method.invoke(data).toString() );
                            }

                        }
                    }
                }
            }
        }

        autoSizeColumns(workBook);


        return workBook;


    }

    private static void autoSizeColumns(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for( int i = 0; i < numberOfSheets; i++ ) {
            Sheet sheet = workbook.getSheetAt(i);
            if( sheet.getPhysicalNumberOfRows() > 0 ) {
                Row row = sheet.getRow(0);
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }
}
