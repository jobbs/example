package nciaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BomRemoveTest {

    private static final Logger logger = LoggerFactory.getLogger(BomRemoveTest.class);

	public static void main(String[] args) {

	    bomRemoveEntity();
	    bomRemoveDao();

	}

	public static void bomRemoveEntity() {

	    String folder = "C:\\Develop\\workspace\\eclipse\\ncms\\src\\main\\java\\ncis\\cmn\\entity\\";
        String targetfolder = "C:\\Develop\\tmp\\entity\\";

        BufferedReader br = null;
        BufferedWriter bw = null;
        //RcClstrPrpos
        try {

            File dir = new File(folder);
            File[] fileList = dir.listFiles();

            File curFile = null;
            for(int i = 0 ; i < fileList.length; i++ ) {
                curFile = fileList[i];

                if( "couch".equals(curFile.getName()) )
                    continue;

                br = new BufferedReader(new FileReader(curFile));
                bw = new BufferedWriter( new FileWriter(targetfolder + curFile.getName(), false));

                String line;
                while( (line = br.readLine()) != null ) {

                    line = line.replace("\ufeff","");
                    bw.write(line);
                    bw.newLine();

                }

                bw.close();
                br.close();

            }

        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("Entity 종료~~~~~~~~");
	}

	public static void bomRemoveDao() {

        String folder = "C:\\Develop\\workspace\\eclipse\\ncms\\src\\main\\java\\ncis\\cmn\\dao\\";
        String targetfolder = "C:\\Develop\\tmp\\dao\\";

        BufferedReader br = null;
        BufferedWriter bw = null;
        //RcClstrPrpos
        try {

            File dir = new File(folder);
            File[] fileList = dir.listFiles();

            File curFile = null;
            for(int i = 0 ; i < fileList.length; i++ ) {
                curFile = fileList[i];

                if( "couch".equals(curFile.getName()) )
                    continue;

                br = new BufferedReader(new FileReader(curFile));
                bw = new BufferedWriter( new FileWriter(targetfolder + curFile.getName(), false));

                String line;
                while( (line = br.readLine()) != null ) {

                    line = line.replace("\ufeff","");
                    bw.write(line);
                    bw.newLine();

                }

                bw.close();
                br.close();

            }

        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("DAO 종료~~~~~~~~");
    }
}
